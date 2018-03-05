<%@ page language="java" import="java.util.*,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test8.jsp' starting page</title>
    
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
   <%=new QueryDao().queryState("男",4,null,10) %>
   <%=new QueryDao().queryShowList("男","10")%>
   <div id="test" style="background:red;height:50px;width:50px;border-radius:50%;"></div>
   <div>
   <%=new Date().getYear()%><br>
   <%=Calendar.getInstance().get(Calendar.YEAR)%><br>
   </div>
  </body>
</html>
