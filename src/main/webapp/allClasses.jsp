<%@page import="com.yvette.gym.domain.GymClass"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.yvette.gym.domain.Workout"%>
<%@page import="com.yvette.gym.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Member loggedUser = (Member) session.getAttribute("session");
	if (loggedUser != null) {
%>
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
		</a> <a href="/logout" class="btn btn-outline-success my-2 my-sm-0"
			type="submit">Logout</a>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3" style="margin-top: 5px;">
				<div class="list-group">
					<a href="getWorkouts" class="list-group-item list-group-item-action">My Workout Book</a> 
					<a href="getMemberGymClasses" class="list-group-item list-group-item-action">My Classes</a>
					<a href="getGymClasses" class="list-group-item list-group-item-action">All Classes</a>
				</div>
			</div>
			<div class="col-md-9">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col"># Students</th>
							<th scope="col">Enrolled</th>
							<th scope="col">Day</th>
							<th scope="col">From</th>
							<th scope="col">To</th>
							<th scope="col">Operation</th>
						</tr>
					</thead>
					<tbody>
					<%
					if (request.getAttribute("classes") != null) {
						List<GymClass> classes = (List<GymClass>)request.getAttribute("classes");
						for(GymClass gymclass: classes){
					%>
						<tr>
							<th scope="row"><%=gymclass.getId() %></th>
							<td><%=gymclass.getName() %></td>
							<td><%=gymclass.getTotalStudents() %></td>
							<td><%=gymclass.getEnrolledStudents() %></td>
							<td><%=gymclass.getDayOfWeek() %></td>
							<td><%=gymclass.getFromHour() %></td>
							<td><%=gymclass.getToHour() %></td>
							<th>
								<a href="addClass?classId=<%=gymclass.getId() %>" class="btn btn-success">Take Class</a>
							</th>
						</tr>
						<%}} %>
					</tbody>
				</table>
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
	<script src="./js/jquery.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>
<%
	} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>