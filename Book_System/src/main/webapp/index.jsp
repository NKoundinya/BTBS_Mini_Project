<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Design.css">
<meta charset="ISO-8859-1">
<title>Start</title>
</head>
<body>
	<div class="container">
		<div class="value">
			<h3 align="center" style="color: navy;">...Bus Ticket Booking
				System...</h3>
			<form action="controller" method="post">
				<div class="center">
					<input type='submit' name="control" value='Book Ticket'>
				</div>
				<div class="center">
					<input type='submit' name="control" value='Show Ticket Details'>
				</div>
				<div class="center">
					<input type='submit' name="control" value='Cancel Ticket'>
				</div>	
			<div class="center">
					<input type='submit' name="control" value='Admin' id="sub">
			</div>
			</form>
		</div>   
	</div>
</body>
</html>