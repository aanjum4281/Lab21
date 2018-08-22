<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<link rel= "stylesheet" href= "/style.css"/>  
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>
	<body>
		<div>
			<h1> WELCOME TO THE COFFEE SHOP</h1>
			
			<h2> <img src="images/download.jpeg"> </h2>
			
			
			<table class="table">
            <thead>
                <tr>
                  <th>Item</th><th>Price</th> <th>Description</th><th>Quantity</th><th> Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="items" items="${items}">
                
                <tr>
                    <td>${items.id} </td><td>${items.name}</td><td>${items.description}</td><td>${items.quantity}</td>
                    <td>${items.price}</td>
                </tr>
               
                </c:forEach>
            </tbody>
        </table>
     
    
               
			
			<p> <a href="/registration-form">Register</a> </p>
		</div>
	
	</body>
</html>