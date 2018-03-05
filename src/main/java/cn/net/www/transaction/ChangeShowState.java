package cn.net.www.transaction;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.io.XMLWriter;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.DOM;

public class ChangeShowState {
	 public static void change_userlist(ServletContext sc,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			HttpSession session=request.getSession();
			String state =request.getParameter("state");
			int pagenow=1;
			String type=PageBean.TYPE_XUNTA;
			LoginSession ls=(LoginSession) session.getAttribute("ls");
			List<XuntaUser> list = null;
	        String gender=ls.getGender();
	        if(gender.equals("男")) gender="女";
	        else if(gender.equals("女")) gender="男";
			list = new QueryDao().queryShowList(gender,state,pagenow);
			DOM dom=new DOM();
			dom.createDocument();
			try {
				dom.setUserShow(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PageBean pb=new PageBean();
			pb.setPagenow(pagenow);
			pb.setItem(PageBean.LENGTH_TEN);
			pb.setType(type);
			pb.setState(state);
			PageSpan.pagination(pb);
			System.out.print("页数:"+pb.getPagination());
			session.setAttribute("pb",pb);
			Document document=dom.getDocument();
			response.setContentType("text/xml");
			PrintWriter out=response.getWriter();
			XMLWriter writer=new XMLWriter(out);
			writer.write(document);
			writer.close();
			out.close();
		}
	 public static void changePage(ServletContext sc,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			HttpSession session=request.getSession();
			PageBean pb=(PageBean)session.getAttribute("pb");
		    PageSpan.pagination(pb);
			String func=request.getParameter("func");
			if(func.equals("first")){
		     PageSpan.first(pb);}
			else if(func.equals("prev")){
		    PageSpan.prev(pb);}
			else if(func.equals("to")){
			int want=Integer.parseInt(request.getParameter("want"));
			PageSpan.to(pb,want);}
			else if(func.equals("next")){
			PageSpan.next(pb);}
			else if(func.equals("last")){
			PageSpan.last(pb);}
			String state =pb.getState();
			int pagenow=pb.getPagenow();
			LoginSession ls=(LoginSession) session.getAttribute("ls");
			List<XuntaUser> list = null;
	        String gender=ls.getGender();
	        if(gender.equals("男")) gender="女";
	        else if(gender.equals("女")) gender="男";
			list = new QueryDao().queryShowList(gender,state,pagenow);
			DOM dom=new DOM();
			dom.createDocument();
			try {
				dom.setUserShow(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("pb",pb);
			Document document=dom.getDocument();
			response.setContentType("text/xml");
			PrintWriter out=response.getWriter();
			XMLWriter writer=new XMLWriter(out);
			writer.write(document);
			writer.close();
			out.close();
		}
}
