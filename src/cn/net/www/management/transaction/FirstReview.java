package cn.net.www.management.transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.dao.QueryDao;
import cn.net.www.unit.MessageBuilder;

public class FirstReview {
	public void forwardReview(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException{
		String type=request.getParameter("type");
		String reviewtype=request.getParameter("reviewtype");
		String admin=String.valueOf(request.getSession().getAttribute("admin"));
		String url="";
		String pagename="";
		if(admin.equalsIgnoreCase("null")) sc.getRequestDispatcher("/WEB-INF/management/adminlogin.jsp").forward(request, response); 
		RequestDispatcher rd=null;
		PageBean pb=new PageBean();
		if(type.equals("ruiqu")){
			url="/WEB-INF/userinformation/xunta/reviewruiqu.jsp";
			rd=sc.getRequestDispatcher(url);
		}else if(type.equals("xunta")){
			if(reviewtype.equals("register")){
				int count=new QueryDao().queryCount(type,XuntaUser.REGISTER_FOUR);
				int item=10;
				pb.setCount(count, item);
				pb.setPagenow(1);
				request.getSession().setAttribute("pb",pb);
				List<XuntaUserForm> list=new QueryDao().queryList_PagextufByPhone(pb,XuntaUser.REGISTER_FOUR);
				request.setAttribute("list",list);
				pagename="review_register";
			}//查询注册
			else if(reviewtype.equalsIgnoreCase("WYZQ")){
				int count=new QueryDao().queryCount(type,XuntaUser.WYZQ_REQUEST_START);
				int item=10;
				pb.setCount(count, item);
				pb.setPagenow(1);
				request.getSession().setAttribute("pb",pb);
				List<XuntaUserForm> list=new QueryDao().queryList_PagextufByPhone(pb,XuntaUser.WYZQ_REQUEST_START);
				pagename="review_wyzq";
				request.setAttribute("list",list);
			}//查询我要招亲申请
			else if(reviewtype.equals("authority")){
				int count=new QueryDao().queryCount(type,XuntaUser.REGISTER_FOUR);
				int item=10;
				pb.setCount(count, item);
				pb.setPagenow(1);
				request.getSession().setAttribute("pb",pb);
				List<XuntaUserForm> list=new QueryDao().queryList_PagextufByPhone(pb,XuntaUser.AUTHORITY_PASS);
				request.setAttribute("list",list);
				pagename="review_authority";
			}else if(reviewtype.equals("date")){
				int count=new QueryDao().queryCount(type,XuntaUser.WYZQ_REQUEST_START);
				int item=10;
				pb.setCount(count, item);
				pb.setPagenow(1);
				request.getSession().setAttribute("pb",pb);
				List<XuntaUserForm> list=new QueryDao().queryList_PagextufByPhone(pb,XuntaUser.WYZQ_REQUEST_START);
				request.setAttribute("list",list);
				pagename="review_date";
			}
		}else if(type.equals("qinzi")){
			url="/WEB-INF/userinformation/xunta/reviewqinzi.jsp";	
		}
		String[] string={"management",type,pagename};
		url=MessageBuilder.forwardURL(3,string);
		rd=sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
