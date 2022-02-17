<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Electric Car:</h1>
	<form action="editCarServlet" method="post">
	<p>Make: <input type="text" name="make" value="${carToEdit.make}"></p>
	<p>Model: <input type="text" name="model" value="${carToEdit.model}"></p>
	<p>Year: <input type="number" name="year" value="${carToEdit.year}"></p>
	<p>Range: <input type="number" name="range" value="${carToEdit.maxmiles}"> miles</p>
	<p>Top Speed: <input type="number" name="topspeed" value="${carToEdit.topspeed}"> MPH</p>
	<p>0-60 Acceleration: <input type="number" name="zerosixty" value="${carToEdit.zerosixtyacceleration}"> seconds</p>
	<p>Charge Speed: <input type="number" name="chargepower" value="${carToEdit.chargepower}">W</p>
	<p>Price: <input type="number" name="price" value="${carToEdit.price}">$</p>
	<input type="hidden" name="id" value="${carToEdit.id}">
	<input type="submit" value="Save Changes">
	<input type="reset" value="Reset">
	</form><br>
	<a href = "viewAllCarsServlet">View all electric cars</a>
</body>
</html>