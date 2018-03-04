package cn.net.www.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.bean.YohooAdmin;
import cn.net.www.bean.YohooUser;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.management.transaction.AdminLogin;
import cn.net.www.management.transaction.Detail;
import cn.net.www.management.transaction.SuperFunc;
import cn.net.www.management.transaction.UpdateReview;
import cn.net.www.unit.MathUnit;
import cn.net.www.unit.MethodInvoke;
import cn.net.www.unit.MessageBuilder;
import cn.net.www.unit.UploadFile;

public class AdminServlet extends HttpServlet {
   private int length=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5769447254599014313L;
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
String action=request.getParameter("action").trim();
try {
	MethodInvoke.invokeMethod(this,action, request, response);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public void query(HttpServletRequest request,HttpServletResponse response) throws Exception{
SuperFunc.query(getServletContext(),request, response);
}
public void insert(HttpServletRequest request,HttpServletResponse response){
	String id=request.getParameter("phone");
	
}
public void updateReview(HttpServletRequest request,HttpServletResponse response) throws Exception{
String  type=request.getParameter("type");
if(type.equals("xunta")){
	UpdateReview.xunta(getServletContext(), request, response);
	
}else if(type.equals("ruiqu")){
	
}else if(type.equals("qinzi")){
	
} 

}
public void delete(HttpServletRequest request,HttpServletResponse response){
	String id=request.getParameter("");
}
public void upload(HttpServletRequest request,HttpServletResponse response) throws IOException{
String type="xunta";
String service="change";
if(type.equals("xunta")){
	if(service.equals("change")){
		try {
			new UploadFile().uploadOne(getServletContext(), request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
public void showUserDetail(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, SQLException, NamingException, IOException, ServletException{
	Detail.detailAboutPhone(getServletContext(), request, response);
}
}
