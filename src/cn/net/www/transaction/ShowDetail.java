package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.base.PhoneDigest;
import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.unit.SecurityUnit;

public class ShowDetail {
	public static void showDetail(ServletContext servletcontext,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
	String	phone_decode=SecurityUnit.phoneDecode(phone);
		XuntaUser xtu = null;
		QueryDao qd = new QueryDao();
		xtu = qd.queryUserInformation(phone_decode);
		String url = "";
		if (xtu == null) {
			request.setAttribute("msg", "不存在指定人物!!");
			url = "/404.jsp";
		} else {
			xtu.setPhone(phone);
			url = "/WEB-INF/userinformation/xunta/usershowdetail.jsp";
			request.setAttribute("object", xtu);
		}
		ServletContext sc = servletcontext;
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	public static void showUserDetail(ServletContext servletcontext,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
	String	phone_decode=SecurityUnit.phoneDecode(phone);
		XuntaUser xtu = null;
		QueryDao qd = new QueryDao();
		xtu = qd.queryUserInformation(phone_decode);
		String url = "";
		if (xtu == null) {
			request.setAttribute("msg", "不存在指定人物!!");
			url = "/404.jsp";
		} else {
			xtu.setPhone(phone);
			url = "/WEB-INF/userinformation/xunta/userdetail.jsp";
			request.setAttribute("object", xtu);
		}
		ServletContext sc = servletcontext;
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
