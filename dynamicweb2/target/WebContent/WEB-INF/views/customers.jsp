<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List all Customers</title>
<link href="Resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="Resources/js/bootstrap.min.js"></script>
<link href="Resources/css/grandview.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="grid-container">
	<div class="header"><h1>Grandview Drones and Helicopters</h1> ADMIN</div>
		<section class="navbar" align= "left" >
 			<li><a href="index">Home</a> </li>
			<li><a href="gologin">Login</a></li>
            <li><a href="CustProfile01">Create Account</a></li>
            <li><a href="customers">List of Customers</a></li>
            <li><a href="itemProfile">Create Items</a></li>
			<li><a href="items">List of Items</a></li>
            <li><a href="cart">Cart</a></li>
		</section>
		<div class="menu" Style="text-align: left;">Menu


			<ul type="blank" style="list-style: none">
 			<li><a href="index">Home</a> </li>
			<li><a href="gologin">Login</a></li>
            <li><a href="CustProfile01">Create Account</a></li>
            <li><a href="customers">List of Customers</a></li>
            <li><a href="itemProfile">Create Items</a></li>
			<li><a href="items">List of Items</a></li>
            <li><a href="cart">Cart</a></li>
			</ul>
		</div>

		<!--  800 221 1605 maralei  -->
		<div class="main" Style="text-align: left;">
			<h1>List of Customer</h1>
			<p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th><h5>ID</h5></th>
						<th><h5>First Name</h5></h5></th>
						<th><h5>Last Name</h5></th>
						<th><h5>Email</h5></th>
						<th><h5>Address line 1</h5></th>
						<th><h5>Address line 2</h5></th>
						<th><h5>City</h5></th>
						<th><h5>State</h5></th>
						<th><h5>Zip Code</h5></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${customerList}" var="customer">
						<tr>
							<th>${customer.cid}</th>
							<th>${customer.cFname}</th>
							<th>${customer.cLname}</th>
							<th>${customer.cEmail}</th>
							<th>${customer.cAddressLine1}</th>
							<th>${customer.cAddressLine2}</th>
							<th>${customer.cCity}</th>
							<th>${customer.cState}</th>
							<th>${customer.cZipCode}</th>
<%-- 							<th>${customer.}</th> --%>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="footer">Footer</div>
</body>
</html>