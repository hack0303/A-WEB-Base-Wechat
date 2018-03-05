package cn.net.www.transaction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.unit.MessageBuilder;

public class LoginOut {
	public static void loginout(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		session.invalidate();
		String[] str=new String[2];
		String action="userlogin";
		str[0]=action;
		str[1]=request.getParameter("type").trim();
		String url=new MessageBuilder().returnUrl(str[0], str);
		sc.getRequestDispatcher(url).forward(request,response);
	}
}
