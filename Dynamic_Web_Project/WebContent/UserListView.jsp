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
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;

		List nextList = (List) request.getAttribute("nextList");

		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
	<%@include file="Header.jsp"%>
	<form action="UserListCtl.do" method="post">

		<table>
			<tr>
				<td><input type="text"  placeholder="FirstName" name="firstName"></td>
				<td><input type="date" name="dob"></td>
				<td><input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		<table border="2%" style="width: 100%">
			<tr style="color:maroon;">
				<th>Select</th>
				<th>S.No</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginID</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<%
				while (it.hasNext()) {

					UserBean bean = (UserBean) it.next();
			%>
			<tr style="color:navy;">
				<td align="center"><input type="checkbox" name="ids"
					value="<%=bean.getId()%>"></td>
				<td align="center"><%=index++%></td>
				<td align="center"><%=bean.getFirstName()%></td>
				<td align="center"><%=bean.getLastName()%></td>
				<td align="center"><%=bean.getLoginId()%></td>
				<td align="center"><%=bean.getPassword()%></td>
				<td align="center"><%=bean.getDob()%></td>
				<td align="center"><%=bean.getAddress()%></td>
				<td align="center"><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table style="width: 100%">
			<tr>
				<td style="text-align: left;"><input type="submit" name="operation"
					value="previous" <%=(pageNo != 1) ? "" : "disabled"%>></td>
				<td style="text-align:center;"><input type="submit" name="operation"
					value="add"></td>
				<td style="text-align:right;"><input type="submit" name="operation"
					value="delete"></td>
				</tr>
				<tr>
								<td style="text-align: left;"><input type="submit" name="operation"
					value="next" <%=(nextList.size() != 0) ? "" : "disabled"%>></td>
				</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>

</body>
</html>