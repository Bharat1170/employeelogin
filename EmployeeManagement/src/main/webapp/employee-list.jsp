<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Employee Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<style>
header
{
	background:blue;
}
</style>
</head>

<body>

	<header>
		<nav class="navbar brand">
			<div align = "left">
				<a style="color:white" href="employee-list.jsp" class="navbar-brand" > Employee Application </a>
			</div>
			
			<div align="right">
				<a style="color:white" href="logout.jsp" class="navbar-brand"> Logout </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="Addemployee-form.jsp" class="btn btn-success">Add New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.id}"/></td>
							<td><c:out value="${employee.name}"/></td>
							<td><c:out value="${employee.email}"/></td>
							<td><c:out value="${employee.country}"/></td>
							<td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>