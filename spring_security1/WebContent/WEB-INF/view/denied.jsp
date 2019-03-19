<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body><h1 id="banner">Unauthorized access</h1>
<hr><c:if test="${not empty error }">
<div style="color:red">
your fake login attempt was bursted,dare again!!!<br>
Caused:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
</c:if>
<p class="message">Access denied</p>
<a href="${pageContext.request.contextPath}/login">go back to login page</a>
</body></html>