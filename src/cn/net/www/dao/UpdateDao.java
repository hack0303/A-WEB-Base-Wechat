package cn.net.www.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import cn.net.www.bean.YohooAdmin;
import cn.net.www.bean.YohooCheckCode;
import cn.net.www.bean.YohooLogin;
import cn.net.www.bean.YohooUser;

public class UpdateDao {
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pstm=null;
	private ResultSet rs = null;

	public boolean update(String sql) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		boolean flag = false;
		int i=0;
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		i = st.executeUpdate(sql);
		if (i == 0)
		flag =false;
		else
		flag =true;
		}finally{
		close();}
		return flag;

	}
	public boolean updateObject(Object ob,Class classname) throws FileNotFoundException, NamingException, IOException{
    	boolean flag=false;
    	try{
    	conn=new ConnDao().getConn();
    	String sql="";
    	if(classname.equals(YohooCheckCode.class)){
    	   YohooCheckCode ycc=(YohooCheckCode)ob;
    		sql="update yohoo_checkcode set checkcode=?,get_time=? where phone=?";
    	   pstm=conn.prepareStatement(sql);
    	   pstm.setString(1,ycc.getCheckcode());
		   pstm.setString(2,ycc.getGet_time());
		   pstm.setString(3,ycc.getPhone());
    	}else if(classname.equals(YohooLogin.class)){
    	   YohooLogin yl=(YohooLogin)ob;
       	   sql="update yohoo_login set lastlogin=?,last_faillogin=?,common_use_ip=?,faillogin_counter=? where phone=?";
       	   pstm=conn.prepareStatement(sql);
       	   pstm.setString(1,yl.getLastlogin());
   		   pstm.setString(2,yl.getLast_faillogin());
   		   pstm.setString(3,yl.getCommon_use_ip());
   		   pstm.setString(4,yl.getFaillogin_counter());
   		   pstm.setString(5,yl.getPhone());
    	}else if(classname.equals(YohooAdmin.class)){
    	   YohooAdmin ya=(YohooAdmin)ob;
       	   sql="update yohoo_admin set password=?,authority=?,creating_time=?,lastlogin_time=? where account=?";
       	   pstm=conn.prepareStatement(sql);
       	   pstm.setString(1,ya.getPassword());
   		   pstm.setInt(2,ya.getAuthority());
   		   pstm.setString(3,ya.getCreating_time());
   		   pstm.setString(4,ya.getLastlogin_time());
   		   pstm.setString(5,ya.getAccount());
    	}
    	int flag_int=0;
    	flag_int=pstm.executeUpdate();
    	if(flag_int==0){
    		flag=false;
    	}else{
    		flag=true;
    	}
    	System.out.println(flag);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    	close_pstm();	
    	}
    	return flag;
    }

	public boolean updateDate(int date_flag) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		boolean flag = false;
		String sql = "update youhuo_date set date_flag='" + date_flag + "'";
		flag = update(sql);
		return flag;
	}
    public boolean updateReview(int flag,String phone) throws FileNotFoundException, NamingException, SQLException, IOException{
    	boolean updateflag=false;
    	String sql="update yohoo_user set flag='"+flag+"' where phone='"+phone+"'" ;
    	updateflag=update(sql);
    	return updateflag;
    }
    public boolean update_batch_review(int[] flag,String[] phone) throws SQLException, FileNotFoundException, NamingException, IOException{
    	boolean updateflag=false;
    	try{
    	conn=new ConnDao().getConn();
    	conn.setAutoCommit(false);
    	st=conn.createStatement();
    	for(int i=0;i<flag.length;i++){
    		int _flag=flag[i];
    		String _phone=phone[i];
    		String sql="update yohoo_user set flag='"+_flag+"' where phone='"+_phone+"'";
    		st.addBatch(sql);
    	}
    	st.executeBatch();
    	updateflag=true;
    	conn.commit();
    	}catch (Exception e) {
			// TODO: handle exception
    	e.printStackTrace();
    	updateflag=false;
		conn.rollback();
    	}finally{
    		close();
    	}
    	return updateflag;
    }
    public boolean updateDate_flag(int flag,String from_phone,String to_phone) throws FileNotFoundException, NamingException, SQLException, IOException{
    	boolean out=false;
    	PreparedStatement ps=null;
    	try{
    	conn=new ConnDao().getConn();
    	String sql="update yohoo_date set date_flag=? where from_phone=? and to_phone=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1,flag);
    	ps.setString(2,from_phone); 	
    	ps.setString(3,to_phone);
    	int int_flag=ps.executeUpdate();
        if(int_flag==0) out=false;
        else{
        	out=true;
        }}finally{
        ps.close();
        conn.close();
        }
    	return out;
    }
    public boolean updateDate_flag(int flag,String date_number) throws FileNotFoundException, NamingException, SQLException, IOException{
    	boolean out=false;
    	PreparedStatement ps=null;
    	try{
    	conn=new ConnDao().getConn();
    	String sql="update yohoo_date set date_flag=? where date_number=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1,flag);
    	ps.setString(2,date_number); 	
    	int int_flag=ps.executeUpdate();
        if(int_flag==0) out=false;
        else{
        	out=true;
        }}finally{
        ps.close();
        conn.close();
        }
    	return out;
    }
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
	}
	public void close_pstm(){
		try{
		if (rs != null)
			rs.close();
		if (pstm != null)
			pstm.close();
		if (conn != null)
			conn.close();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		rs=null;
		pstm=null;
		conn=null;
	}
	}
	public boolean update(String name, String value, String phone,String tablename) throws SQLException, FileNotFoundException, NamingException, IOException {
		// TODO Auto-generated method stub
		int tableflag=0;
		try{
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		String sql="update "+tablename+" set "+name+"='"+value+"'"+" where phone="+"'"+phone+"'";
		tableflag=st.executeUpdate(sql);
		}finally{
			close();
		}
		boolean flag=false;
		if(tableflag!=0){flag=true;}
		return flag;
	}
	public boolean update(String name, String value, String phone) throws SQLException, FileNotFoundException, NamingException, IOException {
		// TODO Auto-generated method stub
		int tableflag=0;
		try{
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		String sql="update yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone left join yohoo_xunta_form c on b.key_phone=c.key_phone set "+name+"='"+value+"' where phone='"+phone+"'";
		//System.out.println(sql);
		tableflag=st.executeUpdate(sql);
		}finally{
			close();
		}
		boolean flag=false;
		if(tableflag!=0){flag=true;}
		return flag;
	}
	public boolean updateWYZQPass(int state, int number, String phone) throws SQLException, FileNotFoundException, NamingException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
		conn=new ConnDao().getConn();
		String sql="update yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone set a.flag=?,b.state=?,b.number=? where phone=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,String.valueOf(YohooUser.WYZQ_REQUEST_PASS));
		pstm.setString(2,String.valueOf(state));
		pstm.setString(3,String.valueOf(number));
		pstm.setString(4,String.valueOf(phone));
		int int_flag=pstm.executeUpdate();
		if(int_flag==0){
			flag=false;
		}else{
			flag=true;
		}}finally{
			close_pstm();
		}
		return flag;
	}
}
