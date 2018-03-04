<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝贝资料</title>
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
  <link rel="stylesheet" href="css/userinformation/register/qinzi/three.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/register/qinzi/three.js"></script></head>
  
  <body>
   <div id="nav">
  <div id="title">
  <h1>
  <p>宝贝资料</p>
  <p>Babe Information</p>
  </h1>
  <h1>
  <marquee>
  <p>如需要升级为家庭卡需补充配偶信息
  if you want to upgrade family card
  to double card please fill in the
  form of your babe's information</p>
  </marquee>
  </h1>
  </div>
   <form action="MyServlet" method="post">
 <input type="hidden" name="action" value="register">
 <input type="hidden" name="type" value="qinzi">
 <input type="hidden" name="step" value="three">
 <div id="id1">  
<p><font color="red">*</font>姓名Name</p><p><input name="name" type="text" maxlength="10"></p>
</div>
<div class="p1"><p></p></div>
<div id="id1">  
<p><font color="red">*</font>昵称Nickname</p>
<p>
<input type="text" name="nickname"></p>
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
<p><font color="red">*</font>生日Birthday</p><p> <input name="birthday" type="hidden" value="">
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
<p><font color="red">*</font>
就读学校School</p><p><input name="school" type="text"></p>
</div>

<div class="p1"><p></p></div>
<div id="id1">  
<p><font color="red">*</font>
年级Grade</p><p>
<select name="grade"><option value="1" selected>一年级</option>
<option value="2">二年级</option>
<option value="3">三年级</option>
<option value="4">四年级</option>
<option value="5">五年级</option>
<option value="6">六年级</option>
<option value="7">初中一年级</option>
<option value="8">初中二年级</option>
<option value="9">初中三年级</option>
<option value="10">高中一年级</option>
<option value="11">高中二年级</option>
<option value="12">高中三年级</option>
</select></p>
</div>

<div class="p1"><p></p></div>
 <div id="id1">
 <p>
<font color="red">*</font>是否独生子女 </p>
<p>
 <input name="onlychild" type="radio" value="是" checked>是 </p>
<p> <input name="onlychild" type="radio" value="否"><select><option value="否,还有个姐姐">否,还有姐姐</option>
 <option value="否,还有个哥哥">否,还有哥哥</option>
 <option value="否,还有个妹妹">否,还有妹妹</option>
 <option value="否,还有个弟弟">否,还有弟弟</option></select>
 </p>
</div>
 <div class="p1"><p></p><p>请选择对应信息</p></div>
 <div id="id1">  
<p><font color="red">*</font>
兴趣爱好Hobby</p><p><input name="hobby" type="text"></p>
</div>
<div class="p1"><p></p></div>

 <div id="id1">  
 <p>
<font color="red">*</font> 
特长Speciality</p><p><input type="text" name="speciality"></p>
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
