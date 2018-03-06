package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.LoginSession;

public class Search {
public static void search(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String search=request.getParameter("search").trim();
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession)session.getAttribute("ls");
		String gender=ls.getGender();
		if(gender.equals("女")) gender="男";
		else if(gender.equals("男")) gender="女";
		List<XuntaUser> list=new QueryDao().queryBySearch(search,gender);
		request.setAttribute("list",list);
		request.setAttribute("nav",search);
		sc.getRequestDispatcher("/WEB-INF/userinformation/xunta/search_result.jsp").forward(request, response);
	}//search查询
}
