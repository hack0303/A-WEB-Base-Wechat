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
import cn.net.www.dao.QueryDao;

public class Register {
public static void xunta(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	String url="";
	String page="";
	int count=0;
	String func=request.getParameter("func");
	String type=request.getParameter("type");
	String state=request.getParameter("state");
	HttpSession session=request.getSession();
	PageBean pb=(PageBean) session.getAttribute("pb");
	System.out.println(func+type+state);
	if(state.equals("begin")){
		page="begin";
		if(pb==null){
		count=QueryList.count(type,YohooUser.REGISTER_FOUR);
		pb=new PageBean();
		pb.setPagenow(1);
		pb.setItem(PageBean.LENGTH_TEN);//1页10个
		pb.setCount(count);
		pb.setType(type);
		pb.setFunc(func);
		pb.setState(state);
		session.setAttribute("pb",pb);
	}else{
		String pagespan=request.getParameter("pagespan");
		count=QueryList.count(type,YohooUser.REGISTER_FOUR);
		if(pb.getType().equals(type)&&pb.getFunc().equals(func)&&pb.getState().equals(state)){
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
				}
			}
		}else{
			pb.setItem(PageBean.LENGTH_TEN);
			pb.setPagenow(1);
			pb.setCount(count);
			pb.setType(type);
			pb.setFunc(func);
			pb.setState(state);
		}	
	}
		List<Object> list=QueryList.xunta(pb,YohooUser.REGISTER_FOUR);
		request.setAttribute("list",list);
		}
	else if(state.equals("pass")){
			page="pass";
			if(pb==null){
			count=QueryList.count(type,YohooUser.REGISTER_PASS);
			pb=new PageBean();
			pb.setPagenow(1);
			pb.setItem(PageBean.LENGTH_TEN);//1页10个
			pb.setCount(count);
			pb.setType(type);
			pb.setFunc(func);
			pb.setState(state);
			session.setAttribute("pb",pb);
		}else{
			String pagespan=request.getParameter("pagespan");
			count=QueryList.count(type,YohooUser.REGISTER_PASS);
			if(pb.getType().equals(type)&&pb.getFunc().equals(func)&&pb.getState().equals(state)){
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
					}
				}
			}else{
				pb.setItem(PageBean.LENGTH_TEN);
				pb.setPagenow(1);
				pb.setCount(count);
				pb.setType(type);
				pb.setFunc(func);
				pb.setState(state);
			}	
		}
			List<Object> list=QueryList.xunta(pb,YohooUser.REGISTER_PASS);
			request.setAttribute("list",list);
			}
		else if(state.equals("nopass")){
			page="nopass";
			if(pb==null){
			count=QueryList.count(type,YohooUser.REGISTER_NOT_PASS);
			pb=new PageBean();
			pb.setPagenow(1);
			pb.setItem(PageBean.LENGTH_TEN);//1页10个
			pb.setCount(count);
			pb.setType(type);
			pb.setFunc(func);
			pb.setState(state);
			session.setAttribute("pb",pb);
		}else{
			String pagespan=request.getParameter("pagespan");
			count=QueryList.count(type,YohooUser.REGISTER_NOT_PASS);
			if(pb.getType().equals(type)&&pb.getFunc().equals(func)&&pb.getState().equals(state)){
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
					}
				}
			}else{
				pb.setItem(PageBean.LENGTH_TEN);
				pb.setPagenow(1);
				pb.setCount(count);
				pb.setType(type);
				pb.setFunc(func);
				pb.setState(state);
			}	
		}
			List<Object> list=QueryList.xunta(pb,YohooUser.REGISTER_NOT_PASS);
			request.setAttribute("list",list);
			}url="/ForwardServlet?action=review&type="+type+"&func="+func+"&page="+page;
	sc.getRequestDispatcher(url).forward(request, response);
}
}
