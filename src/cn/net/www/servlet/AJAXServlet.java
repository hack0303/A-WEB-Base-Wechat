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

import cn.net.www.bean.UserInformation;
import cn.net.www.dao.QueryDao;
import cn.net.www.transaction.AJAX;
import cn.net.www.unit.MathUnit;
import cn.net.www.unit.MethodInvoke;

public class AJAXServlet extends HttpServlet {

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
	public void ajax(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException,
	NamingException, SQLException, IOException {
		AJAX.checkIdentify(getServletContext(), request, response);
	    
	}
	public void checkajax(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException,
	NamingException, SQLException, IOException {
PrintWriter out = null;
out = response.getWriter();
String type = request.getParameter("type").trim();
String telephone = request.getParameter("telephone");
String userid = request.getParameter("userid");
// 有个细节就是,传参接受过程中,trim()去空格是肯定要加的,这里我没有立刻就加，是为了防止空指针,因为我这个是为了分别验证用户名是否唯一,还有手机号
// 是否唯一.即一次肯定是有个参数不存在,那么它获取的是空对象,不可以对空对象使用函数.
String sql = "select * from youhuo_user";
if (type.equals("userid"))
	sql = "select * from youhuo_user where userid='" + userid.trim()
			+ "'";
else if (type.equals("telephone"))
	sql = "select * from youhuo_user where telephone ='"
			+ telephone.trim() + "'";
boolean flag = true;
flag = new QueryDao().query(sql);
String response_msg = "";
if (!flag) {
	if (type.equals("userid"))
		response_msg = "用户可以进行注册,没有使用过!";
	else if (type.equals("telephone"))
		response_msg = "手机号没有被注册过,可以注册";
} else {
	if (type.equals("userid"))
		response_msg = "用户名不可以进行注册,已经被使用过!";
	else if (type.equals("telephone"))
		response_msg = "手机号不可以进行注册,已经被使用过";
}
out.print(response_msg);
out.flush();
out.close();
}

    public void ajax_register(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException, NamingException{
    	String type=request.getParameter("type").trim();
    	String value="";
    	boolean flag=false;
    	if(type.equalsIgnoreCase("phone")) value=request.getParameter("phone");
    	else if(type.equalsIgnoreCase("nickname")) value=request.getParameter("nickname");
    	flag=new QueryDao().ajax_query(type, value);
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	String i="0";
    	if(flag) i="1";
    	out.print(i);
    	out.flush();
    	out.close();	
    }
    public void ajax_yuewo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			NamingException, SQLException {
		String id = request.getParameter("id");
		UserInformation ui = new UserInformation();
		PrintWriter out = response.getWriter();
		String nickname = ui.getNickname();
		String birth_date = ui.getBirth_date();
		String weight = String.valueOf(ui.getWeight());
		String profession = ui.getProfession();
		String marital_status = String.valueOf(ui.getMarital_status());
		String yuewo = "\"nickname\":\"" + nickname + "\",\"birth_date\":\""
				+ birth_date + "\",\"weight\":\"" + weight
				+ "\",\"profession\":\"" + profession
				+ "\",\"marital_status\":\"" + marital_status + "\"";
		out.print(yuewo);
		out.flush();
		out.close();
	}

	public void getCheckcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		String checkcode=MathUnit.returnRandom(6,10);
		session.setAttribute("checkcode",checkcode);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println(checkcode);
		out.flush();
		out.close();
	}
}
