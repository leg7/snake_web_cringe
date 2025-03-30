<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Signup Page</title>
</head>
<body>
    <h2>Login</h2>
    <!-- Form that posts to the LoginServlet -->
    <form action="signup" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="nick" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Login" /></td>
            </tr>
        </table>
    </form>

    <c:if test="${true}">
    <p>Hello there, ${nick}, your password is ${password}!</p>
    </c:if>

    <c:if test="${errorCreateTable}">
    <h1>ERROR</h1>
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
