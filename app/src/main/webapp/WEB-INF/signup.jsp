<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
</head>
<body>
    <h2>Signup</h2>
    <form action="signup" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="nick" minlength="1" maxlength="30" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" minlength="5" maxlength="128" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" minlength="8" maxlength="128" required /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Signup" /></td>
            </tr>
        </table>
    </form>

    <c:if test="${!empty error}">
    <p><c:out value="${error}"/></p>
    </c:if>

    <c:forEach items="${userList}" var="user" varStatus="status">
    	<p>
	<c:out value="User number ${user.id}:"/>
	<br>
	<c:out value="nickname = ${user.nick}"/>
	<br>
	<c:out value="email = ${user.email}"/>
	<br>
	<c:out value="password = ${user.password}"/>
	<br>
	</p>
    </c:forEach>
</body>
</html>
