<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 body {
	/* background-color: aqua; */
	background-image: url("https://c8.alamy.com/comp/GX1GWK/safety-concept-login-on-digital-background-GX1GWK.jpg");
	 
	}

.space{
display: flex;
	justify-content: center;
	
	position: relative;
    
}

.form {
	display: flex;
	justify-content: center;
	margin-top: 4cm;
	color: white;
	
}
/* .color{

background-color: red;


}  */
</style>
</head>
<body>
	<%
	String uri = (String) request.getAttribute("uri");
	
		String msg = (String) request.getAttribute("error");

		String login = (String) request.getAttribute("login");

		String pass = (String) request.getAttribute("pass");
		
		
	%>
	<%@include file ="StudentHeader.jsp" %>
	<form action="StudentLoginCtl" method="post">
	
   
    	<div class="space">
     		
		<%
			if (msg != null) {
		%>

		<h3>
			<font color="red"><%=msg%></font>
		</h3>

		<%
			}
		%>
		</div>
		  <div Class =form>
		<table>
			<tr>
				<th>LoginId:</th>
				<td><input type="text" name="loginId"></td>
				<td>
					<%
						if (login != null) {
					%>
					<h5>
						<font color="#f76262"><%=login%></font>
					</h5> <%
 						}
 						  %>
				</td>

			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="password"></td>

				<td>
					<%
						if (pass != null) {
					%>
					<h5>
						<font color="#f76262"><%=pass%></font>
					</h5> <%
 						}
   						  %>
				</td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="singIn">
					<input type="submit" name="operation" value="singUp"> <input
					type="submit" name="operation" value="forgotPassword"></td>

			</tr>
		</table>

		<input type="hidden" name="uri" value="<%=uri%>">
		</div>
	</form>
</body>
</html>