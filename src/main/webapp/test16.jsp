<%@page import="java.security.MessageDigest"%>
<%@page import="cn.net.www.dao.UpdateDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.File"%>
<%@page import="cn.net.www.unit.PropertiesUnit"%>
<%@page import="cn.net.www.dao.QueryDao"%>
<%@page import="cn.net.www.bean.UserImage"%>
<%@page import="cn.net.www.unit.ReturnNumber"%>
<%@page import="java.util.*"%>
<%@page import="cn.net.www.unit.DateUnit"%>
<%
MessageDigest md=MessageDigest.getInstance("MD5");
%>