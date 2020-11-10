<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kisaan-Seva</title>
</head>
<body>
	<br>
	<form action="login" method="post">
		<fieldSet style="padding:1rem;">
			<legend>Login User</legend>
			<label for="username">Username:</label> 
			<input type="text" id="username" name="username" /> 
			<br> 
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" /> 
			<br> 
			<input type="submit" value="LOGIN" />
		</fieldSet>
	</form>
</body>
</html>