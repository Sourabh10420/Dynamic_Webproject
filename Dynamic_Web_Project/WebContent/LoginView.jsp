<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.form:hover {
	color: blue;
	padding-left: 2px;
}
</style>

</head>
<body>
	<%
		String Str = (String) request.getAttribute("msg");
		String uri = (String) request.getAttribute("uri");
		String login = (String) request.getAttribute("login");
		String pass = (String) request.getAttribute("pass");
	%>


	<%@include file="Header.jsp"%>

	<form action="LoginCtl" method="post">

		<%
			if (Str != null) {
		%>
		<h3>
			<font color="red"><%=Str%></font>
		</h3>

		<%
			}
		%>

		<div class="form">
			<table>
				<tr>
					<th>Login ID :</th>
					<td><input type="text" name="loginId"></td>
					<td> <% if(login != null){ %>
					
						<h4><font color="red"><%=login%></font></h4>
						<%} %>
						</td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="password"></td>
					<td> <% if(pass != null){ %>
					
						<h4><font color="red"><%=pass%></font></h4>
						<%} %>
						</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIn">
						<input type="submit" name="operation" value="signUp"> <input
						type="submit" name="operation" value="forgottPassword"></td>
				</tr>
			</table>
			<input type="hidden" name="uri" value="<%=uri%>">
	</form>

</body>
</html>