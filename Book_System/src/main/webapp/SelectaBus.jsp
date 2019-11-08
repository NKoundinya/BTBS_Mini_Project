<%@page import="com.cmrcet.bs.bean.TicketCost"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="DesignForSelectABus.css">
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<TicketCost> seat = (ArrayList<TicketCost>) request.getAttribute("TicketList");
	%>
	<form action="selected" method="post">
		<div class="container">
			<div class="value">
				<div class="center">
				<h3> Available Buses List </h3>
					<table>
						<tr>
							<th>Bus Name</th>
							<th>Bus Type</th>
							<th>Cost (per ticket)</th>
							<th>Source</th>
							<th>Destination</th>
						</tr>
						<%
							if (seat != null) {
								for (TicketCost list : seat) {
						%>
						<tr>
							<td><input type="submit" name="busId"
								value="<%=list.getBusId().getBusid()%>"></td>
							<td><%=list.getBusId().getType()%></td>
							<td><%=list.getCost()%></td>
							<td><%=list.getSource()%></td>
							<td><%=list.getDestination()%></td>
						</tr>
						<%
							}
								request.removeAttribute("TicketList");
							} else {
						%>
						<tr>
							<td colspan="3">No Buses Available</td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>