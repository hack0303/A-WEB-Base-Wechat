package cn.net.www.transaction;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.DateBean;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.SecurityUnit;

public class WXYT {
public static void yueTa(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	String to_phone=request.getParameter("to_phone").trim();
    	to_phone=SecurityUnit.phoneDecode(to_phone);
    	HttpSession session=request.getSession();
    	LoginSession ls=(LoginSession) session.getAttribute("ls");
    	String from_phone=ls.getPhone();
    	DateBean db=new QueryDao().queryDateBean(from_phone,to_phone);
    	String url="";
    	String msg="";
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out=response.getWriter();
    	if(db!=null){
    		out.print("<script>alert('您已经越过Ta了!请勿重复提交');</script>");
    		out.flush();
    		out.close();
    	    return;
    	}
    	boolean flag=new InsertDao().dateStart(from_phone, to_phone);
    	if(flag){
    		//url="MyServlet?action=show&type=first";
    	    //response.sendRedirect(url);
            msg="邀约成功!";
    		out.print("<script>alert('"+msg+"');location.href='MyServlet?action=show&type=first';</script>");
    		out.flush();
    	}else{
    		msg="操作失败,联系管理员解决";
    		out.print("<script>alert('"+msg+"');</script>");
    		out.flush();
    	}
    	if(out!=null) out.close();
    }//我要约Ta,表单请求页
}
