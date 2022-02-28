<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="model.Vehicle"%>
<% List<Vehicle> eList = (ArrayList<Vehicle>)request.getAttribute("listUser");%>
<html>
<head>
<title>Vehicle Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Vehicle App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
		
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>CC</th>
						<th>model</th>
						<th>desc</th>
                        <th>price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eList}" var="user" >
						<tr>
							<td><c:out value="${user.vehicleId}"/></td>
							<td><c:out value="${user.vehicleName}" /></td>
							<td><c:out value="${user.VehicleModel}"/></td>
							<td><c:out value="${user.VehicleCC}"/></td>
                            <td><c:out value="${user.VehicleDescription"/></td>
                            <td><c:out value="${user.VehiclePrice}"/></td>
							<td><a href="edit?id=<c:out value='${user.VehicleId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a>
								href="delete?id=<c:out value='${user.VehicleId}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>