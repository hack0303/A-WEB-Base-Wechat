<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<form action="MyServlet" method="post">
<input type="hidden" name="action" value="changeShowState">
<input type="hidden" name="type" value="begin">
<c:choose>
<c:when test="${requestScope.statelist eq null}">
<p>嘉宾正在准备中...</p>
</c:when>
<c:otherwise>
<select name="state" id="title_select">
<c:forEach items="${requestScope.statelist}" var="object">
<option value="${object}">第${object}期</option>
</c:forEach>
</select>
</c:otherwise>
</c:choose>
</form>
