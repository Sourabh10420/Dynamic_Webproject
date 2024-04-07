<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Payment Login</title>
<link rel="stylesheet" href="InstStyle.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet" />
</head>
<body>
	<%
	
	String uri = (String) request.getAttribute("uri");
		String msg = (String) request.getAttribute("msg");
		String login = (String) request.getAttribute("login");
		String pas = (String) request.getAttribute("pas");
		String bean =(String) request.getAttribute("user");
	%>

	<form action="PaymentLoginCtl" method="post">
	
		<div class="container">
			<div class="center">
				<div class="header">
					<h2>Login Page</h2>
					</div>
									<%
			if (msg != null) {
		%>
		<center><h4>
			<font color="red"><%=msg%></font>
		</h4></center>
		<%
			}
		%>
					
				<div class="inputElement">
				
					<input type="text" name="emailId" placeholder="Phone number,username or email" 
					class="inputText">
						
				
						<%
							if (login != null) {
						%>
						<h4>
							<font color="red"><%=login%></font>
						</h4>	
							 <%
 	   							}
 								%>
 							
 
						 <input type="password" name="password" placeholder="Password"
						 class="inputText" >
						
						<%
							if (pas != null) {
						%>
						<h4>
							<font color="red"><%=pas%></font>
						</h4> <%
 	   							}
 								%>
 							
 
						<div>
							<center>
								<input type="submit" name="operation" value="Login"
									class="inputButton">
							</center>
						</div>

						<div class="line">
							<span class="arrow"></span> <span class="content">OR</span> <span
								class="arrow"></span>
						</div>
						<div class="forgetPassword">
							<input type="submit" name="operation" value="ForgetPassword"
								class="inputButton">
							</center>
						</div>
				</div>
			</div>
			<div class="footer">
				<p>
					Don't have a accout?<input type="submit" name="operation"
						value="SignUp" class="inputButton">
				</p>
			</div>
		</div>
		<input type="hidden" name="uri" value="<%=uri%>">
	</form>
</body>
</html>
