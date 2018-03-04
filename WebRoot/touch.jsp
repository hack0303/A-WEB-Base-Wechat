<%@ page language="java" import="java.sql.*,javax.naming.*,cn.net.www.dao.ConnDao,cn.net.www.dao.QueryDao"contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="javascript/phonetouch.js"></script></head>
<style type="text/css">
#x1,#x2,#x3,#x4,#x5{
height:100px;
border:red 2px solid;
}
</style>
<body>
<div id="x1">datap</div>
<div id="x2">taphold</div>
<div id="x3">swipe</div>
<div id="x4">
<div id="x40">swipeleft</div>
</div>
<div id="x5">swiperight</div>
<select name="day" id="day" data-native-menu="true">
<option value="1">星期一</option>
<option value="1">星期一</option>
<option value="1">星期一</option>
<option value="1">星期一</option>
<option value="1">星期一</option>
<option value="1">星期一</option>
<option value="1">星期一</option>
</select>
</body>
</html>