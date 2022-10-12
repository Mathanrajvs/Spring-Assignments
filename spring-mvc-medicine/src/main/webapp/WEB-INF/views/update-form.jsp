
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="update-medicine">
		<table>
			<tr>
				<th><label>Medicine name:</label></th>
				<td><input type="text" name="medicineName" value="${medicine.medicineName}" readonly/></td>
			</tr>
			<tr>
				<th><label>Medicine ID:</label></th>
				<td><input type="number" name="medicineId" value="${medicine.medicineId}" readonly/></td>
			</tr>
			<tr>
				<th><label>Category:</label></th>
				<td><input type="text" name="category"value="${medicine.category}" readonly/></td>
			</tr>
			<tr>
				<th><label>Brand:</label></th>
				<td><input type="text" name="brand"value="${medicine.brand}" readonly/></td>
			</tr>
			<tr>
				<th><label>Cost:</label></th>
				<td><input type="number" name="cost" value="${medicine.cost}"/></td>
			</tr>
			<tr>
				<th><label>Medicine Availability:</label></th>
				<td>
				<input type="radio"  name="availability" value="${medicine.availability}" readonly/>
				</select>
				</td>
				
			</tr>

			<tr>
				<td><input type="submit" value="Update medicine"></td>
			</tr>
		</table>
	</form>
</body>
</html>