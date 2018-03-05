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
	</c:choose>星乐趴|会员福利</title>
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
<script type="text/javascript" src="javascript/jquery.js">
  </script>
<link rel="stylesheet" href="css/activities/xunta/welfare.css"
	type="text/css">
<script type="text/javascript"
	src="javascript/activities/xunta/welfare.js"></script>
</head>
<body>
	<div id="title">
		<h1>会 员 福 利</h1>
	</div>
	<div id="nav">
		<p>星乐趴线下实体南通旗舰店12月21日重装开业，即日起成功注册优活寻Ta会员可免费体验“招来爱”邀约活动。</p>
	</div>
	<div id="footer">
		<div id="submit">
			<p>
				<a href="javascript:weixin_pay('${requestScope.to_phone}')">领 取
					福 利</a>
			</p>
		</div>
	</div>
</body>
</html>
