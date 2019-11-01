<%@page import="com.comakeit.bs.bean.TicketCost"%>
<%@page import="java.util.ArrayList"%>
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
		@SuppressWarnings("unchecked")
		ArrayList<TicketCost> seat = (ArrayList<TicketCost>) request.getAttribute("TicketList");
	%>
	<form action="selected" method="post">
		<div class="container">
			<div class="valueBus">
				<div class="center">
					<table id="customer">
						<tr>
							<th colspan="5" align="center">Buses Available</th>
						</tr>
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
								value="<%=list.getBusId().getBusid() %>"></td>
							<% %>
							<td><%=list.getBusId().getType() %></td>
							<td><%= list.getCost() %></td>
							<td><%=list.getSource() %></td>
							<td><%=list.getDestination() %></td>
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