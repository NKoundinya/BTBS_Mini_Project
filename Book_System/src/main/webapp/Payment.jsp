<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="Design.css">
</head>
<body>
	<form action="reserve" method="post">
		<div class="container">
			<div class="value">
				<h1 align="center">Payment</h1>
				<div class="center">Debit-Card Holder:</div>
				<div class="center">
					<input type="text">
				</div>
				<div class="center">Card Number:</div>
				<div class="center">
					<input type="text">
				</div>
				<div class="center">CVV:</div>
				<div class="center">
					<input type="text">
				</div>
				<div class="center"></div>
				<div class="center">
					<input type="submit" value="PAY">
				</div>
			</div>
		</div>
	</form>
</body>
</html>