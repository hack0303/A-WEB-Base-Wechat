<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>配偶资料</title>
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
  <link rel="stylesheet" href="css/userinformation/register/qinzi/two.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
   <script type="text/javascript" src="javascript/userinformation/register/qinzi/two.js"></script></head>
  </head>
  
  <body>
  <div id="nav">
  <div id="title">
  <h1>
  <p>配偶资料</p>
  <p>Spouse Information</p>
  </h1>
  <h1>
  <marquee>
  <p>如需要升级为家庭卡需补充配偶信息
  if you want to upgrade family card 
  to double card please fill in the
  form of your spouse's information</p>
  </marquee>
  </h1>
  </div>
 <form action="MyServlet" method="post">
 <input type="hidden" name="action" value="register">
 <input type="hidden" name="type" value="qinzi">
<input type="hidden" name="step" value="two">
<div id="id1">  
<p><font color="red">*</font>姓名 Name</p><p><input name="name" type="text" maxlength="10"></p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>性别 Gender</p>
<p><input name="gender" type="radio" value="男" checked>男Male</p>
<p><input name="gender" type="radio" value="女">女Female</p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<input type="hidden" value="" name="birthday"/>
<p><font color="red">*</font>生日 Birthday</p><p> <input name="birthday" type="hidden" value="">
<select>
<%Calendar ca=Calendar.getInstance();
ca.setTime(new Date());
int year=ca.get(Calendar.YEAR);
for(int i=0;i<=100;i++){
%>
<option value="<%=year-i%>"><%=year-i%></option><%}%></select>
-<select><%for(int i=1;i<=12;i++){
%><option value="<%=((i<10)?("0"+i):i)%>"><%=((i<10)?("0"+i):i)%></option><%}%></select>
-<select><%for(int i=1;i<=31;i++){
%><option value="<%=((i<10)?("0"+i):i)%>"><%=((i<10)?("0"+i):i)%></option><%}%></select>
</p></div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>证件类型 ID Type</p>
<p>
 <select  name="id_type">
 <option>身份证</option>
 <option>居住证</option>
 <option>签证</option>
 <option>护照</option>
 <option>户口本</option>
 <option>军人证</option>
 <option>团员证</option>
 <option>党员证</option>
 <option>港澳通行证</option>
 </select>
</p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
证件编号ID Number
</p>
<p>
<input type="text" name="id_number">
</p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>职业 Occupation </p><p><input name="occupation" type="text"></p>
 </div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>手机 Phone </p><p><input type="text" name="phone"></p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>邮箱 Email </p><p><input type="text" name="email"></p>
</div>
<div class="p1"><p></p></div>
<div id="id1">
<p>
<font color="red">*</font>通讯地址Address</p><p> <input type="text" name="address"></p>
</div>
<div class="p1"><p></p></div>
</form>
</div>
 <div id="footer">
<div id="submit">提交</div>
<div id="reset">重置</div>
 </div>
  </body>
</html>
