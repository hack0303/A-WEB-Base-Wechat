<%@page import="cn.net.www.session.AdminSession"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.net.www.unit.MathUnit" %>
<!DOCTYPE html>
<html style="height:100%;">
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>管理员登录页面</title>
     <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" href="css/management/adminlogin.css" type="text/css"></link>
 <%
  AdminSession as=(AdminSession)session.getAttribute("as");
 String url="ForwardServlet?action=adminmanage";
  if(as!=null) response.sendRedirect(url);else{
 String checkcode=MathUnit.returnRandom(6,10);
 session.setAttribute("checkcode",checkcode);}
  %>
  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/management/adminlogin.js"></script>
  <%Object msg=request.getAttribute("msg"); if(msg!=null){%>
  <script>
  alert('<%=String.valueOf(msg)%>');
  </script>
  <%} %>
  </head>
  
  <body>
  <div id="title">
  <div id="title_logo">
  </div>
  <div id="title_nav">
  </div>
  </div>
    <div id="nav">
   <form action="SecurityServlet" method="post">
   <div id="login">
   <div id="login_img"><img src="image/management/login/login.png"></img></div>
  <input name="account" type="text" placeholder="请输入帐号">
  </div>
  <div id="password">
  <div id="password_img"><img src="image/management/login/password.png"></img></div>
  <input name="password" type="password" placeholder="请输入密码">
  </div>
  <div id="checkcode">
  <input name="checkcode" type="text"/><div id="checkcode_nav"><p>${sessionScope.checkcode}</p></div>
  </div>
  <input name="action" type="hidden" value="adminlogin"/>
   </form>
   <div id="footer">
   <div id="submit">提交</div>
   <div id="reset">重置</div>
   </div>
   </div>
   <div id="msg"></div>
   <div id="nav_background"></div>
  </body>
</html>
