<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html style="height:100%;">
  <head>
    <base href="<%=basePath%>">
    
    <title>申办人资料</title>
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
<link rel="stylesheet" href="css/userinformation/register/xunta/one.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/register/xunta/one.js"></script>
 <%
 String type=String.valueOf(request.getAttribute("type"));
  %>
  </head>
  
  <body>
  <h1>
  <p>申办人资料 
  <p>Application Information</h1> 
  <form action="RegisterServlet?action=register&type=xunta&step=one" method="post" enctype="multipart/form-data" name="form1">
  <input type="hidden" name="type" value="<%=type%>">  
<div id="id1">  
<p><font color="red">*</font>姓名 Name</p><p><input name="name" type="text" maxlength="10"></p>
</div>
<div class="p1"><p>请填写真实姓名,长度不超过10个字符</p></div>
<div id="id1">
<p>
<font color="red">*</font>性别 Gender</p>
<p><input name="gender" type="radio" value="男" checked>男Male</p>
<p><input name="gender" type="radio" value="女">女Female</p>
</div>
<div class="p1"><p>请填入性别</p></div> 
<div id="id1">
<p>
<font color="red">*</font>籍贯 NativePlace </p><p><input name="nativeplace" type="text">
</p>
</div>
<div class="p1"><p>请正确填入籍贯,中间不允许有标点符号</p></div>
<div id="id1">
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
</p>
</div>
<div class="p1"><p>生日格式:2010-01-01</p></div>
<div id="id1">
<p>
<font color="red">*</font>证件类型 ID Type</p>
<p>
 <select  name="id_type" data-native-menu="false">
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
 <div class="p1"><p>请选择对应的证件类型</p></div>
<div id="id1">
<p>
<font color="red">*</font>证件编号 ID Number </p>
<p>
<input name="id_number" type="text">
</p>
</div> 
 <div class="p1"><p>请填入证件编号</p></div>
<div id="id1">
<p>
<font color="red">*</font>工作单位 WorkOrganization</p><p> <input name="work_organization" type="text"></p>
 </div>
 <div class="p1"><p>请填入工作单位名称</p></div>
<div id="id1">
<p>
<font color="red">*</font>职业 Occupation </p><p><input name="occupation" type="text"></p>
 </div>
 <div class="p1"><p>请填入职业</p></div>
<div id="id1"><p>
<font color="red">*</font>学历 Education</p><p> <select name="education">
<option value="高中中专以及以下">高中中专以及以下</option>
<option value="大专">大专</option>
<option value="本科">本科</option>
<option value="双学士">双学士</option>
<option value="硕士">硕士</option>
<option value="博士">博士</option>
<option value="博士后">博士后</option>
</select>
</p>
</div>
<div class="p1">请选择学历</div>
<div id="id1">
<p><font color="red">*</font>昵称 Nickname</p><p><input type="text" name="nickname" maxlength="10"></p>
</div>
<div class="p1"><p>请输入昵称</p></div>
<div id="id1">
<p>
<font color="red">*</font>身高Height</p><p> <input type="text" name="height">CM</p>
</div>
 <div class="p1"><p>请填写身高</p></div>
<div id="id1">
<p>
<font color="red">*</font>体重Weight </p><p><input type="text" name="weight">KG</p>
 </div>
 <div class="p1"><p>请填写体重</p></div>
<div id="id1">
<p>
<font color="red">*</font>月收入Salary </p><p><select name="salary"><%for(int i=1;i<=5;i++){
String outstr="";
switch(i){
case 1:{
outstr="3000以下";
break;
}
case 2:{
outstr="3000~5000";
break;
}
case 3:{
outstr="5000~8000";
break;
}
case 4:{
outstr="8000~10000";
break;
}
case 5:{
outstr="10000以上";
break;
}}
%>
<option value="<%=outstr%>"><%
out.print(outstr);
%></option><%}%></select>RMB</p>
</div>
 <div class="p1"><p>请填写月收入</p></div>
 <div id="id1">
 <p>
<font color="red">*</font>是否独生子女 </p>
<p>
 <input name="onlychild" type="radio" value="是" checked>是</p>
<p> <input name="onlychild" type="radio" value="否"><select><option value="否,还有个姐姐">否,还有姐姐</option>
 <option value="否,还有个哥哥">否,还有哥哥</option>
 <option value="否,还有个妹妹">否,还有妹妹</option>
 <option value="否,还有个弟弟">否,还有弟弟</option></select>
 </p>
</div>
 <div class="p1"><p>请选择对应信息</p></div>
 <div id="id1">
 <p>
 <font color="red">*</font>婚姻状况Marriage </p>
 <p>
 <select name="marriage"><option>未婚</option>
 <option>离异</option>
 <option>丧偶</option>
 </select>
 </p>
 </div>
 <div class="p1"><p>请选择实际婚姻状况</p></div>
 <div id="id1">
 <p>
<font color="red">*</font>是否有小孩 Have Baby Or Not</p><p> <select name="havebaby"><option value="有">有</option><option value="无">无</option></select></p>
</div>
<div class="p1"><p>请填写自己情况</p></div>
<div id="id1">
<p>
<font color="red">*</font>手机 Phone </p><p><input type="text" name="phone"></p>
</div>
<div class="p1"><p>请填写手机号</p></div>
<div id="id1">
<p>
<font color="red">*</font>邮箱 Email </p><p><input type="text" name="email"></p>
</div>
<div class="p1"><p>请填写可以用的Email地址</p></div>
<div id="id1">
<p>
<font color="red">*</font>通讯地址Address</p><p> <input type="text" name="address"></p>
</div>
<div class="p1"><p>请填写真实的可用的通讯地址</p></div>
<div id="id1">
<p>
<font color="red">*</font>邮编 Postcode </p><p><input type="text" name="postcode"></p>
</div>
<div class="p1"><p>请填写邮编号码</p></div>
<div id="id1">
<p>
上传图片1~3张</p>
<p>
<div class="p2">
<input type="file" name="file" hidden="true" id="file1"><label for="file1"><img src="image/system/file.png"></img></label><div class="image_show"><p></p></div><input type="button" value="删除" name="delete">
</div>
<div class="p2">
<input type="file" name="file" hidden="true" id="file2"><label for="file2"><img src="image/system/file.png"></img></label><div class="image_show"><p></p></div><input type="button" value="删除" name="delete">
</div>
<div class="p2">
<input type="file" name="file" hidden="true" id="file3"><label for="file3"><img src="image/system/file.png"></img></label><div class="image_show"><p></p></div><input type="button" value="删除" name="delete">
</div>
</p>
</div>
<div class="p1">
<p>请上传图片,上传图片大小不得超过2M,格式结尾为.png,.jpeg,.bmp,.gif,.rgb,.jpg其中第一张图,为主图片,审核通过后不可以再更改</p>
</div>
</form>
 <div id="footer">
 <div id="submit">下 一 步</div>
 <div id="reset">重 置</div>
 </div>
 <div id="prop">
 <div id="nav">
 <p><img></p>
 <p>
 请求处理中...
 </p>
 </div>
 </div>
  </body>
</html>
