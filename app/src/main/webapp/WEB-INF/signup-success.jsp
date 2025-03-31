<!DOCTYPE html>
<html>
<head>
    <title>Signup Success</title>
</head>
<body>
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

    <p>
        <a href="index">Go to the Home Page</a>
    </p>
</body>
</html>
