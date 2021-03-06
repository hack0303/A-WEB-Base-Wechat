package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.dao.UpdateDao;

public class WoYue {
	public void woYue_dealRequest(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
		HttpSession session=request.getSession();
		String from_phone=String.valueOf(session.getAttribute("id"));
		String to_phone=request.getParameter("to_phone");
		String where=String.valueOf(session.getAttribute("where"));
		if(where.equals("null")) where=request.getParameter("where");
		int date_flag=Integer.parseInt(request.getParameter("date_flag"));
		boolean flag=new UpdateDao().updateDate_flag(date_flag,from_phone,to_phone);
		String url="MyServlet?action={0}&procedure={1}";
		String procedure="";
		String method="woYue_span";
		if(flag){
			if(where.equals("all")){
				procedure="0";			
			}else if(where.equals("one")){
				procedure="1";
				
			}else if(where.equals("two")){
				procedure="2";
			}else if(where.equals("three")){
				procedure="3";
			}else if(where.equals("four")){
				procedure="4";
			}
	    url=MessageFormat.format(url,method,procedure);
		}else{
			String msg="操作失败,请联系管理员解决";
			request.setAttribute("msg",msg);
			url="error.jsp";
		}
		sc.getRequestDispatcher("/"+url).forward(request, response);
	}
	public static void zero(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
		
		
	}
   public static void one(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
		
		
	}
public static void two(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
	
	
}
public static void three(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
	
	
}
public static void four(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
	
	
}
}
