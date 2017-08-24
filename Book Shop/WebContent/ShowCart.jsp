<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	
	<%@ page import="bookshop.javabeans.CartBean" %>
	<h1>Cart Items:</h1>
	<% 	CartBean cart=(CartBean)session.getAttribute("cart");
		for(String book:cart.getCartItems()) { 
		%>    
            <h3><%=book%></h3>
    <% } %>
    
   <form action='controller?forward=logout' method='post'>
		<input type='submit' value='Logout'/>
	</form>
</body>
</html>