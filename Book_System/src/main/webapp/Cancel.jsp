<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Design.css">
<style>
div>p {
	text-align: left;
	color: red;
	font-size: 12px;
}

div>p.center {
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {
		var pnr = document.forms["form"]["pnr"].value;

		document.getElementById('enter').innerHTML = "";

		if (pnr == "" || pnr == null) {
			document.getElementById('enter').innerHTML = "Enter PNR Number";
			return false;
		}
		return true;
	}
</script>
<meta charset="ISO-8859-1">

</head>
<body>
	<%
		String enter = (String) request.getAttribute("Enter");
		String notFound = (String) request.getAttribute("NotFound");
	%>

	<div class="value">
		<form <%if (enter.equals("Cancel")) {%> action="DetailsCancel"
				<%} else if (enter.equals("Details")) {%> action="Details" <%}%>
				name="form" onsubmit="return check();" method="post">
				<%
					if (enter.equals("Cancel")) {
				%>
				<h1 align="center">Ticket Cancellation</h1>
				<%
					request.removeAttribute("Enter");

					} else if (enter.equals("Details")) {
				%>
				<h1 align="center">Ticket Details</h1>

				<%
					request.removeAttribute("Details");

					}
				%>
				Enter Ticket PNR Number:
				<div class="center">
					<input type="text" name="pnr" required="required">
					<p class="center"></p>
				</div>
				<div class="center">
					<input id="remove" type="submit" value="Enter">
					<%
						if (notFound != null) {
					%>
					<p class="center"><%=notFound%>
						not Found. Enter Correct PNR.
					</p>
					<%
						}
					%>
				</div>
			</form>
		</div>
</body>
</html>