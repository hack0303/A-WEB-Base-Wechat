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
    <title>查询结果页面|星乐趴</title> 
   <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" href="css/userinformation/search_result.css" type="text/css"></link>
  
  
  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/search_result.js"></script></head>
  
  <body>
    <div id="top">
    <h1> 
    以下是关于<div class="style">${requestScope.nav}</div>的检索结果
    </h1>
    <div id="list">
    <c:if test="${requestScope.list eq null}">没有您所要找的人....</c:if>
<c:forEach items="${requestScope.list}" var="object">
<table>
  <tr>
    <td colspan="2">
    <a href="MyServlet?action=showDetail&phone=${object.phone}">
    <img width="100%" height="100%" src="image/user/${object.main_url}"></img>
    </a>
     <div class="nav_show">
 </div>
   </td>
    </tr>
  <tr>
    <td>编号:${object.number}号</td>
  </tr>
  <tr>
    <td>昵称:${object.nickname}</td>
  </tr>
  <tr>
    <td><a href="MyServlet?action=forward&to=wxyt&to_phone=${object.phone}"><input type="button" value="立即约ta"></a></td>
    </tr>
</table>
</c:forEach>
</div>
</div>
<div id="footer">
<jsp:include page="/WEB-INF/main/footer.jsp"></jsp:include>
</div>
  </body>
</html>
