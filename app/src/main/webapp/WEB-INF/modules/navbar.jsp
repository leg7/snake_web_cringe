<div class="navbar">
	<h1><a href="index">shnake.io</a></h1>
	<div>
		<c:choose>
		<c:when test="${empty sessionScope.user}">
		<a href="login">Login</a>
		<a href="signup">Sign Up</a>
		</c:when>
		<c:otherwise>
		<a href="profile">Profile</a>
		<a href="logout">Logout</a>
		</c:otherwise>
		</c:choose>
	</div>
</div>
