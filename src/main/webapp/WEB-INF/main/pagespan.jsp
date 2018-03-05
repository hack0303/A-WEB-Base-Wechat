<%@page import="cn.net.www.bean.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<ul>
<li>首 页
</li>
<li>上一页
</li>
<li>
<select>
<%
PageBean pb=(PageBean)session.getAttribute("pb");
int pagenow=pb.getPagenow();
for(int i=1;i<=pb.getPagination();i++){%>
<option value="<%=i%>" <%=pagenow==i?"selected":"" %>>第<%=i%>页
</option>
<%}%>
</select>
<input type="hidden" name="pagenow" value="<%=pb.getPagenow()%>">
<input type="hidden" name="pagination" value="<%=pb.getPagination()%>">
</li>
<li>下一页
</li>
<li>末 页
</li>
</ul>