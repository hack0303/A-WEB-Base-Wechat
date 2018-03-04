package cn.net.www.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.DateBean;
import cn.net.www.bean.UserInformation;
import cn.net.www.dao.DeleteDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;
import cn.net.www.transaction.DateShowList;
import cn.net.www.transaction.Declare;
import cn.net.www.unit.MessageBuilder;
import cn.net.www.unit.MethodInvoke;
import cn.net.www.unit.SecurityUnit;

public class DateServlet extends HttpServlet {

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

	public void cancelRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		boolean flag=false;
		HttpSession session=request.getSession();
		LoginSession ls=(LoginSession) session.getAttribute("ls");
		String from=ls.getPhone();
		String to=SecurityUnit.phoneDecode(request.getParameter("to_phone"));
		String from_where=request.getParameter("procedure");
		String date_flag=request.getParameter("date_flag");
		int dateflag=0;
		if(date_flag.equals("onestart")) dateflag=DateBean.DATE_ONE_START;
		else if(date_flag.equals("payerror")) dateflag=DateBean.DATE_ONE_PAY_ERROR;
		else if(date_flag.equals("redate")) dateflag=DateBean.DATE_TWO_ACCEPT_NO;
		else if(date_flag.equals("twostart")) dateflag=DateBean.DATE_TWO_START;
		flag=new DeleteDao().deleteDateTable(from,to,dateflag);
		String url="/DateServlet?action=date&type=woyue&procedure={0}";
		url=MessageFormat.format(url,from_where);
		String msg="";
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if(flag){
			msg="撤销成功!";
		}else{
			msg="操作失败,请重新尝试";
		}
        String script="<script>alert('"+msg+"');" +
        		"location.href='DateServlet?action=date&type=woyue&procedure=1&nocache="+new Date().getTime()+"';</script>";
		out.write(script);
		out.flush();
		out.close();
	}//取消邀约
	public void woYue_dealRequest(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
		HttpSession session=request.getSession();
		String from_phone=String.valueOf(session.getAttribute("id"));
		String to_phone=request.getParameter("to_phone");
		String where=String.valueOf(session.getAttribute("where"));
		if(where.equals("null")) where=request.getParameter("where");
		int date_flag=Integer.parseInt(request.getParameter("date_flag"));
		boolean flag=new UpdateDao().updateDate_flag(date_flag,from_phone,to_phone);
		String url="MyServlet?action={0}&procedure={1}";
		String procedure="";
		String method="woYue_span";
		ServletContext sc=getServletContext();
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
	    url=MessageFormat.format(url,method,procedure);
		}else{
			String msg="操作失败,请联系管理员解决";
			request.setAttribute("msg",msg);
			url="error.jsp";
		}
		sc.getRequestDispatcher("/"+url).forward(request, response);
	}
	public void yueWo_dealRequest(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
    	HttpSession session=request.getSession();
		String where=String.valueOf(session.getAttribute("where"));
		if(where.equals("null")) where=request.getParameter("where");
    	String from_phone=request.getParameter("from_phone");
    	String to_phone=String.valueOf(session.getAttribute("id"));
		int date_flag=Integer.parseInt(request.getParameter("date_flag"));
		boolean flag=new UpdateDao().updateDate_flag(date_flag,from_phone,to_phone);
		String url="DateServlet?action=date&type=yuewo&procedure={0}";
		String procedure="";
		ServletContext sc=getServletContext();
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
		}else{
			String msg="操作失败,请联系管理员解决";
			request.setAttribute("msg",msg);
			url="error.jsp";
		}
		sc.getRequestDispatcher("/"+url).forward(request, response);
	}

    public void declare(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	String type=request.getParameter("type");
    	String step=request.getParameter("step");
    	if(type.equals("woyue")){
    		Declare.woyue_declare_four(getServletContext(), request, response);
    	}else if(type.equals("yuewo")){
    		if(step.equals("one")){
    			Declare.yuewo_declare_one(getServletContext(), request, response);
    		}else if(step.equals("three")){
    			Declare.yuewo_declare_three(getServletContext(), request, response);
    		}
    	}
    	
    }
    public void date(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
    	String type=request.getParameter("type");
    	if(type.equals("woyue")){
    		DateShowList.woYue_span(getServletContext(), request, response);
    	}else if(type.equals("yuewo")){
    		DateShowList.yueWo_span(getServletContext(), request, response);
    	}
    }//约会展示
    public void forwardDeclare(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        String type=request.getParameter("type");
        String url="";
        HttpSession session=request.getSession();
        LoginSession ls=(LoginSession)session.getAttribute("ls");
        int length=0;
	    if(type.equals("yuewo")){
        String procedure=request.getParameter("procedure").trim();
		String from_phone=SecurityUnit.phoneDecode(request.getParameter("from_phone"));
		String to_phone=ls.getPhone();
		try {
			UserInformation ui=new QueryDao().queryUIF_twoByPhone(from_phone, to_phone);
		request.setAttribute("object",ui);
		request.setAttribute("from_phone",from_phone);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		length=5;
		if(procedure.equals("1")){
			String[] str={"userinformation","xunta","Yuewo","declare","one"};
			url=MessageBuilder.forwardURL(length,str);	
		}else if(procedure.equals("3")){
			String[] str={"userinformation","xunta","Yuewo","declare","three"};		
			url=MessageBuilder.forwardURL(length,str);
		}
	}else if(type.equals("woyue")){
    String procedure=request.getParameter("procedure");
		String to_phone=SecurityUnit.phoneDecode(request.getParameter("to_phone"));
		String from_phone=ls.getPhone();
		try {
			UserInformation ui=new QueryDao().queryUIF_twoByPhone(from_phone, to_phone);
		request.setAttribute("object",ui);
		request.setAttribute("to_phone",to_phone);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		length=5;
		if(procedure.equals("4")){
			String[] str={"userinformation","xunta","Woyue","declare","four"};
			url=MessageBuilder.forwardURL(length,str);	
		}
		}
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
