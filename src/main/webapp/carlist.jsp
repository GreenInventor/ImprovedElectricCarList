<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electric Car List</title>
</head>
<body>
	<h1>Electric Car List:</h1>
	<form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allCars}" var="currentcar">
		<tr>
			<td><input type="radio" name="id" value="${currentcar.id}"></td>
			<td>${currentcar.year}</td>
			<td>${currentcar.make}</td>
			<td>${currentcar.model}</td>
			<td>|  Range: ${currentcar.maxmiles} miles</td>
			<td>|  Top Speed: ${currentcar.topspeed} MPH</td>
			<td>|  0-60 Acceleration: ${currentcar.zerosixtyacceleration} seconds</td>
			<td>|  Charge Speed: ${currentcar.chargepower}W</td>
			<td>|  Price: ${currentcar.price}$</td>
		</tr>
		</c:forEach>
	</table>
	<h3>Please select an option:</h3>
	<input type="submit" value="Add Car" name="doThisToCar">
	<input type="submit" value="Edit Car" name="doThisToCar">
	<input type="submit" value="Delete Car" name="doThisToCar">
	</form>
	<br><a href="viewAllDealersServlet">View all Dealerships</a>
</body>
</html>