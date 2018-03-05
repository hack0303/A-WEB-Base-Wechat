package cn.net.www.transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.QinziBabe;
import cn.net.www.bean.QinziForm;
import cn.net.www.bean.QinziSpouse;
import cn.net.www.bean.RuiquPartner;
import cn.net.www.bean.XuntaUserForm;
import cn.net.www.bean.YohooUser;
import cn.net.www.dao.InsertDao;
import cn.net.www.servlet.MyServlet;
import cn.net.www.session.RegisterSession;
import cn.net.www.unit.MessageBuilder;
import cn.net.www.unit.TextUnit;
import cn.net.www.unit.UploadFile;

public class Register {
public static final String STEP_ZERO="warning";//注册声明
public static final String STEP_ONE="one";//注册1
public static final String STEP_TWO="two";//注册2
public static final String STEP_THREE="three";//注册3
public static final String STEP_FOUR="four";//注册4
private ServletContext sc=null;
private HttpSession session=null;
private RegisterSession rs=null;
public void xunta(String step,ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	if(step.equals(STEP_ONE)){
		this.xunta_one(sc,request,response);
	}else if(step.equals(STEP_TWO)){
		this.xunta_two(sc,request,response);
	}
}
public void qinzi(String step,ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	if(step.equals(STEP_ONE)){
		this.qinzi_one(sc,request,response);
	}else if(step.equals(STEP_TWO)){
		this.qinzi_two(sc,request,response);
	}else if(step.equals(STEP_THREE)){
		this.qinzi_three(sc,request,response);
	}else if(step.equals(STEP_FOUR)){
		this.qinzi_four(sc,request,response);
	}
}
public void ruiqu(String step,ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	if(step.equals(STEP_ONE)){
		this.ruiqu_one(sc,request,response);
	}else if(step.equals(STEP_TWO)){
		this.ruiqu_two(sc,request,response);
	}else if(step.equals(STEP_THREE)){
		this.ruiqu_three(sc,request,response);
	}
}

public void xunta_one(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	String type="xunta";
	int flag = new UploadFile().register(request);
	String msg = "";
	String url = "";
	String pageurl = "";
	switch (flag) {
	case 0: {
		PrintWriter out = response.getWriter();
		msg = "逻辑代码出错,并没有经过逻辑判断.请联系管理员";
		response.setContentType("text/html");
		out.print("<script>" + "alert('" + msg + "');" + "history.go(-1);"
				+ "</script>");
		out.flush();
		out.close();
		break;
	}
	case 1: {
		PrintWriter out = response.getWriter();
		msg = "图片不可以超过2M";
		response.setContentType("text/html");
		out.print("<script>" + "alert('" + msg + "');" + "history.go(-1);"
		+ "</script>");
		out.flush();
		out.close();
		break;
	}
	case 2: {
		PrintWriter out = response.getWriter();
		msg = "图片格式不对";
		response.setContentType("text/html");
		out.print("<script>" + "alert('" + msg + "');" + "history.go(-1);"
				+ "</script>");
		out.flush();
		out.close();
	    break;
	}
	case 3: {
		msg = "数据库操作失败,请联系管理员查明原因";
		request.setAttribute("msg", msg);
		url = "/error.jsp";
		pageurl = "index.jsp";
		request.setAttribute("pageurl", pageurl);
		response.sendRedirect(url);
		break;

	}
	case 4: {
		msg = "数据库修改成功";
		String nextstep="two";
		url= "ForwardServlet?action=register&type="+type+"&step="+nextstep;
		response.sendRedirect(url);
		break;
	}
	case 5: {
		PrintWriter out = response.getWriter();
		msg = "主图片出错,后续操作中断,请检查";
		response.setContentType("text/html");
		out.print("<script>" + "alert('" + msg + "');" + "history.go(-1);"
		+ "</script>");
		out.flush();
		out.close();
		break;
	}
	}
}

public void xunta_two(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException,
		NamingException, SQLException {
	int flag = 0;
	RegisterSession rs=(RegisterSession) request.getSession().getAttribute("rs");
	if(rs==null){
		return;
	}
	String url = "/WEB-INF/userinformation/userlogin.jsp";
	String phone = String.valueOf(rs.getPhone());
	String[] fone = request.getParameterValues("one");
	String one = XuntaUserForm.returnString(fone);
	String[] ftwo = request.getParameterValues("two");
	String two = XuntaUserForm.returnString(ftwo);
	String[] fthree = request.getParameterValues("three");
	String three = XuntaUserForm.returnString(fthree);
	String four = request.getParameter("four");
	String five = request.getParameter("five");
	String six = request.getParameter("six");
	String seven = request.getParameter("seven");
	String[] feight = request.getParameterValues("eight");
	String eight = XuntaUserForm.returnString(feight);
	String nine = request.getParameter("nine");
	String[] ften = request.getParameterValues("ten");
	String ten = XuntaUserForm.returnString(ften);
	String eleven = request.getParameter("eleven");
	String twelve = request.getParameter("twelve");
	String thirteen = "";
	String[] ffourteen = { request.getParameter("love"),
			request.getParameter("career") };
	String fourteen = XuntaUserForm.returnString(ffourteen);
	String fifteen = request.getParameter("fifteen");
	String sixteen = request.getParameter("sixteen");
	String seventeen = request.getParameter("seventeen");
	String eighteen = request.getParameter("eighteen");
	String nineteen = request.getParameter("nineteen");
	//String nineteen = "测试";
	String twenty = request.getParameter("twenty");
	XuntaUserForm xtuf = new XuntaUserForm(one, two, three, four, five,
			six, seven, eight, nine, ten, eleven, twelve, thirteen,
			fourteen, fifteen, sixteen, seventeen, eighteen, nineteen,
			twenty);
	System.out.print(xtuf.toString());
	xtuf.setFlag("2");
	xtuf.setPhone(phone);
	flag = new InsertDao().registerForm(xtuf);
	String msg = "";
	switch (flag) {
	case 0: {
		request.setAttribute("msg", "系统逻辑出错,请联系管理员解决");
		url = "/error.jsp";
		sc.getRequestDispatcher(url).forward(request, response);
		break;
	}
	case 1: {
		session=request.getSession();
		url = "ForwardServlet?action=activities&type=xunta&page=out";
        session.removeAttribute("rs");
        response.sendRedirect(url);
	    break;
	}
	case 2: {
		PrintWriter out = response.getWriter();
		msg = "数据添加失败!";
		response.setContentType("text/html");
		out.print("<script>" + "alert('" + msg + "');" + "history.go(-1);"
				+ "</script>");
		out.flush();
		out.close();
	   break;
	}
	}
}
public void qinzi_one(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
	String type="qinzi";
	String nextstep="two";
	int id=0;
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String id_type=request.getParameter("id_type");
	String id_number=request.getParameter("id_number");
	String occupation=request.getParameter("occupation");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	int postcode=Integer.parseInt(request.getParameter("postcode"));
	int flag=1;
	YohooUser yu=new YohooUser(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address,type, postcode, flag);
	boolean db_flag=new InsertDao().register_qinzi_one(yu);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag){
		if(session==null)
		session=request.getSession();
		session.setAttribute("phone",phone);
		response.sendRedirect(url);}
	else{
		response.sendError(500,"内部数据库错误!");
	}
}
public void qinzi_two(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
	String type="qinzi";
	String nextstep="three";
	int id=0;
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String id_type=request.getParameter("id_type");
	String id_number=request.getParameter("id_number");
	String occupation=request.getParameter("occupation");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	int flag=2;
	QinziSpouse qs=new QinziSpouse(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, type);
	if(session==null)
		session=request.getSession();
	String prev_phone=String.valueOf(session.getAttribute("phone"));
	boolean db_flag=new InsertDao().register_qinzi_two(qs,prev_phone);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag)
		response.sendRedirect(url);
	else{
		response.sendError(500,"内部错误");
	}
}


public void qinzi_three(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
	String type="qinzi";
	String nextstep="four";
	String id="";
	String name=request.getParameter("name");
	String nickname=request.getParameter("nickname");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String school=request.getParameter("school");
	String grade=request.getParameter("grade");
	String onlychild=request.getParameter("onlychild");
	String hobby=request.getParameter("hobby");
	String speciality=request.getParameter("speciality");
	int flag=3;
	QinziBabe qb=new QinziBabe(id,name, nickname, gender, birthday, school, grade, onlychild, hobby, speciality);
	if(session==null)
		session=request.getSession();
	String prev_phone=String.valueOf(session.getAttribute("phone"));
	boolean db_flag=new InsertDao().register_qinzi_three(qb,prev_phone);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag)
		response.sendRedirect(url);
	else{
		response.sendError(500,"内部数据库错误!");
	}
}

public void qinzi_four(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
	String type="qinzi";
	String id="";
	
	String babe1=TextUnit.returnString(request.getParameterValues("babe_1"));
	String babe2=TextUnit.returnString(request.getParameterValues("babe_2"));
	String babe3=TextUnit.returnString(request.getParameterValues("babe_3"));
	String babe4=TextUnit.returnString(request.getParameterValues("babe_4"));
	String babe5=TextUnit.returnString(request.getParameterValues("babe_5"));
	String babe6=TextUnit.returnString(request.getParameterValues("babe_6"));
	String babe7=TextUnit.returnString(request.getParameterValues("babe_7"));
	String babe8=TextUnit.returnString(request.getParameterValues("babe_8"));
	String babe9=TextUnit.returnString(request.getParameterValues("babe_9"));
	String you1=TextUnit.returnString(request.getParameterValues("you_1"));
	String you2=TextUnit.returnString(request.getParameterValues("you_2"));
	String you3=TextUnit.returnString(request.getParameterValues("you_3"));
	String you4=TextUnit.returnString(request.getParameterValues("you_4"));
	String you5=TextUnit.returnString(request.getParameterValues("you_5"));
	String you6=TextUnit.returnString(request.getParameterValues("you_6"));
	String you7=TextUnit.returnString(request.getParameterValues("you_7"));
	QinziForm qf=new QinziForm(babe1, babe2, babe3, babe4, babe5, babe6, babe7, babe8, babe9, you1, you2, you3, you4, you5, you6, you7);
	if(session==null)
	session=request.getSession();
	String prev_phone=String.valueOf(session.getAttribute("phone"));
	boolean db_flag=new InsertDao().register_qinzi_four(qf,prev_phone);
	String url = "ForwardServlet?action=activities&type="+type+"&page=out";
	if(db_flag)
		response.sendRedirect(url);
	else{
		response.sendError(500,"内部数据库错误!");
	}
}
public void ruiqu_one(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
	String type="ruiqu";
	String nextstep="two";
	int id=0;
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String id_type=request.getParameter("id_type");
	String id_number=request.getParameter("id_number");
	String occupation=request.getParameter("occupation");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	int postcode=Integer.parseInt(request.getParameter("postcode"));
	int flag=1;
	YohooUser yu=new YohooUser(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address,type, postcode, flag);
	boolean db_flag=new InsertDao().register_ruiqu_one(yu);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag){
		if(session==null)
			session=request.getSession();
			session.setAttribute("phone",phone);
			 response.sendRedirect(url);}
	else{
		response.sendError(500,"内部数据库错误!");
	}
}

public void ruiqu_two(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
	String type="ruiqu";
	String nextstep="three";
	int id=0;
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String id_type=request.getParameter("id_type");
	String id_number=request.getParameter("id_number");
	String occupation=request.getParameter("occupation");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	int postcode=Integer.parseInt(request.getParameter("postcode"));
	int flag=2;
	RuiquPartner rp=new RuiquPartner(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, postcode,type);
	if(session==null)
		session=request.getSession();
	String prev_phone=String.valueOf(session.getAttribute("phone"));
	boolean db_flag=new InsertDao().register_ruiqu_two(rp,prev_phone);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag)
		response.sendRedirect(url);
	else{
		response.sendError(500,"内部数据库错误!");
	}
}


public void ruiqu_three(ServletContext sc,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
	String type="ruiqu";
	String nextstep="three";
	int id=0;
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String id_type=request.getParameter("id_type");
	String id_number=request.getParameter("id_number");
	String occupation=request.getParameter("occupation");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	int postcode=Integer.parseInt(request.getParameter("postcode"));
	RuiquPartner rp=new RuiquPartner(id, name, gender, birthday, id_type, id_number, occupation, phone, email, address, postcode,type);
	if(session==null)
		session=request.getSession();
	String prev_phone=String.valueOf(session.getAttribute("phone"));
	boolean db_flag=new InsertDao().register_ruiqu_three(rp,prev_phone);
	String url = "ForwardServlet?action=register&type="+type+"&step="+nextstep;
	if(db_flag)
		response.sendRedirect(url);
	else{
		response.sendError(500,"内部数据库错误!");
	}}
}
