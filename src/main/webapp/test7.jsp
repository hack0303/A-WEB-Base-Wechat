<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test7.jsp' starting page</title>
    
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
    <%String string="你好";
     %>
     <%=string.split(",")[0] %><br>
     <%Object ob="";
     request.setAttribute("ob",ob);%>
     <%if(ob.equals("")){%>
     为空字符串<br>
     <%}if(ob.toString().equals("null")){%>
  为null <br>
   <%}if(String.valueOf(ob).equals("null")){%>
  为null <br>
     <%}if(ob!=null){%>
   不为空对象<br>
     <%}%>
     <%String ob1=request.getAttribute("ob").toString(); %>
     <%if(ob1.equals("")){%>
     为空字符串<br>
     <%}if(ob1.toString().equals("null")){%>
  为null <br>
   <%}if(String.valueOf(ob1).equals("null")){%>
  为null <br>
     <%}if(ob1!=null){%>
   不为空对象<br>
     <%}%>
     <%String ob2=String.valueOf(request.getAttribute("ob")); %>
     <%if(ob2.equals("")){%>
     为空字符串<br>
     <%}if(ob2.toString().equals("null")){%>
  为null <br>
   <%}if(String.valueOf(ob2).equals("null")){%>
  为null <br>
     <%}if(ob2!=null){%>
   不为空对象<br>
     <%}%>
          <%String ob3=null; %>
     <%--if(ob3.equals("")){--%>
     为空字符串<br>
     <%--}if(ob3.toString().equals("null")){--%>
  <!--  为null <br>-->
   <%if(String.valueOf(ob3).equals("null")){%>
  为null <br>
     <%}if(ob3==null){%>
   为空对象<br>
     <%}%>
     
  </body>
</html>
