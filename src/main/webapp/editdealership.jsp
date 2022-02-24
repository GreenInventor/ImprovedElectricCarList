<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dealership</title>
</head>
<body>
<form action="editDealershipServlet" method="post">
<input type="hidden" name="id" value="${dealerToEdit.id}">
Dealership Name: <input type="text" name="dealershipName" value="${dealerToEdit.dealershipName}"><br>
Available Cars:<br>
<select name="carsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentCar">
	<option value="${currentCar.id}">${currentCar.year} | ${currentCar.make} 
| ${currentCar.model}</option>
</c:forEach>
</select>
<br>
<input type="reset" value="Reset">
<input type="submit" value="Edit Dealership and Add Cars">
</form>
<br><a href="viewAllDealersServlet">View all Dealerships</a>
</body>
</html>