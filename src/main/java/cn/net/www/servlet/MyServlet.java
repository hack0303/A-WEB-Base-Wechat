package cn.net.www.servlet;

import java.io.FileNotFoundException;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.FileUploadBean;
import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.LoginSession;
import cn.net.www.transaction.ChangeShowState;
import cn.net.www.transaction.Search;
import cn.net.www.transaction.ShowList;
import cn.net.www.transaction.ShowDetail;
import cn.net.www.transaction.WXYT;
import cn.net.www.transaction.WYZQ;
import cn.net.www.unit.MethodInvoke;
import cn.net.www.unit.SecurityUnit;
import cn.net.www.unit.MessageBuilder;
import cn.net.www.unit.UploadFile;

public class MyServlet extends HttpServlet {
	/**
	 * @author daxian
	 * @date : 2016-7-30 下午5:11:44
	 */
	private static final long serialVersionUID = 1L;
	QueryDao qd = null;
	HttpSession session = null;
	String methodname=null;

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		methodname = request.getParameter("action").trim();
		try {
			MethodInvoke.invokeMethod(this, methodname, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findPagination(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PageBean pb=(PageBean)session.getAttribute("pb");
		int pagination=pb.getPagination();
		out.println(pagination);
		out.flush();
		out.close();
	}
	public void findPageNow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PageBean pb=(PageBean)session.getAttribute("pb");
		int pagenow=pb.getPagenow();
		out.println(pagenow);
		out.flush();
		out.close();
	}
   public void show(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	String type=request.getParameter("type");
	if(type.equals("first"))
	ShowList.showList(getServletContext(),request,response);
	else if(type.equals("all")){
	ShowList.showList_all(getServletContext(),request,response);
	}	
}//展示嘉宾
   public void changeShowState(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	   ChangeShowState.change_userlist(getServletContext(), request, response);
	}
   public void changePage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	   ChangeShowState.changePage(getServletContext(), request, response);
   }
	public void showDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		ShowDetail.showDetail(getServletContext(), request, response);
	}
	public void showUserDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		ShowDetail.showUserDetail(getServletContext(), request, response);
	}
	@SuppressWarnings("deprecation")
	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileUploadBean fub = new FileUploadBean();
		fub.setPath(request.getRealPath("image/user"));
		fub.setSize(2 * 1024 * 1024);
		FileUploadBean fub_this = UploadFile.parseUploadRequest(fub, request);
		PrintWriter out = null;
		out = response.getWriter();
		out.print("<script>alert('" + fub_this.getMsg()
				+ "');history.go(-2);</script>");
	}

	@SuppressWarnings("deprecation")
	public void uploadFile_ajax(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileUploadBean fub = new FileUploadBean();
		fub.setPath(request.getRealPath("image/user"));
		fub.setSize(2 * 1024 * 1024);
		FileUploadBean fub_this = UploadFile.parseUploadRequest(fub, request);
		PrintWriter out = null;
		out = response.getWriter();
		String json = "{\"test\",\"test\"}";
		response.setContentType("application/json");
		out.print(json);
	}
    public void yueTa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WXYT.yueTa(getServletContext(), request, response);
	}//立即约Ta
	public void wyzq(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WYZQ.wyzq(getServletContext(), request, response);
	}//我要招亲
	public void search(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, NamingException, SQLException, IOException, ServletException{
		try {
			Search.search(getServletContext(), request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//search查询
    public void forward(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, NamingException, SQLException, IOException, ServletException{
    String to=request.getParameter("to");
    HttpSession session=request.getSession();
    LoginSession ls=(LoginSession)session.getAttribute("ls");
    if(ls==null){ 
    	return;
    	}
    String phone=ls.getPhone(); 
    String type="xunta";
    if(to.equals("wyzq")){
   XuntaUser xtu=new QueryDao().queryUserInformation(phone); 
   request.setAttribute("xtu",xtu);  
   int flag=new QueryDao().queryFlagByPhone(phone, type); 
   request.setAttribute("flag",flag);}
    else if(to.equals("wxyt")){
   	String to_phone=request.getParameter("to_phone");  
       String from_phone=ls.getPhone(); 
       QueryDao qd=new QueryDao(); 
       XuntaUser xtu=qd.queryUserInformation(from_phone); 
       boolean dateflag=true; 
       try {
    	   request.setAttribute("to_phone",to_phone);
		to_phone=SecurityUnit.phoneDecode(to_phone);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       dateflag=qd.queryFlag(from_phone, to_phone); 
       request.setAttribute("xtu",xtu); 
       request.setAttribute("dateflag",dateflag);
   }
   int length=3;
   String[] str={"userinformation",type,to};
   String url=MessageBuilder.forwardURL(length, str);
   getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    }
