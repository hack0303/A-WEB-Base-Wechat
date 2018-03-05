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
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.dao.QueryDao;

public class SuperFunc {
	public static void query(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	String type=request.getParameter("type");
	String func=request.getParameter("func");//功能
	if(type.equals("xunta")){
		if(func.equals("register")){
			Register.xunta(sc, request, response);
		}else if(func.equals("wyzq")){
			WYZQ.xunta(sc, request, response);
			
		}else if(func.equals("authority")){
			Authority.xunta(sc, request, response);
		}else if(func.equals("date")){
			Date.xunta(sc, request, response);
		}else if(func.equals("activities")){
			Activities.xunta(sc, request, response);
		}
	}else if(type.equals("qinzi")){
		
		
	}else if(type.equals("ruiqu")){
		
	}
	}
}
