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
	 
	<form action="UserRegistrationCtl" method = post>
					
					
	
		<table>
			<tr>
				<th>First_Name :</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>Last_Name :</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>Login_Id :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>DOb :</th>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value = "save"></td>
			</tr>
				
		</table>
	</form>
</body>
</html>