<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat,cn.net.www.bean.YohooUser,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%@page import="cn.net.www.bean.XuntaUser,cn.net.www.bean.XuntaUserForm" %>
<%@page import="java.text.DateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test11.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
     SimpleDateFormat sdf=new SimpleDateFormat();
	  sdf.applyPattern("yyyy-MM-dd");
	  String date_time=sdf.format(new Date()); 
 %>
 <%
 out.println("SimpleDateFormat方法:"+date_time);
 date_time=DateFormat.getDateInstance().format(new Date());
     out.println("DateFormat方法:"+date_time);
  %>
  <%
  	YohooUser yu=null;
		//yu = (YohooUser) new QueryDao().queryReviewByPhone("18806298620","YohooUser");
	if(yu!=null)
	out.print(yu.toString());
   %>
   <%
  	XuntaUser xtu=null;
		//xtu = (XuntaUser) new QueryDao().queryReviewByPhone("18806298620",XuntaUser.class);
	if(xtu!=null)
	out.print(xtu.toString());
   %>
    <%
  	XuntaUserForm xtuf=null;
		//xtuf = (XuntaUserForm) new QueryDao().queryReviewByPhone("18806298620",XuntaUserForm.class);
	if(xtuf!=null){
	out.print(xtuf.toString());
	String[] test=xtuf.getTen().split(",");
	for(String t:test)
	out.println(t);}
   %>
  </body>
</html>
