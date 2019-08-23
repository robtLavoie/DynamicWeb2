<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRANDVIEW</title>
<link href="Resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Resources/js/bootstrap.min.js"></script>
 <link href="Resources/css/grandview.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="grid-container">
	<div class="header"><h1>Grandview Drones and Helicopters</h1></div>
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
		<div class="main">
		<h1>Create Account</h1>
			<form action="addCustomer" method="POST" style="align: left;" >
			<table class="table table-striped">
			<tr><td><label for="un">username, use you email address</label>
				<td><input type="text" name="un" placeholder="username"></td>
			<tr><td><label for="id">Verify Email</label></td> 
				<td><input type="text" name="cEmail"placeholder="Email"></td> 
			<tr><td><label for="pass">password</label></td> 
				<td><input type="password" name="cPassword" placeholder="password"></td>
			<tr><td><label for="cid">cid</label></td> 
				<td><input type="text" name="cid"placeholder="CID"></td> 
			<tr><td><label for="cfname">First name</label></td> 
				<td><input type="text" name="cFname"placeholder="first name"></td> 
			<tr><td><label for="cLname">Last Name</label></td> 
				<td><input type="text" name="cLname" placeholder="last name"></td> 
			<tr><td><label for="cAddressline1">Address Line 1</label></td> 
				<td><input type="text" name="cAddressLine1" placeholder="address line 1"> 
			<tr><td><label for="cAddressline2">Address Line 2</label></td> 
				<td><input type="text" name="cAddressLine2"placeholder="address line 2(optional)"> 
			<tr><td><label for="cCity">City</label></td> 
				<td><input type="text" name="cCity" placeholder="city">
			<tr><td><label for="cState">State</label></td> 
				<td><input type="text" name="cState" placeholder="stste"></td>
				<td>
			<tr><td><label for="cZipCode">Zip</label></td> 
				<td><input type="text" name="cZipCode" placeholder="zip"></td>
				<br><br><br>
			<tr><td><Input type ="submit" name ="send" value ="Save"></td>
				<td><input type="reset" value="Reset"></td>
				</table>
			</form>


		</div>
	
		<div class="footer">Footer
	
		<h2>MESSAGE:${messageResult}</h2>	
					
					
	
		
		</div>
		
	</div>

</body>
</html>