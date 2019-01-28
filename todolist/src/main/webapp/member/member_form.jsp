<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memer_form</title>
<link href = "css/todolist.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class = "login-form">
	<h1>Sign-in</h1>
	<form action = "/mavenweb/ToDoListController" method = "post" >
		<input type="hidden" name="command" value="regist">
		<p>user-name</p>
		<input type = "text" name ="user"></input>
		
		<p>password</p>
		<input type = "password" name = "pass"></input>
		
		<p>confirm-password</p>
		<input type = "password"></input>
		
		<input type="submit" id="sign-in" value ="sign in"></input>
	</form>
</div>
</body>
</html>