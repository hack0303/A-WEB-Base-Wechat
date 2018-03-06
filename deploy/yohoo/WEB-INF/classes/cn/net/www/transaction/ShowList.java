package cn.net.www.transaction;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.LoginSession;

public class ShowList {

public static void showList(ServletContext servlet,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServletContext sc =servlet;
		String url = "";
		int flag=10;
		int count=4;
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		int pagenow=1;
		int pagination=0;
		PageBean pb=new PageBean(pagenow, pagination,PageBean.LENGTH_TEN);
		pb.setType(PageBean.TYPE_XUNTA);
		List<XuntaUser> list = null;
        String gender=ls.getGender();
        if(gender.equals("男")) gender="女";
        else if(gender.equals("女")) gender="男";
    	List<Integer> statelist =new QueryDao().queryState(gender,count,null,flag);
    	String state="";
    	if(statelist!=null){
    		state=statelist.get(0).toString();
    		pb.setState(state);
		list = new QueryDao().queryShowList(gender,state,pb);
		}
    	PageSpan.pagination(pb);
    	session.setAttribute("pb",pb);
    	request.setAttribute("statelist",statelist);
    	request.setAttribute("state",state);
    	request.setAttribute("list", list);
		url = "/WEB-INF/userinformation/xunta/usershow.jsp";
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}//第一次展示页面列表
	public static void showList_all(ServletContext servlet,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServletContext sc =servlet;
		String url = "";
		int flag=10;
	//	int count=4;
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		int pagenow=1;
		int pagination=0;
		PageBean pb=new PageBean(pagenow, pagination,PageBean.LENGTH_TEN);
		pb.setType(PageBean.TYPE_XUNTA);
		List<XuntaUser> list = null;
        String gender=ls.getGender();
        if(gender.equals("男")) gender="女";
        else if(gender.equals("女")) gender="男";
    	List<Integer> statelist =new QueryDao().queryState(gender,null,flag);
    	String state="";
    	if(statelist!=null){
    		state=statelist.get(0).toString();
    		pb.setState(state);
    	list = new QueryDao().queryShowList(gender,state,pb);
		}
    	PageSpan.pagination(pb);
    	session.setAttribute("pb",pb);
    	request.setAttribute("statelist",statelist);
    	request.setAttribute("state",state);
    	request.setAttribute("list", list);
		url = "/WEB-INF/userinformation/xunta/usershow_all.jsp";
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}//显示全部信息
}
