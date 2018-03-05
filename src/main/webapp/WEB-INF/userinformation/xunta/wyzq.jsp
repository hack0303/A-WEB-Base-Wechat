<%@page import="cn.net.www.session.LoginSession"%>
<%@ page language="java" import="java.util.*,cn.net.www.bean.XuntaUser,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
 <!-- 我要招亲表单页-->
    <title>星乐趴|我要招亲</title>
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
  <link rel="stylesheet" href="css/userinformation/xunta/wyzq.css" type="text/css"></link>
  
  <script type="text/javascript" src="javascript/jquery.js"></script>
	<script type="text/javascript" src="javascript/alert/alertPopShow.js"></script>
  <script type="text/javascript" src="javascript/userinformation/xunta/wyzq.js"></script></head>
  
  <body>
<div id="top">
<div id="top_nav">
</div>
<div id="item">
<div class="type1"><p>编号:</p><p>${sessionScope.ls.number}</p></div>
<div class="type1"><p>昵称:</p><p>${requestScope.xtu.nickname}</p></div>
<div class="type1"><p>学历:</p><p>${requestScope.xtu.education}</p></div>
<div class="type1"><p>籍贯:</p><p>${requestScope.xtu.nativeplace}</p></div>
<div class="type1"><p>职业:</p><p>${requestScope.xtu.occupation}</p></div>
<div class="type1"><p>年龄:</p><p>${requestScope.xtu.birthday}周岁</p></div>
<div class="type1"><p>身高:</p><p>${requestScope.xtu.height}CM</p></div>
<div class="type1"><p>体重:</p><p>${requestScope.xtu.weight}KG</p></div>
<div class="type1"><p>婚姻状况:</p><p>${requestScope.xtu.marriage}</p></div>
<div class="type1"><p>是否有小孩:</p><p>${requestScope.xtu.havebaby}</p></div>
<div class="type2"><h1>认识Ta(个人描述)</h1><p>${requestScope.xtu.introduction}</p></div>
<div class="type2"><h1>Ta想找的伴侣(择偶对象)</h1><p>${requestScope.xtu.condition}</p></div>
<form action="MyServlet" method="post">
<input type="hidden" name="action" value="wyzq">
</form>
<div id="check"><input type="checkbox">我已阅读并同意相关条款</div>
<c:choose>
<c:when test="${requestScope.flag eq 9}">
<div id="msg">已经提交过申请,请耐心等待处理</div>
</c:when>
<c:when test="${requestScope.flag eq 10}">
<div id="msg">已经通过申请,并在展示嘉宾列中</div>
</c:when>
<c:when test="${requestScope.flag eq 11}">
<div id="msg">申请被拒绝,请重新提交,或联系管理员查询情况</div>
<div id="submit">提交申请</div>
<div id="link_admin">联系管理员</div>
</c:when>
<c:otherwise>
<div id="submit">提交申请</div>
</c:otherwise>
</c:choose>
</div>
</div>
<div id="pop">
<div id="pop_top">
<p>X</p>
</div>
<div id="pop_nav">
<h1>活动条款</h1>
<p>本条款和条件(包括以下提及的使用条款和隐私权政策)适用于南通杰思创意策划有限公司星乐趴分公司，并且将构成您与星乐趴分公司之间的法律协议。本条款和条件中的某些用词具有下述“定义”部分所规定的特定含义（在本文中另有定义的除外）。
您确认、声明且保证您所提交信息均真实可靠，并且完全有能力签署本条款和条件并遵守和符合其规定。您同意按照星乐趴的要求提供准确完整的信息（例如在您向星乐趴申请办理寻优活Ta系列会员卡），包括您的真实姓名、电子邮箱地址、工作单位、工作地址和电话号码等。
搜索微信公众平台“lovelyparty520”进入微网站，了解星乐趴、优活寻Ta卡、以及“招来爱”详细信息</p>
</div>
</div>
<div id="footer">
<jsp:include page="/WEB-INF/main/footer.jsp"></jsp:include>
</div>
  </body>
</html>
