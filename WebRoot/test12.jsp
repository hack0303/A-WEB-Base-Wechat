<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat,cn.net.www.bean.YohooUser,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%@page import="cn.net.www.bean.XuntaUser,cn.net.www.bean.XuntaUserForm" %>
<%@page import="java.text.DateFormat"%>
<%@page import="cn.net.www.unit.MathUnit,cn.net.www.unit.DateUnit"%>
<%@page import="cn.net.www.bean.YohooCheckCode"%>

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
  String pattern="yyyy-MM-dd HH:mm:ss";
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
		//xtu = (XuntaUser) new QueryDao().queryReviewByPhone("18806298620","XuntaUser");
	if(xtu!=null)
	out.print(xtu.toString());
   %>
    <%
  	XuntaUserForm xtuf=null;
		//xtuf = (XuntaUserForm) new QueryDao().queryReviewByPhone("18806298620","XuntaUserForm");
	if(xtuf!=null){
	out.print(xtuf.toString());
	String[] test=xtuf.getTen().split(",");
	for(String t:test)
	out.println(t);}
   %>
   <%=MathUnit.returnRandom(4,10)%>
	<%
	Date date=new Date(); 
	out.println("------------------");
	String phone="18806298620";
  QueryDao qd=new QueryDao();
  YohooCheckCode ycc=(YohooCheckCode)qd.queryObject(phone,YohooCheckCode.class);
 out.println(ycc.getGet_time());
	out.println("------------------");
 out.println(DateUnit.returnDateByString(pattern,"1991-03-03 20:04:40"));
	out.println("------------------");
 out.println(date.toString());
 out.println("------------------");
 out.println(date.toGMTString());
	out.println("------------------");
 out.println( Locale.getDefault());
 
	out.println("------------------");
 out.println(new SimpleDateFormat().format(new Date()));
 
	out.println("------------------");
 out.println(new SimpleDateFormat(pattern).format(new Date()));
	out.println("------------------");
	out.println(date.getDay());
	out.println("------------------");
 %>
 <%
 Date date1=DateUnit.returnDateByString(pattern,"1991-03-03 20:04:40");
 Date date2=DateUnit.returnDateByString(pattern,"1991-03-03 20:04:45");
 long differtime=(date2.getTime()-date1.getTime())/1000;
 long differtime2=(date1.getTime()-date2.getTime())/1000;
 out.println("相差的时间:"+differtime);
 out.println("相差的时间:"+differtime2);
  %>
  </body>
</html>
