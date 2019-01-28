<%@ page language = "java" contentType ="text/html; charset = UTF-8" %>
<!doctype html>
<html>
<head>
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

<script>
window.onload = function(){
	var btn = document.getElementById("sign_in_btn");
	btn.onclick = function(){
		location.assign("ToDoListController?command=signin_form");
	};
};
</script>
</head>

<body>
<div class = "login-box">
	<h1>Login</h1><br>
	<form action = "ToDoListController?command=Login" method = "post">	
		
		<input type = "text" name="user" placeholder="Username"></input><br/>
		<input type = "password" name="pass" placeholder="Password"></input><br/>
		
		<input type = "submit" id="Login" name="login" value ="login"></input><br/>
		<button id="sign_in_btn" type=button >sign in</button>
	</form>
	
</div>
</body>

</html>
