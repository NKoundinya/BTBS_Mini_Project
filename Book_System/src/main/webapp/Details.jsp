<%@page import="com.comakeit.bs.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Design.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean userDetailsBean = (UserBean) request.getAttribute("reserved");
		if (userDetailsBean != null) {
	%>
	<div class="container">
		<div class="value">
			<h1 align="center">Details of Ticket</h1>
			<div class="center">

				<table>

					<tr>
						<td>Passenger Name</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getUsername()%></td>
					</tr>
					<tr>
						<td>PNR ID</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getPnr()%></td>
					</tr>
					<tr>
						<td>ID Proof Number</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getIdProof()%></td>
					</tr>
					<tr>
						<td>Bus ID</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getService().getBus().getBusid()%></td>
					</tr>
					<tr>
						<td>Bus Type</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getService().getBus().getType()%></td>
					</tr>
					<tr>
						<td>Seats</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getSeats()%></td>
					</tr>
					<tr>
						<td>Source</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getSource()%></td>
					</tr>
					<tr>
						<td>Destination</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getDestination()%></td>
					</tr>
					<tr>
						<td>Journey Date</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getReservation().getService().getDate()%></td>
					</tr>

					<tr>
						<td>Total Cost</td>
						<td class="colon">:</td>
						<td><%=userDetailsBean.getCost()%></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<%
							String sure = (String) request.getAttribute("SURE");
								String book = (String) request.getAttribute("BOOK");
						%>
						<td><p style="font: 7px">(Copy PNR for Further usage)</p>
							<form <%if (sure != null && sure == "SURE") {%> action="Cancel"
								<%} else if (book != null && book == "BOOK") {%> action="Book"
								<%} else {%> action="index" <%}%> method="post">
								<%
									if (sure != null) {
								%><input type="hidden" name="pnr"
									value=<%=userDetailsBean.getReservation().getPnr()%>>
								<%
									}
								%>
								<input type="submit" name="var"
									<%if (sure != null && sure == "SURE") {%>
									value="Click to cancel"
									<%} else if (book != null && book == "BOOK") {%> value="Book"
									<%} else {%> value="Done" <%}%>>

							</form></td>

					</tr>
				</table>
			</div>
		</div>
	</div>
	<%
		}
		request.removeAttribute("SURE");
		request.removeAttribute("reserved");
	%>
</body>
</html>