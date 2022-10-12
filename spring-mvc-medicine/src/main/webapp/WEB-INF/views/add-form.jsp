<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="add-medicine">
		<table>
			<tr>
				<th><label>Medicine name:</label></th>
				<td><input type="text" name="medicineName"/></td>
			</tr>
			<tr>
				<th><label>Medicine ID:</label></th>
				<td><input type="number" name="medicineId" /></td>
			</tr>
			<tr>
				<th><label>Category:</label></th>
				<td><input type="text" name="category"/></td>
			</tr>
			<tr>
				<th><label>Brand:</label></th>
				<td><input type="text" name="brand"/></td>
			</tr>
			<tr>
				<th><label>Cost:</label></th>
				<td><input type="number" name="cost" /></td>
			</tr>
			<tr>
				<th><label>Medicine Availability:</label></th>
				<td><input type="radio" name="availability" value="1">
					<label>Yes</label> 
					<input type="radio" name="availability" value="0"> 
					<label>No</label> 
				</td>
				
			</tr>

			<tr>
				<td><input type="submit" value="Add medicine"></td>
			</tr>
		</table>
	</form>
</body>
</html>