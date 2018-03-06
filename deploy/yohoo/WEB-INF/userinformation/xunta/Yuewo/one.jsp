<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html Style="height:100%;">
  <head> 
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>我约的人</title>
    <meta name="viewport" content="height=device-height,width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" href="css/userinformation/Yuewo/one.css" type="text/css"></link></head>
  
  <body> 
   <div id="top"> 
   <div class="one"><img src="image/user/${sessionScope.ls.main_url}"></div> 
   <div class="two"><h1>${sessionScope.ls.nickname}</h1></div> 
   <div class="three"><h2>优活寻Ta会员</h2></div> 
   </div>
   <div id="nav1"> 
   <jsp:include page="/WEB-INF/main/Yuewo/nav1.jsp"></jsp:include>
   </div>
   <div id="date_state"> 
   <%@include file="/WEB-INF/main/Yuewo/date_state.jsp"%> 
   </div>
   <div id="main">
      <c:if test="${empty list}"><div id="msg">亲,你还没有约人,赶紧找人约起来吧</div></c:if>
 <div class="date_table">
 <c:forEach items="${requestScope.list}" var="object">
 <c:choose>
 <c:when test="${object.date_flag eq '200'}">
   <table>
   <tr><td colspan="3">
   <h1>约单编号:${object.date_number}</h1>
   <p>
   </p>
   </td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/user/${object.main_url}"></a></td><td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td>
   <td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td>
   </tr>
   <tr>
     <td>
   </td>
   <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p><a href="DateServlet?action=forwardDeclare&type=yuewo&procedure=1&from_phone=${object.phone}">去表态</a></p> 
   </td></tr>
   </table>
   </c:when>
   <c:when test="${object.date_flag eq '202'}">
   <table>
   <tr><td colspan="3">
   <h1>约单编号:${object.date_number}</h1>
   <p>
   </p>
   </td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/user/${object.main_url}"></a></td><td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td>
   <td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td>
   </tr>
   <tr>
     <td>
   </td>
   <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p>已拒绝</p> 
   </td></tr>
   </table>
   </c:when>
   </c:choose>
   </c:forEach>
    </div>
   </div>
  </body>
</html>
