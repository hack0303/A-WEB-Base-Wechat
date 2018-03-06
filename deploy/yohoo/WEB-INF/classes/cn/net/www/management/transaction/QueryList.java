package cn.net.www.management.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import cn.net.www.bean.DateBean;
import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.bean.YohooActivities;
import cn.net.www.bean.YohooUser;
import cn.net.www.dao.QueryDao;

public class QueryList{
	public static List<Object> xunta(PageBean pb,int func) throws FileNotFoundException, NamingException, SQLException, IOException{
		QueryDao qd=new QueryDao();
		int flag=func;//注册完成标志
		Class classname=XuntaUserForm.class;
		List<Object> list=qd.queryReviewListAboutFlag(classname, pb,flag);
		return list;
	}
	public static List<Object> date(PageBean pb,int func,int date_flag) throws FileNotFoundException, NamingException, SQLException, IOException{
		QueryDao qd=new QueryDao();
		int flag=func;//注册完成标志
		Class classname=DateBean.class;
		List<Object> list=qd.queryReviewListAboutFlag(classname, pb,date_flag);
		return list;
	}
	public static List<Object> activities(PageBean pb,String type,int flag) throws FileNotFoundException, NamingException, SQLException, IOException{
		QueryDao qd=new QueryDao();
		Class classname=YohooActivities.class;
		List<Object> list=qd.queryReviewListAboutFlag(classname, pb,flag);
		return list;
	}
	public static int count(String type,int flag) throws FileNotFoundException, SQLException, NamingException, IOException{
		QueryDao qd=new QueryDao();
	int out=qd.count(type,flag);
		return out;
	}
	public static int countDate(int flag,int date_flag) throws FileNotFoundException, SQLException, NamingException, IOException{
		QueryDao qd=new QueryDao();
	int out=qd.countDate(flag,date_flag,"all");
		return out;
	}
	public static int countActivities(int flag) throws FileNotFoundException, SQLException, NamingException, IOException{
		QueryDao qd=new QueryDao();
	int out=qd.countActivities(flag);
		return out;
	}
}
