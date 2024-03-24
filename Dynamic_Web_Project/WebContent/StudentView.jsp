<%@page import="in.co.rays.Bean.StudentFormBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.form {
	color: navy;
	font-family: 'Poppins', sans-serif;
	text-transform: capitalize;
	text-decoration: none;
	
	
}
</style>
</head>
<body>
		<% StudentFormBean bean = (StudentFormBean) request.getAttribute("bean");
		   String msg = (String) request.getAttribute("msg"); %>
		   
	<form>
	
		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>
		<div class="form">
			<table>
				<tr>
					<th>FirstName:</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th>LastName:</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th>LoginId:</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th>CourseName:</th>
					<td><input type="text" name="courseName"></td>
				</tr>
				<tr>
					<th>Enrollment:</th>
					<td><input type="text" name="enrollment"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>Semester:</th>
					<td><input type="text" name="semester"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="submit"></td>
				</tr>


			</table>

		</div>


	</form>
</body>
</html>