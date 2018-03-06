package cn.net.www.dao;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import cn.net.www.base.PhoneDigest;
import cn.net.www.bean.DateBean;
import cn.net.www.bean.QinziBabe;
import cn.net.www.bean.QinziForm;
import cn.net.www.bean.QinziSpouse;
import cn.net.www.bean.RuiquPartner;
import cn.net.www.bean.UserInformation;
import cn.net.www.bean.XuntaAgree;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.bean.YohooActivities;
import cn.net.www.bean.YohooCheckCode;
import cn.net.www.bean.YohooLogin;
import cn.net.www.bean.YohooMember;
import cn.net.www.bean.YohooUser;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.ParseInputStream;
import cn.net.www.unit.ReturnNumber;
import cn.net.www.unit.SecurityUnit;

public class InsertDao {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
    private PreparedStatement pstm=null;
	public boolean insert(String sql) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		boolean flag = false;
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		int i=0;
		try{
		i = st.executeUpdate(sql);
		}finally{
			close();
		}
		if (i == 1)
			flag = true;
		return flag;
	}
    public boolean insertObject(Object ob,Class classname) throws FileNotFoundException, NamingException, IOException{
    	boolean flag=false;
    	try{
    	conn=new ConnDao().getConn();
    	String sql="";
    	if(classname.equals(YohooCheckCode.class)){
    	   YohooCheckCode ycc=(YohooCheckCode)ob;
    		sql="insert yohoo_checkcode(phone,checkcode,get_time) value(?,?,?)";
    	   pstm=conn.prepareStatement(sql);
    	   pstm.setString(1,ycc.getPhone());
    	   pstm.setString(2,ycc.getCheckcode());
		   pstm.setString(3,ycc.getGet_time());
    	}else if(classname.equals(YohooLogin.class)){
     	   YohooLogin yl=(YohooLogin)ob;
     		sql="insert yohoo_login(phone,lastlogin,last_faillogin,common_use_ip,faillogin_counter) value(?,?,?,?,?)";
     	   pstm=conn.prepareStatement(sql);
     	   pstm.setString(1,yl.getPhone());
     	   pstm.setString(2,yl.getLastlogin());
 		   pstm.setString(3,yl.getLast_faillogin());
 		   pstm.setString(4,yl.getCommon_use_ip());
 		   pstm.setString(5,yl.getFaillogin_counter());   
     	}else if(classname.equals(YohooMember.class)){
     		YohooMember ym=(YohooMember)ob;
     		sql="insert yohoo_member(phone,number,creating_time) value(?,?,?)";
     		pstm=conn.prepareStatement(sql);
      	   pstm.setString(1,ym.getPhone());
      	   pstm.setString(2,ym.getNumber());
      	   pstm.setString(3,ym.getCreating_time());
     	}else if(classname.equals(YohooActivities.class)){
     		YohooActivities ya=(YohooActivities)ob;
     		sql="insert yohoo_activities(phone,flag,creating_time) value(?,?,?)";
     		pstm=conn.prepareStatement(sql);
      	   pstm.setString(1,ya.getPhone());
      	   pstm.setInt(2,ya.getFlag());
      	   pstm.setString(3,ya.getCreating_time());
     	}else if(classname.equals(XuntaAgree.class)){
     		XuntaAgree xa=(XuntaAgree)ob;
     		sql="insert xunta_agree(id,agree,content,creating_time) value(?,?,?,?)";
     		pstm=conn.prepareStatement(sql);
      	   pstm.setString(1,xa.getId());
      	   pstm.setString(2,xa.getAgree());
      	   pstm.setString(3,xa.getContent());
      	   pstm.setString(4,xa.getCreating_time());
     	}
    	int flag_int=0;
    	flag_int=pstm.executeUpdate();
    	if(flag_int==0){
    		flag=false;
    	}else{
    		flag=true;
    	}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    	close_pstm();	
    	}
    	return flag;
    }
     public boolean insertAgreeAndUpdateFlag(XuntaAgree xa,int date_flag) throws FileNotFoundException, NamingException, SQLException, IOException{
    	 boolean out=false;
    	 try{
    	 conn=new ConnDao().getConn();
    	 conn.setAutoCommit(false);
    	st=conn.createStatement();
    	String id=xa.getId();
    	String agree=xa.getAgree();
    	String content=xa.getContent();
    	String creating_time=xa.getCreating_time();
    	String sql1="insert xunta_agree(id,agree,content,creating_time) value('"+id+"','"+agree+"','"+content+"','"+creating_time+"')";
    	String sql2="update yohoo_date set date_flag='"+date_flag+"' where date_number='"+id+"'";
    	st.addBatch(sql1);
    	st.addBatch(sql2);
    	int[] int_out=st.executeBatch();
    	conn.commit();
    	for(int i=0;i<int_out.length;i++){
    		if(int_out[i]==Statement.EXECUTE_FAILED){
    			out=false;
    			break;
    		}else{
    			out=true;
    		}
    	}}catch(SQLException e){
    		e.printStackTrace();
    		conn.rollback();
    	}finally{
    		st.close();
    		conn.close();
    	}
    	return out;
     }
	public boolean insertImage(String filename_total, HttpServletRequest request)
			throws SQLException, FileNotFoundException, NamingException,
			IOException {
		filename_total = filename_total.substring(0,
				filename_total.length() - 1).trim();
		String id = String.valueOf((request.getSession().getAttribute("id")));
		String[] filename = filename_total.split(",");
		conn = new ConnDao().getConn();
		st = conn.createStatement();
		boolean flag = false;
		int i = 0;
		try {
			conn.setAutoCommit(false);// 设置为手动提交
			for (String name : filename) {
				String sql = "insert into youhuo_image(imageurl,keyid) values('"
						+ id + "/" + name + "','" + id + "')";
				st.addBatch(sql);
				i++;
			}
			System.out.print(i);
			flag = true;
			st.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			conn.rollback();
		} finally {
			st.close();
			conn.close();
		}
		return flag;
	}
	public int register(String type,String step){
		return 0;
	}
	public int register_xunta(String filename_total, XuntaUser xtu)
			throws SQLException, FileNotFoundException, NamingException,
			IOException {
		if (!filename_total.isEmpty()) {
			System.out.print(filename_total);
			filename_total = filename_total.substring(0,
					filename_total.length());
		}
		String phone = String.valueOf(xtu.getPhone());
		String[] filename = filename_total.split(",");
		conn = new ConnDao().getConn();
		//st = conn.createStatement();
		String sql1="insert into yohoo_image(image,key_phone) values(?,?)"; 
		String sql2="INSERT INTO `yohoo_user` (`name`, `gender`, `birthday`, `id_type`, `id_number`, `occupation`, `phone`, `email`, `address`, `postcode`, `flag`, `type`,`creating_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql3="INSERT INTO `yohoo_xunta_information` (`key_phone`, `nativeplace`, `work_organization`, `height`, `weight`, `salary`, `onlychild`, `marriage`, `havebaby`,`nickname`,`state`,`education`,`main_url`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int flag = 0;
		try {
			conn.setAutoCommit(false);// 设置为手动提交
			for (String name : filename) {
				//String sql = "insert into yohoo_image(image,key_phone) values('"
				//		+ name + "','" + phone + "')";
				pstm=conn.prepareStatement(sql1);
				pstm.setString(1,name);
				pstm.setString(2,phone);
				//st.addBatch(sql);
				pstm.addBatch();
				pstm.executeBatch();
			}
			String name = xtu.getName();
			String gender = xtu.getGender();
			String birthday = xtu.getBirthday();
			String id_type = xtu.getId_type();
			String id_number = xtu.getId_number();
			String occupation = xtu.getOccupation();
			String email = xtu.getEmail();
			String address = xtu.getAddress();
			int postcode = xtu.getPostcode();
			//String type=xtu.getType();
			String type="xunta";
			int tableflag = 1;
			String creating_time=DateUnit.returnStringAboutPattern(DateUnit.PATTERN,new Date());
			pstm=conn.prepareStatement(sql2);
			pstm.setString(1,name);
			pstm.setString(2,gender);
			pstm.setString(3,birthday);
			pstm.setString(4,id_type);
			pstm.setString(5,id_number);
			pstm.setString(6,occupation);
			pstm.setString(7,phone);
			pstm.setString(8,email);
			pstm.setString(9,address);
			pstm.setString(10,String.valueOf(postcode));
			pstm.setString(11,String.valueOf(tableflag));
			pstm.setString(12,type);
			pstm.setString(13,creating_time);
			pstm.addBatch();
			pstm.executeBatch();
			String nativeplace = xtu.getNativeplace();
			String work_organization = xtu.getWork_organization();
			double height = xtu.getHeight();
			double weight = xtu.getWeight();
			String salary = xtu.getSalary();
			String onlychild = xtu.getOnlychild();
			String marriage = xtu.getMarriage();
			String havebaby = xtu.getHavebaby();
			String nickname = xtu.getNickname();
			//String state = xtu.getState();
			String state=null;
			String education = xtu.getEducation();
			pstm=conn.prepareStatement(sql3);
			pstm.setString(1,phone);
			pstm.setString(2,nativeplace);
			pstm.setString(3,work_organization);
			pstm.setString(4,String.valueOf(height));
			pstm.setString(5,String.valueOf(weight));
			pstm.setString(6,salary);
			pstm.setString(7,onlychild);
			pstm.setString(8,marriage);
			pstm.setString(9,havebaby);
			pstm.setString(10,nickname);
			pstm.setString(11,state);
			pstm.setString(12,education);
			pstm.setString(13,filename[0]);
			pstm.addBatch();
			pstm.executeBatch();
			flag = 4;// 添加成功
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = 3;// 添加失败
			conn.rollback();
		} finally {
			pstm.close();
			conn.close();
		}
		return flag;
	}

	public int registerForm(XuntaUserForm xtuf) throws FileNotFoundException,
			NamingException, SQLException, IOException {
		int flag = 0;
		try {
			conn = new ConnDao().getConn();
			st = conn.createStatement();
			conn.setAutoCommit(false);
			st.addBatch("INSERT INTO `yohoo_xunta_form` (`key_phone`, `one`, `two`, `three`, `four`, `five`, `six`, `seven`, `eight`, `nine`, `ten`, `eleven`, `twelve`, `thirteen`, `fourteen`, `fifteen`, `sixteen`, `seventeen`, `eighteen`, `nineteen`, `twenty`) VALUES ('"
					+ xtuf.getPhone()
					+ "', '"
					+ xtuf.getOne()
					+ "', '"
					+ xtuf.getTwo()
					+ "', '"
					+ xtuf.getThree()
					+ "', '"
					+ xtuf.getFour()
					+ "', '"
					+ xtuf.getFive()
					+ "', '"
					+ xtuf.getSix()
					+ "', '"
					+ xtuf.getSeven()
					+ "', '"
					+ xtuf.getEight()
					+ "', '"
					+ xtuf.getNine()
					+ "', '"
					+ xtuf.getTen()
					+ "', '"
					+ xtuf.getEleven()
					+ "', '"
					+ xtuf.getTwelve()
					+ "', '"
					+ xtuf.getThirteen()
					+ "', '"
					+ xtuf.getFourteen()
					+ "', '"
					+ xtuf.getFifteen()
					+ "', '"
					+ xtuf.getSixteen()
					+ "', '"
					+ xtuf.getSeventeen()
					+ "', '"
					+ xtuf.getEighteen()
					+ "', '"
					+ xtuf.getNineteen()
					+ "', '"
					+ xtuf.getTwenty() + "')");
			xtuf.setFlag("4");
			st.addBatch("update yohoo_user set flag='" + xtuf.getFlag() + "' where phone='"+xtuf.getPhone()+"'");
			st.executeBatch();
			flag = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			flag = 2;
			conn.rollback();
		} finally {
			st.close();
			conn.close();
		}
		return flag;
	}
	public boolean register_ruiqu_one(YohooUser yu) throws SQLException, FileNotFoundException, NamingException, IOException{
		boolean func_flag=false;
		conn=new ConnDao().getConn();
		String type=yu.getType();
		//int id=0;
		String name=yu.getName();
		String gender=yu.getGender();
		String birthday=yu.getBirthday();
		String id_type=yu.getId_type();
		String id_number=yu.getId_number();
		String occupation=yu.getOccupation();
		String phone=yu.getPhone();
		String email=yu.getEmail();
		String address=yu.getAddress();
		int postcode=yu.getPostcode();
		String creating_time=DateUnit.returnStringAboutPattern(DateUnit.PATTERN,new Date());
		int flag=1;
		String sql="insert into yohoo_user(name,gender,birthday,id_type,id_number,occupation,phone,email,address,postcode,flag,type,creating_time) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,name);
		pstm.setString(2,gender);
		pstm.setString(3,birthday);
		pstm.setString(4,id_type);
		pstm.setString(5,id_number);
		pstm.setString(6, occupation);
		pstm.setString(7,phone);
		pstm.setString(8,email);
		pstm.setString(9,address);
		pstm.setString(10,String.valueOf(postcode));
		pstm.setString(11,String.valueOf(flag));
		pstm.setString(12,type);
		pstm.setString(13,creating_time);
		int db_flag=pstm.executeUpdate();
		if(db_flag==0){
			func_flag=false;
		}else{
			func_flag=true;
		}
	return func_flag;
	}
	public boolean register_ruiqu_two(RuiquPartner rp,String prev_phone) throws FileNotFoundException, NamingException, IOException, SQLException{
		boolean func_flag=true;
		int i=PreparedStatement.EXECUTE_FAILED;
		conn=new ConnDao().getConn();
		conn.setAutoCommit(false);
		//String type=rp.getType();
		//int id=0;
		String name=rp.getName();
		String gender=rp.getGender();
		String birthday=rp.getBirthday();
		String id_type=rp.getId_type();
		String id_number=rp.getId_number();
		String occupation=rp.getOccupation();
		String phone=rp.getPhone();
		String email=rp.getEmail();
		String address=rp.getAddress();
		int postcode=rp.getPostcode();
		int flag=2;
		String sql1="update yohoo_user set flag=? where phone=?";
		String sql2="insert into ruiqu_partner(name,gender,birthday,id_type,id_number,occupation,phone,email,address,postcode,key_phone) value(?,?,?,?,?,?,?,?,?,?,?)";
		try{
		pstm=conn.prepareStatement(sql1);
		pstm.setString(1,String.valueOf(flag));
		pstm.setString(2,prev_phone);
		pstm.addBatch();
		int[] db_flag0=pstm.executeBatch();
		for(int x:db_flag0){
			if(x==i){
				func_flag=false;	
			}
		}
		pstm=conn.prepareStatement(sql2);
		pstm.setString(1,name);
		pstm.setString(2,gender);
		pstm.setString(3,birthday);
		pstm.setString(4,id_type);
		pstm.setString(5,id_number);
		pstm.setString(6, occupation);
		pstm.setString(7,phone);
		pstm.setString(8,email);
		pstm.setString(9,address);
		pstm.setString(10,String.valueOf(postcode));
		pstm.setString(11,prev_phone);
		pstm.addBatch();
		int[] db_flag1=pstm.executeBatch();
		for(int x:db_flag1){
			if(x==i){
				func_flag=false;	
			}
		}
		conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			close_pstm();
		}
	return func_flag;
	}
	public boolean register_ruiqu_three(RuiquPartner rp,String prev_phone) throws FileNotFoundException, NamingException, IOException, SQLException{
		boolean func_flag=true;
		conn=new ConnDao().getConn();
		conn.setAutoCommit(false);
		//String type=rp.getType();
		//int id=0;
		String name=rp.getName();
		String gender=rp.getGender();
		String birthday=rp.getBirthday();
		String id_type=rp.getId_type();
		String id_number=rp.getId_number();
		String occupation=rp.getOccupation();
		String phone=rp.getPhone();
		String email=rp.getEmail();
		String address=rp.getAddress();
		int postcode=rp.getPostcode();
		int flag=3;
		String sql1="update yohoo_user set flag=? where phone=?";
		String sql2="insert into ruiqu_partner(name,gender,birthday,id_type,id_number,occupation,phone,email,address,postcode,key_phone) value(?,?,?,?,?,?,?,?,?,?,?)";
		try{	
		pstm=conn.prepareStatement(sql1);
		pstm.setString(1,String.valueOf(flag));
		pstm.setString(2,prev_phone);
		pstm.addBatch();
		pstm=conn.prepareStatement(sql2);
		pstm.setString(1,name);
		pstm.setString(2,gender);
		pstm.setString(3,birthday);
		pstm.setString(4,id_type);
		pstm.setString(5,id_number);
		pstm.setString(6, occupation);
		pstm.setString(7,phone);
		pstm.setString(8,email);
		pstm.setString(9,address);
		pstm.setString(10,String.valueOf(postcode));
		pstm.setString(11,prev_phone);
		pstm.addBatch();
		int[] db_flag=pstm.executeBatch();
		int i=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag){
			if(x==i){
				func_flag=false;	
			}
		}
		conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			close_pstm();
		}
	return func_flag;
	}
	public boolean register_qinzi_one(YohooUser yu) throws SQLException, FileNotFoundException, NamingException, IOException{
		boolean func_flag=false;
		conn=new ConnDao().getConn();
		String type=yu.getType();
		int id=0;
		String name=yu.getName();
		String gender=yu.getGender();
		String birthday=yu.getBirthday();
		String id_type=yu.getId_type();
		String id_number=yu.getId_number();
		String occupation=yu.getOccupation();
		String phone=yu.getPhone();
		String email=yu.getEmail();
		String address=yu.getAddress();
		int postcode=yu.getPostcode();
		String creating_time=DateUnit.returnStringAboutPattern(DateUnit.PATTERN,new Date());
		int flag=1;
		String sql="insert into yohoo_user(name,gender,birthday,id_type,id_number,occupation,phone,email,address,postcode,flag,type,creating_time) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,name);
		pstm.setString(2,gender);
		pstm.setString(3,birthday);
		pstm.setString(4,id_type);
		pstm.setString(5,id_number);
		pstm.setString(6, occupation);
		pstm.setString(7,phone);
		pstm.setString(8,email);
		pstm.setString(9,address);
		pstm.setString(10,String.valueOf(postcode));
		pstm.setString(11,String.valueOf(flag));
		pstm.setString(12,type);
		pstm.setString(13,creating_time);
		int db_flag=pstm.executeUpdate();
		if(db_flag==0){
			func_flag=false;
		}else{
			func_flag=true;
		}
	return func_flag;
	}
	public boolean register_qinzi_two(QinziSpouse qs,String prev_phone) throws FileNotFoundException, NamingException, IOException, SQLException{
		boolean func_flag=true;
		conn=new ConnDao().getConn();
		conn.setAutoCommit(false);
		int id=0;
		String name=qs.getName();
		String gender=qs.getGender();
		String birthday=qs.getBirthday();
		String id_type=qs.getId_type();
		String id_number=qs.getId_number();
		String occupation=qs.getOccupation();
		String phone=qs.getPhone();
		String email=qs.getEmail();
		String address=qs.getAddress();
		int flag=2;
		String sql1="update yohoo_user set flag=? where phone=?";
		String sql2="insert into qinzi_spouse(name,gender,birthday,id_type,id_number,occupation,phone,email,address,key_phone) value(?,?,?,?,?,?,?,?,?,?)";
		try{
		pstm=conn.prepareStatement(sql1);
		pstm.setString(1,String.valueOf(flag));
		pstm.setString(2,prev_phone);
		pstm.addBatch();
		int[] db_flag_flag=pstm.executeBatch();
		int i_flag=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag_flag){
			if(x==i_flag){
				func_flag=false;	
			}
		}
		pstm=conn.prepareStatement(sql2);
		pstm.setString(1,name);
		pstm.setString(2,gender);
		pstm.setString(3,birthday);
		pstm.setString(4,id_type);
		pstm.setString(5,id_number);
		pstm.setString(6, occupation);
		pstm.setString(7,phone);
		pstm.setString(8,email);
		pstm.setString(9,address);
		pstm.setString(10,prev_phone);
		pstm.addBatch();
		int[] db_flag=pstm.executeBatch();
		int i=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag){
			if(x==i){
				func_flag=false;	
			}
		}
		conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			close_pstm();
		}
	return func_flag;
	}
	public boolean register_qinzi_three(QinziBabe qb,String prev_phone) throws FileNotFoundException, NamingException, IOException, SQLException{
		boolean func_flag=true;
		conn=new ConnDao().getConn();
		conn.setAutoCommit(false);
		int id=0;
		String name=qb.getName();
		String nickname=qb.getNickname();
		String gender=qb.getGender();
		String birthday=qb.getBirthday();
		String school=qb.getSchool();
		String grade=qb.getGrade();
		String onlychild=qb.getOnlychild();
		String hobby=qb.getHobby();
		String speciality=qb.getSpeciality();
		//int postcode=qs.getPostcode();
		int flag=3;
		String sql1="update yohoo_user set flag=? where phone=?";
		String sql2="insert into qinzi_babe(name,nickname,gender,birthday,school,grade,onlychild,hobby,speciality,key_phone) value(?,?,?,?,?,?,?,?,?,?)";
		try{
		pstm=conn.prepareStatement(sql1);
		pstm.setString(1,String.valueOf(flag));
		pstm.setString(2,prev_phone);
		pstm.addBatch();
		int[] db_flag_flag=pstm.executeBatch();
		int i_flag=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag_flag){
			if(x==i_flag){
				func_flag=false;	
			}
		}
		pstm=conn.prepareStatement(sql2);
		pstm.setString(1,name);
		pstm.setString(2,nickname);
		pstm.setString(3,gender);
		pstm.setString(4,birthday);
		pstm.setString(5,school);
		pstm.setString(6, grade);
		pstm.setString(7,onlychild);
		pstm.setString(8,hobby);
		pstm.setString(9,speciality);
		pstm.setString(10,prev_phone);
		pstm.addBatch();
		int[] db_flag=pstm.executeBatch();
		int i=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag){
			if(x==i){
				func_flag=false;	
			}
		}
		conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			close_pstm();
		}
	return func_flag;
	}
	public boolean register_qinzi_four(QinziForm qf,String prev_phone) throws FileNotFoundException, NamingException, IOException, SQLException{
		boolean func_flag=true;
		conn=new ConnDao().getConn();
		conn.setAutoCommit(false);
		int id=0;
		String babe1=qf.getBabe1();
		String babe2=qf.getBabe2();
		String babe3=qf.getBabe3();
		String babe4=qf.getBabe4();
		String babe5=qf.getBabe5();
		String babe6=qf.getBabe6();
		String babe7=qf.getBabe7();
		String babe8=qf.getBabe8();
		String babe9=qf.getBabe9();
		String you1=qf.getYou1();
		String you2=qf.getYou2();
		String you3=qf.getYou3();
		String you4=qf.getYou4();
		String you5=qf.getYou5();
		String you6=qf.getYou6();
		String you7=qf.getYou7();
		//int postcode=qs.getPostcode();
		int flag=4;
		String sql1="update yohoo_user set flag=? where phone=?";
		String sql2="insert into qinzi_form(babe1,babe2,babe3,babe4,babe5,babe6,babe7,babe8,babe9,you1,you2,you3,you4,you5,you6,you7,key_phone) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
		pstm=conn.prepareStatement(sql1);
		pstm.setString(1,String.valueOf(flag));
		pstm.setString(2,prev_phone);
		pstm.addBatch();
		int[] db_flag_flag=pstm.executeBatch();
		int i_flag=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag_flag){
			if(x==i_flag){
				func_flag=false;	
			}
		}
		pstm=conn.prepareStatement(sql2);
		pstm.setString(1,babe1);
		pstm.setString(2,babe2);
		pstm.setString(3,babe3);
		pstm.setString(4,babe4);
		pstm.setString(5,babe5);
		pstm.setString(6,babe6);
		pstm.setString(7,babe7);
		pstm.setString(8,babe8);
		pstm.setString(9,babe9);
		pstm.setString(10,you1);
		pstm.setString(11,you2);
		pstm.setString(12,you3);
		pstm.setString(13,you4);
		pstm.setString(14,you5);
		pstm.setString(15,you6);
		pstm.setString(16,you7);
		pstm.setString(17,prev_phone);
		pstm.addBatch();
		int[] db_flag=pstm.executeBatch();
		int i=PreparedStatement.EXECUTE_FAILED;
		for(int x:db_flag){
			if(x==i){
				func_flag=false;	
			}
		}
		conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			close_pstm();
		}
	return func_flag;
	}
	
   public synchronized boolean dateStart(String from_phone,String to_phone) throws Exception{
	   boolean flag=false;
	   conn=new ConnDao().getConn();
	   String date_number="";
	   String sql="insert into yohoo_date(from_phone,to_phone,date_time,date_flag,date_number) values(?,?,?,?,?)";
	   PreparedStatement pstm=conn.prepareStatement(sql);
	  SimpleDateFormat sdf=new SimpleDateFormat();
	  Date date=new Date();
	  String pattern="yyyy-MM-dd HH:mm:ss";
	  sdf.applyPattern("yyyy-MM-dd");
	  String date_time=sdf.format(date); 
	  int date_flag=DateBean.DATE_ONE_START;
	  System.out.println(to_phone);
	   XuntaUser xtu=new QueryDao().queryUserInformation(to_phone);
	   String state=xtu.getState();
	   String number=xtu.getNumber();
	   String gender=xtu.getGender();
	   date_number=new ReturnNumber().returnDateNumber(date_time, state,number,gender);
	   pstm.setString(1, from_phone);
	   pstm.setString(2,to_phone);
	   date_time=DateUnit.returnStringAboutPattern(pattern, date);
	   pstm.setString(3,date_time);
	   pstm.setInt(4,date_flag);
	   pstm.setString(5, date_number);
	   int int_flag=0;
	   try{
	   int_flag=pstm.executeUpdate();
	   }finally{
		   pstm.close();
		   conn.close();  
	   }
	   if(int_flag==0){
		   flag=false;
		   }else{
		   flag=true;
	   }
	   return flag; 
   }
   public boolean insertDeclare(String date_number,String key_phone,String content,String star,String type,String agree) throws SQLException{
	   PreparedStatement pstm=null;
	   boolean flag=false;
	   try{
		conn=new ConnDao().getConn();
	   String sql="INSERT INTO yohoo_xunta_declare(`date_number`,`key_phone`,`content`,`star`,`declare_time`,`type`,`agree`) VALUE(?,?,?,?,?,?,?)"; 
	   pstm=conn.prepareStatement(sql);
	   pstm.setString(1,date_number);
	   pstm.setString(2,key_phone);
	   pstm.setString(3,content);
	   pstm.setString(4,star);
	   pstm.setString(5,DateUnit.returnStringAboutPattern(DateUnit.PATTERN,new Date()));
	   pstm.setString(6,type);
	   pstm.setString(7,agree);
	   int int_flag=pstm.executeUpdate();
	   if(int_flag==0) flag=false;
	   else flag=true;
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   close_pstm();
	   }
	   return flag;
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
}
