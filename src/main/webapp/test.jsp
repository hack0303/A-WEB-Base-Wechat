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
<title>Insert title here</title>
</head>
<body>
<% 
Connection conn=null;
try {
	conn = new ConnDao().getConn();
} catch (NamingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	if(conn!=null) System.out.println("获取连接成功");
	else System.out.println("获取连接失败");
%>
<%=request.getServletPath()%><br>
<%=request.getContextPath()%><br>
<%=request.getRealPath("css")%><br>
<%=request.getRealPath("")%><br>
<%=request.getRealPath("/")%><br>
<%=request.getRealPath("css/")%><br>
<%=request.getRealPath("/css/")%><br>
<%=request.getRealPath("/css/c")%><br>
<%out.println(new QueryDao().queryPhoneById(1));%>
</body>
</html>