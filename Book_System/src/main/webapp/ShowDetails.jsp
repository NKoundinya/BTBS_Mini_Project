<%@page import="com.comakeit.bs.bean.BusDates"%>
<%@page import="com.comakeit.bs.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Deisgn.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
			ArrayList<UserBean> arrayList = (ArrayList<UserBean>) request.getAttribute("passengers");
	%>

	<div class="center">
		<table style="border: 3px solid;">
			<%
				if (arrayList != null) {
			%>
			<tr>
				<th>UserName</th>
				<th>PNR</th>
				<th>ID Proof</th>
				<th>Bus ID</th>
				<th>Bus Type</th>
				<th>Seats</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Date</th>
				<th>Cost</th>
			</tr>
			<%
				if (!arrayList.isEmpty()) {
							for (UserBean userDetailsBean : arrayList) {
			%>
			<tr>
				<td><%=userDetailsBean.getReservation().getUsername()%></td>
				<td><%=userDetailsBean.getReservation().getPnr()%></td>
				<td><%=userDetailsBean.getReservation().getIdProof()%></td>
				<td><%=userDetailsBean.getReservation().getService().getBus().getBusid()%></td>
				<td><%=userDetailsBean.getReservation().getService().getBus().getType()%></td>
				<td><%=userDetailsBean.getReservation().getSeats()%></td>
				<td><%=userDetailsBean.getReservation().getSource()%></td>
				<td><%=userDetailsBean.getReservation().getDestination()%></td>
				<td><%=userDetailsBean.getReservation().getService().getDate()%></td>
				<td><%=userDetailsBean.getCost()%></td>
			</tr>
			<%
				}
			%>
			<%
				} else {
			%>
			<tr>
				<td colspan="10">No Passengers (On the date or On the BUS
					specified)</td>
			</tr>
			<%
				}
						request.removeAttribute("passengers");
					}
			%>
		</table>
	</div>
	<%
		UserBean income = (UserBean) request.getAttribute("income");
	%>

	<div class="container">
		<div class="value">
			<div class="center">
				<table style="border: 3px solid;">
					<%
						if (income != null) {
					%>
					<tr>
						<th>Bus</th>
						<th>Remaining Seats</th>
						<th>Income of Bus</th>
					</tr>
					<tr>
						<td><%=income.getReservation().getService().getBus().getBusid()%></td>
						<td><%=income.getReservation().getSeats()%>
						<td><%=income.getCost()%></td>
					</tr>
						<%
							}
										request.removeAttribute("income");
						%>
				</table>
			</div>
		</div>
	</div>
	<%
		@SuppressWarnings("unchecked")
			ArrayList<BusDates> busesCount = (ArrayList<BusDates>) request.getAttribute("count");
	%>
	<%
		if (busesCount != null) {
	%>
	<div class="container">
		<div class="value">
			<div class="center">
				<table id="customer" style="border: 3px solid;">
					<tr>
						<th>Bus</th>
						<th>Type</th>
						<th>Date</th>
					</tr>
					<%
						if(!busesCount.isEmpty()) {
									for (BusDates count : busesCount) {
					%>
					<tr>
						<td><%=count.getBus().getBusid()%></td>
						<td><%=count.getBus().getType()%>
						<td><%=count.getDate()%></td>
					</tr>
					<%
						}
					} else { %>
						<tr>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<% }
					%>
				</table>
			</div>
		</div>
	</div>
	<%
		request.removeAttribute("count");
		}
	%>
</body>
</html>