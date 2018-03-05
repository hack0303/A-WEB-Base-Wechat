<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test9.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<p>2016-09-03</p>
<p>
<%String str="2016-09-03";
String[] array=str.split("x");
String test=str.substring(0,10);
 %>
 当对象里没有对应分隔符,索引0处的值:
<%=array[0]%><br>
测试对象2016-按"-"分割,产生数组情况:
<%String test2="2016-";
String test3="2016- ";
int x=0;
for(String i:test2.split("-")){
x++;
out.println("其中第"+x+"数组为:"+i);
}
%>

测试对象2016-空格按-分割,产生数组情况:
<%
 x=0;
for(String i:test3.split("-")){
x++;
out.println("其中第"+x+"数组为:"+i);
}
%>
<br>
 当子字符串长度和父亲一样输出为:
 <%=test%>
</p>  
</body>
</html>
