<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memer_form</title>
<link href = "css/memberFormStyle.css" rel="stylesheet" type="text/css">

<%
String signinMsg = (String)request.getAttribute("signin");
if(signinMsg == "existUser"){
	response.setContentType("text/html; charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.println("<script>alert('uesrname already exist');</script>");
}

if(signinMsg == "pwdDosentEqual"){
	response.setContentType("text/html; charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.println("<script>alert('passwords dosent equal');</script>");
}

%>
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
		<input type = "password" name ="cnfPass"></input>
		
		<input type="submit" id="sign-in" value ="sign in"></input>
	</form>
</div>
</body>
</html>