<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<main class="container">
		<h1>${ title }</h1>
		
		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form  action="update-item-form">
		<input name="id" value="${items.id }" type="hidden">
			<div class="form-group">
			    <label for="name">Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			    <input class="form-control" id="name" name="name" value="${items.name}" required minlength="2" autocomplete="off">
			</div>
			
			<div class="form-group">
			    <label for="description">Description</label>
			    <input class="form-control" id="description" name="description" value="${items.description}" required minlength="3">
			</div>
			
			<div class="form-group">
			    <label for="category">Quantity</label>
			    <input class="form-control" id="quantity" name="quantity" value="${items.quantity}" required>
			</div>
			<div class="form-group">
			    <label for="price">Price</label>
			    <input class="form-control" id="price" name="price" value="${items.price}" required>
			</div>
		<!-- 	<button type="submit" class="btn btn-primary">Submit</button> -->
			<button type="submit" "btn btn-light btn-primary">Submit</button>
			<a href="/" class="btn btn-link">Cancel</a>
		</form>
	</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>