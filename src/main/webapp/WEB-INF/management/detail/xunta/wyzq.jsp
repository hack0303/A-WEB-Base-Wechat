<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    
    <title>注册会员详情页</title>
        <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/management/detail/xunta/register.css">

  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/management/detail/xunta/register.js"></script></head>
  
  <body>
  <div id="grid">
  <div id="top">
  <div id="left">←</div>
  <div id="image">
  <ul>
  <c:forEach items="${requestScope.object.list}" var="IMGobject">
  <li>
  <img src="image/user/${IMGobject.image}"/>
  </li>
  </c:forEach>
  </ul>
  </div>
  <div id="right">→</div>
  </div>
  <div id="middle">
  <p class="image">
  <c:forEach items="${requestScope.object.list}" var="IMGobject">
  原图片:${IMGobject.image}<td><a href="ForwardServlet?action=adminupload&type=xunta&service=change&phone=${requestScope.object.phone}&image_url=${IMGobject.image}" target="_blank">[修改]</a></td><br>
  </c:forEach>
  </p>
  <p class="reflush"><a href="javascript:location.reload(true)" title="如果修改了图片,请刷新当前页面进行显示">刷 新 当 前 页 面</a></p>
  <p class="id">
  主键:<I>${requestScope.object.id}</I></p>
 <p class="name">姓名:<I>${requestScope.object.name}</I><font color="red">[修改]</font></p>
 <p class="gender">性别:<I>${requestScope.object.gender}</I><font color="red">[修改]</font></p>
 <p class="birthday">生日:<I>${requestScope.object.birthday}</I><font color="red">[修改]</font></p>
 <p class="id_type">ID类型:<I>${requestScope.object.id_type}</I><font color="red">[修改]</font></p>
 <p class="id_number">ID编号<I>${requestScope.object.id_number}</I><font color="red">[修改]</font></p>
 <p class="occupation">职业:<I>${requestScope.object.occupation}</I><font color="red">[修改]</font></p>
 <p class="phone">手机号:<I>${requestScope.object.phone}</I></p>
 <p class="email">邮箱:<I>${requestScope.object.email}</I><font color="red">[修改]</font></p>
 <p class="address">地址:<I>${requestScope.object.address}</I><font color="red">[修改]</font></p>
 <p class="postcode">邮编:<I>${requestScope.object.postcode}</I><font color="red">[修改]</font></p>
 <p class="flag">标志位: <I>${requestScope.object.flag}</I></p>
 <p class="type">类型: <I>${requestScope.object.type}</I><font color="red">[修改]</font></p>
 <p class="creating_time">创建时间: <I>${requestScope.object.creating_time}</I></p>
 <p class="nativeplace">籍贯: <I>${requestScope.object.nativeplace}</I><font color="red">[修改]</font></p>
 <p class="work_organization">工作地址: <I>${requestScope.object.work_organization}</I><font color="red">[修改]</font></p>
 <p class="height">身高: <I>${requestScope.object.height}</I><font color="red">[修改]</font></p>
 <p class="weight">体重: <I>${requestScope.object.weight}</I><font color="red">[修改]</font></p>
 <p class="salary">薪水: <I>${requestScope.object.salary}</I><font color="red">[修改]</font></p>
 <p class="onlychild">是否独生子女: <I>${requestScope.object.onlychild}</I><font color="red">[修改]</font></p>
 <p class="marriage">是否结婚:<I> ${requestScope.object.marriage}</I><font color="red">[修改]</font></p>
 <p class="havebaby">是否有小孩: <I>${requestScope.object.havebaby}</I><font color="red">[修改]</font></p>
 <p class="nickname">昵称: <I>${requestScope.object.nickname}</I><font color="red">[修改]</font></p>
 <p class="state">嘉宾期数: <I>${requestScope.object.state}</I><font color="red">[修改]</font></p>
 <p class="number"> 嘉宾编号:<I>${requestScope.object.number}</I><font color="red">[修改]</font></p>
 <p class="main_url">主图片地址: <I>${requestScope.object.main_url}</I><font color="red">[修改]</font></p>
 <p class="education">学历:<I>${requestScope.object.education}</I><font color="red">[修改]</font></p>
 <p class="one">问卷1:<I>${requestScope.object.one}</I><font color="red">[修改]</font>
 <p class="two">问卷2:<I>${requestScope.object.two}</I><font color="red">[修改]</font></p>
 <p class="three">问卷3:<I>${requestScope.object.three}</I><font color="red">[修改]</font></p>
 <p class="four">问卷4:<I>${requestScope.object.four}</I><font color="red">[修改]</font></p>
<p class="five">问卷5:<I>${requestScope.object.five}</I><font color="red">[修改]</font></p>
 <p class="six">问卷6:<I>${requestScope.object.six}</I><font color="red">[修改]</font></p>
 <p class="seven">问卷7:<I>${requestScope.object.seven}</I><font color="red">[修改]</font></p>
  <p class="eight">问卷8:<I>${requestScope.object.eight}</I><font color="red">[修改]</font></p>
  <p class="nine">问卷9:<I>${requestScope.object.nine}</I><font color="red">[修改]</font></p>
  <p class="ten">问卷10:<I>${requestScope.object.ten}</I><font color="red">[修改]</font></p>
  <p class="eleven"> 问卷11:<I>${requestScope.object.eleven}</I><font color="red">[修改]</font></p>
  <p class="twelve">问卷12:<I>${requestScope.object.twelve}</I><font color="red">[修改]</font></p>
  <p class="thirteen">
  问卷13:<I>${requestScope.object.thirteen}</I><font color="red">[修改]</font></p>
  <p class="fourteen">
  问卷14:<I>${requestScope.object.fourteen}</I><font color="red">[修改]</font></p>
  <p class="fifteen">
  问卷15:<I>${requestScope.object.fifteen}</I><font color="red">[修改]</font></p>
  <p class="sixteen">
  问卷16:<I>${requestScope.object.sixteen}</I><font color="red">[修改]</font></p>
  <p class="seventeen">
  问卷17:<I>${requestScope.object.seventeen}</I><font color="red">[修改]</font></p>
  <p class="eighteen">
  问卷18:<I>${requestScope.object.eighteen}</I><font color="red">[修改]</font></p>
  <p class="nineteen">
  问卷19:<I>${requestScope.object.nineteen}</I><font color="red">[修改]</font></p>
  <p class="twenty">
  问卷20:<I>${requestScope.object.twenty}</I><font color="red">[修改]</font></p>
  </div>
  <div id="change">
  <h1>修改界面</h1>
  <form action="" method="post">
  <input name="action" value="modify" type="hidden">
  <input name="name" value="" type="hidden">
  <input name="phone" value="${requestScope.object.phone}" type="hidden">
 <p> <input name="value" value="" type="text" autocomplete="off">
  </p>
  <p>
  <input type="button" value="确定"><input type="button" value="关闭">
  </p>
  </form>
  </div>
  <div id="footer">
  <p><a href="javascript:pass(${requestScope.object.phone})">通 过</a></p>
  <p><a href="javascript:nopass(${requestScope.object.phone}">拒 绝</a></p></div>
  </div>
  </body>
</html>
