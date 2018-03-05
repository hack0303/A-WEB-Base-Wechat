<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table>
<tr>
<td><p <c:if test="${requestScope.procedure eq 1}"> class="red"</c:if>></p></td>
<td><p <c:if test="${requestScope.procedure eq 2}"> class="red"</c:if>></p></td>
<td><p <c:if test="${requestScope.procedure eq 3}"> class="red"</c:if>></p></td>
<td><p <c:if test="${requestScope.procedure eq 4}"> class="red"</c:if>></p></td>
</tr>
<tr>
<td><p><a href="MyServlet?action=woYue_span&procedure=1">待邀约</a></p></td>
<td><p><a href="MyServlet?action=woYue_span&procedure=2">待牵线</a></p></td>
<td><p><a href="MyServlet?action=woYue_span&procedure=3">待约会</a></p></td>
<td><p><a href="MyServlet?action=woYue_span&procedure=4">已约会</a></p></td>
</tr>
</table>

