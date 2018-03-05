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
<meta http-equiv="refresh" content="5;url=index.jsp">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/default.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js">
  </script>
<link rel="stylesheet" href="css/activities/out.css" type="text/css">
<script type="text/javascript" src="javascript/activities/out.js">
  </script>
</head>

<body>
	<div id="top">
		<img src="image/activities/top.jpg"></img>
	</div>
	<div id="nav">
		<p>
			<c:choose>
				<c:when test="${requestScope.type eq 'qinzi'}">
   感谢您预约注册优活亲子会员,开业前期,我们将联系您完成认证,领取会员卡,届时您将获得各种权益和福利.
  </c:when>
				<c:when test="${requestScope.type eq 'xunta'}">
 感谢您注册优活寻Ta会员,请您准备好相关资料证明,我们将联系您完成认证,领取会员卡.拥有优活寻Ta会员资格,您将获得各种权益和福利.
  </c:when>
				<c:when test="${requestScope.type eq 'ruiqu'}">
   感谢您预约注册优活睿趣会员,开业前期,我们将联系您完成认证,领取会员卡,届时您将获得各种权益和福利.
  </c:when>
			</c:choose>
		</p>
		<p>
			<c:choose>
				<c:when test="${requestScope.type eq 'qinzi'}">
   敬请期待!
 </c:when>
				<c:when test="${requestScope.type eq 'xunta'}">
欢迎加入!</c:when>
				<c:when test="${requestScope.type eq 'ruiqu'}">
   敬请期待!
   </c:when>
			</c:choose>
		</p>
	</div>
	<div id="footer">
		<div id="count">
			<p>5</p>
		</div>
		<p>
			秒后自动返回主页,<a href="index.jsp">点击可以立即返回</a>
		</p>
	</div>

</body>
</html>
