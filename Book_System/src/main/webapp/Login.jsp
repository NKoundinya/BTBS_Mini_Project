<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["username"].value;

		var idproof = document.forms["form"]["password"].value;

		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter Name</p>";

			return false;
		} else if (idproof == null || idproof == "") {

			document.getElementById('enter1').innerHTML += "<p>Enter Password</p>";

			return false;
		}
		return true;
	}
</script>

<link rel="stylesheet" href="Design.css">

<style type="text/css">
div>p {
	text-align: left;
	color: red;
	font-size: 12px;
}

div>p.center {
	text-align: center;
}
</style>

<meta charset="ISO-8859-1">

<title>Login</title>

</head>
<body>
	<%
		String wrongLogin = (String) request.getAttribute("WrongLogin");
	%>
	<div class="value">
		<h2 align="center">Login Page</h2>
		<form action="Admin" onsubmit="return display();" name="form"
			method="post">
			UserName:
			<div class="center">
				<input type="text" name="username">
				<p id="enter"></p>
			</div>

			Password:
			<div class="center">
				<input type="password" name="password">
				<p id="enter1"></p>
			</div>
			<div class="center">
				<input type="submit" value="Login">
				<%
					if (wrongLogin != null) {
				%>
				<p class="center"><%=wrongLogin%></p>
				<%
					request.removeAttribute("WrongLogin");

					}
				%>
			</div>
		</form>
	</div>
</body>
</html>