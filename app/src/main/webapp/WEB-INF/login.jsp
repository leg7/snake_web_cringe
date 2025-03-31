<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
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

    <c:if test="${!empty error}">
    <p><c:out value="${error}"/></p>
    </c:if>
</body>
</html>
