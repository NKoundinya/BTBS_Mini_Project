<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
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
	<div class="container">
		<div class="design">
			<h2 align="center">Booking Ticket</h2>
			<form action="done" method="post">
				Source:
				<div class="center">
					<%
						@SuppressWarnings("unchecked")
						List<String> s = (List<String>) request.getAttribute("Sources");
					%>
					<select name="source">
						<%
							for (String x : s) {
						%>
						<option><%=x%>
							<%
								}
								request.removeAttribute("Sources");
							%>
						
					</select>
				</div>
				Destination:
				<%
					@SuppressWarnings("unchecked")
					List<String> d = (List<String>) request.getAttribute("Destination");
				%>
				<div class="center">
					<select name="destination">
						<%
							for (String x : d) {
						%>
						<option><%=x%>
							<%
								}
								request.removeAttribute("Destination");
							%>
						
					</select>
				</div>
				Journey Date and Time:
				<div class="center">
					<input type="date" name="date" value="2019-08-13">
				</div>
				<div class="center">
					<input id="remove" type="submit" value="Go ->">
				</div>
			</form>
		</div>
	</div>
</body>
</html>