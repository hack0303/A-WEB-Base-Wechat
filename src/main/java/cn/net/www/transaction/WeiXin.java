package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.bean.DateBean;
import cn.net.www.dao.UpdateDao;

public class WeiXin {
    public void weixin_pay(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, NamingException, SQLException, IOException, ServletException{
    	String procedure="1";
    	boolean pay_flag=true;
    	boolean sql_flag=false;
    	String to_phone=request.getParameter("to_phone").trim();
    	String from_phone=String.valueOf(request.getSession().getAttribute("id"));
    	if(pay_flag){
    	sql_flag=new UpdateDao().updateDate_flag(DateBean.DATE_ONE_PAY_YES, from_phone, to_phone);
    	}else{
    	sql_flag=new UpdateDao().updateDate_flag(DateBean.DATE_ONE_PAY_ERROR, from_phone, to_phone);	
    	}   
    	String url="";
    	if(sql_flag){
    		String pattern="/MyServlet?action=woYue_span&procedure={0}";
            url=MessageFormat.format(pattern,procedure);
    		}
    	else{ 
    		url="/error.jsp";
    	request.setAttribute("msg","操作失败,联系管理员解决");
    	request.setAttribute("pageurl","");
    	}
        sc.getRequestDispatcher(url).forward(request, response);
    	}
}
