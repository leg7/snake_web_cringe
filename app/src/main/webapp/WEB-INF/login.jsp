<!DOCTYPE html>
<html>
<jsp:include page="modules/head.jsp">
	<jsp:param name="title" value="Login"/>
</jsp:include>
<body>
	<jsp:include page="modules/navbar.jsp"/>
	<jsp:include page="modules/error.jsp"/>

	<h2>Login</h2>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="nick" minlength="1" maxlength="30" required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" minlength="8" maxlength="128" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
