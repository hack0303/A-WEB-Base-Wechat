<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    
    <title>错误信息提示页</title>
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

  </head>
  
  <body>
  公告通知:如果您之前注册完成超过1个步骤以上,并未完全注册通过全部步骤,请通过下方输入注册手机号,系统会帮您继续回到之前后续的页面继续完成注册,给您带来不便请见谅.
  <br>
  手机号:<form><input type="text" name="phone"><input type="hidden" name="action" value="continue"></form>检索
  </body>
</html>
