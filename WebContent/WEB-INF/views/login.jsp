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
<!-- 	<section class="navbar" align= "left" > -->
<!--  			<li><a href="index">Home</a> </li> -->
<!-- 			<li><a href="login">Login</a></li> -->
<!--             <li><a href="CustProfile01">Create Account</a></li> -->
<!--             <li><a href="customers">Customers</a></li> -->
<!--             <li><a href="itemProfile">Item Profile</a></li> -->
<!-- 			<li><a href="customers">Items</a></li> -->
<!--             <li><a href="cart">Cart</a></li> -->

<!-- </section> -->




        <div class="menu" Style="text-align:left;">Menu

            <ul type="blank" style="list-style: none" >
			<li><a href="index">Home</a> </li>
			<li><a href="gologin">Login</a></li>
            <li><a href="CustProfile01">Register</a></li>
            <li><a href="customers">Customers</a></li>
            <li><a href="itemProfile">Item Profile</a></li>
			<li><a href="customers">Items</a></li>
            <li><a href="cart">Cart</a></li>
            </ul>
        </div>
     <div class="main"><h1>GrandView Login</h1>
<!--         method="POST" -->
        <form action="login" method="POST" style="align: left;" >
			<table class="table table-striped">
        		<tr><td><label for="cEmail">username</label>
				<td><input type="text" name="cEmail" placeholder="username"></td>
				<tr><td><label for="cPassword">password</label></td> 
				<td><input type="password" name="cPassword" placeholder="password"></td>
        		<tr><td><Input type ="submit" name ="send" value ="Login">
				<td><input type="reset" value="Reset">
        </table>
			</form>
        
        
        
	</div>
        <div class="footer">
        	<h2>MESSAGE:${messageResult}</h2>	
        
       </div>
    </div>

</body>
</html>