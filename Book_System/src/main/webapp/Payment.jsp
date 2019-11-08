<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" href="Design.css">
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["Holder"].value;

		var num = document.forms["form"]["cardNumber"].value;

		var cvv = document.forms["form"]["CVV"].value;

		document.getElementById('enterHolder').innerHTML = "";
		document.getElementById('enterNumber').innerHTML = "";
		document.getElementById('enterCVV').innerHTML = "";

		if (username == null || username == "") {
			document.getElementById('enterHolder').innerHTML += "<p>Enter Name</p>";
			return false;
		} else if (num == null || num.length > 16 || num.length < 16) {
			document.getElementById('enterNumber').innerHTML += "<p>Enter Proper Number</p>";
			return false;
		} else if (cvv == null || cvv.length != 3) {
			document.getElementById('enterCVV').innerHTML += "<p>Enter Proper CVV</p>";
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="reserve" method="post" name="form"
		onSubmit="return display();">
		<div class="container">
			<div class="value">
				<h1 align="center">Payment</h1>
				<div class="center">Debit-Card Holder:</div>
				<div class="center">
					<input type="text" name="Holder">
					<p id="enterHolder"></p>
				</div>
				<div class="center">Card Number:</div>
				<div class="center">
					<input type="text" name="cardNumber">
					<p id="enterNumber"></p>
				</div>
				<div class="center">CVV:</div>
				<div class="center">
					<input type="text" name="CVV">
					<p id="enterCVV"></p>
				</div>
				<div class="center">
					<input type="submit" value="PAY">
				</div>
			</div>
		</div>
	</form>
</body>
</html>