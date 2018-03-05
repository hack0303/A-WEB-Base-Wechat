<%@page import="cn.net.www.unit.SecurityUnit"%>
<%@ page language="java" import="java.util.*,cn.net.www.dao.QueryDao,cn.net.www.bean.XuntaUser" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>星乐趴|我想约她</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/javascript/jquery.js"></script>
    <!-- 
    <script type="text/javascript" src="javascript/upload_ajax.js"></script>
    -->
    <link rel="stylesheet" href="css/default.css" type="text/css"></link>
      <link rel="stylesheet" href="css/userinformation/xunta/wxyt.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/userinformation/xunta/wxyt.js"></script>
  </head>
  
  <body>
   <!--我想约她界面 -->
   <div id="top">请核对您的基础信息,如有变更,需携带相关证明文件至星乐趴客服中心修改</div>
   <div id="item">
<div class="type1"><p>编号:</p><p>${sessionScope.ls.number}</p></div>
<div class="type1"><p>昵称:</p><p>${xtu.nickname}</p></div>
<div class="type1"><p>年龄:</p><p>${xtu.birthday}周岁</p></div>
<div class="type1"><p>职业:</p><p>${xtu.occupation}</p></div>
<div class="type1"><p>学历:</p><p>${xtu.education}</p></div>
<div class="type1"><p>籍贯:</p><p>${xtu.nativeplace}</p></div>
<div class="type1"><p>身高:</p><p>${xtu.height}CM</p></div>
<div class="type1"><p>体重:</p><p>${xtu.weight}KG</p></div>
<div class="type1"><p>婚姻状况:</p><p>${xtu.marriage}</p></div>
<div class="type1"><p>是否有小孩:</p><p>${xtu.havebaby}</p></div>
   <div class="type2"><h1>个人描述</h1><p>${xtu.introduction}</p></div>
   <div class="type2"><h1>择偶对象</h1><p>${xtu.condition}</p></div>
   </div>
   <div id="check"><input type="checkbox">我已阅读并同意相关条款</div>
   <form action="MyServlet" method="post">
   <input type="hidden" name="action" value="yueTa">
   <input type="hidden" name="to_phone" value="${requestScope.to_phone}"/>
  <c:choose>
  <c:when test="${requestScope.dateflag}"><div id="msg">您已经约过Ta了</div></c:when>
  <c:otherwise>
  <div id="submit">
  立即提交
  </div>
  </c:otherwise>
    </c:choose>
   </form>
  </body>
</html>

