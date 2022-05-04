<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<h3>todo list</h3>
<input id="title"> <button id="btn">등록</button>
<div id="list">
	<div data-id="1">title completed</div>
</div>
<script>
	const url = "https://jsonplaceholder.typicode.com/todos"
	
	//등록
	$("#btn").on("click", function(){
		$.ajax({
			url : url,
			method :'POST',
			data :JSON.stringify({ title: $("#title").val(), userId :"kim", completed: false }),
			contentType : "application/json"	
		}).done(function(response){
			console.log(response)
		});
	})
	
	//조회
	$.ajax(url)
	.done(function(data){
		 for(todo of data){
			 //div 태그 생성해서 추가
			 let div = $("<div>")
			 div.data("id", data.id)
	 		    .html(todo.title)
	 		    .appendTo($("#list"))
	 		    
			 //completed가 true 이면(실행완료) color = red
	 		 if(todo.completed) {
	 			div.css("color","red");
	 		 }
		 }
	})
</script>
</body>
</html>