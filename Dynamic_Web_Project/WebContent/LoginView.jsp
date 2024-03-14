<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
</style>

</head>
<body>
	<%
		String Str = (String) request.getAttribute("msg");
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


		<table>
			<tr>
				<th>loginId :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>password :</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>

		</table>
	</form>
	
</body>
</html>