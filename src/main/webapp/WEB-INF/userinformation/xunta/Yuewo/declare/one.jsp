<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html style="height:100%;">
  <head>
    <base href="<%=basePath%>">
    
    <title>表态|星乐趴</title>
     <meta name="viewport" content="height=device-height,width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" href="css/userinformation/Yuewo/declare/one.css" type="text/css"></link>
  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/Yuewo/declare/one.js"></script></head>
  <body>
 <div id="top">
 <h1>
 表态
 </h1>
 </div>
 <div id="nav">
 <h1><p>约单编号:${object.date_number}</p></h1>
 <ul>
 <li><img src="image/user/${object.main_url}"></li>
 <li><p>招来爱●爱的邀约</p></li>
 </ul>
 <div class="class1">
 <form action="DateServlet" method="post">
 <input type="hidden" name="action" value="declare">
 <input type="hidden" name="type" value="yuewo">
 <input type="hidden" name="step" value="one">
 <input type="hidden" name="date_number" value="${object.date_number}">
 <input type="radio" name="agree" id="agree_yes" value="yes" checked hidden="true">
 <input type="radio" name="agree" id="agree_no" value="no" hidden="true">
 <p><label for="agree_yes"><img src="image/system/declare/yes_change.png"></img>愿意约会</label></p>
 <p><label for="agree_no"><img src="image/system/declare/no.png"></img>不考虑</label></p>
 </div>
  <div class="class2">
  <textarea name="content"></textarea>
  </div>
  </form>
  <div class="class3">
  <p>
 <input type="checkbox">我已阅读并同意相关条款</p>
 </div>
 </div>
 <div id="footer">
<p><a href="tel:18862991268">联系客服</a></p><p> 确认提交</p>
 </div>
 
  </body>
</html>
