<%@page import="in.co.rays.Bean.PaymentBean"%>
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
		List list = (List) request.getAttribute("list");
		List nextList = (List) request.getAttribute("nextList");
		int pageNo = (int) request.getAttribute("pageNo");
		
		int index = (pageNo - 1) * 5 + 1;

		Iterator it = list.iterator();
	%>
	<%@ include file = "PaymentHeader.jsp" %>
	<form action="PaymentListCtl.dm" method = "post">


		<table>
			<tr>
				<td><input type="text"  placeholder="Payer" name="payer"></td>
				<td><input type="date" name="payementDate"></td>
				<td><input type ="submit" name=operation value="search">

			</tr>
		</table>
		<table border="2px" style="width: 100%">
			<tr>
				<th>Select</th>
				<th>S.No</th>
				<th>PaymentDate</th>
				<th>Description</th>
				<th>Amount</th>
				<th>PaymentMethod</th>
				<th>Status</th>
				<th>Payer</th>
				<th>EmailId</th>
				<th>Password</th>
				<th>Edit</th>
			</tr>
			<%
				while (it.hasNext()) {

					PaymentBean bean = (PaymentBean) it.next();
			%>


			<tr>
				<td align="center"><input type="checkbox" name="ids"
					value="<%=bean.getId()%>"></td>
				<td align="center"><%=index++%></td>
				<td align="center"><%=bean.getPayementDate()%>
				<td align="center"><%=bean.getDescription()%>
				<td align="center"><%=bean.getAmmount()%>
				<td align="center"><%=bean.getPaymentMethod()%>
				<td align="center"><%=bean.getStatus()%>
				<td align="center"><%=bean.getPayer()%>
				<td align="center"><%=bean.getEmailId()%>
				<td align="center"><%=bean.getPassword()%> 
				<td align="center"><a href="PaymentCtl.dm?id=<%=bean.getId()%>">edit</a></td>
				<%
 	}
 %>
			</tr>
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