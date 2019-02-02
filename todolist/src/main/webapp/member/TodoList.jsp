<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/todolist.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class="todolist">
	<div class ="todo">
		<div class="todoHeader">
		<%
			String username = (String)session.getAttribute("userName");
			System.out.println(username);
		%>
			<h1>TODO LIST</h1>
			<p>welcome ${sessionScope.userName} !!</p>
			<p>Insert what you do</p>
			
			<div class ="addtodo">
				<form action ="#" method ="get">
					<p>date : </p><input type="date" min="2019-01-01" max="2020-12-31"></input>
					<p>todo : </p><input type="text"></input>
					<input type ="submit" value = "add!"></input>
				</form>
			</div>
		</div>
		
		<div class="todoBody">

		</div>
		
		<div class = "todoList">
			
		</div>
	</div>
	
	<div class ="done">
		<div class ="doneHeader">
			<h1>DONE LIST</h1>
			<p>list of what you done</p>
		</div>
		<div class="doneBody">
			
		</div>
		<div class = "doneList">
		
		</div>
		
	</div>
</div>
</body>
</html>