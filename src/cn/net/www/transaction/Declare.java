package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.DateBean;
import cn.net.www.bean.XuntaAgree;
import cn.net.www.bean.XuntaDeclare;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.SecurityUnit;

public class Declare {
	public static void woyue_declare_four(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException{
    	String date_number=request.getParameter("date_number");
    	PrintWriter out=response.getWriter();
    	if(date_number==null){
    		String msg="不存在此约单哦!";
        	response.setContentType("text/html;charset=utf-8");
        	out.write("<script>alert('"+msg+"');history.go(-1);</script>");
    		if(out!=null) out.close();
    		return;
    	}
    	HttpSession session=request.getSession();
    	LoginSession ls=(LoginSession) session.getAttribute("ls");
    	String key_phone=ls.getPhone();
    	String content=request.getParameter("content");
    	String star=request.getParameter("star");
    	String agree=request.getParameter("agree");
    	String where="four";
    	String type="from";
    	if(star==null) star="0";
    	boolean flag=false;
    	XuntaDeclare xd=new QueryDao().queryDeclare(date_number,type);
    	if(xd!=null){
    		String msg="您已经表态过了呀!";
        	response.setContentType("text/html;charset=utf-8");
        	out.write("<script>alert('"+msg+"');history.go(-1);</script>");
    		if(out!=null) out.close();
    		return;
    	}
    	try {
			flag=new InsertDao().insertDeclare(date_number, key_phone, content, star, type,agree);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String url="";
    	if(flag){
    		url="DateServlet?action=date&type=woyue&procedure={0}";
    	}else{
    		String msg="操作失败,请重新尝试!";
    	response.setContentType("text/html;charset=utf-8");
    	out.write("<script>alert('"+msg+"');history.go(-1);</script>");
    	out.flush();
    	if(out!=null) out.close();
    	return;
    	}
    	url="DateServlet?action=date&type=woyue&procedure={0}";
		String procedure="";
		if(flag){
			if(where.equals("all")){
				procedure="0";			
			}else if(where.equals("one")){
				procedure="1";		
			}else if(where.equals("two")){
				procedure="2";
			}else if(where.equals("three")){
				procedure="3";
			}else if(where.equals("four")){
				procedure="4";
			}
	    url=MessageFormat.format(url,procedure);
		response.sendRedirect(url);
		}
       }
	public static void yuewo_declare_one(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out=response.getWriter();
        String agree=request.getParameter("agree");
        String where="one";
        String id=request.getParameter("date_number");
        String content=request.getParameter("content");
        XuntaAgree xa=(XuntaAgree)new QueryDao().queryObjectById(id);
        if(xa!=null){
        	response.setContentType("text/html;charset=utf-8");
        	out.write("<script>alert('您已经评价过咯!');location.href='DateServlet?action=date&type=yuewo&procedure=1'<script>");
        	out.flush();
        	out.close();
        	return;
        }
        int date_flag=0;
        if(agree.equals("yes")){
        	date_flag=DateBean.DATE_THREE_START;//我同意,进入后台,等待管理员审核
        }else if(agree.equals("no")){
        	date_flag=DateBean.DATE_TWO_ACCEPT_NO;//我拒绝,系统进行退款
        }
        String creating_time=DateUnit.returnStringAboutPattern(DateUnit.PATTERN, new Date());
        xa=new XuntaAgree(id, agree, content, creating_time);
		boolean flag=new InsertDao().insertAgreeAndUpdateFlag(xa, date_flag);
		String url="DateServlet?action=date&type=yuewo&procedure={0}";
		String procedure="";
		if(flag){
			if(where.equals("all")){
				procedure="0";			
			}else if(where.equals("one")){
				procedure="1";		
			}else if(where.equals("two")){
				procedure="2";
			}else if(where.equals("three")){
				procedure="3";
			}
	    url=MessageFormat.format(url,procedure);
		response.sendRedirect(url);
		}else{
		String msg="操作失败,请重新尝试!";
		response.setContentType("text/html;charset=utf-8");
		out.write("<script>alert('"+msg+"');history.go(-1);</script>");
		out.flush();
		}
		if(out!=null) out.close();
	}
    public static void yuewo_declare_three(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException{
    	String date_number=request.getParameter("date_number");
    	String where="three";
    	PrintWriter out=response.getWriter();
    	HttpSession session=request.getSession();
    	LoginSession ls=(LoginSession) session.getAttribute("ls");
    	String key_phone=ls.getPhone();
    	String content=request.getParameter("content");
    	String agree=request.getParameter("agree");
    	String star=request.getParameter("star");
    	String type="to";
    	if(star==null) star="0";
    	boolean flag=false;
    	XuntaDeclare xd=new QueryDao().queryDeclare(date_number,type);
    	if(xd!=null){
    		String msg="您已经表态过了呀!";
        	response.setContentType("text/html;charset=utf-8");
        	out.write("<script>alert('"+msg+"');history.go(-1);</script>");
    		if(out!=null) out.close();
    		return;
    	}
    	try {
			flag=new InsertDao().insertDeclare(date_number, key_phone, content, star, type,agree);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String url="";
    	if(flag){
    		url="DateServlet?action=date&type=yuewo&procedure={0}";
    	}else{
    		String msg="操作失败,请重新尝试!";
    	response.setContentType("text/html;charset=utf-8");
    	out.write("<script>alert('"+msg+"');history.go(-1);</script>");
    	out.flush();
    	if(out!=null) out.close();
    	return;
    	}
    	url="DateServlet?action=date&type=yuewo&procedure={0}";
		String procedure="";
		if(flag){
			if(where.equals("all")){
				procedure="0";			
			}else if(where.equals("one")){
				procedure="1";		
			}else if(where.equals("two")){
				procedure="2";
			}else if(where.equals("three")){
				procedure="3";
			}
	    url=MessageFormat.format(url,procedure);
		response.sendRedirect(url);
    	sc.getRequestDispatcher(url).forward(request, response);	
       
    	}
    }
}
