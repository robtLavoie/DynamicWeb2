<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRANDVIEW</title>
<<link href="Resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Resources/js/bootstrap.min.js"></script>
 <link href="Resources/css/grandview.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="grid-container">
 	<div class="header"><h1>Grandview Drones and Helicopters</h1></div>
 
<section class="navbar" align="left">
 			<li><a href="index">Home</a> </li>
			<li><a href="gologin">Login</a></li>
            <li><a href="CustProfile01">Create Account</a></li>
            <li><a href="customers">List of Customers</a></li>
            <li><a href="itemProfile">Create Items</a></li>
			<li><a href="items">List of Items</a></li>
            <li><a href="cart">Cart</a></li>
			
</section>

        <div class="menu" Style="text-align:left;">Menu


            <ul type="blank" style="list-style: none" >
 				<li><a href="index">Home</a> </li>
				<li><a href="gologin">Login</a></li>
       	     	<li><a href="CustProfile01">Create Account</a></li>
            	<li><a href="customers">List of Customers</a></li>
            	<li><a href="itemProfile">Create Items</a></li>
				<li><a href="items">List of Items</a></li>
            	<li><a href="cart">Cart</a></li>
             </ul>
        </div>
        
        <div class="main"><h1><img src="Resources/img/cart.png" alt="cart" style="hight: 100px; width: 100px;">GrandView Cart</h1></div>
        
        
        
        
        
        
		</div>
    	<div class="footer">
        	<h2>MESSAGE:${messageResult}</h2>
    	</div>
    </div>

</body>
</html>