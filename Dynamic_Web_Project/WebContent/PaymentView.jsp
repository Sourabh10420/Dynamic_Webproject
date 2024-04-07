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
		String msg = (String) request.getAttribute("msg");
		PaymentBean bean = (PaymentBean) request.getAttribute("bean");
	%>

	<%@ include file ="PaymentHeader.jsp" %>
	<form action="PaymentCtl.dm" method="post">


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
				<th>PaymentDate :</th>
				<td><input type="date" placeholder="Date" name="payementDate"
					value="<%=(bean != null) ? bean.getPayementDate() : ""%>"></td>
			</tr>
			<tr>
				<th>Description :</th>
				<td><input type="text" placeholder="Description"
					name="description" value="<%=(bean != null) ? bean.getDescription() : ""%>"></td>
			</tr>
			<tr>
				<th>Amount :</th>
				<td><input type="text" placeholder="Amount" name="ammount"
					value="<%=(bean != null) ? bean.getAmmount() : ""%>"></td>
			</tr>
			<tr>
				<th>PaymentMethod :</th>
				<td><input type="text" placeholder="PaymentMethod"
					name="paymentMethod"
					value="<%=(bean != null) ? bean.getPaymentMethod() : ""%>"></td>
			</tr>
			<tr>
				<th>Status :</th>
				<td><input type="text" placeholder="Status" name="status"
					value="<%=(bean != null) ? bean.getStatus() : ""%>"></td>
			</tr>
			<tr>
				<th>Payer :</th>
				<td><input type="text" placeholder="Payer" name="payer"
					value="<%=(bean != null) ? bean.getPayer() : ""%>"></td>
			</tr>
			<tr>
				<th>EmailId :</th>
				<td><input type="text" placeholder="EmailId" name="emailId"
					value="<%=(bean != null) ? bean.getEmailId() : ""%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" placeholder="Password" name="password"
					value="<%=(bean != null) ? bean.getPassword() : ""%>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
				<td><input type="submit" name=operation value="list"></td>

			</tr>
		</table>
	</form>
</body>
</html>