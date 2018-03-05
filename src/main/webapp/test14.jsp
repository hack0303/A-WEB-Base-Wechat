<%@page import="cn.net.www.unit.ReturnNumber"%>
<%@page import="java.util.Date"%>
<%@page import="cn.net.www.unit.DateUnit"%>
<%out.println(DateUnit.getDay("1991-03-03"));
out.println(DateUnit.getDay("1991-03-03-"));
out.println(DateUnit.getDay(new Date()));%>

<%out.println(DateUnit.getDateString("1991-03-03"));
out.println(DateUnit.getDateString("1991-03-03-"));
out.println(DateUnit.getDateString(new Date()));%>
<%out.println(ReturnNumber.formatNumber(1234,2));
out.println(ReturnNumber.formatNumber(1234,5));
out.println(ReturnNumber.formatNumber(1234,4));%>
<%
out.println(ReturnNumber.returnMembernumber(new Date(),new Date(),77, 3,"女"));%>