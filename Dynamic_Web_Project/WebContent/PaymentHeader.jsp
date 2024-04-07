<%@page import="in.co.rays.Bean.PaymentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		PaymentBean user = (PaymentBean) session.getAttribute("user");
	%>
	
	<%
		if (user != null) {
	%>
	<h3>
		Hi, <br>
		<%=user.getPayer()%></h3>
	<a href="PaymentCtl.dm">AddPayer</a> |
	<a href="PaymentListCtl.dm">PaymentList</a> |
	<a href= "PaymentLoginCtl?operation=logout">Logout</a>
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