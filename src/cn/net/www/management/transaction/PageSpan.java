package cn.net.www.management.transaction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.PageBean;

public class PageSpan {
public static PageBean first(HttpServletRequest request,HttpServletResponse response){
	HttpSession session=request.getSession();
	PageBean pb=(PageBean) session.getAttribute("pb");
	pb.setPagenow(1);
	return pb;
}
public static void prev(HttpServletRequest request,HttpServletResponse response){
	
}
public static void go(HttpServletRequest request,HttpServletResponse response){
	
}
public static void next(HttpServletRequest request,HttpServletResponse response){
	
}
public static void last(HttpServletRequest request,HttpServletResponse response){
	
}
}
