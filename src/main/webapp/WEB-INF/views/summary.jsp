<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet" href= "/style.css"/> 
</head>
<body>
<div>

	<h1>Confirmation</h1>
	<h2> <img src="images/tick-305245_960_720.png"> </h2>
	<p>
	Congratulations ${ user.first } ${ user.last }! You are now registered!
	</p>
	<p> Your username is ${ user.username } </p>
	
	<a href="/registration-form">Back to Registration</a>
	 
</div>
</body>
</html>
