<%@page import="in.co.rays.Bean.StudentFormBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
		a:hover {
	color: red;
	padding-left: 5px;
}
 h3{
 font-size: large;
 font: italic;
 font-family: sans-serif;
 padding-left: 5px;
 font-style: italic;
 
 }
.color{

color: black;

}
</style>
</head>
<body>
<%   StudentFormBean admin  = (StudentFormBean) session.getAttribute("admin"); %>
	
	<%
		if (admin != null) {
	%>
	<h3>
		Hi, <br>
		<%=admin.getFirstName()%></h3>
	<h4><a href="StudentFormCtl.SM">Add Student</a> |
	<a href="StudentFormListCtl.SM">StudentList</a> |
	<a href= "StudentLoginCtl?operation=logout">Logout</a></h4>
	<%
		} else {
	%>
	<div class = "color">
	<h3>Hi, Guest</h3>
	</div>
	<%
		}
	%>
	<hr>

</body>
</html>