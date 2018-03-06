package cn.net.www.transaction;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;

public class WYZQ {
	public static void wyzq(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		String type="xunta";
		String phone = ls.getPhone();
		int now_flag=new QueryDao().queryFlagByPhone(phone, type);
		/*
		 * 只有当前状态为审核通过的才可以申请为招亲
		 * */
		switch(now_flag){
		case YohooUser.REGISTER_PASS:{
			break;
		}
		case YohooUser.WYZQ_REQUEST_NOT_PASS:{
			break;
		}
		default:{
			return;
		}
		}
        boolean flag=new UpdateDao().updateReview(YohooUser.WYZQ_REQUEST_START, phone);
	    PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		try{
		if(flag){ 
		out.print(true);
		}else{
		out.print(false);
		}
		out.flush();
		}finally{out.close();}
	}
}
