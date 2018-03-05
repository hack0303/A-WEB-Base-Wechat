<%@page import="cn.net.www.session.LoginSession"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="cn.net.www.bean.YohooUser"%>
<%@page import="cn.net.www.dao.QueryDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="height:100%;">
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>用户登录页面|星乐趴</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link href="css/userinformation/userlogin.css" rel="stylesheet" type="text/css"></link>
	<script src="javascript/jquery.js">
	</script>
	<script type="text/javascript" src="javascript/alert/alertPopShow.js"></script>
  <script src="javascript/userinformation/userlogin/sendMessage.js">
	</script>
	<%
	Object ob=request.getAttribute("msg");
	String msg="";
	LoginSession ls=(LoginSession)session.getAttribute("ls");
	if(ls!=null)
    response.sendRedirect("MyServlet?action=show&type=first");
	%>
	<%
	if(ob!=null){
	msg=String.valueOf(ob);
	 %>
	 <script>
	 $(document).ready(function(){
popTipShow.alert('错误警告','<%=msg%>', ['知道了'],
			function(e){
			  //callback 处理按钮事件		  
			  var button = $(e.target).attr('class');
			  if(button == 'ok'){
				//按下确定按钮执行的操作
				//todo ....
				this.hide();
			  }	
			}
		);
		});
	 </script>
	 <%}%>
 </head>
  
  <body>
   <div id="login">
   <form action="SecurityServlet" id="phone_login" method="post">
 <div class="list">
 <img src="image/system/userlogin/phone_icon.png"/>
 <input name="phone"  type="text" id="phone_number" autocomplete="off" placeholder="请输入手机号  Please enter the phone number" >
 </div>
 <div class="list">
 <img src="image/system/userlogin/checkcode_icon.png"/>
 <input name="checkcode" type="text" id="checkcode" autocomplete="off" placeholder="请填入验证码  Please fill in the captcha">
 </div>
 <div class="list">
 <div id="check">
  <p>点击获取验证码<br>Click to get captcha</p>
 </div>
  </div>
   <input type="hidden" name="action" value="login">
   <input type="hidden" name="type" value="xunta">
  <div class="list"> 
  <div id="submit">登 录 系 统</div>
  </div>
   </form>
   </div>
  </body>
</html>
