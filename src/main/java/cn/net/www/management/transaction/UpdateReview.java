package cn.net.www.management.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooUser;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;

public class UpdateReview {
	public static void xunta(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	String func=request.getParameter("func");
	if(func.equals("register")){
			register(sc,request,response);
	}else if(func.equals("wyzq")){
		wyzq(sc, request, response);
	}else if(func.equals("date")){
		date(sc, request, response);
	}
	}
	public static void register(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	String target=request.getParameter("target");
	String phone=request.getParameter("phone");
	UpdateDao ud=new UpdateDao();
	int updateflag=0;
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	if(target.equals("pass")){
		boolean i_flag=AddMemberNumber.add(phone);
		if(!i_flag){ 
		out.write("会员号添加失败,后续操作中断");
		out.flush();
		out.close();
		return;}
		updateflag=YohooUser.REGISTER_PASS;
	}else if(target.equals("nopass")){
		updateflag=YohooUser.REGISTER_NOT_PASS;
	}
	boolean flag=false;
	try {
		flag=ud.updateReview(updateflag, phone);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String msg="";
	if(flag){
		msg="操作成功";
	}else{
		msg="操作失败";
	}
	out.write(msg);
	out.flush();
	out.close();
		}
	public static void wyzq(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String target=request.getParameter("target");
		String phone=request.getParameter("phone");
		String gender=request.getParameter("gender");
		System.out.print("wyzq:"+gender);
		UpdateDao ud=new UpdateDao();
		int updateflag=0;
		String msg="";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(target.equals("pass")){
			int state=Integer.parseInt(request.getParameter("state"));
			boolean flag=AddNumberAndState.add(state, phone,gender);
			if(flag) msg="添加会员到展示界面成功";
			else msg="添加会员到展示界面失败";
		}else if(target.equals("nopass")){
			updateflag=YohooUser.REGISTER_NOT_PASS;
		boolean flag=ud.updateReview(updateflag, phone);
		if(flag){
			msg="操作成功!";
		}else{
			msg="操作失败!";
		}}
		out.write(msg);
		out.flush();
		out.close();
	}
    public static void date(ServletContext sc,HttpServletRequest request,HttpServletResponse response){
		
	}
	
}
