<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    a{
    	text-align = bottom
    }
</style>
		
</head>
<body>
 <form action="LoginCtl" method="post">
	<table>
	<tr>
			<th>loginId :</th>
			<td><input type = "text" name="loginId"></td>
	</tr>
	<tr>
			<th>password :</th>
			<td><input type ="text"name="password"></td>
	</tr>
	<tr>
			<th></th>
			<td><input type ="submit"></td>
	</tr>
		
			<a href="UserRegistration.jsp">New User Registration</a>
				
			
	</table>
	</form>
</body>
</html>