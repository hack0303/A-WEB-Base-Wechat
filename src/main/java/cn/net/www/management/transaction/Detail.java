package cn.net.www.management.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.dao.QueryDao;

public class Detail {
public static void detailAboutPhone(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
String url="";
String type=request.getParameter("type");	
String func=request.getParameter("func");
String state=request.getParameter("state");
	String phone=request.getParameter("phone");
	XuntaUserForm xtuf=(XuntaUserForm) Detail.query(type,func,phone);
	request.setAttribute("object",xtuf);
	url="/ForwardServlet?action=detail";
	request.setAttribute("type",type);
	request.setAttribute("func",func);
	request.setAttribute("state",state);
	sc.getRequestDispatcher(url).forward(request, response);
}
public static Object query(String type,String func,String phone) throws FileNotFoundException, SQLException, NamingException, IOException{
	QueryDao qd=new QueryDao();
	Object ob=null;
	if(type.equals("xunta")){
		 ob=qd.queryObjectByPhone(phone,XuntaUserForm.class);
	}else if(type.equals("qinzi")){
		
	}else if(type.equals("ruiqu")){
		
	}
	return ob;
}
}
