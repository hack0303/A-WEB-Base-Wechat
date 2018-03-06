<%@ page language="java" import="java.util.*,cn.net.www.bean.PageBean,cn.net.www.bean.XuntaUserForm" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册审核|管理员后台</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="css/management/xunta/review_register.css" type="text/css"></link>
  <%
  String msg=String.valueOf(request.getAttribute("msg"));
  if(msg!="null"){
   %>
   <script>
   alert('<%=msg%>');
   </script>
   <%} %>
</head>
  <body>
  <div id="top"></div>
  <div id="nav">
<c:if test="${requestScope.list==null}">暂时没有相关人员信息</c:if>
<form action="AdminServlet" method="post">
 <table width="100%" border="0">
  <tr>
    <td>主键<input type="checkbox"></td>
    <td>用户姓名:</td>
    <td>用户电话:</td>
    <td>是否通知过</td>
  </tr>
  <tr>
    <td colspan="2">通知完成</td>
    <td colspan="2">通知完成,用户拒绝后续操作</td>
  </tr>
</table>
 </form>
 </div>
  <div id="footer">
<c:if test="${requestScope.list!=null}">
批量同意/重置
</c:if>
  </div> 
  </body>
</html>
