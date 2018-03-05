<%@page import="java.text.DateFormat"%>
<%@page import="java.text.MessageFormat"%>
<%@ page language="java" import="java.util.*,cn.net.www.bean.UserInformation,cn.net.www.dao.QueryDao,cn.net.www.dao.UpdateDao" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test10.jsp' starting page</title>
    
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
  <%
  String pattern="MyServlet?action={0}&procedure={1}";
  String outstr="";
  String object[]={"我不是","我是"};
  outstr=MessageFormat.format(pattern,"我不是","我是");
   %>
   <%
   out.print(outstr);
    %>
    
    <%
    UserInformation ui=new QueryDao().queryUIF_twoByPhone("18806298611","18806298620");
    boolean flag=new UpdateDao().updateDate_flag(202,"18806298611","18806298620");
    out.print(flag);
    out.print(ui.getMain_url());
    out.print(ui.getDate_number());
     %>
     <%String date_time=DateFormat.getDateInstance().format(new Date());
     out.print(date_time);
      %>
      <%
      out.print(new QueryDao().queryMaxId());
       %>
  </body>
</html>
