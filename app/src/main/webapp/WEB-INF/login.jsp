<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <!-- Form that posts to the LoginServlet -->
    <form action="login" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required /></td>
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
