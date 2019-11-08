<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Design.css">

<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["username"].value;

		var opt = document.forms["form"]["number"];
		
		var idproof = document.forms["form"]["idProof"].value;
	
		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {
			document.getElementById('enter').innerHTML += "<p>Enter Name</p>";
			return false;
		} else if(opt.value == "Aadhar") {
			if(idproof.length < 12 || idproof.length > 12) {
				document.getElementById('enter1').innerHTML += "<p>Enter Proper ID</p>";
				return false;
			}
		} else if(opt.value == "PAN" || opt.value == "Voter ID") {
			if(idproof.length < 10 || idproof.length > 10) {
				document.getElementById('enter1').innerHTML += "<p>Enter Proper ID</p>";
				return false;
			}
		}
		return true;
	}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="design">
			<h2 align="center">Booking Ticket</h2>
			<form action="pay" onsubmit="return display();"
				name="form" method="post">
				Name:
				<div class="center">
					<input type="text" name="username">
					<p id="enter"></p>
				</div>

				ID Proof:
				<div class="center">
					<select name="number">

						<option value="Aadhar">Aadhar</option>

						<option value="Voter ID">Voter ID</option>

						<option value="PAN">PAN</option>

					</select>
				</div>
				Number:
				<div class="center">
					<input type="text" name="idProof">
					<p id="enter1"></p>
				</div>
				No. Of Seats to be booked:
				<div class="center">
					<select name="seats">
						<%
							Integer seats = (Integer) request.getAttribute("lessSeats");

							if (seats == null) {
						%>
						<option>Bus Is Full. Try For another Bus.</option>

						<%
							} else {
								for (int i = 1; i <= 4; i++) {
						%>
						<option><%=i%></option>
						<%
							}
							}
						%>
					</select>

				</div>

				<div class="center">
					<input id="remove" type="submit" value="Go ->">
				</div>
			</form>
		</div>
	</div>
</body>
</html>