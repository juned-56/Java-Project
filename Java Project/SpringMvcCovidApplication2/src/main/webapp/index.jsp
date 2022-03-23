<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Covid Data</h2>
<table border="1">
		<th>Location</th>
		<th>New_cases</th>
		<c:forEach var="co" items="${covidCases}">
			<tr>
				<td>${co.location}</td>
				<td>${co.new_cases}</td>
				</tr>
		</c:forEach>
	</table>
				
</body>
</html>
