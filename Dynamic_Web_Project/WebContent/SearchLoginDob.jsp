<%@page import="in.co.rays.Bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		String msg = (String) request.getAttribute("msg");
		
			UserBean user =  (UserBean) request.getAttribute("user");
	%>
		
			
		<form action="ResetPasswordCtl" method = "post">
		
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
			   <th>LoginId :</th>
			   <td><input type = "text" name ="loginId"> </td>
			   	<td><input type="submit" name="operation" value="submit"></td>
			    </tr>
		</table>
			
			
	</form>
</body>
</html>