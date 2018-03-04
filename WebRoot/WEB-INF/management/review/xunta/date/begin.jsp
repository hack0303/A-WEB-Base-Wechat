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
    
    <title>约会审核|管理员后台</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%
  String msg=String.valueOf(request.getAttribute("msg"));
  if(msg!="null"){
   %>
   <script>
   alert('<%=msg%>');
   </script>
   <%} %>
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/main/admin/span.js"></script>
<link rel="stylesheet" href="css/management/xunta/register.css" type="text/css"></link></head>
  <body>
  <div id="top"></div>
  <div id="nav">
<c:if test="${requestScope.list==null}">暂时没有相关人员信息</c:if>
<form action="AdminServlet" method="post">
  <c:forEach items="${requestScope.list}" var="object">
  <div class="item">
 <h1><input type="checkbox" name="check" value=""></h1>
<table>
 <tr>
 <td>主键:${object.id}</td>
 <td>
 <p>约单号:${object.date_number}</p>
 </td>
 <td>
 <p>邀约方:${object.from_id}</p>
 <p><a href="AdminServlet?action=showUserDetail&phone=${object.from_id}&type=xunta&func=date">查看详情</a></p>
 </td>
 <td>
 <p>被约方:${object.to_id}</p>
 <p><a href="AdminServlet?action=showUserDetail&phone=${object.to_id}&type=xunta&func=date">查看详情</a></p>
 </td>
 <td>约会时间:${object.date_time}</td>
 </tr>
</table>
<div id="bottom">
<ul>
<li></li>
<li><p><a href="AdminServlet?action=update&id=${object.id}&service=review&type=xunta&deal=pass">通过</a></p></li>
<li><p><a href="AdminServlet?action=update&id=${object.id}&&service=review&type=xunta&deal=nopass">拒绝</a></p></li></ul>
</div>
</div>
</c:forEach>
 </form>
 </div>
 <div id="span">
 <%@include file="/WEB-INF/main/admin/span.jsp"%></div>
  <div id="footer">
<c:if test="${requestScope.list!=null}">
<div id="batch_submit">批量同意</div><div id="reset">重 置</div>
</c:if>
  </div> 
  </body>
</html>
