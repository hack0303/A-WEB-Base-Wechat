package cn.net.www.transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.dao.QueryDao;

public class AJAX {
public static void checkIdentify(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException, NamingException{
	String type=request.getParameter("type");
    String identify=request.getParameter("identify");
    String queryname=request.getParameter("queryname");
   int flag=new QueryDao().queryAJAX(type, identify, queryname);
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   out.println(String.valueOf(flag));
   out.flush();
   out.close();
}
}
