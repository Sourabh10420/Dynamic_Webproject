<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="#A3E4D7">
<form action="ResetPasswordCtl" method="post">
<h1 align="center">Submit your Email address and we'll send your password.</h1>
    <%String pass=(String)request.getAttribute("Pwd"); 
    String em=(String)request.getAttribute("email");
%>
<h2 align="center" style="color: red"><%if(pass!=null){%><%=pass %><%} %></h2>
<table align="center">

<tr>
<td>Enter your Email</td>
<td><input type="email" name="loginId" value=""></td>
<td><input type="submit" name="operation" value="search"></td>
<td style="position: fixed; color: red"><%if(em!=null){%><%=em %><%} %></td>
</tr>
<tr>
<th></th>
<th></th>
 <td><input type = "submit" name = operation value = "loginPage"></td>
</tr>


</table>
</form>
</body>

</html>