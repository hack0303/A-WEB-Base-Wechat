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
    <title>管理员页面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="css/management/adminmanage.css" type="text/css"></link>
  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/management/adminmanage.js"></script></head>
  
  <body>
  <div id="top">
  <h1>yohoo管理员后台</h1>
  </div>
  <div id="login_information">
  <marquee>欢迎使用星乐趴后台系统!</marquee><p>登录时间:${sessionScope.as.lastlogin_time}</p>
  <p>权限名称:<c:choose>
  <c:when test="${sessionScope.as.authority eq 110 }">
  超级管理员
  </c:when>
  <c:when test="${sessionScope.as.authority eq 1}">
  复核客服
  </c:when>
  <c:when test="${sessionScope.as.authority eq 2 }">
  审核客服
  </c:when>
  <c:when test="${sessionScope.as.authority eq 3 }">
  电话客服
  </c:when>
  </c:choose></p><p><a href="AdminLoginOutServlet?action=loginout">退出</a></p>
  </div>
  <div id="middle">
  <div id="left">
  <c:choose>
  <c:when test="${sessionScope.as.authority eq 110}">
  <div id="nav">
  <h1>yohoo亲子</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  <div id="nav">
 <h1>yohoo寻Ta</h1>
  <div id="item">
  <div class="class2">
  <h2>注册审核</h2>
  <div id="list">
  <p><a href="AdminServlet?action=query&type=xunta&func=register" target="main">注册只完成阶段一</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=register&state=begin" target="main">审核注册人员</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=register&state=pass" target="main">已审核通过人员</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=register&state=nopass" target="main">拒绝通过审核人员</a></p>
  </div>
  </div>
  <div class="class2">
  <h2>我要招亲审核</h2>
  <div id="list">
  <p><a href="AdminServlet?action=query&type=xunta&func=wyzq&state=begin" target="main">审核参加招亲人员</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=wyzq&state=pass" target="main">招亲已通过人员</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=wyzq&state=nopass" target="main">招亲审核未通过人员</a></p>
  </div>
  </div>
  <div class="class2">
  <h2>权限审核</h2>
  <div id="list">
  <p><a href="AdminServlet?action=query&type=xunta&func=authority&state=forbid" target="main">限制权限</a></p>
  <p><a href="AdminServlet?action=query&type=xunta&func=authority&state=forbided" target="main">权限被限制人员</a></p>
  </div>
  </div>
   <div class="class2">
   <h2>约会安排</h2>
   <div id="list">
   <p><a href="AdminServlet?action=query&type=xunta&func=date&state=begin" target="main">待牵线</a></p>
   <p><a href="AdminServlet?action=query&type=xunta&func=date&state=pass" target="main">约会安排成功人员</a></p>
   <p><a href="AdminServlet?action=query&type=xunta&func=date&state=nopass" target="main">约会安排失败/退出</a></p>
   </div>
   </div>
   <div class="class2">
   <h2>活动相关</h2>
   <div id="list">
   <p><a href="AdminServlet?action=query&type=xunta&func=activities&state=begin" target="main">申请参加活动人员</a></p>
   <p><a href="AdminServlet?action=query&type=xunta&func=activities&state=pass" target="main">审核通过人员</a></p>
   <p><a href="AdminServlet?action=query&type=xunta&func=activities&state=nopass" target="main">审核未通过人员</a></p>
  </div> 
   </div>
  </div>
  </div>
  <div id="nav">
  <h1>yohoo睿趣</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  </c:when>
  <c:when test="${sessionScope.as.authority eq 1}">
   <div id="item">
  <div class="class2">
  <p><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register" target="main">注册审核</a></p>
  <p><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register_one" target="main">注册审核</a></p>
  <p><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register_two" target="main">注册审核</a></p>
  <p><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register_pass" target="main">注册审核</a></p>
  <p><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register_nopass" target="main">注册审核</a></p>
  </div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=wyzq" target="main">招亲审核</a></div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=authority" target="main">权限审核</a></div>
   <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=date" target="main">约会安排</a></div>
  </div>
  </div>
  <div id="nav">
  <h1>yohoo睿趣</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  </c:when>
  <c:when test="${sessionScope.as.authority eq 2}">
   <div id="item">
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=register" target="main">注册审核</a></div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=wyzq" target="main">招亲审核</a></div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=authority" target="main">权限审核</a></div>
   <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=date" target="main">约会安排</a></div>
  </div>
  </div>
  <div id="nav">
  <h1>yohoo睿趣</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  </c:when>
  <c:when test="${sessionScope.as.authority eq 3}">
  <div id="nav">
  <h1>yohoo亲子</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  <div id="nav">
 <h1>yohoo寻Ta</h1>
  <div id="item">
  <div class="class2"><a href="AdminServlet?action=query&type=xunta&reviewtype=register" target="main">注册审核</a></div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=wyzq" target="main">招亲审核</a></div>
  <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=authority" target="main">权限审核</a></div>
   <div class="class2"><a href="AdminServlet?action=forwardReview&type=xunta&reviewtype=date" target="main">约会安排</a></div>
  </div>
  </div>
  <div id="nav">
  <h1>yohoo睿趣</h1>
  <div id="item">
  <div class="class2">审核嘉宾</div>
  <div class="class2">添加本期嘉宾</div>
  <div class="class2">删除违规用户</div>
  </div>
  </div>
  </c:when>
  </c:choose>
  </div>
  <div id="right">
  <iframe src="ForwardServlet?action=welcome" name="main">
  </iframe>
  </div>
  </div>
  <div id="footer">
  </div>
  </body>
</html>
