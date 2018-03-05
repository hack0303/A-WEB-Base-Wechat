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
<script type="text/javascript" src="javascript/jquery.js">
  </script>
<link rel="stylesheet" href="css/activities/in.css" type="text/css">
<script type="text/javascript" src="javascript/activities/in.js"></script>
</head>
<body>
	<div id="top">
		<img src="image/activities/top.jpg"></img>
	</div>
	<div id="nav">
		<c:choose>
			<c:when test="${requestScope.type eq 'qinzi'}">
				<!--  星乐趴线下实体南通旗舰店12月21日重装开业,创新开启同城优质生活新篇章。即日起预约注册优活亲子会员,享受开业大庆多重好礼,并有机会受邀参加年底亲子系列大趴,寓教于乐,史无前例。
   -->
			</c:when>
			<c:when test="${requestScope.type eq 'xunta'}">
				<!-- 星乐趴线下实体南通旗舰店12月21日重装开业,创新开启同城优质生活新篇章。即日起接受合作单位优活寻Ta会员申请,实施集体实名认证,10月底线上平台正式开启,11月11日首场大型派对精彩呈现。
 其他同城单身青年预约注册,完成实名认证后,可优先免费享受寻Ta体验活动,获取定制服务优惠。
  -->
			</c:when>
			<c:when test="${requestScope.type eq 'ruiqu'}">
				<!-- 星乐趴线下实体南通旗舰店12月21日重装开业,创新开启同城优质生活新篇章。即日起预约注册优活睿趣会员,享受开业大庆多重好礼,并有机会受邀参加年底系列兴趣大趴,文化盛宴,史无前例。
  -->
			</c:when>
		</c:choose>
	</div>
	<div id="footer">
		<div id="submit" onClick="submit('${requestScope.type}')">
			<p>立 即 注 册</p>
			<p>Register</p>
		</div>
	</div>
</body>
</html>
