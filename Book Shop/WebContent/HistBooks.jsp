<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History Books</title>
</head>
<body>
	<h2>Welcome <%= session.getAttribute("username")%></h2>
	
	<form action='controller?forward=showcart' method='post'>
		<input type='checkbox' value='H1'  name='hist'> H1<br>
		<input type='checkbox' value='H2' name='hist'> H2<br>
		<input type='checkbox' value='H3' name='hist'> H3<br>
		<input type='submit' value='Next'>
	</form>
</body>
</html>