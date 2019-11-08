<%@page import="com.cmrcet.bs.bean.Buses"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
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
		String wrongBus = (String) request.getAttribute("WrongBus");
	%>
	<%
		String adminOp = (String) request.getAttribute("adminOp");
	%>
	<%
		List<Buses> busid = (List<Buses>) request.getAttribute("busid");
	%>
	<div class="container">
		<%
			if (!adminOp.equals("BusesBetween")) {
		%>
		<div class="value">
			<form <%if (adminOp.equals("PassengerDetails")) {%>
				action="BusDetails" onsubmit="return display();"
				<%} else if (adminOp.equals("CheckIncome")) {%> action="GetIncome"
				<%}%> name="form" method="post">
				<%
					if (adminOp.equals("PassengerDetails") || adminOp.equals("CheckIncome")) {
				%>
				BusID :
				<div class="center">
					<select name="busId">
						<%
							for (Buses b : busid) {
						%>
						<option><%=b.getBusid()%></option>
				<%
					}
				%>
					</select>
				</div>
				Date:
				<div class="center">
					<input type="date" name="dateOfTravel" value="2019-08-13">
				</div>
				<div class="center">
					<input type="submit" value="Get">
				</div>
			</form>
		</div>
		<%
			request.removeAttribute("adminOp");
				}
			} else {
		%>
		<div class="value">
			<form action="BusCount" method="post">
				Source:
				<div class="center">
					<%
						@SuppressWarnings("unchecked")
							List<String> source = (List<String>) request.getAttribute("Source");
							@SuppressWarnings("unchecked")
							List<String> destination = (List<String>) request.getAttribute("Destination");
					%>
					<select name="Source">
						<%
							for (String x : source) {
						%>
						<option><%=x%></option>
						<%
							}
						%>
					</select>
				</div>
				Destination:
				<div class="center">
					<select name="Destination">
						<%
							for (String x : destination) {
						%>
						<option><%=x%></option>
						<%
							}
						%>
					</select>
				</div>
				<div class="center">
					<input type="submit" value="Get">
				</div>
			</form>
		</div>
	</div>
	<%
		request.removeAttribute("Source");
			request.removeAttribute("Destination");
		}
	%>
</body>
</html>