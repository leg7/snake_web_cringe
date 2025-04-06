<!DOCTYPE html>
<html>
<jsp:include page="modules/head.jsp">
	<jsp:param name="title" value="Signup"/>
</jsp:include>
<body>
	<jsp:include page="modules/navbar.jsp"/>
	<jsp:include page="modules/error.jsp"/>

	<form action="stalk" method="get">
		<label for="id">Id to stalk:</label>
		<input type="number" min="0" max="10" id="id" name="id"/>
    <button type="submit">Submit</button>
	</form>

	<c:if test="${!empty stalked}">
	<table
		<p>User of id ${stalked.id} details</p>
		<table>
			<tr>
				<td>Username:</td>
				<td><c:out value="${stalked.nick}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><c:out value="${stalked.email}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><c:out value="${stalked.password}" /></td>
			</tr>
		</table>
		</c:if>
</body>
</html>
