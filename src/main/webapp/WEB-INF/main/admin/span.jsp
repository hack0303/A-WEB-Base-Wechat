<%@ page language="java" import="java.util.*,cn.net.www.bean.PageBean,cn.net.www.bean.XuntaUserForm" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%PageBean pb=(PageBean)session.getAttribute("pb");
 if(pb==null){
 %>
 <script>
 alert('请重新登录');
 </script>
 <%}%>
<ul><li><a href="javascript:first(${sessionScope.pb.pagenow},'${sessionScope.pb.type}','${sessionScope.pb.func}','${sessionScope.pb.state}')">首页</a></li>
<li><a href="javascript:prev(${sessionScope.pb.pagenow},'${sessionScope.pb.type}','${sessionScope.pb.func}','${sessionScope.pb.state}')">上一页</a></li>
<li>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="query">
<input type="hidden" name="type" value="${sessionScope.pb.type}">
<input type="hidden" name="func" value="${sessionScope.pb.func}">
<input type="hidden" name="state" value="${sessionScope.pb.state}">
<input type="hidden" name="pagespan" value="go">
<select name="pagenumber">
<%for(int i=1;i<=pb.getPagination();i++){%>
<option value="<%=i%>" <%=(pb.getPagenow()==i)?"selected":""%>>第<%=i%>页</option>
<%}%>
</select>
</form>
</li>
<li><a href="javascript:next(${sessionScope.pb.pagenow},${sessionScope.pb.pagination},'${sessionScope.pb.type}','${sessionScope.pb.func}','${sessionScope.pb.state}')">下一页</a></li>
<li><a href="javascript:last(${sessionScope.pb.pagenow},${sessionScope.pb.pagination},'${sessionScope.pb.type}','${sessionScope.pb.func}','${sessionScope.pb.state}')">末页</a></li></ul>