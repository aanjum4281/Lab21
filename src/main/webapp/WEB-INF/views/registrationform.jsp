<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Form action determines the next URL path
	     These match the @RequestMapping path in the controller
	     that handles the form submission. -->
	<form action="/summary">
	<!-- Input names determine the URL parameters.
			     These match the @RequestParam annotations
			     in the controller that handles the form submission. -->
		<p> Fist: <input name="first"/> </p>
		<p> Last: <input name="last"/> </p>
		<p> Email: <input name="email"/> </p>
		<p> Phone: <input name="phone"/> </p>
		<p> Password: <input name="password"/> </p>
		
		<p>
			<!-- Clicking a button will submit the form. -->
			<button type="submit">Register!</button>
		</p>
	</form>

</body>
</html>