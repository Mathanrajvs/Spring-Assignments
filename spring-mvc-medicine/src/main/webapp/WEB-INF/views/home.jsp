<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:right">
<a href="admin-view">Admin</a><br>
</div>
<h2>All Medicines</h2>
${medicines}
<hr>
<form action="search-medicine-for-diseases">
<select name="choice">
<option value="Covid Essentials">Covid Essentials</option>
<option value="Skin Care">Skin Care</option>
<option value="Ayurvedic Care">Ayurvedic Care</option>
<option value="Diabetic Care">Diabetic Care</option>
<option value="Pain Reief">Pain Reief</option>
<option value="Cold and Cough">Cold and Cough</option>
<option value="Cancer">Cancer</option>
<option value="Food Poisoning">Food Poisioning</option>
</select>
<input type="submit" value="Search Medicine">
</form>
</body>
</html>