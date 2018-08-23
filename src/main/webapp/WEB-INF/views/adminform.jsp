<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/summary" method= "post">
	
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
                    <td>
						<a href="/admin-form ${ items.id }/update" class="btn btn-light btn-sm">Edit</a>
						<a href="/admin-form ${ items.id }/delete" class="btn btn-light btn-sm">Delete</a>
					</td>
                </tr>
               
                </c:forEach>
            </tbody>
        </table>
	
	<p> <a href="/add-item">Add an Item</a>  </p>
	
	
	</form>
</body>
</html>