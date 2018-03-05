package cn.net.www.transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;

public class DateShowList {
	public static void woYue_span(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		String phone =ls.getPhone();
		int procedure=Integer.parseInt(request.getParameter("procedure"));
		List<XuntaUser> list = null;
		list = new QueryDao().queryWoYueByDate_flag(phone,procedure);
		request.setAttribute("list", list);
		request.setAttribute("procedure",procedure);
		String url = "";
		switch(procedure){
		case 0:{
			url="/WEB-INF/userinformation/xunta/Woyue/all.jsp";
			break;
		}
		case 1:{
			url="/WEB-INF/userinformation/xunta/Woyue/one.jsp";
			break;
		}
		case 2:{
			url="/WEB-INF/userinformation/xunta/Woyue/two.jsp";
			break;
		}
		case 3:{
			url="/WEB-INF/userinformation/xunta/Woyue/three.jsp";
			break;
		}
		case 4:{
			url="/WEB-INF/userinformation/xunta/Woyue/four.jsp";
			break;
		}
		}
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	public static void yueWo_span(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		String phone =ls.getPhone();
		int procedure=Integer.parseInt(request.getParameter("procedure"));
		List<XuntaUser> list = null;
		list = new QueryDao().queryYueWoByDate_flag(phone,procedure);
		request.setAttribute("list",list);
		request.setAttribute("procedure",procedure);
		String url = "";
		switch(procedure){
		case 0:{
			url="/WEB-INF/userinformation/xunta/Yuewo/all.jsp";
			break;
		}
		case 1:{
			url="/WEB-INF/userinformation/xunta/Yuewo/one.jsp";
			break;
		}
		case 2:{
			url="/WEB-INF/userinformation/xunta/Yuewo/two.jsp";
			break;
		}
		case 3:{
			url="/WEB-INF/userinformation/xunta/Yuewo/three.jsp";
			break;
		}
		}
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
