<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Dealerships</title>
</head>
<body>
<h1>Dealership List:</h1>
<form method="post" action="dealershipnavigationServlet">
<table>
<c:forEach items="${requestScope.allDealers}" var="currentDealer">
<tr>
	<td><input type="radio" name="id" value="${currentDealer.id}"></td>
	<td><h2>${currentDealer.dealershipName}</h2></td></tr>
	<c:forEach var="carVal" items="${currentDealer.cars}">
		<tr><td></td><td colspan="3">
			${carVal.year} ${carVal.make} ${carVal.model}
			</td>
		</tr>
	</c:forEach>
</c:forEach>	
</table>
<h3>Please select an option:</h3>
<input type="submit" value="Add Dealership" name="doThisToDealers">
<input type="submit" value="Edit Dealership" name="doThisToDealers">
<input type="submit" value="Delete Dealership" name="doThisToDealers">
</form>
<br><a href="viewAllCarsServlet">View all Cars</a>
</body>
</html>