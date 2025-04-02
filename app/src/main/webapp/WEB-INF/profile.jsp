<!DOCTYPE html>
<html>
<jsp:include page="modules/head.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>
<body>
 <jsp:include page="modules/navbar.jsp"/>
	<jsp:include page="modules/error.jsp"/>

	<h2>This is your profile</h2>

	<c:choose>
		<c:when test="{empty sessionScope.user}">
			<p>Please login to view your profile</p>
		</c:when>

		<c:otherwise>
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
		</c:otherwise>
	</c:choose>


	<table border="1">
		<thead>
			<tr>
				<th>Oponent id</th>
				<th>Match Result</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="md" items="${matchDisplayers}">
			<tr class="${md.won ? 'match-won' : 'match-lost'}">
				<td>${md.opponent_id}</td>
				<td>
					<c:choose>
					<c:when test="${md.won}">
					Won
					</c:when>
					<c:otherwise>
					Lost
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
