<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/todolist.css" rel="stylesheet" type="text/css" >
<script type ="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		loadTodo();
	}
	
	var searchRequest = new XMLHttpRequest();
	var searchDoneRequest = new XMLHttpRequest();
	var inserRequest = new XMLHttpRequest();
	var changeRequest = new XMLHttpRequest();
	
	function loadTodo(){
		searchRequest.open("Post", "./ToDoListController?ajax=true&command=showTables")
		searchRequest.onreadystatechange = loadProcess;
		searchRequest.send(null);
	}
	
	function loadProcess(){
		var tableTodo = document.getElementById("ajaxTodo");
		var tableDone = document.getElementById("ajaxDone");
		tableTodo.innerHTML = "";
		tableDone.innerHTML = "";
		if(searchRequest.readyState == 4 && searchRequest.status == 200){
			var object = eval('(' + searchRequest.responseText + ')');
			var result = object.result;
			for(var i =0; i < result.length; i++){
				
				if(result[i][2].value === "false"){
					var row= tableTodo.insertRow(0);
				}
				
				else if(result[i][2].value === "true"){
					var row= tableDone.insertRow(0);
				}
				
				for(var j = 0; j < result[i].length; j++){
					var cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
					if(j === 2){
						cell.innerHTML = "<input type=\"submit\" class=\"checkBtn\" value=\"" + result[i][j].value + "\"></input>";
						//cell.setAttribute("type", "submit");
					}
					else{
						cell.innerHTML = result[i][j].value;
					}
				}
			}
			
		}
	}
	$(document).on('click', '.checkBtn', function(){
		console.log("isdone");
		var checkBtn = $(this);
		var tr = checkBtn.parent().parent();
		var td = tr.children();
		changeRequest.open("Post", "./ToDoListController?ajax=true&command=changeStatus&todo=" + td.eq(1).text() );
		changeRequest.send(null);
		loadTodo();
	});
	
	
	function changeStatus(){
		var tr = $(this).parent().parent();
		var td = tr.children();
		alert(tr.text());
		alert(td.eq(1).text());
		
		changeRequest.open("Post", "./ToDoListController?ajax=true&command=changeStatus&todo=" + td.eq(1).text() );
		changeRequest.send(null);
		loadTodo();
	}
	
	
	/*
	function loadDone(){
		searchRequest.open("Post", "./ToDoListController?ajax=true&command=showDone");
		searchRequest.onreadystatechange = loadDoneProcess;
		searchRequest.send(null);
	}
	
	function loadDoneProcess(){
		var table = document.getElementById("ajaxDone");
		table.innerHTML = "";
		if(searchRequest.readyState == 4 && searchRequest.status == 200){
			var object = eval('(' + searchRequest.responseText + ')');
			var result = object.result;
			for(var i =0; i < result.length; i++){
				var row= table.insertRow(0);
				for(var j = 0; j < result[i].length; j++){
					var cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				}
			}
			
		}
	}
	*/

	function insertFunction(){
		inserRequest.open("Post", "./ToDoListController?ajax=true&command=insertList"
				+ "&date="+ encodeURIComponent(document.getElementById("date").value)
				+"&todo="+ encodeURIComponent(document.getElementById("todo").value),true
		);
		inserRequest.onreadystatechange = insertProcess;
		inserRequest.send(null);
	}
	
	function insertProcess(){
		if(inserRequest.readyState == 4 && inserRequest.status == 200){
			var result = inserRequest.responseText;
			
			var date = document.getElementById("date");
			var todo = document.getElementById("todo");
			
			date.value = "";
			todo.value="";
			loadTodo();
		}
	}
	
</script>
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
				<p>date : </p><input id = "date" type="date" min="2019-01-01" max="2020-12-31"></input>
				<p>todo : </p><input id = "todo" type="text"></input>
				<input type ="submit" onclick = "insertFunction()"value = "add!"></input>
			</div>
		</div>
		
		<div class="todoBody">

		</div>
	

		<table class ="tableTodo">
			<thead>
				<th> date</th>
				<th> todo</th>
				<th> isdone</th>
			</thead>
			<tbody id = "ajaxTodo">
				
			</tbody>
		</table>
	</div>
	
	<div class ="done">
		<div class ="doneHeader">
			<h1>DONE LIST</h1>
			<p>list of what you done</p>
		</div>
		<div class="doneBody">
			
		</div>
		<table class ="tabledone">
			<thead>
				<th> date</th>
				<th> todo</th>
				<th> isdone</th>
			</thead>
			<tbody id ="ajaxDone">
				
			</tbody>
			</table>
	</div>
</div>
</body>
</html>