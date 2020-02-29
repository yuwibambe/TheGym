<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TheGym</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" />
</head>

<body style="font-family: 'Courier New', Courier, monospace;">
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img src="./img/logo.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			THEGYM
		</a>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<nav aria-label="breadcrumb" style="margin-top: 5px;">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Member'S
								Registration Page</a></li>
					</ol>
				</nav>
				<form action="/createmember" method="post">
					<div class="row">
						<div class="col-md-6 mb-3 form-group">
							<label for="firstName">First Name</label> <input type="text" name="firstName"
								class="form-control" id="firstName" aria-describedby="firstName">
						</div>
						<div class="col-md-6 mb-3 form-group">
							<label for="lastName">Last Name</label> <input type="text" name="lastName"
								class="form-control" id="lastName" aria-describedby="lastName">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 mb-3 form-group">
							<label for="email">E-mail</label> <input type="email" name="email"
								class="form-control" id="email" aria-describedby="email">
						</div>
						<div class="col-md-6 mb-3 form-group">
							<label for="accountName">Account Name</label> <input type="text" name="username"
								class="form-control" id="accountName"
								aria-describedby="accountName">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 mb-3 form-group">
							<div class="form-group">
								<label for="password">Password</label> <input name="password"
									type="password" class="form-control" id="password"
									aria-describedby="password">
							</div>
						</div>
						<div class="col-md-6 mb-3 form-group">
							<div class="form-group">
								<label for="dateOfBirth">Date of Birth</label> <input name="dob"
									type="date" class="form-control" id="dateOfBirth"
									aria-describedby="dateOfBirth">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 form-group">
							<label for="homeAddress">Home Address</label> <input type="text" name="street"
								class="form-control" id="homeAddress"
								aria-describedby="homeAddress">
						</div>
						<div class="col-md-3 form-group">
							<label for="state">State</label> <input type="text" name = "state"
								class="form-control" id="state" aria-describedby="state">
						</div>
						<div class="col-md-3 form-group">
							<label for="city">City</label> <input type="text" name= "city"
								class="form-control" id="city" aria-describedby="city" >
						</div>
						<div class="col-md-2 form-group">
							<label for="zip">Zip</label> <input type="text" name="zipCode"
								class="form-control" id="zip" aria-describedby="zip">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>
		<hr>
		<footer class="my-3 pt-3 text-muted text-center text-small">
			<p class="mb-1">© 2019-2022 TheGym App</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</div>
</body>

</html>