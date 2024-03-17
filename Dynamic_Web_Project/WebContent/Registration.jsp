<%@page import="in.co.rays.Bean.UserRegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% String msg = (String) request.getAttribute("msg") ;
		UserRegistrationBean bean = (UserRegistrationBean) request.getAttribute("bean");		
		%>
		
	<form action="RegistrationCtl" method = post>

		<table>
			<tr>
			<th>FirstName :</th>
			<td><input type= "text" name = "fName"></td>
			</tr>
			<tr>
			<th>LastName :</th>
			<td><input type = "text" name = "lName"></td>
			</tr>
			<tr>
			<th>LoginId :</th>
			<td><input type = "text" name = "loginId"></td>
			</tr>
			<tr>
			<th>Password :</th>
			<td><input type = "text" name = "password"></td>
			</tr>
			<tr>
			<th>Address :</th>
			<td><input type = "text" name = "address"></td>
			</tr>
			<tr>
			<th>DOB :</th>
			<td><input type = "Date" name = "dob"></td>
			</tr>
			<tr>
			<th></th>
			<td><input type = "submit"></td>
			</tr>
			<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
		</table>


	</form>

</body>
</html>