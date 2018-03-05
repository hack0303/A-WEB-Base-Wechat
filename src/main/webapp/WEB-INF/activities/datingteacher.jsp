<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html style="height:100%;">
<head>
<base href="<%=basePath%>">

<title><c:choose>
		<c:when test="${requestScope.type eq 'qinzi'}">优活亲子</c:when>
		<c:when test="${requestScope.type eq 'ruiqu'}">优活睿趣</c:when>
		<c:when test="${requestScope.type eq 'xunta'}">优活寻Ta</c:when>
	</c:choose>|星乐趴</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/default.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/alert/alertPopShow.js"></script>
<link rel="stylesheet" href="css/activities/datingteacher.css"
	type="text/css">
<script type="text/javascript"
	src="javascript/activities/datingteacher.js"></script>
</head>
<body>
	<div id="grid">
		<div id="top_nav">
			<img src="image/activities/02.jpg">
		</div>
	</div>
	<div id="footer">
		<div id="submit">报名参加活动</div>
	</div>
</body>
</html>
