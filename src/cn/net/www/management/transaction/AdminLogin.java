package cn.net.www.management.transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooAdmin;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.AdminSession;
import cn.net.www.unit.DateUnit;

public class AdminLogin {
	public static void adminlogin(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException {
	    response.setContentType("text/html");
		String account=request.getParameter("account");
	String password=request.getParameter("password");
	String checkcode=request.getParameter("checkcode");
	HttpSession session=request.getSession();
	Object attribute=session.getAttribute("checkcode");
	PrintWriter out=null;
	YohooAdmin ya=null;
	QueryDao qd=null;
	if(attribute==null){
		out=response.getWriter();
		String msg="请刷新,重新获取验证码";
		out.println(msg);
		return;
	}
	String session_checkcode=String.valueOf(session.getAttribute("checkcode"));
	if(checkcode.equals(session_checkcode)){
		qd=new QueryDao();
		try {
			ya=(YohooAdmin)qd.queryObject(account,YohooAdmin.class);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ya==null){
			out=response.getWriter();
			String msg="检查帐号密码是否出错!";
			out.println(msg);
			return;	
		}else{
			String pattern="yyyy-MM-dd HH:mm:ss";
			UpdateDao ud=new UpdateDao();
			String password_db=ya.getPassword();
			String lastlogin_time=ya.getLastlogin_time();
			if(password_db.equals(password)){
			session.removeAttribute("checkcode");
			String logintime=DateUnit.returnStringAboutPattern(pattern,new Date());
			ya.setLastlogin_time(logintime);
			boolean flag=ud.updateObject(ya, YohooAdmin.class);
		    if(flag){
		    	int authority=ya.getAuthority();
		    	String type="";
		    	String action="";
		    	String where="";
		    	String want="";
		    	AdminSession as=new AdminSession(account, authority, type, action, where, want);
		    	as.setLastlogin_time(lastlogin_time);
				session.setAttribute("as",as);
		    	String url="ForwardServlet?action=adminmanage";
		    	response.sendRedirect(url);
		    }else{
		    	out=response.getWriter();
				String msg="系统出错,请检查";
				out.println(msg);
				return;
		    }}else{
		    	out=response.getWriter();
				String msg="密码出错,请检查";
				out.println(msg);
				return; 	
		    }
		}
	}else{
		out=response.getWriter();
		String msg="验证码出错,请刷新重新获取";
		out.println(msg);
		return;
	}
	}
}
