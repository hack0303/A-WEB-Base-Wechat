package cn.net.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooAdmin;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.management.transaction.AdminLogin;
import cn.net.www.transaction.Login;
import cn.net.www.transaction.Register;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.MethodInvoke;

public class SecurityServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	MethodInvoke mi=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     mi=new MethodInvoke();
     String methodname=request.getParameter("action");
     try {
		mi.invokeMethod(this, methodname, request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
	      Login.login(getServletContext(), request, response);	
	    }
	public void adminlogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException {
	AdminLogin.adminlogin(getServletContext(), request, response);
	}
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	Register register=new Register();
	String step=request.getParameter("step");
	String type=request.getParameter("type");
	MethodInvoke.invokeMethod(register, type,step, getServletContext(), request, response);
	}
	public void modify(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException, NamingException{
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String phone=request.getParameter("phone");
		if(name.equals("flag")) return;
		boolean flag=new UpdateDao().update(name,value,phone);
		PrintWriter out=response.getWriter();
			out.print(flag);
			out.close();
	}
}
