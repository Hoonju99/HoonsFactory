<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	.active { background-color : green; color : white }
</style>
</head>
<body>
	<input id="book">
	<ul>
		<li data-isbn="102" data-price="500"><span>스프링</span></li>
		<li data-isbn="103" data-price="600"><span>자바</span></li>
		<li data-isbn="104" data-price="700"><span>스프링</span></li>
	</ul>
	<script>
		$("#book").on("keypress",function(){
			if(event.keyCode == 13) { //엔터키
				const newname = $("#book").val();
				const newSpan = $("<span>").html(newname);
				const newLi = $("<li>").append(newSpan)
									   .data("isbn", "101")
				$("ul").append(newLi);
				
				$("#book").val("")
			}
		});
		
		//그룹이벤트(부모에 위임) :동적으로 추가될 태그에도 이벤트가 적용됨
		$("ul").on("mouseover", "span", function(){
			$(this).addClass("active");
			$(this).parent().data("price")
			
		})
		$("ul").on("mouseout", "span", function(){
			$(this).removeClass("active");
		})
	</script>
</body>
</html>