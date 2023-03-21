<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/additem.css" />

</head>
<body>
<div class="Container">

            <h1>Login</h1>
	<form action="Controller" method="post">
		    <input type="hidden" name="actionControl" value="login">
		    <label for="nom">Name:</label><br>
			<input type="text" name="nom" placeholder="name">
			<label for="password">Password:</label><br>	
			<input type="password" name="password" placeholder="password">
			<label for="type">Type:</label><br>		
		<select name="type">
		    <option value="Employee">Employee</option>
		    <option value="Admin">Admin</option>
		    <option value="Sous Admin">Sous Admin</option>
		</select>
			<input type="submit" value="submit">
	</form>
	</div>
</body>
</html>