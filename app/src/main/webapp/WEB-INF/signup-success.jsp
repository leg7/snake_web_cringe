<!DOCTYPE html>
<html>
<jsp:include page="modules/head.jsp">
	<jsp:param name="title" value="Signup success"/>
</jsp:include>
<body>
	<jsp:include page="modules/navbar.jsp"/>
	<jsp:include page="modules/error.jsp"/>

	<h2>Signup Successful!</h2>
	<p>Congratulations, your account has been created.</p>

	<c:if test="${!empty sessionScope.user}">
		<p>Your account details:</p>
		<table>
			<tr>
				<td>Username:</td>
				<td><c:out value="${sessionScope.user.nick}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><c:out value="${sessionScope.user.email}" /></td>
			</tr>
		</table>
	</c:if>
</body>
</html>
