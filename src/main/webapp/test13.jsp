<%@page import="cn.net.www.base.PhoneDigest"%>
<%@page import="cn.net.www.unit.SecurityUnit"%>
<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat,cn.net.www.bean.YohooUser,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%@page import="cn.net.www.bean.XuntaUser,cn.net.www.bean.XuntaUserForm" %>
<%@page import="java.text.DateFormat"%>
<%@page import="cn.net.www.unit.MathUnit"%>
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
.Calendar测试<br>
<%
	Calendar c=Calendar.getInstance();
	out.println("--------Calendar.ALL_STYLES----------");
	out.println(c.get(Calendar.ALL_STYLES));
	
	out.println("-------Calendar.AM-----------");
	out.println(c.get(Calendar.AM));
	
	out.println("------------------");
	out.println(c.get(Calendar.AM_PM));
	
	out.println("------------------");
	out.println(c.get(Calendar.APRIL));	
	
	out.println("------------------");
	out.println(c.get(Calendar.AUGUST));
 
 	out.println("------------------");
	out.println(c.get(Calendar.DATE));
	
		out.println("------------------");
	out.println(c.get(Calendar.DAY_OF_MONTH));
	
		out.println("------------------");
	out.println(c.get(Calendar.DAY_OF_WEEK));
	
		out.println("------------------");
	out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	
		out.println("------------------");
	out.println(c.get(Calendar.DAY_OF_YEAR));
	out.println("------------------");
	out.println(c.get(Calendar.DECEMBER));
	out.println("------------------");
	out.println(c.get(Calendar.DST_OFFSET));
	out.println("------------------");
	out.println(c.get(Calendar.ERA));
	out.println("------------------");
	out.println(c.get(Calendar.FEBRUARY));
	out.println("------------------");
	//out.println(c.get(Calendar.FIELD_COUNT));
	out.println("------------------");
	out.println(c.get(Calendar.FRIDAY));
	out.println("------------------");
	out.println(c.get(Calendar.HOUR));
	out.println("------------------");
	out.println(c.get(Calendar.HOUR_OF_DAY));
	out.println("------------------");
	out.println(c.get(Calendar.JANUARY));
	out.println("------------------");
	out.println(c.get(Calendar.JULY));
	out.println("------------------");
	out.println(c.get(Calendar.JUNE));
	out.println("------------------");
	out.println(c.get(Calendar.LONG));
	out.println("------------------");
	out.println(c.get(Calendar.MARCH));
	out.println("------------------");
	out.println(c.get(Calendar.MAY));
	out.println("------------------");
	out.println(c.get(Calendar.MILLISECOND));
	out.println("------------------");
	out.println(c.get(Calendar.MINUTE));
	out.println("------------------");
	out.println(c.get(Calendar.MONDAY));
	out.println("------------------");
	out.println(c.get(Calendar.MONTH));
	out.println("------------------");
	out.println(c.get(Calendar.NOVEMBER));
	out.println("------------------");
	out.println(c.get(Calendar.OCTOBER));
	out.println("------------------");
	out.println(c.get(Calendar.PM));
	out.println("------------------");
	out.println(c.get(Calendar.SATURDAY));
	out.println("------------------");
	out.println(c.get(Calendar.SECOND));
	out.println("------------------");
	out.println(c.get(Calendar.SEPTEMBER));
	out.println("------------------");
	out.println(c.get(Calendar.SHORT));
	out.println("------------------");
	out.println(c.get(Calendar.SUNDAY));
	out.println("------------------");
	out.println(c.get(Calendar.THURSDAY));
	out.println("------------------");
	out.println(c.get(Calendar.TUESDAY));
	out.println("------------------");
	out.println(c.get(Calendar.UNDECIMBER));
	out.println("------------------");
	out.println(c.get(Calendar.WEDNESDAY));
	out.println("------------------");
	out.println(c.get(Calendar.WEEK_OF_MONTH));
	out.println("------------------");
	out.println(c.get(Calendar.WEEK_OF_YEAR));
	out.println("------------------");
	out.println(c.get(Calendar.YEAR));
	out.println("------------------");
	out.println(c.get(Calendar.ZONE_OFFSET));
%>
	<%
		Date dt=new Date();
		String s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
		out.print(dt);
		out.print(s);
	%>
	 <%
	 	String phone="18806298620";
	 	  phone="18807070707";
	 	   String encode_phone=SecurityUnit.phoneEncode(phone);
	 	   String decode_phone=SecurityUnit.phoneDecode(encode_phone);
	 	   out.println(encode_phone);
	 	   out.println(decode_phone);
	 %>
  </body>
</html>
