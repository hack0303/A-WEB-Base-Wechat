<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.net.www.dao.QueryDao"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="height:100%;">
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>嘉宾详情页面</title>
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
   <link rel="stylesheet" type="text/css" href="css/userinformation/usershowdetail.css">
  <script  type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/phonetouch.js"></script>
  <script type="text/javascript" src="javascript/userinformation/usershowdetail.js"></script>
  </head>
  
  <body>
    <div id="top">
    <div id="image">
    <ul>
   <c:forEach items="${requestScope.object.list}" var="IMGobject">
  <li>
  <img src="image/user/${IMGobject.image}"/>
  </li>
  </c:forEach>
  </ul>
    </div>
 <div id="item">
<div class="type1"><p>嘉宾编号:</p><p>${object.number}号</p></div>
<div class="type1"><p>昵称:</p><p>${object.nickname}</p></div>
<div class="type1"><p>学历:</p><p>${object.education}</p></div>
<div class="type1"><p>籍贯:</p><p>${object.nativeplace}</p></div>
<div class="type1"><p>职业:</p><p>${object.occupation}</p></div>
<div class="type1"><p>年龄:</p><p>${object.birthday}周岁</p></div>
<div class="type1"><p>身高:</p><p>${object.height}CM</p></div>
<div class="type1"><p>体重:</p><p>${object.weight}KG</p></div>
<div class="type1"><p>婚姻状况:</p><p>${object.marriage}</p></div>
<div class="type1"><p>是否有小孩</p><p>${object.havebaby}</p></div>
<div class="type2"><h1>认识Ta(个人描述)</h1><p>${object.introduction}</p></div>
<div class="type2"><h1>Ta想找的伴侣(择偶对象)</h1><p>${object.condition}</p></div>
</div>
<div id="nav3">
<table>
<tr>
<td><a href="MyServlet?action=forward&to=wxyt&to_phone=${object.phone}">
<div id="button">我想约ta</div></a></td>
<td><a href="MyServlet?action=show&type=first"><div id="button">取消</div></a></td>
</tr>
</table>
</div>
</div>
<div id="footer">
<jsp:include page="/WEB-INF/main/footer.jsp"></jsp:include>
</div>
</body>
</html>
