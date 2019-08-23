<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRANDVIEW</title>
<link rel = "stylesheet" href="Resources/css/grandview.css"/>
<link href="Resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Resources/js/bootstrap.min.js"></script>
 <link href="Resources/css/grandview.css" rel="stylesheet" type="text/css" />
 
 <script type="text/javascript">
 function button1()
 {
     document.form1.buttonName.value = "yes";
     form1.submit();
 } 
 </script>

</head>
<body>
<div class="grid-container">
        	<div class="header"><h1>Grandview Drones and Helicopters</h1> </div>
<section class="navbar" align= "left" >
 			<li><a href="index">Home</a> </li>
			<li><a href="${pageContext.request.contextPath}/gologin">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/CustProfile01">Create Account</a></li>
            <li><a href="${pageContext.request.contextPath}/customers">List of Customers</a></li>
            <li><a href="${pageContext.request.contextPath}/itemProfile">Create Items</a></li>
			<li><a href="${pageContext.request.contextPath}/items">List of Items</a></li>
            <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
</section>
        <div class="menu" Style="text-align:left;">Menu
            <ul type="blank" style="list-style: none" >
 			<li><a href="${pageContext.request.contextPath}/index">Home</a> </li>
			<li><a href="${pageContext.request.contextPath}/gologin">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/CustProfile01">Create Account</a></li>
            <li><a href="${pageContext.request.contextPath}/customers">List of Customers</a></li>
            <li><a href="${pageContext.request.contextPath}/itemProfile">Create Items</a></li>
			<li><a href="${pageContext.request.contextPath}/items">List of Items</a></li>
            <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul> 
        </div>
        
        <div class="main" Style="text-align: left"">
        	<h1 class="h1">Items</h1>
			<table class="table table-striped" style="text-size:4px">
                 <thead >
                      <tr >
                           <th>#</th>
                           <th>Item</th>
                           <th>Description</th>
                           <th>Price</th>
                           <th>-----</th>
                           <th>add to cart</th>
                      </tr> 
                </thead> 
                
            <tbody>
<!-- 	Show Item that the custmer can add to cart -->
			<c:forEach items="${itemList}" var="item">
				<tr class="fontlist">
					<th>${item.id} </th>	
					<th>${item.iName}</th>
					<th>${item.iDescription}</th>
					<th>${item.iPrice}</th> 
<%-- 					<th>${item.SalePrice}</th>  --%>
					<th><img src="Resources/img/${item.iPicture}" alt="image" style="
							hight: 100px; width: 100px;"> ${item.iPicture}</th> 
					<th><a href="${pageContext.request.contextPath}/additems1/${item.getId()}">  <button type="button" class="btn btn-primary btn-sm">Add</button> </a></th>
				<tr>
			</c:forEach>  
			    
        		</tbody>
        		<tr>
        		<tr>
<!--      		<td></td><td><button type="button" class=\"btn btn-danger\" action="button2()">make cart</button></th> -->
        		
         	</table>
  <form action="addOrders" method="POST" style="align: left;" >
  
  </form>       	

        </div>
        
       <div class="footer">
       		<h2>MESSAGE:${messageResult}</h2>
       		
<%--        		<p>Hi, ${sCustomer.cEmail}</p>   --%>
<!--        		<p>cart list</p> -->
<!--  			<tbody> -->
<%-- 			<c:forEach items="	" var="item"> --%>
<!-- 				<tr class="fontlist"> -->
<%-- 					<th>${item.id} </th>	 --%>
<%-- 					<th>${item.iName}</th> --%>
<%-- 					<th>${item.iDescription}</th> --%>
<%-- 					<th>${item.iPrice}</th>  --%>
<!-- 				<tr> -->
<%-- 			</c:forEach>       --%>
<!--         	</tbody> -->
       </div>

</div>
</body>
</html>