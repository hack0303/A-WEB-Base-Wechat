package cn.net.www.dao;

import java.io.FileNotFoundException;


import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;

import cn.net.www.base.PhoneDigest;
import cn.net.www.bean.DateBean;
import cn.net.www.bean.PageBean;
import cn.net.www.bean.UserImage;
import cn.net.www.bean.UserInformation;
import cn.net.www.bean.XuntaAgree;
import cn.net.www.bean.XuntaDeclare;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.bean.YohooActivities;
import cn.net.www.bean.YohooAdmin;
import cn.net.www.bean.YohooCheckCode;
import cn.net.www.bean.YohooLogin;
import cn.net.www.bean.YohooMember;
import cn.net.www.bean.YohooUser;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.MessageBuilder;
import cn.net.www.unit.SecurityUnit;

public class QueryDao {
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pstm=null;
	private ResultSet rs = null;

	public boolean query(String sql) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next()) {
			return true;
		} else {
			return false;
		}}finally{
			close();
		}
	}// 判断是否存在
	public int queryAJAX(String type,String identify,String querytype) throws FileNotFoundException, NamingException, IOException{
		int flag=0;//0,无信息,1存在信息,2数据库出错
		String sql="";
		try{
		conn=new ConnDao().getConn();
		if(querytype.equals("nickname")){
			if(type.equals("qinzi")){
				
			}else if(type.equals("xunta")){
				sql="select * from yohoo_xunta_information where nickname=? and type=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1,identify);
				pstm.setString(2,type);
			}
			else if(type.equals("ruiqu")){
				
			}
		}else if(querytype.equals("phone")){
	sql="select * from yohoo_user where phone=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1,identify);
		}else if(querytype.equals("email")){
if(type.equals("qinzi")){
				
			}else if(type.equals("xunta")){}
			else if(type.equals("ruiqu")){}
		}
		rs=pstm.executeQuery();
		if(rs.next()){
			flag=1;
		}
}catch(SQLException e){
	e.printStackTrace();
	flag=2;
	
}finally{
			try {
				close_pstm();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库无法关闭");
			}
		}
return flag;
	}
	public int count(String type,int flag) throws SQLException, FileNotFoundException, NamingException, IOException{
		int out=0;
		try{
		conn=new ConnDao().getConn();
		String sql="select count(*) from yohoo_user where type=? AND flag=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,type);
		pstm.setInt(2,flag);
		rs=pstm.executeQuery();
		if(rs.next()){
			out=rs.getInt(1);
		}}finally{
			close_pstm();
		}
		return out;	
	}
	public int countUserListByState(String type,int flag,String state) throws SQLException, FileNotFoundException, NamingException, IOException{
		int out=0;
		try{
		conn=new ConnDao().getConn();
		String sql="select count(*) from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone where type=? AND flag=? and state=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,type);
		pstm.setInt(2,flag);
		pstm.setString(3,state);
		rs=pstm.executeQuery();
		if(rs.next()){
			out=rs.getInt(1);
		}}finally{
			close_pstm();
		}
		return out;	
	}
	public int countDate(int flag,int date_flag,String type) throws SQLException, FileNotFoundException, NamingException, IOException{
		int out=0;
		try{
		conn=new ConnDao().getConn();
		String sql="";
		if(type.equals("all")) 
		sql="select count(*) from yohoo_date where date_flag=?";
		else if(type.equals("from")) 
			sql="select count(*) from yohoo_user a left join yohoo_date b on a.phone=b.from_phone where b.date_flag=?";
		else if(type.equals("to")) 
			sql="select count(*) from yohoo_user a left join yohoo_date b on a.phone=b.to_phone where b.date_flag=?";
		pstm=conn.prepareStatement(sql);
		//pstm.setInt(1,flag);
		pstm.setInt(1,date_flag);
		rs=pstm.executeQuery();
		if(rs.next()){
			out=rs.getInt(1);
		}}finally{
			close_pstm();
		}
		return out;	
	}
	public int countActivities(int flag) throws SQLException, FileNotFoundException, NamingException, IOException{
		int out=0;
		try{
		conn=new ConnDao().getConn();
		String sql="select * from yohoo_activities where flag=?";
		pstm=conn.prepareStatement(sql);
		//pstm.setInt(1,flag);
		pstm.setInt(1,flag);
		rs=pstm.executeQuery();
		if(rs.next()){
			out=rs.getInt(1);
		}}finally{
			close_pstm();
		}
		return out;	
	}
	public Object queryObject(String phoneoraccount,Class classname) throws FileNotFoundException, NamingException, SQLException, IOException{
		Object ob=null;
		try{
		conn=new ConnDao().getConn();
		String sql="";
		if(classname.equals(YohooCheckCode.class)){
			sql="select * from yohoo_checkcode where phone=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,phoneoraccount);
			rs=pstm.executeQuery();
			if(rs.next()){
				String id=rs.getString("id");
			  //String phone="";
				String checkcode=rs.getString("checkcode");
				String get_time=rs.getString("get_time");
				YohooCheckCode ycc=new YohooCheckCode(id,phoneoraccount,checkcode,get_time);
				ob=ycc;
			}else{
				ob=null;
			}
		}else if(classname.equals(YohooLogin.class)){
			sql="select * from yohoo_login where phone=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,phoneoraccount);
			rs=pstm.executeQuery();
			if(rs.next()){
				String id=rs.getString("id");
			  //String phone="";
				String lastlogin=rs.getString("lastlogin");
				String last_faillogin=rs.getString("last_faillogin");
				String common_use_ip=rs.getString("common_use_ip");
				String faillogin_counter=rs.getString("faillogin_counter");
				YohooLogin yl=new YohooLogin(id, phoneoraccount, lastlogin, last_faillogin, common_use_ip, faillogin_counter);
				ob=yl;
			}else{
				ob=null;
			}
		}
		else if(classname.equals(YohooAdmin.class)){
			sql="select * from yohoo_admin where account=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,phoneoraccount);
			rs=pstm.executeQuery();
			if(rs.next()){
				String id=rs.getString("id");
			  //String account="";
				String password=rs.getString("password");
				int authority=rs.getInt("authority");
				String creating_time=rs.getString("creating_time");
				String lastlogin_time=rs.getString("lastlogin_time");
				YohooAdmin ya=new YohooAdmin(id, phoneoraccount, password, authority, creating_time, lastlogin_time);
				ob=ya;
			}else{
				ob=null;
			}
		}else if(classname.equals(YohooActivities.class)){
			sql="select * from yohoo_activities where phone=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,phoneoraccount);
			rs=pstm.executeQuery();
			if(rs.next()){
				String id=rs.getString("id");
			    String phone=rs.getString("phone");
				int flag=rs.getInt("flag");
				String creating_time=rs.getString("creating_time");
				YohooActivities ya=new YohooActivities(id, phone, flag, creating_time);  
				ob=ya;
			}else{
				ob=null;
			}		
		}
		
		}finally{
			close_pstm();
		}
		return ob;
	}
	public int queryMaxId() throws SQLException {
	int id=0;
	try{
	conn = new ConnDao().getConn();
	st = conn.createStatement();
	String sql="select MAX(id) FROM yohoo_user";
	rs = st.executeQuery(sql);
	if (rs.next()) {
		id=rs.getInt(1);
	} else {
    Random	random=new Random();
    id=random.nextInt(1000);
	}} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		close();
	}
	return id;
}// 判断是否存在
	public String queryPhoneById(int id) throws SQLException, FileNotFoundException, NamingException, IOException{
		String phone="";
		try{
		conn=new ConnDao().getConn();
		String[] part={"phone","yohoo_user where id=?"};
		String sql=MessageBuilder.buildSQL("select",part);
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,String.valueOf(id));
		rs=pstm.executeQuery();
		if(rs.next()){
			phone=rs.getString(1);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close_pstm();
		}
		return phone;
	}
	public List<XuntaUser> queryBySearch(String search,String gender) throws Exception{
		List<XuntaUser> list=new ArrayList<XuntaUser>();
		PreparedStatement ps=null;
		String yu_flag=String.valueOf(YohooUser.WYZQ_REQUEST_PASS);
		try{
		conn=new ConnDao().getConn();
		String sql="SELECT phone,main_url,nickname FROM yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone WHERE b.nickname=? and a.flag=? and a.gender=? UNION SELECT phone,main_url,nickname FROM yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone WHERE b.number=? and a.flag=? and a.gender=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1,search);
		ps.setString(2,yu_flag);
		ps.setString(3,gender);
		ps.setString(4,search);
		ps.setString(5,yu_flag);
		ps.setString(6,gender);
		
		rs=ps.executeQuery();
		XuntaUser e=new XuntaUser(); 
		while(rs.next()){
			e.setPhone(SecurityUnit.phoneEncode(rs.getString(1)));
			e.setMain_url(rs.getString(2));
			e.setNickname(rs.getString(3));
			list.add(e);
		}}finally{
		rs.close();
		ps.close();
		conn.close();
		}
		if(list.equals(new ArrayList<XuntaUser>())) list=null;
		return list;
	}//语句查询
	public boolean ajax_query(String key,String value) throws SQLException, FileNotFoundException, NamingException, IOException{
		boolean flag=false;
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		try{
		String sql="";
		if(key.equalsIgnoreCase("phone"))
		sql="select * from yohoo_user where phone='"+value+"'";
		else if(key.equalsIgnoreCase("nickname")) sql="select * from yohoo_xunta_information where nickname='"+value+"'";
		rs=st.executeQuery(sql);
		flag=rs.next();
		}finally{
		close();}
		return flag;
	}//ajax查询phone是否存在。
   public int queryAdminByAccount(String account,String password) throws FileNotFoundException, NamingException, SQLException, IOException{
	   int authority=0;
	   try{
	   conn=new ConnDao().getConn();
	   String sql="select authority from yohoo_admin where account=? and password=?";
	   pstm=conn.prepareStatement(sql);
	   pstm.setString(1,account);
	   pstm.setString(2,password);
	   rs=pstm.executeQuery();
	   if(rs.next()){
		   authority=rs.getInt("authority");
	   }}finally{
		  close_pstm();
	   }
	   return authority;
   }//管理员帐号密码登录,返回权限值,默认值为0,如果为0,说明无这号人物。
   public YohooAdmin queryAdmin(String account,String password) throws FileNotFoundException, NamingException, SQLException, IOException{
	   YohooAdmin ya=null;
	   try{
	   conn=new ConnDao().getConn();
	   String sql="select * from yohoo_admin where account=? and password=?";
	   pstm=conn.prepareStatement(sql);
	   pstm.setString(1,account);
	   pstm.setString(2,password);
	   rs=pstm.executeQuery();
	   if(rs.next()){
		  String id=rs.getString("id");
		  //String account=rs.getString("account");
		  int authority=rs.getInt("authority");
		  String creating_time=rs.getString("creating_time");
		  String lastlogin_time=rs.getString("lastlogin_time");
		   ya=new YohooAdmin(id, account, password, authority, creating_time, lastlogin_time);
	   }}finally{
		  close_pstm();
	   }
	   return ya;
   }
   public String queryStateByPhone(String phone) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		String state = "";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		String sql = "select b.state from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone where phone='"
				+ phone + "‘";
		rs = st.executeQuery(sql);
		if (rs.next())
			state = rs.getString(1);
		}finally{
		close();}
		return state;
	}

	public int queryFlagByPhone(String phone,String type) throws SQLException,
			FileNotFoundException, NamingException, IOException {
		int flag = 0;
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		String sql = "select flag from yohoo_user where phone='" + phone + "' and type='"+type+"'";
		rs = st.executeQuery(sql);
		if (rs.next())
			flag = rs.getInt(1);
		}finally{
		close();}
		return flag;
	}
	//根据phone和type来查询flag标志。
	public int queryFlagByPhone(String phone) throws SQLException,
	FileNotFoundException, NamingException, IOException {
    int flag = 0;
    try{
    conn = new ConnDao().getConn();
    st = conn.createStatement();
    String sql = "select flag from yohoo_user where phone='" + phone + "'";
    rs = st.executeQuery(sql);
    if (rs.next())
	flag = rs.getInt(1);
    }finally{close();
    }
    return flag;
    }

	public List<XuntaUser> queryWoYue(String from_phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		List<XuntaUser> list = new ArrayList<XuntaUser>();
		// String
		// sql="select * from youhuo_information where keyid in (select to_id from youhuo_date where from_id='"+from_id+"')";
		String sql = "SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "'";
		try{
			conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {

			XuntaUser xtu = new XuntaUser();
			xtu.setWoYue(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getInt(4),rs.getString(5),DateUnit.parseDatetoBirth(rs.getString(6)));
			list.add(xtu);
		}}finally{
		close();}
		if(list.equals(new ArrayList<XuntaUser>())) list=null;
		return list;
	}
	public List<XuntaUser> queryWoYueByDate_flag(String from_phone,int procedure)
			throws Exception {
		List<XuntaUser> list = new ArrayList<XuntaUser>();
     String sql="";
	switch(procedure){
	case 0:{
		sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "'";
		break;
	}
	case 1:{
		sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "' and (c.date_flag='"+DateBean.DATE_ONE_START+"' or c.date_flag='"+DateBean.DATE_TWO_ACCEPT_NO+"' or c.date_flag='"+DateBean.DATE_ONE_PAY_ERROR+"')";
		break;
	}
	case 2:{
		sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "' and (c.date_flag='"+DateBean.DATE_TWO_START+"' or c.date_flag='"+DateBean.DATE_TWO_ACCEPT_NO+"' or c.date_flag='"+DateBean.DATE_TWO_PAY_BACK_ERROR+"')";
		break;
	}
	case 3:{
		sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "' and (c.date_flag='"+DateBean.DATE_THREE_START+"' or c.date_flag='"+DateBean.DATE_THREE_ARRANGE_ERROR+"')";
		break;
	}
	case 4:{
		sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.to_phone WHERE c.from_phone='"
				+ from_phone + "' and (c.date_flag='"+DateBean.DATE_FOUR_END+"' or c.date_flag='"+DateBean.DATE_FOUR_START+"')";
		break;
	}
	}
	try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {

			XuntaUser xtu = new XuntaUser();
			xtu.setWoYue(SecurityUnit.phoneEncode(rs.getString(1)), rs.getString(2), rs.getString(3),
					rs.getInt(4),rs.getString(5),DateUnit.parseDatetoBirth(rs.getString(6)));
			list.add(xtu);
		}
	}finally{
		close();}
		if(list.equals(new ArrayList<XuntaUser>())) list=null;
		return list;
	}
	public List<XuntaUser> queryYueWo(String to_phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		List<XuntaUser> list = new ArrayList<XuntaUser>();
		// String
		// sql="select * from youhuo_information where keyid in (select from_id from youhuo_date where from_id='"+to_id+"')";
		String sql = "SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.from_phone WHERE c.to_phone='"
				+ to_phone + "'";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			XuntaUser ui = new XuntaUser();
			ui.setWoYue(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getInt(4),rs.getString(5),DateUnit.parseDatetoBirth(rs.getString(6)));
			list.add(ui);
		}}finally{
		close();}
		if(list.equals(new ArrayList<XuntaUser>())) list=null;
		return list;
	}
	public List<XuntaUser> queryYueWoByDate_flag(String to_phone,int procedure)
			throws Exception {
		List<XuntaUser> list = new ArrayList<XuntaUser>();
	     String sql="";
		switch(procedure){
		case 0:{
			sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time,b.education,a.birthday,a.occupation FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.from_phone WHERE c.to_phone='"
					+ to_phone + "'";
			break;
		}
		case 1:{
			sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time,b.education,a.birthday,a.occupation FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.from_phone WHERE c.to_phone='"
					+ to_phone + "' and (c.date_flag='"+DateBean.DATE_TWO_START+"' or c.date_flag='"+DateBean.DATE_TWO_ACCEPT_NO+"')";
			break;
		}//支付成功后进入流程2，查看约会标志
		case 2:{
			sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time,b.education,a.birthday,a.occupation FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.from_phone WHERE c.to_phone='"
					+ to_phone + "' and (c.date_flag='"+DateBean.DATE_THREE_START+"' or c.date_flag='"+DateBean.DATE_THREE_ARRANGE_ERROR+"')";
			break;
		}//等待约会安排，约会安排成功，约会安排出现问题联系客服
		case 3:{
			sql="SELECT a.phone,b.nickname,b.main_url,c.date_flag,c.date_number,c.date_time,b.education,a.birthday,a.occupation FROM yohoo_user a LEFT JOIN yohoo_xunta_information b on a.phone=b.key_phone LEFT JOIN yohoo_date c ON a.phone=c.from_phone WHERE c.to_phone='"
					+ to_phone + "' and (c.date_flag='"+DateBean.DATE_FOUR_START+"' or c.date_flag='"+DateBean.DATE_FOUR_END+"')";
			break;
		}//等待表态,表态完成
		}
		try{
			conn = new ConnDao().getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				XuntaUser xtu = new XuntaUser();
				xtu.setYueWo(SecurityUnit.phoneEncode(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getInt(4),rs.getString(5),DateUnit.parseDatetoBirth(rs.getString(6)),rs.getString(7),DateUnit.parseDatetoAge(rs.getString(8)),rs.getString(9));
				list.add(xtu);
			}
		}finally{
			close();
		}
			if(list.equals(new ArrayList<XuntaUser>())) list=null;
			return list;
	}

	public String queryByUserId(String userid) throws SQLException,
			FileNotFoundException, NamingException, IOException {
		String sql = "select id from yohoo_test where userid='" + userid + "'";
		String id = "";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next())
			id = rs.getString(1);
		else
			id = "0";
		}finally{
		close();
		}
		return id;
	}// 根据UserId查询

	public String queryByTelephone(String telephone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		String sql = "select phone from yohoo_user where phone='" + telephone
				+ "'";
		String phone = "";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next())
			phone = rs.getString(1);
		else
			phone = "0";
		}finally{
		close();}
		return phone;
	}// 根据Telephone查询

	public List<XuntaUser> queryShowList(String state) throws SQLException,
			FileNotFoundException, NamingException, IOException {
		String sql = "SELECT phone,c.nineteen,c.twenty,b.state,b.nickname,b.number,flag,b.main_url FROM yohoo_user AS a LEFT JOIN yohoo_xunta_information AS b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form AS c ON a.phone=c.key_phone";
		List<XuntaUser> list = new ArrayList<XuntaUser>();
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql + " where b.state ='" + state + "'");
		// UserInformation ui=new UserInformation();
		while (rs.next()) {
			XuntaUser xtu = new XuntaUser();
			xtu.setPhone(rs.getString(1));
			xtu.setIntroduction(rs.getString(2));
			xtu.setCondition(rs.getString(3));
			xtu.setState(rs.getString(4));
			xtu.setNickname(rs.getString(5));
			xtu.setNumber(rs.getString(6));
			xtu.setFlag(rs.getString(7));
			xtu.setMain_url(rs.getString(8));
			list.add(xtu);
		}}finally{
		close();}
		if(list.equals(new ArrayList<XuntaUser>())) list=null;
		return list;
	}
public List<XuntaUser> queryShowList(String gender,String state,int pagenow) throws Exception {
String sql = "SELECT phone,c.nineteen,c.twenty,b.state,b.nickname,b.number,flag,b.main_url FROM yohoo_user AS a LEFT JOIN yohoo_xunta_information AS b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form AS c ON a.phone=c.key_phone";
List<XuntaUser> list = new ArrayList<XuntaUser>();
try{
conn = new ConnDao().getConn();
st = conn.createStatement();
rs = st.executeQuery(sql + " where b.state ='" + state + "' and a.gender='"+gender+"' and a.flag='"+YohooUser.WYZQ_REQUEST_PASS+"' order by b.number desc limit "+(pagenow-1)+","+PageBean.LENGTH_TEN);
System.out.print(gender+"::"+state+"::"+pagenow);
while (rs.next()) {
	XuntaUser xtu = new XuntaUser();
	xtu.setPhone(SecurityUnit.phoneEncode(rs.getString(1)));
	xtu.setIntroduction(rs.getString(2));
	xtu.setCondition(rs.getString(3));
	xtu.setState(rs.getString(4));
	xtu.setNickname(rs.getString(5));
	xtu.setNumber(rs.getString(6));
	xtu.setFlag(rs.getString(7));
	xtu.setMain_url(rs.getString(8));
	list.add(xtu);
}}finally{
close();}
if(list.equals(new ArrayList<XuntaUser>())) list=null;
return list;
}
public List<XuntaUser> queryShowList(String gender,String state,PageBean pb) throws Exception {
String sql = "SELECT phone,c.nineteen,c.twenty,b.state,b.nickname,b.number,flag,b.main_url FROM yohoo_user AS a LEFT JOIN yohoo_xunta_information AS b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form AS c ON a.phone=c.key_phone";
List<XuntaUser> list = new ArrayList<XuntaUser>();
try{
conn = new ConnDao().getConn();
st = conn.createStatement();
rs = st.executeQuery(sql + " where b.state ='" + state + "' and a.gender='"+gender+"' and a.flag='"+YohooUser.WYZQ_REQUEST_PASS+"' order by b.number desc limit "+(pb.getPagenow()-1)+",10");
// UserInformation ui=new UserInformation();
while (rs.next()) {
	XuntaUser xtu = new XuntaUser();
	xtu.setPhone(SecurityUnit.phoneEncode(rs.getString(1)));
	xtu.setIntroduction(rs.getString(2));
	xtu.setCondition(rs.getString(3));
	xtu.setState(rs.getString(4));
	xtu.setNickname(rs.getString(5));
	xtu.setNumber(rs.getString(6));
	xtu.setFlag(rs.getString(7));
	xtu.setMain_url(rs.getString(8));
	list.add(xtu);
}}finally{
close();}
if(list.equals(new ArrayList<XuntaUser>())) list=null;
return list;
}

	public XuntaUser queryDetail(String phone) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		XuntaUser xtu = new XuntaUser();
		String sql = "SELECT phone,c.nineteen,c.twenty,b.state FROM yohoo_user AS a LEFT JOIN yohoo_xunta_information AS b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form AS c ON a.phone=c.key_phone where phone='"
				+ phone + "'";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next()) {
			xtu.setPhone(rs.getString(1));
			xtu.setIntroduction(rs.getString(2));
			xtu.setCondition(rs.getString(3));
			xtu.setState(rs.getString(4));
			xtu.setList(queryImage(phone));
			return xtu;
		} else {
			return null;
		}}finally{
			close();
		}
	}

	public XuntaUser queryUserInformation(String phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		XuntaUser xtu = new XuntaUser();
		String sql = "select a.phone,c.nineteen,c.twenty,b.state,b.nickname," +
				"b.number,a.flag,b.main_url,a.gender,a.birthday,b.height,b.weight,a.occupation,b.marriage,b.education,b.nativeplace,a.creating_time,a.id,b.havebaby from yohoo_user as a left join yohoo_xunta_information as b ON a.phone=b.key_phone left join yohoo_xunta_form as c ON a.phone=c.key_phone where a.phone='"
				+ phone + "'";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next()) {
			xtu.setPhone(rs.getString(1));
			xtu.setIntroduction(rs.getString(2));
			xtu.setCondition(rs.getString(3));
			xtu.setState(rs.getString(4));
			xtu.setNickname(rs.getString(5));
			xtu.setNumber(rs.getString(6));
			xtu.setFlag(rs.getString(7));
			xtu.setMain_url(rs.getString(8));
			xtu.setGender(rs.getString(9));
			String age=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(new DateUnit().getYear(rs.getString(10))));
			xtu.setBirthday(age);
			xtu.setHeight(rs.getString(11));
			xtu.setWeight(rs.getString(12));
			xtu.setOccupation(rs.getString(13));
			xtu.setMarriage(rs.getString(14));
			xtu.setEducation(rs.getString(15));
			xtu.setNativeplace(rs.getString(16));
			xtu.setCreating_time(rs.getString(17));
			xtu.setId(rs.getInt(18));
			xtu.setHavebaby(rs.getString(19));
			xtu.setList(queryImage(phone));
		} else {
			xtu = null;
		}
		}finally{
		close();}
		return xtu;
	}

	public List<UserImage> queryImage(String phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		List<UserImage> list = new ArrayList<UserImage>();
		String sql = "select key_phone,image,id from yohoo_image where key_phone='"
				+ phone + "'";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			UserImage ui = new UserImage();
			ui.setKey_phone(rs.getString(1));
			ui.setImage(rs.getString(2));
			ui.setId(rs.getInt(3));
			list.add(ui);
		}}finally{
		rs.close();
		st.close();
		conn.close();
		}
		return list;
	}
	public List<UserImage> queryImageCopy(String phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		List<UserImage> list = new ArrayList<UserImage>();
		;
		UserImage ui = new UserImage();
		String sql = "select key_phone,image from yohoo_image where key_phone='"
				+ phone + "'";
		try{
		conn = new ConnDao().getConn();
	    st = conn.createStatement();
	    rs = st.executeQuery(sql);
		while (rs.next()) {
			ui.setKey_phone(rs.getString(1));
			ui.setImage(rs.getString(2));
			list.add(ui);
		}}finally{
		close();
		}
		return list;
	}

	public String queryState(int count) throws Exception {
		String str = "";
		String sql = "select distinct state from yohoo_xunta_information order by state desc";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			str += rs.getString(1);
			str += ",";
		}
		}finally{
		close();}
		if(!str.isEmpty())
		str = str.substring(0, str.length() - 1);
		return str;
	}
	public String queryState(String gender,int count) throws Exception {
		String str = "";
		String sql = "select distinct state from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone where gender='"+gender+"' order by state desc limit 0,4";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			str += rs.getString(1);
			str += ",";
		}}finally{
		close();}
		if(!str.isEmpty())
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public String queryState(int count, String state, int flag)
			throws Exception {
		String str = "";
		String sql = "select distinct b.state from yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone where b.state!='"
				+ state + "' and a.flag='" + flag + "' order by b.state desc";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			str += rs.getString(1);
			str += ",";
		}}finally{
		close();}
		str.trim();
		if(!str.isEmpty())
		str = str.substring(0, str.length()-1);
		return str;
	}
	public List<Integer> queryState(String gender,int count, String state, int flag)
			throws Exception {
		List<Integer> list=null;
		String sql = "select distinct b.state from yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone where b.state!='"
				+ state + "' and a.flag='" + flag + "' and gender='"+gender+"' order by b.state desc limit 0,"+count;
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		list=new ArrayList<Integer>();
		while (rs.next()) {
			list.add(Integer.valueOf(rs.getInt(1)));
		}}finally{
		close();}
		if(list.equals(new ArrayList<Integer>()))
			list=null;
		return list;
	}//主页显示期数
	public List<Integer> queryState(String gender, String state, int flag)
			throws Exception {
		List<Integer> list=null;
		String sql = "select distinct b.state from yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone where b.state!='"
				+ state + "' and a.flag='" + flag + "' and gender='"+gender+"' order by b.state desc";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		list=new ArrayList<Integer>();
		while (rs.next()) {
		list.add(Integer.valueOf(rs.getInt(1)));
		System.out.print(rs.getInt(1)+":");
		}}finally{
		close();}
		if(list.equals(new ArrayList<Integer>()))
			list=null;
		return list;
	}//显示全部期数
	public String queryState(String gender,int count, int flag)
			throws Exception {
		String str = "";
		String sql = "select distinct b.state from yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone where "
				+" a.flag='" + flag + "' and gender='"+gender+"' order by b.state desc limit 0,"+count;
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			str += rs.getString(1);
			str += ",";
		}}finally{
		close();}
		str.trim();
		if(!str.isEmpty())
		str = str.substring(0, str.length()-1);
		return str;
	}
	public int queryCount(String sql) throws SQLException,
			FileNotFoundException, NamingException, IOException {
		int count = 0;
		try{
		conn = new ConnDao().getConn();
	    st = conn.createStatement();
	    rs = st.executeQuery(sql);
		if (rs.next())
			count = rs.getInt(1);
		else
			count = 0;
		}finally{
		close();
		}
		return count;
	}
	public int queryCount(String type,int flag) throws SQLException,
	FileNotFoundException, NamingException, IOException {
		int count = 0;
		try{
conn = new ConnDao().getConn();
st = conn.createStatement();
String sql="";
if(type.equals("xunta")){
	sql="SELECT COUNT(*) FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"'";
}
else if(type.equals("qinzi")){
	sql="SELECT COUNT(*) FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"'";
}else if(type.equals("ruiqu")){
	sql="SELECT COUNT(*) FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"'";
}
rs = st.executeQuery(sql);
if (rs.next())
	count = rs.getInt(1);
else
	count = 0;
}finally{
	close();}
return count;
}
	public XuntaUser queryyuewo_detail(String from_phone) throws SQLException {
		XuntaUser xtu = new XuntaUser();
		String sql = "select nickname,birthday,height,weight,occupation,marriage,education from yohoo_user as a left join yohoo_xunta_information as b on a.phone=b.key_phone where key_phone='"
				+ from_phone + "'";
		try {
			conn = new ConnDao().getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				xtu.setNickname(rs.getString(1));
				xtu.setBirthday(rs.getString(2));
				xtu.setHeight(rs.getString(3));
				xtu.setWeight(rs.getString(4));
				xtu.setOccupation(rs.getString(5));
				xtu.setMarriage(rs.getString(6));
				xtu.setEducation(rs.getString(7));
				xtu.setPhone(from_phone);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();	
		}
		return xtu;
	}

	public int querydate_flag(String from_phone, String to_phone) throws SQLException {
		int flag = 0;
		String sql = "select date_flag from yohoo_date where from_phone='"
				+ from_phone + "' and to_phone='" + to_phone + "'";
		try {
			conn = new ConnDao().getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = rs.getInt(1);
			} else {
				flag = 0;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return flag;// 不为0为有此信息,否则没有此信息。
	}

	public XuntaUserForm queryXuntaUserFormByPhone(String phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		int time1=(int)new Date().getTime();
		   System.out.println(time1);
		XuntaUserForm xtuf = null;
		String sql = "select * from yohoo_xunta_form";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next())
			xtuf = new XuntaUserForm(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8),
					rs.getString(9), rs.getString(10), rs.getString(11),
					rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15), rs.getString(16), rs.getString(17),
					rs.getString(18), rs.getString(19), rs.getString(20));
		}finally{
		close();}
		int time2=(int)new Date().getTime();
		System.out.println(time2);
		System.out.println(time2-time1);
		return xtuf;
	}
/*
 * 查询约会是否发出过，是否是自己。
 */
	public boolean queryFlag(String from_phone, String to_phone)
			throws FileNotFoundException, NamingException, SQLException,
			IOException {
		boolean flag = false;
		String sql = "select * from yohoo_date where from_phone='" + from_phone
				+ "' and to_phone='" + to_phone + "' and from_phone!=to_phone";
		try{
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next())
			flag = true;
		}finally{
		close();}
		return flag;
	}
/*
 * 根据phone查询类型
 */
   public String queryTypeByPhone(String phone) throws SQLException, FileNotFoundException, NamingException, IOException{
	   String str=null;
	  try{
	   conn=new ConnDao().getConn();
	   st=conn.createStatement();
	   String sql="select type from yohoo_user where phone='"+phone+"'";
	   rs=st.executeQuery(sql);
	   if(rs.next()) str=rs.getString(1);
	  }finally{
	   close();}
	   return str;
   }
   public String queryGenderByPhone(String phone) throws SQLException, FileNotFoundException, NamingException, IOException{
	   String str=null;
	   try{
	   conn=new ConnDao().getConn();
	   st=conn.createStatement();
	   String sql="select gender from yohoo_user where phone='"+phone+"'";
	   rs=st.executeQuery(sql);
	   if(rs.next()) str=rs.getString(1);
	   }finally{
		   close();
	   }
	   return str;
   }
   public XuntaUserForm queryXuntaUserFormByPhone(String phone,int flag) throws FileNotFoundException, NamingException, SQLException, IOException{
	int time1=(int)new Date().getTime();
	   System.out.println(time1);
	   List<UserImage> list=queryImage(phone);
	   XuntaUserForm xtuf=null;
	   try{
	   conn=new ConnDao().getConn();
	st=conn.createStatement();
	String sql="SELECT * FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"'";
	rs=st.executeQuery(sql);
	int id=0;
	if(rs.next()) id=rs.getInt("a.id");
	else id=0;
	String name=rs.getString("name"); 
	String gender=rs.getString("gender");
	String birthday=rs.getString("birthday");
	String id_type=rs.getString("id_type");
	String id_number=rs.getString("id_number");
	String occupation=rs.getString("occupation");
	//String phone="";
	String email=rs.getString("email");
	String address=rs.getString("address");
	String type=rs.getString("type");
	int postcode=rs.getInt("postcode"); 
	//int  flag=0;
	String nativeplace=rs.getString("nativeplace");
	String work_organization=rs.getString("work_organization");
	double height=rs.getDouble("height");
	double weight=rs.getDouble("weight");
	String salary=rs.getString("salary");
	String onlychild=rs.getString("onlychild");
	String marriage=rs.getString("marriage");
	String havebaby=rs.getString("havebaby");
	String education=rs.getString("education");
	String nickname=rs.getString("nickname");
	String main_url=rs.getString("main_url");
	int date_flag=10;//并没有查询
	String introduction=rs.getString("nineteen");
	String condition=rs.getString("twenty");
	String number=rs.getString("number");
	String state=rs.getString("state");
	String one=rs.getString("one");
	String two=rs.getString("two");
	String three=rs.getString("three");
	String four=rs.getString("four");
	String five=rs.getString("five");
	String six=rs.getString("six"); 
	String seven=rs.getString("seven");
	String eight=rs.getString("eight"); 
	String nine=rs.getString("nine");
	String ten=rs.getString("ten");
	String eleven=rs.getString("eleven");
	String twelve=rs.getString("twelve");
	String thirteen=rs.getString("thirteen");
	String fourteen=rs.getString("fourteen");
	String fifteen=rs.getString("fifteen");
	String sixteen=rs.getString("sixteen");
	String seventeen=rs.getString("seventeen");
	String eighteen=rs.getString("eighteen");
	String nineteen=rs.getString("nineteen");
	String twenty=rs.getString("twenty");
	xtuf=new XuntaUserForm(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag, nativeplace, work_organization, height, weight, salary, onlychild, marriage, havebaby, education, nickname, main_url, date_flag, introduction, condition, number, list, state, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty);
	}finally{
	close();}
	   int time2=(int)new Date().getTime();
	   System.out.println(time2);
	System.out.println(time2-time1);
	return xtuf;
   }
   public List<XuntaUserForm> queryList_xtufByPhone(int flag) throws FileNotFoundException, NamingException, SQLException, IOException{
		List<XuntaUserForm> listt=new ArrayList<XuntaUserForm>();
		  int time1=(int)new Date().getTime();
		   System.out.println(time1);
		try{
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		String sql="SELECT * FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"'";
		rs=st.executeQuery(sql);
		int id=0;
		while(rs.next()){ 
		id=rs.getInt("a.id");
		String name=rs.getString("name"); 
		String gender=rs.getString("gender");
		String birthday=rs.getString("birthday");
		String id_type=rs.getString("id_type");
		String id_number=rs.getString("id_number");
		String occupation=rs.getString("occupation");
		String phone=rs.getString("phone");
		String email=rs.getString("email");
		String address=rs.getString("address");
		String type=rs.getString("type");
		int postcode=rs.getInt("postcode"); 
		//int  flag=0;
		String nativeplace=rs.getString("nativeplace");
		String work_organization=rs.getString("work_organization");
		double height=rs.getDouble("height");
		double weight=rs.getDouble("weight");
		String salary=rs.getString("salary");
		String onlychild=rs.getString("onlychild");
		String marriage=rs.getString("marriage");
		String havebaby=rs.getString("havebaby");
		String education=rs.getString("education");
		String nickname=rs.getString("nickname");
		String main_url=rs.getString("main_url");
		int date_flag=10;//并没有查询
		String introduction=rs.getString("nineteen");
		String condition=rs.getString("twenty");
		String number=rs.getString("number");
		String state=rs.getString("state");
		String one=rs.getString("one");
		String two=rs.getString("two");
		String three=rs.getString("three");
		String four=rs.getString("four");
		String five=rs.getString("five");
		String six=rs.getString("six"); 
		String seven=rs.getString("seven");
		String eight=rs.getString("eight"); 
		String nine=rs.getString("nine");
		String ten=rs.getString("ten");
		String eleven=rs.getString("eleven");
		String twelve=rs.getString("twelve");
		String thirteen=rs.getString("thirteen");
		String fourteen=rs.getString("fourteen");
		String fifteen=rs.getString("fifteen");
		String sixteen=rs.getString("sixteen");
		String seventeen=rs.getString("seventeen");
		String eighteen=rs.getString("eighteen");
		String nineteen=rs.getString("nineteen");
		String twenty=rs.getString("twenty");
		List<UserImage> list=queryImageCopy(phone);
		XuntaUserForm xtuf=new XuntaUserForm(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag, nativeplace, work_organization, height, weight, salary, onlychild, marriage, havebaby, education, nickname, main_url, date_flag, introduction, condition, number, list, state, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty);
		listt.add(xtuf);
		}
		}finally{
		close();}
		int time2=(int)new Date().getTime();
		System.out.println(time2);
		System.out.println(time2-time1);
		return listt;
	   }
   public List<XuntaUserForm> queryList_PagextufByPhone(PageBean pagebean,int flag) throws FileNotFoundException, NamingException, SQLException, IOException{
		List<XuntaUserForm> listt=new ArrayList<XuntaUserForm>();
		int limit1=(pagebean.getPagenow()-1)*pagebean.getItem();
		int limit2=pagebean.getItem();
		try{
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		String sql="SELECT * FROM yohoo_user a LEFT JOIN yohoo_xunta_information b ON a.phone=b.key_phone LEFT JOIN yohoo_xunta_form c ON b.key_phone=c.key_phone WHERE a.flag='"+flag+"' limit "+limit1+","+limit2;
		rs=st.executeQuery(sql);
		int id=0;
		while(rs.next()){ 
		id=rs.getInt("a.id");
		String name=rs.getString("name"); 
		String gender=rs.getString("gender");
		String birthday=rs.getString("birthday");
		String id_type=rs.getString("id_type");
		String id_number=rs.getString("id_number");
		String occupation=rs.getString("occupation");
		String phone=rs.getString("phone");
		String email=rs.getString("email");
		String address=rs.getString("address");
		String type=rs.getString("type");
		int postcode=rs.getInt("postcode"); 
		//int  flag=0;
		String nativeplace=rs.getString("nativeplace");
		String work_organization=rs.getString("work_organization");
		double height=rs.getDouble("height");
		double weight=rs.getDouble("weight");
		String salary=rs.getString("salary");
		String onlychild=rs.getString("onlychild");
		String marriage=rs.getString("marriage");
		String havebaby=rs.getString("havebaby");
		String education=rs.getString("education");
		String nickname=rs.getString("nickname");
		String main_url=rs.getString("main_url");
		int date_flag=10;//并没有查询
		String introduction=rs.getString("nineteen");
		String condition=rs.getString("twenty");
		String number=rs.getString("number");
		String state=rs.getString("state");
		String one=rs.getString("one");
		String two=rs.getString("two");
		String three=rs.getString("three");
		String four=rs.getString("four");
		String five=rs.getString("five");
		String six=rs.getString("six"); 
		String seven=rs.getString("seven");
		String eight=rs.getString("eight"); 
		String nine=rs.getString("nine");
		String ten=rs.getString("ten");
		String eleven=rs.getString("eleven");
		String twelve=rs.getString("twelve");
		String thirteen=rs.getString("thirteen");
		String fourteen=rs.getString("fourteen");
		String fifteen=rs.getString("fifteen");
		String sixteen=rs.getString("sixteen");
		String seventeen=rs.getString("seventeen");
		String eighteen=rs.getString("eighteen");
		String nineteen=rs.getString("nineteen");
		String twenty=rs.getString("twenty");
		List<UserImage> list=queryImage(phone);
		XuntaUserForm xtuf=new XuntaUserForm(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag, nativeplace, work_organization, height, weight, salary, onlychild, marriage, havebaby, education, nickname, main_url, date_flag, introduction, condition, number, list, state, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty);
		listt.add(xtuf);
		}}finally{
		close();
		}
		if(listt.equals(new ArrayList<XuntaUserForm>())) listt=null;
		return listt;
	   }
   public UserInformation queryUIF_twoByPhone(String from_phone,String to_phone) throws FileNotFoundException, NamingException, SQLException, IOException{
	   UserInformation ui=new UserInformation();
	   String sql="select * from yohoo_xunta_information as a left join yohoo_date as b on a.key_phone=b.from_phone where b.from_phone='"+from_phone+"' and b.to_phone='"+to_phone+"'";
	   try{
	   conn=new ConnDao().getConn();
	   st=conn.createStatement();
	   rs=st.executeQuery(sql);
	   if(rs.next()){
		   ui.setDate_number(rs.getString("b.date_number"));
		   ui.setMain_url(rs.getString("a.main_url"));
	   }
	   if(ui.equals(new UserInformation())) ui=null;
	   }finally{
	   close();}
	   return ui;
   }
   public Object queryObjectById(String id) throws SQLException, FileNotFoundException, NamingException, IOException{
	   conn=new ConnDao().getConn();
	   st=conn.createStatement();
	   String sql="select * from xunta_agree where id='"+id+"'";
	   rs=st.executeQuery(sql);
	   Object ob=null;
	   try{
	   if(rs.next()){
		   String agree=rs.getString("agree");
		   String content=rs.getString("content");
		   String creating_time=rs.getString("creating_time");
		   XuntaAgree xa=new XuntaAgree(id, agree, content, creating_time);
         ob=xa;
	   }}finally{
		   close();
	   }
	   return ob;
   }
   public Object queryObjectByPhone(String phone,Class classname) throws SQLException, FileNotFoundException, NamingException, IOException{
	   conn=new ConnDao().getConn();
	   String sql="";
	   Object object=null;
	  try{
	   if(classname.equals(YohooUser.class)){
	   sql="select * from yohoo_user where phone=?";
		   pstm=conn.prepareStatement(sql);
	   pstm.setString(1,phone);
	   rs=pstm.executeQuery();
	   YohooUser yu=null;
	   if(rs.next()){
		   int id=rs.getInt("id");
		   String name=rs.getString("name");
		   String gender=rs.getString("gender");
		   String birthday=rs.getString("birthday");
		   String id_type=rs.getString("id_type");
		   String id_number=rs.getString("id_number");
		   String occupation=rs.getString("occupation");
		   //String phone=phone;
		   String email=rs.getString("email");
		   String address=rs.getString("address");
		   String type=rs.getString("type");
		   int postcode=rs.getInt("postcode");
		   int flag=rs.getInt("flag");
		yu=new YohooUser(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag);
	   }
	   object=yu;
	   }else if(classname.equals(XuntaUser.class)){
		 XuntaUser xtu=null;
		sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone where a.phone=?";
		   pstm=conn.prepareStatement(sql);   
		   pstm.setString(1,phone);
		   rs=pstm.executeQuery();
		   if(rs.next()){
		   int id=rs.getInt("a.id");
		   String name=rs.getString("a.name");
		   String gender=rs.getString("a.gender");
		   String birthday=rs.getString("a.birthday");
		   String id_type=rs.getString("a.id_type");
		   String id_number=rs.getString("a.id_number");
		   String occupation=rs.getString("a.occupation");
		   //String phone=phone;
		   String email=rs.getString("a.email");
		   String address=rs.getString("a.address");
		   String type=rs.getString("a.type");
		   int postcode=rs.getInt("a.postcode");
		   int flag=rs.getInt("a.flag");
		   String nativeplace=rs.getString("b.nativeplace");
		   String work_organization=rs.getString("b.work_organization");
		   double height=rs.getDouble("b.height");
		   double weight=rs.getDouble("b.weight");
		   String salary=rs.getString("b.salary");
		   String onlychild=rs.getString("b.onlychild");
		   String marriage=rs.getString("b.marriage");
		   String havebaby=rs.getString("b.havebaby");
		   String education=rs.getString("b.education");
		   String nickname=rs.getString("b.nickname");
		   String main_url=rs.getString("b.main_url");
		   //int date_flag=rs.getInt("b.date_flag");
		   int date_flag=0;
		   //String introduction=rs.getString("b.introduction");
		   String introduction=null;
		  // String condition=rs.getString("b.condition");
		   String condition=null;
		   String number=rs.getString("b.number");
		   List<UserImage> list=queryImage(phone);
		   String state=rs.getString("b.state");
		   xtu=new XuntaUser(id, name, gender, birthday, id_type, id_number, occupation, phone,
				   email, address, type, postcode, flag
				   , nativeplace, work_organization, height, weight, salary, onlychild,
				   marriage, havebaby, education, nickname, main_url, date_flag, introduction, 
				   condition, number, list, state);
		   
		   } 
		   object=xtu;
	   }else if(classname.equals(XuntaUserForm.class)){
		sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone left join yohoo_xunta_form c on a.phone=c.key_phone where a.phone=?";
		   pstm=conn.prepareStatement(sql);
		   XuntaUserForm xtuf=null;   
			   pstm.setString(1,phone);
			   rs=pstm.executeQuery();
			   if(rs.next()){
			   int id=rs.getInt("a.id");
			   String name=rs.getString("a.name");
			   String gender=rs.getString("a.gender");
			   String birthday=rs.getString("a.birthday");
			   String id_type=rs.getString("a.id_type");
			   String id_number=rs.getString("a.id_number");
			   String occupation=rs.getString("a.occupation");
			   //String phone=phone;
			   String email=rs.getString("a.email");
			   String address=rs.getString("a.address");
			   String type=rs.getString("a.type");
			   String creating_time=rs.getString("a.creating_time");
			   int postcode=rs.getInt("a.postcode");
			   int flag=rs.getInt("a.flag");
			   String nativeplace=rs.getString("b.nativeplace");
			   String work_organization=rs.getString("b.work_organization");
			   double height=rs.getDouble("b.height");
			   double weight=rs.getDouble("b.weight");
			   String salary=rs.getString("b.salary");
			   String onlychild=rs.getString("b.onlychild");
			   String marriage=rs.getString("b.marriage");
			   String havebaby=rs.getString("b.havebaby");
			   String education=rs.getString("b.education");
			   String nickname=rs.getString("b.nickname");
			   String main_url=rs.getString("b.main_url");
			   //int date_flag=rs.getInt("b.date_flag");
			   int date_flag=0;
			   //String introduction=rs.getString("b.introduction");
			   String introduction=null;
			  // String condition=rs.getString("b.condition");
			   String condition=null;
			   String number=rs.getString("b.number");
			   List<UserImage> list=queryImage(phone);
			   String state=rs.getString("b.state");
			   String one=rs.getString("c.one");
			   String two=rs.getString("c.two");
			   String three=rs.getString("c.three");
			   String four=rs.getString("c.four");
			   String five=rs.getString("c.five");
			   String six=rs.getString("c.six");
			   String seven=rs.getString("c.seven");
			   String eight=rs.getString("c.eight");
			   String nine=rs.getString("c.nine");
			   String ten=rs.getString("c.ten");
			   String eleven=rs.getString("c.eleven");
			   String twelve=rs.getString("c.twelve");
			   String thirteen=rs.getString("c.thirteen");
			   String fourteen=rs.getString("c.fourteen");
			   String fifteen=rs.getString("c.fifteen");
			   String sixteen=rs.getString("c.sixteen");
			   String seventeen=rs.getString("c.seventeen");
			   String eighteen=rs.getString("c.eighteen");
			   String nineteen=rs.getString("c.nineteen");
			   String twenty=rs.getString("c.twenty");
			   xtuf=new XuntaUserForm(id, name, gender, birthday, id_type,
					   id_number, occupation, phone, email, address, 
					   id_type, postcode, flag, nativeplace, 
					   work_organization, height, weight, salary, onlychild, 
					   marriage, havebaby, education, nickname, main_url,
					   date_flag, introduction, condition,number, list, state,
					   one, two, three, four, five, six, seven, eight, nine, ten,
					   eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen,
					   eighteen, nineteen, twenty);
			   xtuf.setCreating_time(creating_time);
			   }
			   object=xtuf;  
	   }else if(classname.equals(YohooMember.class)){
		   sql="select * from yohoo_member where phone=?";
		   pstm=conn.prepareStatement(sql);
		   YohooMember ym=null;   
			pstm.setString(1,phone);
			rs=pstm.executeQuery();
	      if(rs.next()){
	    	  //String phone=rs.getString("phone");
	    	  String number=rs.getString("number");
	    	  String creating_time=rs.getString("creating_time");
	    	  ym=new YohooMember(phone, number, creating_time);
	    	}
	      object=ym;
	   }else if(classname.equals(YohooActivities.class)){
		   sql="select * from yohoo_activities where phone=?";
		   pstm=conn.prepareStatement(sql);
		   YohooActivities ya=null;   
			pstm.setString(1,phone);
			rs=pstm.executeQuery();
	      if(rs.next()){
	    	  //String phone=rs.getString("phone");
	    	  String id=rs.getString("id");
	    	  int flag=rs.getInt("flag");
	    	  String creating_time=rs.getString("creating_time");
	    	  ya=new YohooActivities(id, phone, flag, creating_time);
	    	}
	      object=ya;
	   }
	   
	  }finally{
		   close_pstm();
	   }   
	  return object;
   }
   public List<Object> queryReviewList(Class classname,PageBean pb) throws FileNotFoundException, NamingException, SQLException, IOException{
	   List<Object> list=null;
	   conn=new ConnDao().getConn();
	   String sql="";
	   Object object=null;
	  try{
	   if(classname.equals(YohooUser.class)){
		   int offset=pb.getPagenow()-1;
		   int length=pb.getItem();
		   sql="select * from yohoo_user limit "+offset+","+length;
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);
	   YohooUser yu=null;
	   list=new ArrayList<Object>();
	   while(rs.next()){
		   int id=rs.getInt("id");
		   String name=rs.getString("name");
		   String gender=rs.getString("gender");
		   String birthday=rs.getString("birthday");
		   String id_type=rs.getString("id_type");
		   String id_number=rs.getString("id_number");
		   String occupation=rs.getString("occupation");
		   String phone=rs.getString("phone");
		   String email=rs.getString("email");
		   String address=rs.getString("address");
		   String type=rs.getString("type");
		   int postcode=rs.getInt("postcode");
		   int flag=rs.getInt("flag");
		yu=new YohooUser(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag);
		object=yu;
		list.add(object);
	   }
	   }else if(classname.equals(XuntaUser.class)){
		 XuntaUser xtu=null;
		 list=new ArrayList<Object>();
		   int offset=pb.getPagenow()-1;
		   int length=pb.getItem();
		 sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone limit "+offset+","+length;
		st=conn.createStatement();
	       rs=st.executeQuery(sql);
		   while(rs.next()){
		   int id=rs.getInt("a.id");
		   String name=rs.getString("a.name");
		   String gender=rs.getString("a.gender");
		   String birthday=rs.getString("a.birthday");
		   String id_type=rs.getString("a.id_type");
		   String id_number=rs.getString("a.id_number");
		   String occupation=rs.getString("a.occupation");
		   String phone=rs.getString("phone");
		   String email=rs.getString("a.email");
		   String address=rs.getString("a.address");
		   String type=rs.getString("a.type");
		   int postcode=rs.getInt("a.postcode");
		   int flag=rs.getInt("a.flag");
		   String nativeplace=rs.getString("b.nativeplace");
		   String work_organization=rs.getString("b.work_organization");
		   double height=rs.getDouble("b.height");
		   double weight=rs.getDouble("b.weight");
		   String salary=rs.getString("b.salary");
		   String onlychild=rs.getString("b.onlychild");
		   String marriage=rs.getString("b.marriage");
		   String havebaby=rs.getString("b.havebaby");
		   String education=rs.getString("b.education");
		   String nickname=rs.getString("b.nickname");
		   String main_url=rs.getString("b.main_url");
		   int date_flag=rs.getInt("b.date_flag");
		   String introduction=rs.getString("b.introduction");
		   String condition=rs.getString("b.condition");
		   String number=rs.getString("b.number");
		   List<UserImage> list_image=queryImage(phone);
		   String state=rs.getString("b.state");
		   xtu=new XuntaUser(id, name, gender, birthday, id_type, id_number, occupation, phone,
				   email, address, type, postcode, flag
				   , nativeplace, work_organization, height, weight, salary, onlychild,
				   marriage, havebaby, education, nickname, main_url, date_flag, introduction, 
				   condition, number, list_image, state);
		   object=xtu;
		   list.add(object);
		   } 
	   }else if(classname.equals(XuntaUserForm.class)){
		   list=new ArrayList<Object>();
		   int offset=pb.getPagenow()-1;
		   int length=pb.getItem();
		sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone left join yohoo_xunta_form c on a.phone=c.key_phone limit "+offset+","+length;
		   XuntaUserForm xtuf=null;   
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);  
		   while(rs.next()){
			   int id=rs.getInt("a.id");
			   String name=rs.getString("a.name");
			   String gender=rs.getString("a.gender");
			   String birthday=rs.getString("a.birthday");
			   String id_type=rs.getString("a.id_type");
			   String id_number=rs.getString("a.id_number");
			   String occupation=rs.getString("a.occupation");
			   String phone=rs.getString("a.phone");
			   String email=rs.getString("a.email");
			   String address=rs.getString("a.address");
			   String type=rs.getString("a.type");
			   int postcode=rs.getInt("a.postcode");
			   int flag=rs.getInt("a.flag");
			   String nativeplace=rs.getString("b.nativeplace");
			   String work_organization=rs.getString("b.work_organization");
			   double height=rs.getDouble("b.height");
			   double weight=rs.getDouble("b.weight");
			   String salary=rs.getString("b.salary");
			   String onlychild=rs.getString("b.onlychild");
			   String marriage=rs.getString("b.marriage");
			   String havebaby=rs.getString("b.havebaby");
			   String education=rs.getString("b.education");
			   String nickname=rs.getString("b.nickname");
			   String main_url=rs.getString("b.main_url");
			   int date_flag=0;
			   String introduction=rs.getString("c.nineteen");
			   String condition=rs.getString("c.twenty");
			   String number=rs.getString("b.number");
			   List<UserImage> list_image=queryImage(phone);
			   String state=rs.getString("b.state");
			   String one=rs.getString("c.one");
			   String two=rs.getString("c.two");
			   String three=rs.getString("c.three");
			   String four=rs.getString("c.four");
			   String five=rs.getString("c.five");
			   String six=rs.getString("c.six");
			   String seven=rs.getString("c.seven");
			   String eight=rs.getString("c.eight");
			   String nine=rs.getString("c.nine");
			   String ten=rs.getString("c.ten");
			   String eleven=rs.getString("c.eleven");
			   String twelve=rs.getString("c.twelve");
			   String thirteen=rs.getString("c.thirteen");
			   String fourteen=rs.getString("c.fourteen");
			   String fifteen=rs.getString("c.fifteen");
			   String sixteen=rs.getString("c.sixteen");
			   String seventeen=rs.getString("c.seventeen");
			   String eighteen=rs.getString("c.eighteen");
			   String nineteen=rs.getString("c.nineteen");
			   String twenty=rs.getString("c.twenty");
			   xtuf=new XuntaUserForm(id, name, gender, birthday, id_type,
					   id_number, occupation, phone, email, address, 
					   id_type, postcode, flag, nativeplace, 
					   work_organization, height, weight, salary, onlychild, 
					   marriage, havebaby, education, nickname, main_url,
					   date_flag, introduction, condition, id_number, list_image, state,
					   one, two, three, four, five, six, seven, eight, nine, ten,
					   eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen,
					   eighteen, nineteen, twenty);
			   xtuf.setNumber(number);
			   xtuf.setType(type);
			   object=xtuf;  
			   list.add(object);  
			   }   
	   }}finally{
		   close();
	   }   
	 if(list.equals(new ArrayList<Object>()))
		 list=null;
	   return list;
   }
   public List<Object> queryReviewListAboutFlag(Class classname,PageBean pb,int tableflag) throws FileNotFoundException, NamingException, SQLException, IOException{
	   List<Object> list=null;
	   conn=new ConnDao().getConn();
	   String sql="";
	   Object object=null;
	  try{
	   if(classname.equals(YohooUser.class)){
		   int length=pb.getItem();
		   int offset=(pb.getPagenow()-1)*length;
		   sql="select * from yohoo_user limit "+offset+","+length;
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);
	   YohooUser yu=null;
	   list=new ArrayList<Object>();
	   while(rs.next()){
		   int id=rs.getInt("id");
		   String name=rs.getString("name");
		   String gender=rs.getString("gender");
		   String birthday=rs.getString("birthday");
		   String id_type=rs.getString("id_type");
		   String id_number=rs.getString("id_number");
		   String occupation=rs.getString("occupation");
		   String phone=rs.getString("phone");
		   String email=rs.getString("email");
		   String address=rs.getString("address");
		   String type=rs.getString("type");
		   int postcode=rs.getInt("postcode");
		   int flag=rs.getInt("flag");
		yu=new YohooUser(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type, postcode, flag);
		object=yu;
		list.add(object);
	   }
	   }else if(classname.equals(XuntaUser.class)){
		 XuntaUser xtu=null;
		 list=new ArrayList<Object>();
		 int length=pb.getItem();
		   int offset=(pb.getPagenow()-1)*length;
		 sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone limit "+offset+","+length;
		st=conn.createStatement();
	       rs=st.executeQuery(sql);
		   while(rs.next()){
		   int id=rs.getInt("a.id");
		   String name=rs.getString("a.name");
		   String gender=rs.getString("a.gender");
		   String birthday=rs.getString("a.birthday");
		   String id_type=rs.getString("a.id_type");
		   String id_number=rs.getString("a.id_number");
		   String occupation=rs.getString("a.occupation");
		   String phone=rs.getString("phone");
		   String email=rs.getString("a.email");
		   String address=rs.getString("a.address");
		   String type=rs.getString("a.type");
		   int postcode=rs.getInt("a.postcode");
		   int flag=rs.getInt("a.flag");
		   String nativeplace=rs.getString("b.nativeplace");
		   String work_organization=rs.getString("b.work_organization");
		   double height=rs.getDouble("b.height");
		   double weight=rs.getDouble("b.weight");
		   String salary=rs.getString("b.salary");
		   String onlychild=rs.getString("b.onlychild");
		   String marriage=rs.getString("b.marriage");
		   String havebaby=rs.getString("b.havebaby");
		   String education=rs.getString("b.education");
		   String nickname=rs.getString("b.nickname");
		   String main_url=rs.getString("b.main_url");
		   int date_flag=rs.getInt("b.date_flag");
		   String introduction=rs.getString("b.introduction");
		   String condition=rs.getString("b.condition");
		   String number=rs.getString("b.number");
		   List<UserImage> list_image=queryImage(phone);
		   String state=rs.getString("b.state");
		   xtu=new XuntaUser(id, name, gender, birthday, id_type, id_number, occupation, phone,
				   email, address, type, postcode, flag
				   , nativeplace, work_organization, height, weight, salary, onlychild,
				   marriage, havebaby, education, nickname, main_url, date_flag, introduction, 
				   condition, number, list_image, state);
		   object=xtu;
		   list.add(object);
		   } 
	   }else if(classname.equals(XuntaUserForm.class)){
		   list=new ArrayList<Object>();
		   int length=pb.getItem();
		   int offset=(pb.getPagenow()-1)*length;
		sql="select * from yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone left join yohoo_xunta_form c on a.phone=c.key_phone where a.flag="+tableflag+" limit "+offset+","+length;
		   XuntaUserForm xtuf=null;   
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);  
		   while(rs.next()){
			   int id=rs.getInt("a.id");
			   String name=rs.getString("a.name");
			   String gender=rs.getString("a.gender");
			   String birthday=rs.getString("a.birthday");
			   String id_type=rs.getString("a.id_type");
			   String id_number=rs.getString("a.id_number");
			   String occupation=rs.getString("a.occupation");
			   String phone=rs.getString("a.phone");
			   String email=rs.getString("a.email");
			   String address=rs.getString("a.address");
			   String type=rs.getString("a.type");
			   int postcode=rs.getInt("a.postcode");
			   int flag=rs.getInt("a.flag");
			   String nativeplace=rs.getString("b.nativeplace");
			   String work_organization=rs.getString("b.work_organization");
			   double height=rs.getDouble("b.height");
			   double weight=rs.getDouble("b.weight");
			   String salary=rs.getString("b.salary");
			   String onlychild=rs.getString("b.onlychild");
			   String marriage=rs.getString("b.marriage");
			   String havebaby=rs.getString("b.havebaby");
			   String education=rs.getString("b.education");
			   String nickname=rs.getString("b.nickname");
			   String main_url=rs.getString("b.main_url");
			   int date_flag=0;
			   String introduction=rs.getString("c.nineteen");
			   String condition=rs.getString("c.twenty");
			   String number=rs.getString("b.number");
			   List<UserImage> list_image=queryImage(phone);
			   String state=rs.getString("b.state");
			   String one=rs.getString("c.one");
			   String two=rs.getString("c.two");
			   String three=rs.getString("c.three");
			   String four=rs.getString("c.four");
			   String five=rs.getString("c.five");
			   String six=rs.getString("c.six");
			   String seven=rs.getString("c.seven");
			   String eight=rs.getString("c.eight");
			   String nine=rs.getString("c.nine");
			   String ten=rs.getString("c.ten");
			   String eleven=rs.getString("c.eleven");
			   String twelve=rs.getString("c.twelve");
			   String thirteen=rs.getString("c.thirteen");
			   String fourteen=rs.getString("c.fourteen");
			   String fifteen=rs.getString("c.fifteen");
			   String sixteen=rs.getString("c.sixteen");
			   String seventeen=rs.getString("c.seventeen");
			   String eighteen=rs.getString("c.eighteen");
			   String nineteen=rs.getString("c.nineteen");
			   String twenty=rs.getString("c.twenty");
			   xtuf=new XuntaUserForm(id, name, gender, birthday, id_type,
					   id_number, occupation, phone, email, address, 
					   id_type, postcode, flag, nativeplace, 
					   work_organization, height, weight, salary, onlychild, 
					   marriage, havebaby, education, nickname, main_url,
					   date_flag, introduction, condition, id_number, list_image, state,
					   one, two, three, four, five, six, seven, eight, nine, ten,
					   eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen,
					   eighteen, nineteen, twenty);
			   xtuf.setNumber(number);
			   xtuf.setType(type);
			   object=xtuf;  
			   list.add(object);  
			   }   
	   }else if(classname.equals(DateBean.class)){
		   list=new ArrayList<Object>();
		   int length=pb.getItem();
		   int offset=(pb.getPagenow()-1)*length;
		sql="select * from yohoo_date where date_flag='"+tableflag+"' limit "+offset+","+length;
		    DateBean db=null;   
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);  
	       while(rs.next()){
	    	   int id=0;
	    	   String from_id=rs.getString("from_phone");
	    	   String to_id=rs.getString("to_phone");
	    	   String date_time=rs.getString("date_time");
	    	   int date_flag=rs.getInt("date_flag");
	    	   String content=rs.getString("content");
	    	   String date_number=rs.getString("date_number");
	    	   db=new DateBean(id, from_id, to_id, date_time, date_flag, content, date_number);
	    	   object=db;
	    	   list.add(db);
	       }
	   }else if(classname.equals(YohooActivities.class)){
		   list=new ArrayList<Object>();
		   int length=pb.getItem();
		   int offset=(pb.getPagenow()-1)*length;
		sql="select * from yohoo_activities where flag='"+tableflag+"' limit "+offset+","+length;
		    YohooActivities db=null;   
		   st=conn.createStatement();
	       rs=st.executeQuery(sql);  
	       while(rs.next()){
	    	   String id=null;
	    	   String phone=rs.getString("phone");
	    	   String creating_time=rs.getString("creating_time");
	    	   db=new YohooActivities(id, phone, tableflag, creating_time);
	    	   object=db;
	    	   list.add(db);
	       }
	   }
	   
	  }finally{
		   close();
	   }   
	 if(list.equals(new ArrayList<Object>()))
		 list=null;
	   return list;
   }
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
	}
	public void close_pstm() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstm != null)
			pstm.close();
		if (conn != null)
			conn.close();
	}
	public DateBean queryDateBean(String from_phone, String to_phone) throws FileNotFoundException, NamingException, SQLException, IOException {
		// TODO Auto-generated method stub
		DateBean db=null;
		try{
		conn=new ConnDao().getConn();
		String sql="select * from yohoo_date where from_phone=? and to_phone=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,from_phone);
		pstm.setString(2,to_phone);
		rs=pstm.executeQuery();
		if(rs.next()){
			db=new DateBean();
			db.setId(rs.getInt("id"));
		    db.setFrom_id(rs.getString("from_phone"));
		    db.setTo_id(rs.getString("to_phone"));
		    db.setContent(rs.getString("content"));
		    db.setDate_time(rs.getString("date_time"));
		    db.setDate_flag(rs.getInt("date_flag"));
		    db.setDate_number(rs.getString("date_number"));
		   }
		}finally{
			close_pstm();
		}
		return db;
	}
	public int queryMaxNumber(int state,String gender) throws SQLException, FileNotFoundException, NamingException, IOException{
	int	yohoo_flag=YohooUser.WYZQ_REQUEST_PASS;
	int number=0;
	try{
	conn=new ConnDao().getConn();
	String sql="select MAX(number) FROM yohoo_user a left join yohoo_xunta_information b on a.phone=b.key_phone WHERE b.state=? and a.gender=? and a.flag="+yohoo_flag+"";
	//System.out.print("SQL:"+sql);
	pstm=conn.prepareStatement(sql);
	pstm.setString(1,String.valueOf(state));
	pstm.setString(2,gender);
	rs=pstm.executeQuery();
	if(rs.next()){
		number=rs.getInt(1);
		//System.out.print("MAX:"+number);
	}}finally{
		close_pstm();
		
	}
	return number;
	}
	public XuntaDeclare queryDeclare(String number,String type0) throws SQLException, FileNotFoundException, NamingException, IOException{
		XuntaDeclare xd=null;
		try{
		conn=new ConnDao().getConn();
		String sql="select * from yohoo_xunta_declare where date_number=? and type=?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,number);
		pstm.setString(2,type0);
		rs=pstm.executeQuery();
		if(rs.next()){
			int id=rs.getInt("id");
			String date_number=rs.getString("date_number");
			String phone=rs.getString("key_phone");
			String type=rs.getString("type");
			String content=rs.getString("content");
			String star=rs.getString("star");
			String agree=rs.getString("agree");
			String declare_time=rs.getString("declare_time");
			xd=new XuntaDeclare(id, date_number, phone, type, content, star, agree, declare_time);
		}}finally{
			close_pstm();
		}
		return xd;
		}
		
}
