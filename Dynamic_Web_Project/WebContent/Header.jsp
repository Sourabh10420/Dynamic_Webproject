<%@page import="in.co.rays.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
		a:hover {
	color: red;
	padding-left: 5px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 
 
 h3{
 font: italic;
 font-family: sans-serif;
 padding-left: 5px;
 font-style: italic;
 
 }

</style>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		Hi, <br>
		<%=user.getFirstName()%></h3>
	<a href="UserCtl.do">Add User</a> |
	<a href="UserListCtl.do">User List</a> |
	<a href= "LoginCtl?operation=logout">Logout</a>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<%
		}
	%>
	<hr>

</body>
</html>