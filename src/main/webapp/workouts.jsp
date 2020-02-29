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
					<a href="getWorkouts"
						class="list-group-item list-group-item-action">My Workout Book</a>
					<a href="getMemberGymClasses"
						class="list-group-item list-group-item-action">My Classes</a> <a
						href="getGymClasses"
						class="list-group-item list-group-item-action">All Classes</a>
				</div>
			</div>
			<div class="col-md-9">
				<nav aria-label="breadcrumb"
					style="margin-top: 5px; margin-bottom: 5px;">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModal">Add today's Workout</button>
				</nav>
				<%
					if (request.getAttribute("message") != null) {
				%>
				<h6 class="p-3 mb-2 bg-success text-white"><%=request.getAttribute("message")%></h6>
				<%
					}
				%>

				<%
					if (request.getAttribute("workouts") != null) {
							Map<LocalDate, List<Workout>> workouts = (Map<LocalDate, List<Workout>>)request.getAttribute("workouts");
							for (Map.Entry<LocalDate, List<Workout>> itemVal : workouts.entrySet()) {
								List<Workout> mapWorkouts = itemVal.getValue();
				%>
				<div class="card-deck">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">
								Day:<%=itemVal.getKey()%></h5>
							<div class="list-group">
								<%
									for (Workout currentWorkout : mapWorkouts) {
								%>
								<a href="#"
									class="list-group-item list-group-item-action flex-column align-items-start">
									<div class="d-flex w-100 justify-content-between">
										<h5 class="mb-1"><%=currentWorkout.getWorkoutType()%></h5>
									</div> <span class="badge badge-danger badge-pill"><%=currentWorkout.getWeight()%>
										lbs</span> <span class="badge badge-success badge-pill"><%=currentWorkout.getSets()%>
										sets</span> <span class="badge badge-primary badge-pill"><%=currentWorkout.getReps()%>
										reps</span>
								</a>
								<%
									}
								%>
							</div>
						</div>
						<div class="card-footer"></div>
					</div>
				</div>
				<%
					}
						}
				%>
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
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Workout
							Registration</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/addworkout" method="post">
						<div class="modal-body">
							<div class="row">
								<div class="col-md-6 mb-3 form-group">
									<label for="workoutType">Workout Type</label> <select
										name="workoutType" class="form-control" id="workoutType">
										<option hidden="true">Options</option>
										<option value="Push ups">Push ups</option>
										<option value="Bench Press">Bench Press</option>
										<option value="Barbell Overhead Press">Barbell
											Overhead Press</option>
										<option value="Incline dumbbell press">Incline
											dumbbell press</option>
										<option value="Dips">Dips</option>
										<option value="Shoulder press">Shoulder press</option>
										<option value="Tricep kick backs">Tricep kick backs</option>
										<option value="Bicep curls">Bicep curls</option>
										<option value="Wide grip barbell rows">Wide grip
											barbell rows</option>
										<option value="Abs">Abs</option>
										<option value="Chest Dumbbell Press">Chest Dumbbell
											Press</option>
										<option value="Calve raises">Calve raises</option>
										<option value="Romanian Dead lifts">Romanian Dead
											lifts</option>
										<option value="Face pulls">Face pulls</option>
										<option value="Hammer curls">Hammer curls</option>
										<option value="Leg curls">Leg curls</option>
									</select>
								</div>
								<div class="col-md-6 mb-3 form-group">
									<label for="weight">Weight</label> <input type="number"
										name="weight" class="form-control" id="weight"
										aria-describedby="weight">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3 form-group">
									<label for="workoutTitle">Sets</label> <input type="text"
										name="sets" class="form-control" id="workoutTitle"
										aria-describedby="workoutTitle">
								</div>
								<div class="col-md-6 mb-3 form-group">
									<label for="reps">Reps</label> <input type="text" name="reps"
										class="form-control" id="reps" aria-describedby="reps">
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Save</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="./js/jquery.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script>
		$('#exampleModal').modal(options)
	</script>
</body>
</html>
<%
	} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>