<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Vehicle Appliction</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
        style="background-color:rosybrown">
        <div>
            <a href="" class="navbar-brand"> Vehicle App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                class="nav-link">Users</a></li>
        </ul>
        <hr>
        <a href="#"><i class="fa fa-fw fa-search"></i> Search</a>
        
    </nav>
</header>
<br>
<c:if test="${user != null}">
    <form action="update" method="post">
</c:if>

<caption>
    <h2>
        <c:if test="${user != null}">
        Edit User
    </c:if>
        <c:if test="${user == null}">
        Add New User
    </c:if>
    </h2>
</caption>
<form class="form-horizontal" method="post" action="insert">
    <div class="container">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name"
                    name="name" ><br>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="form-group">
            <label class="control-label col-sm-2" for="model">Latest Model:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="model"
                    name="model" ><br>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="form-group">
            <label class="control-label col-sm-2" for="cc">CC:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="cc"
                    name="cc" ><br>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Description:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="description"
                    name="description" ><br>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Price:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price"
                    name="price" ><br>
            </div>
        </div>
    </div>
    <div class="container">
            <div class="col-sm-4">
                <input type="submit" class="btn btn-lg btn-primary" value="submit"
                style = "display:block; border-radius: 5px; float: right; padding: 10px;">
                     
                <br>
            </div>
    </div>
    
</body>
</html>
    
