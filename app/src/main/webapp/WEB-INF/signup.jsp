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
                <td><input type="text" name="username" required /></td>
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
    <p>Hello, ${password}!</p>
    </c:if>

    <!-- Optionally, display an error message if present -->
    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
            <p style="color:red;">Invalid username or password</p>
    <%
        }
    %>
</body>
</html>
