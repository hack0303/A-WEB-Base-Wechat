<%@ page language="java" import="java.util.*,cn.net.www.dao.QueryDao,cn.net.www.bean.XuntaUser" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="height:100%;">
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
  <base href="<%=basePath%>" > 
  <title>嘉宾展示页面|星乐趴</title>
   <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	   <link rel="stylesheet" href="css/default.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="css/userinformation/usershow.css">
  <script src="javascript/jquery.js" ></script>
  <script src="javascript/userinformation/usershow_all.js"></script>
  <%
  String msg=String.valueOf(request.getAttribute("msg"));
  if(!msg.equals("null")){
   %>
   <script>
   alert('<%=msg%>');
   </script>
   <%}%>
  </head>
  
  <body>
  <div id="top">
 <div id="top_nav">
 </div>
 <div id="search">
 <form action="MyServlet" method="post">
 <input type="hidden" name="action" value="search">
 <input type="text" name="search" placeholder="搜索昵称或编号" maxlength="10"><div id="search_button">搜索</div>
 </form>
 </div>
<div id="titlelist">
<%@include file="/WEB-INF/main/usershow_select_all.jsp" %>
<p></p>
</div>
<div id="list">
<c:forEach items="${requestScope.list}" var="object">
<table>
  <tr>
    <td colspan="2">
    <div id="image">
    <a href="MyServlet?action=showDetail&phone=${object.phone}"><img width="100%" height="100%" src="image/user/${object.main_url}"></img>
    </a>
     </div>
     <div class="nav_show">
     <p>
     ${object.introduction}
     </p>
     <div id="detail_button">
     <a href="MyServlet?action=showUserDetail&phone=${object.phone}">
     了解详情
     </a>
     </div>
     </div>
   </td>
    </tr>
  <tr>
    <td>嘉宾编号:${object.number}号</td>
  </tr>
  <tr>
    <td>昵称:${object.nickname}</td>
  </tr>
  <tr>
    <td><a href="MyServlet?action=forward&to=wxyt&to_phone=${object.phone}">
    <input type="button" value="立即约ta"></a></td>
    </tr>
</table>
</c:forEach>
</div>
<div id="spanuser">
<jsp:include page="/WEB-INF/main/pagespan.jsp"></jsp:include>
</div>
</div>
<div id="footer">
<jsp:include page="/WEB-INF/main/footer.jsp"></jsp:include>
</div>
  </body>
</html>
