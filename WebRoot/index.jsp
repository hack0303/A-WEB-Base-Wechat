<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>  
<html style="height:100%;">
  <head>
    <base href="<%=basePath%>">
    <title>入口界面|星乐趴</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script type="text/javascript" src="javascript/jquery.js"></script>
    <script type="text/javascript" src="javascript/index.js"></script>
  </head>
  
  <body>
 <div id="scroller">
 <ul>
 <li><img src="image/system/index/qinzi.jpg"></img>
 </li>
 <li><img src="image/system/index/xunta.jpg"></img>
 </li>
 <li><img src="image/system/index/ruiqu.jpg"></img>
 </li>
 </ul>
 </div>
 <div id="index_nav">
<div class="class1">
<a href="ForwardServlet?action=activities&type=qinzi&page=in">
<img src="image/system/qinzi.png"></a>
</div>
<div class="class1">
<a href="ForwardServlet?action=activities&type=xunta&page=in">
<img src="image/system/xunta.png"></a>
</div>
<div class="class1">
<a href="ForwardServlet?action=activities&type=ruiqu&page=in">
<img src="image/system/ruiqu.png"></a>
</div>
 </div>
  </body>
</html>
