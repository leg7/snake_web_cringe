<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        /* CSS styles for the top bar */
        .top-bar {
            background-color: #333;
            color: #fff;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .top-bar a {
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
        }
        .top-bar a:hover {
            color: #ccc;
        }
    </style>
</head>
<body>
    <div class="top-bar">
        <h1>Welcome to our website!</h1>
        <div>
						<c:if test="${empty sessionScope.user}">
							<a href="login">Login</a>
							<a href="signup">Sign Up</a>
						</c:if>

						<c:if test="${!empty sessionScope.user}">
							<a href="logout">Logout</a>
						</c:if>
        </div>
    </div>
    <div style="padding: 20px;">
        <h2>This is the home page</h2>
        <p>You can add your content here.</p>
    </div>

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
