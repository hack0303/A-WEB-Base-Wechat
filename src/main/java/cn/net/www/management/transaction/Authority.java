package cn.net.www.management.transaction;

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

import cn.net.www.bean.PageBean;
import cn.net.www.bean.YohooUser;

public class Authority {
	public static void xunta(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String url="";
		String page="";
		int count=0;
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		PageBean pb=(PageBean) session.getAttribute("pb");
		page="register";
		if(pb==null){
			count=QueryList.count(type,YohooUser.AUTHORITY_FORBID);
			pb=new PageBean();
			pb.setPagenow(1);
			pb.setItem(PageBean.LENGTH_TEN);//1页10个
			pb.setCount(count);
			session.setAttribute("pb",pb);
		}else{
			String pagespan=request.getParameter("pagespan");
			count=QueryList.count(type,YohooUser.AUTHORITY_FORBID);
			pb.setCount(count);
			if(pagespan!=null){
			if(pagespan.equals("first")){
				pb.setPagenow(1);
		        pb.setCount(count);
			}else if(pagespan.equals("prev")){
				pb.setPagenow(pb.getPagenow()-1);
		        pb.setCount(count);
		        }else if(pagespan.equals("go")){
				int pagenumber=Integer.parseInt(request.getParameter("pagenumber"));
				pb.setPagenow(pagenumber);
		        pb.setCount(count);
			}else if(pagespan.equals("next")){
				pb.setPagenow(pb.getPagenow()+1);
		        pb.setCount(count);
			}else if(pagespan.equals("last")){
		        pb.setCount(count);
		        pb.setPagenow(count);
			}}
		}
		List<Object> list=QueryList.xunta(pb,YohooUser.AUTHORITY_FORBID);
		request.setAttribute("list",list);
		url="/ForwardServlet?action=management&service=review&type="+type+"&page="+page;
		sc.getRequestDispatcher(url).forward(request, response);
	}
}
