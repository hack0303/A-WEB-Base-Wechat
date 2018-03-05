<%@ page language="java" import="java.util.*,cn.net.www.dao.QueryDao,cn.net.www.bean.XuntaUserForm" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test4.jsp' starting page</title>
    
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
    test1
    <%
   XuntaUserForm xtuf=new QueryDao().queryXuntaUserFormByPhone("222");
    session.setAttribute("xtuf",xtuf);
     %><br>
    test2<%
    new QueryDao().queryXuntaUserFormByPhone("111",10);
     %><br><br>
     <%session.setAttribute("time",new Date().getTime());%>
  </body>
</html>
