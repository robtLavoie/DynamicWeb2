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
			<div class="header"><h1>Grandview Drones and Helicopters</h1> ADMIN</div>
		<section class="navbar" align="left">
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
            <li><a href="cart">Cart</a></li>			</ul>
		</div>
		<div class="main">
			<h1>Create Item</h1>
			<form action="addItem" method="POST" style="align: left;" >
			<table class="table table-striped">
				<tr><td><label for="Id">ID</label> 
					<td><input type="text" name="id"placeholder="Item ID"> 

				<tr><td><label for="iName">Item Name</label> 
				<td><input type="text" name="iName"placeholder="Item Name"> 
				<tr><td><label for="Description">Description</label> 
				<td><input type="text" name="iDescription" placeholder="Description"> 
				<br>
				<tr><td><label for="Price">Item Price</label> 
				<td><input type="text" name="iPrice" placeholder="Item Price"> 
				<br>
				<tr><td><label for="SalePrice">Vender Price</label> 
				<td><input type="text" name="iSalePrice"placeholder="Vender Price"> 
				<br>
				<tr><td><label for="ImageLink">Image</label> 
				<td><input type="text" name="iPicture" placeholder="Image link">
				<tr><td><Input type ="submit" name ="send" value ="Add">
		
				<td><input type="reset" value="Reset">
				</table>
	
				<h3>Search:</h3><div class="dropdown"> <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </button> <div class="dropdown-menu" aria-labelledby="dropdownMenu1"> <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> </div> </div>
				
			</form>
		</div>
		<div class="footer">Footer
			<h2>MESSAGE:${messageResult}</h2>	
						
		</div>
	</div>

</body>
