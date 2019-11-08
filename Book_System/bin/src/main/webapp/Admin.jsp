<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.center {
	text-align: left;
	margin: auto;
	height: 75px;
	background: white;
}

a:link, a:visited {
	background-color: #079297;
	color: white;
	padding: 14px 25px;
	text-align: justify;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: #09C5CB;
}

.container {
	box-shadow: 10px 10px 5px grey;
	width: 400px;
	position: absolute;
	left: 50%;
	top: 40%;
	transform: translate(-50%, -50%);
	top: 40%;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3 align="center">
			Welcome
			<%=request.getAttribute("username")%>
			<%request.removeAttribute("username"); %>
		</h3>
		<div class="center">
			<ul>
				<li><a href="PassengerDetails">Get Passenger Details on a
						bus.</a></li>
			</ul>
		</div>
		<div class="center">
			<ul>
				<li><a href="CheckIncome">Check Income.</a></li>
			</ul>
		</div>
		<div class="center">
			<ul>
				<li><a href="BusesBetween">Busses between routes.</a></li>
			</ul>

		</div>
		<div class="center">
			<ul>
				<li><a href="Logout">Log Out</a></li>
			</ul>

		</div>
	</div>
</body>
</html>