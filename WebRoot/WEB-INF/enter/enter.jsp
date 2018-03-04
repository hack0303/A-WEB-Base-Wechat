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

<title>寻Ta入口|星乐趴</title>
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
<c:choose>
	<c:when test="${requestScope.type eq 'xunta' }">
		<link rel="stylesheet" href="css/enter/xunta.css" type="text/css"></link>
		<script type="text/javascript" src="javascript/enter/xunta.js"></script>
	</c:when>
	<c:when test="${requestScope.type eq 'ruiqu' }">
		<link rel="stylesheet" href="css/enter/ruiqu.css" type="text/css"></link>
		<script type="text/javascript" src="javascript/enter/ruiqu.js"></script>
	</c:when>
	<c:when test="${requestScope.type eq 'qinzi' }">
		<link rel="stylesheet" href="css/enter/qinzi.css" type="text/css"></link>
		<script type="text/javascript" src="javascript/enter/qinzi.js"></script>
	</c:when>
</c:choose>
</head>

<body>
	<div id="one"></div>
	<c:choose>
		<c:when test="${requestScope.type eq 'xunta' }">
			<div id="two">
				<div class="vertical">
					<p>【招来爱】 仅对优活寻Ta会员开放</p>
					<p>[Falling Love] Only open to Yohoo Dating member</p>
				</div>
			</div>
			<div id="three">
				<div id="nav_left">
					<div id="nav_top">
						<p>我想成为优活寻Ta会员</p>
						<p>I want to be</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>注 册</p>
							<p>Register</p>
						</div>
					</div>
				</div>
				<div id="nav_right">
					<div id="nav_top">
						<p>我是优活寻Ta会员</p>
						<p>I am</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>登 录</p>
							<p>Login</p>
						</div>
					</div>
				</div>
			</div>
			<div id="four">
				<div id="nav">
					<p>
						<a href="https://h5.koudaitong.com/v2/feature/7w8em3ek"
							target="_blank">了解招来爱服务>>></a>
					</p>
					<p>Yohoo Dating service</p>
				</div>
			</div>
		</c:when>
		<c:when test="${requestScope.type eq 'ruiqu' }">
			<div id="two">
				<div class="vertical">
					<p>【？？？】 仅对优活睿趣会员开放</p>
					<p>[???] Only open to Yohoo Smart member</p>
				</div>
			</div>
			<div id="three">
				<div id="nav_left">
					<div id="nav_top">
						<p>我想成为优活睿趣会员</p>
						<p>I want to be</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>注 册</p>
							<p>Register</p>
						</div>
					</div>
				</div>
				<div id="nav_right">
					<div id="nav_top">
						<p>我是优活睿趣会员</p>
						<p>I am</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>登 录</p>
							<p>Login</p>
						</div>
					</div>
				</div>
			</div>
			<div id="four">
				<div id="nav">
					<p>了解优活睿趣服务>>></p>
					<p>Yohoo Smart service</p>
				</div>
			</div>
		</c:when>
		<c:when test="${requestScope.type eq 'qinzi' }">
			<div id="two">
				<div class="vertical">
					<p>【？？？】 仅对优活亲子会员开放</p>
					<p>[???] Only open to Yohoo Parenting member</p>
				</div>
			</div>
			<div id="three">
				<div id="nav_left">
					<div id="nav_top">
						<p>我想成为优活亲子会员</p>
						<p>I want to be</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>注 册</p>
							<p>Register</p>
						</div>
					</div>
				</div>
				<div id="nav_right">
					<div id="nav_top">
						<p>我是优活亲子会员</p>
						<p>I am</p>
					</div>
					<div id="nav_bottom">
						<div class="nav_button">
							<p>登 录</p>
							<p>Login</p>
						</div>
					</div>
				</div>
			</div>
			<div id="four">
				<div id="nav">
					<p>了解优活亲子服务>>></p>
					<p>Yohoo Parenting service</p>
				</div>
			</div>
		</c:when>
	</c:choose>
</body>
</html>
