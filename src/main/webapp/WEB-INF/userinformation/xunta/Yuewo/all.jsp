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
  <link rel="stylesheet" href="css/userinformation/Yuewo/all.css" type="text/css"></link></head>
  
  <body> 
   <div id="nav1"> 
   <h1>我的约单</h1> 
   <p>查看全部约单>>></p> 
   </div><div id="date_state"> 
   <%@include file="/WEB-INF/main/Yuewo/all_state.jsp"%> 
   </div>
   <div id="main">
      <c:if test="${empty list}"><div id="msg">亲,你还没有约人,赶紧找人约起来吧</div></c:if>
 <c:forEach items="${requestScope.list}" var="object">
   <div class="date_table">
  
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
    <c:when test="${object.date_flag eq 300}">
   <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
<font color="red">等待约会安排</font>
  </p></td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/test1.png"></a></td>
   <td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td>
   <td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td>
   </tr>
  <tr><td></td>
   <td>
   <p><a href="tel:18862991268">联系客服</a></p>
   </td>
   <td>
   <p>
   不可取消
   </p>
   </td></tr>
   </table>
   </c:when>
     <c:when test="${object.date_flag eq 302}">
   <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
<font color="red">拒绝安排约会,请查看原因</font>
  </p></td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/test1.png"></a></td>
   <td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td>
   <td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td>
   </tr>
  <tr><td></td>
   <td>
   <p><a href="tel:18862991268">联系客服</a></p>
   </td>
   <td>
   <p>
   查看原因
   </p>
   </td></tr>
   </table>
   </c:when>
   
   <c:when test="${object.date_flag eq 400}">  
     <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p><font color="red">等待约会</font>
   </p></td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/test1.png"></a></td><td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td><td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td></tr>
<tr>
  <td></td>
 <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p>
  不可取消
   </p>
   </td>
   </tr>
     </table>
   </c:when>
   <c:when test="${object.date_flag eq 403}">
        <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
   </p></td></tr>
   <tr><td><a href="MyServlet?action=showUserDetail&phone=${object.phone}"><img src="image/test1.png"></a></td><td><p>昵称:${object.nickname}</p><p>年龄:${object.age}</p></td><td><p>学历:${object.education}</p><p>职业:${object.occupation}</p></td></tr>
   <tr>
 <td><p>删除约单</p></td>
 <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p>
  <a href="DateServlet?action=forwardDeclare&type=yuewo&procedure=3&from_phone=${object.phone}">待表态</a>
   </p>
   </td>
   </tr>
   </table>
   </c:when>
   </c:choose>
   </div>
   </c:forEach>
   </div>
  </body>
</html>
