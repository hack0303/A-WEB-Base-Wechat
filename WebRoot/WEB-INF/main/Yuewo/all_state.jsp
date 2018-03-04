<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table>
<tr>
<td><p <c:if test="${requestScope.procedure eq 0}"> class="red"</c:if>><a href="DateServlet?action=date&type=yuewo&procedure=0">全部</a></p></td>
<td><p <c:if test="${requestScope.procedure eq 1}"> class="red"</c:if>><a href="DateServlet?action=date&type=yuewo&procedure=1">待牵线</a></p></td>
<td><p <c:if test="${requestScope.procedure eq 2}"> class="red"</c:if>><a href="DateServlet?action=date&type=yuewo&procedure=2">待约会</a></p></td>
<td><p <c:if test="${requestScope.procedure eq 3}"> class="red"</c:if>><a href="DateServlet?action=date&type=yuewo&procedure=3">已约会</a></p></td>
</tr>
</table>

