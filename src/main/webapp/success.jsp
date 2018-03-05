<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>成功信息提示页</title>
    <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
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
  <div style="text-align:center;">
<%String pageurl=String.valueOf(request.getAttribute("pageurl"));
   String msg=String.valueOf(request.getAttribute("msg"));
    if(msg.equals("null")){
   %>
   SUCCESS PAGE <br>
   <%}else {%>
   <a href="<%=pageurl%>"><%=msg%></a>
   <%} %>
   </div>
  </body>
</html>
