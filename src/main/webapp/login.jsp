<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TheGym</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<link href="./css/login.css" rel="stylesheet">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>

<body class="text-center">
	<form action="/login" method="post" class="form-signin">
		<%
			if (request.getAttribute("message") != null) {
		%>
		<h6 class="p-3 mb-2 bg-success text-white"><%=request.getAttribute("message")%></h6>
		<%
			}
		%>
		<img class="mb-4" src="./img/logo.png" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="accountName" class="sr-only">Account name</label> 
		<input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus/> 
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<hr>
		<footer class="my-3 pt-3 text-muted text-center text-small">
			<p class="mb-1">© 2019-2022 TheGym App</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</form>
</html>