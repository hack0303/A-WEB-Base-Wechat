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
    <title>待邀约|星乐趴</title>
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
  <link rel="stylesheet" href="css/userinformation/Woyue/all.css" type="text/css"></link></head>
  
  <body> 
   <div id="nav1"> 
   <h1>我的约单</h1> 
   </div><div id="date_state"> 
   <%@include file="/WEB-INF/main/Woyue/all_state.jsp"%> 
   </div>
   <div id="main">
      <c:if test="${empty list}"><div id="msg">亲,你还没有约人,赶紧找人约起来吧</div></c:if>
 <c:forEach items="${requestScope.list}" var="object">
   <div class="date_table">
   <c:choose>
   <c:when test="${object.date_flag eq 100}">
      <table>
   <tr><td colspan="3">
   <h1>约单编号:${object.date_number}</h1>
  <!-- 100,进入，102，付款失败 202,对方拒绝,钱款返还到账 -->
   <p>
   ${object.date_time}
   </p>
   </td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>   
   <tr><td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p><a href="DateServlet?action=cancelRequest&to_phone=${object.phone}&procedure=1&date_flag=onestart">取消邀约</a></p>
   </td>
   <td>
   <p><a href="PayServlet?action=forward&type=xunta&to_phone=${object.phone}">免费体验</a></p>
   </td>
   </tr>
   </table>
   </c:when>
  <c:when test="${object.date_flag eq 102}">
      <table>
   <tr><td colspan="3">
   <h1>约单编号:${object.date_number}</h1>
  <!-- 100,进入，102，付款失败 203,对方拒绝,钱款返还到账 -->
   <p>
   <font color="red">付款失败,请重新支付</font>
   </p>
   </td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
   
   <tr><td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p><a href="DateServlet?action=cancelRequest&to_phone=${object.phone}&procedure=1&date_flag=payerror">取消邀约</a></p>
   </td>
   <td>
   <p><a href="PayServlet?action=forward&type=xunta&to_phone=${object.phone}">免费体验</a></p>
   </td>
   </tr>
   </table>
   </c:when>
 <c:when test="${object.date_flag eq 202}">
      <table>
   <tr><td colspan="3">
   <h1>约单编号:${object.date_number}</h1>
  <!-- 100,进入，102，付款失败 203,对方拒绝,钱款返还到账 -->
   <p>
  <font color="red">对方拒绝,钱已返还到账</font>
 </p>
   </td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
   
   <tr><td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p><a href="DateServlet?action=cancelRequest&to_phone=${object.phone}&procedure=1&date_flag=redate">取消邀约</a></p>
   </td>
   <td>
   <p><a href="PayServlet?action=forward&type=xunta&to_phone=${object.phone}">免费体验</a></p>
   </td>
   </tr>
   </table>
   </c:when>
   <c:when test="${object.date_flag eq 200}">
 <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>   
<font color="red">等待对方回复</font>
</p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
<tr><td></td>
   <td>
   <p><a href="tel:18862991268">联系客服</a></p>
   </td>
   <td>
   <p>
   <a href="DateServlet?action=cancelRequest&to_phone=${object.phone}&procedure=2&date_flag=twostart">
   取消邀约
   </a>
   </p>
   </td></tr>
   </table>
   </c:when>
   <c:when test="${object.date_flag eq 203}">
    <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>   
   <font color="red">对方未同意,退款失败,联系客服解决</font>
   </p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
<tr><td></td>
   <td>
   </td>
   <td>
 <p><a href="tel:18862991268">联系客服</a></p>
   </td></tr>
   </table>
   </c:when>
   
<c:when test="${object.date_flag eq 300}">
 <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p><font color="red">等待约会安排</font>
   </p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
 <tr>
 <td></td>
 <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p>
   <a href="MyServlet?action=cancelRequest&to_phone=${object.phone}">
   取消邀约
   </a>
   </p>
   </td>
   </tr>
   </table>
</c:when>
<c:when test="${object.date_flag eq 302}">
 <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
   <font color="red">约会安排失败,请联系管理员解决</font>
   </p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
<tr>
 <td></td>
 <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td>
   <p>
   <a href="MyServlet?action=cancelRequest&to_phone=${object.phone}">
   取消邀约
   </a>
   </p>
   </td>
   </tr>
   </table>
</c:when>

<c:when test="${object.date_flag eq 400}">
  <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
    </p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>  
<tr>
   <td>
   <p><a href="MyServlet?action=cancelRequest&to_phone=${object.phone}">删除约单</a></p>
   </td>
   <td><p>联系客服</p></td>
   <td><p>查看详情</p></td></tr>
   </table>
   </c:when>
   <c:when test="${object.date_flag eq 403}">
     <table>
   <tr><td colspan="3"><h1>约单编号:${object.date_number}</h1>
   <p>
    </p></td></tr>
   <tr><td><img src="image/user/${object.main_url}"></td><td><p>招来爱·爱的邀约</p><p>(第一期)</p></td><td>RMB88.0</td></tr>
    <tr>
   <td>
   </td>
   <td><p><a href="tel:18862991268">联系客服</a></p></td>
   <td><p><a href="DateServlet?action=forwardDeclare&type=woyue&procedure=4&to_phone=${object.phone}">待表态</a></p></td></tr>
    </table>
   </c:when>
    </c:choose> 
   </div>
   </c:forEach>
   </div>
  </body>
</html>
