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
<option value="covid">Covid Essentials</option>
<option value="skin-care">Skin Care</option>
<option value="ayurvedic-care">Ayurvedic Care</option>
<option value="diabetic-care">Diabetic Care</option>
<option value="pain-relief">Pain Reief</option>
<option value="cold-and-cough">Cold and Cough</option>
<option value="cancer">Cancer</option>
<option value="food-poisioning">Food Poisioning</option>
</select>
<input type="submit" value="Search Medicine">
</form>
</body>
</html>