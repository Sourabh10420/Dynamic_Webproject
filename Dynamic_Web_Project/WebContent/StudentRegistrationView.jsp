<%@page import="in.co.rays.Bean.StudentFormBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: aqua;
}

.form {
	display: flex;
	justify-content: center;
	margin-top: 3cm;
}
/* .color{

background-color: red;


}  */
</style>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");

		StudentFormBean bean = (StudentFormBean) request.getAttribute("bean");

		String first = (String) request.getAttribute("first");
		String last = (String) request.getAttribute("last");

		String login = (String) request.getAttribute("login");

		String pass = (String) request.getAttribute("pass");

		String course = (String) request.getAttribute("course");

		String enroll = (String) request.getAttribute("enroll");

		String dob = (String) request.getAttribute("dob");

		String address = (String) request.getAttribute("address");

		String semester = (String) request.getAttribute("semester");
	%>

	<img alt="" src="">
	<div class="form">
		<span class="color">
		
				
				<h1 align="center">Student Registration</h1>

			<form action="StudentFormRegistrationCtl" method="post">

				<%
					if (msg != null) {
				%>

				<h3>
					<font color="red"><%=msg%></font>
				</h3>


				<%
					}
				%>

				<table>
					<tr>
						<td><input type="hidden" name="id"
							value="<%=(bean != null) ? bean.getId() : ""%>"></td>
					</tr>

					<tr>

						<th>FirstName :</th>
						<td><input type="text" name="firstName"
							placeholder="FirstName"
							value="<%=(bean != null) ? bean.getFirstName() : ""%>"></td>
						<td>
							<%
								if (first != null) {
							%>
							<h5>
								<font color="#f76262"><%=first%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>LastName :</th>
						<td><input type="text" name="lastName" placeholder="LastName"
							value="<%=(bean != null) ? bean.getLastName() : ""%>"></td>
						<td>
							<%
								if (last != null) {
							%>
							<h5>
								<font color="#f76262"><%=last%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>LoginId :</th>
						<td><input type="text" name="loginId" placeholder="LoginId"
							value="<%=(bean != null) ? bean.getLoginId() : ""%>"></td>
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
						<th>Password :</th>
						<td><input type="text" name="password" placeholder="Password"
							value="<%=(bean != null) ? bean.getPassword() : ""%>"></td>
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
						<th>CourseName :</th>
						<td><input type="text" name="courseName"
							placeholder="CourseName"
							value="<%=(bean != null) ? bean.getCourseName() : ""%>"></td>
						<td>
							<%
								if (course != null) {
							%>
							<h5>
								<font color="#f76262"><%=course%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>Enrollment :</th>
						<td><input type="text" name="enrollment"
							placeholder="Enrollment"
							value="<%=(bean != null) ? bean.getEnrollment() : ""%>"></td>
						<td>
							<%
								if (enroll != null) {
							%>
							<h5>
								<font color="#f76262"><%=enroll%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>DOB :</th>
						<td><input type="date" name="dob" placeholder="DOB"
							value="<%=(bean != null) ? bean.getDob() : ""%>"></td>
						<td>
							<%
								if (dob != null) {
							%>
							<h5>
								<font color="#f76262"><%=dob%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>Address :</th>
						<td><input type="text" name="address" placeholder="Address"
							value="<%=(bean != null) ? bean.getAddress() : ""%>"></td>
						<td>
							<%
								if (address != null) {
							%>
							<h5>
								<font color="#f76262"><%=address%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>Semester :</th>
						<td><input type="text" name="semester" placeholder="Semester"
							value="<%=(bean != null) ? bean.getSemester() : ""%>"></td>
						<td>
							<%
								if (semester != null) {
							%>
							<h5>
								<font color="#f76262"><%=semester%></font>
							</h5> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th></th>
						<td ><br><input type="submit" name="operation"
							value="<%=(bean != null) ? "update" : "save"%>">
							 <input type="submit" name="operation"
							value="backToLoginPage">
							<input type="submit" name="operation" value="Reset"></td>
					</tr>
					
				</table>

			</form>
		</span>
	</div>
</body>
</html>