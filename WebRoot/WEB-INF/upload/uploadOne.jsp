<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    
    <title>图片修改</title>
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

  <link rel="stylesheet" href="css/upload/uploadOne.css" type="text/css"></link></head>
  <div id="position">
  <form action="AdminServlet?action=upload&service=change" method="post" enctype="multipart/form-data" >
  <input type="hidden" name="phone" value="${phone}">
  <input type="hidden" name="image_url" value="${image_url}">
  <input type="file" name="file">
  <input type="submit" value="提交">
  </form>
  </div>
  <body>
  
  </body>
</html>
