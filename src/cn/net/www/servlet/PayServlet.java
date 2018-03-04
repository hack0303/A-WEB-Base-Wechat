package cn.net.www.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.DateBean;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.MethodInvoke;
import cn.net.www.unit.SecurityUnit;

public class PayServlet extends HttpServlet {
   HttpSession session=null;
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodname = request.getParameter("action").trim();
		try {
			MethodInvoke.invokeMethod(this, methodname, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
    public void weixin_pay(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	String procedure="1";
    	PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
    	boolean pay_flag=true;
    	boolean sql_flag=false;
    	session=request.getSession();
    	LoginSession ls=(LoginSession) session.getAttribute("ls");
    	String to_phone=SecurityUnit.phoneDecode(request.getParameter("to_phone"));
    	String from_phone=ls.getPhone();
    	String url="";
    	if(pay_flag){
    	sql_flag=new UpdateDao().updateDate_flag(DateBean.DATE_ONE_PAY_YES, from_phone, to_phone);
    	if(sql_flag){
    		String pattern="DateServlet?action=date&type=woyue&procedure={0}";
            url=MessageFormat.format(pattern,procedure);
    	    response.sendRedirect(url);	
    	}
    	else{
    		out.write("<script>alert('操作失败!')</script>");
    		out.flush();
    	}
    	}else{
    	sql_flag=new UpdateDao().updateDate_flag(DateBean.DATE_ONE_PAY_ERROR, from_phone, to_phone);
    	if(sql_flag){
    		String pattern="DateServlet?action=woYue_span&procedure={0}";
            url=MessageFormat.format(pattern,procedure);
    	    response.sendRedirect(url);	
    	}
    	else{
    		out.write("<script>alert('操作失败!')</script>");
    		out.flush();
    	}
    	}
    	if(out!=null) out.close();
    	}
    public void forward(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, NamingException, SQLException, IOException, ServletException{
     String to_phone=request.getParameter("to_phone");
     String type=request.getParameter("type");
     String url="ForwardServlet?action=activities&nav=welfare&type="+type+"&to_phone="+to_phone;
     response.sendRedirect(url);	
    }

}
