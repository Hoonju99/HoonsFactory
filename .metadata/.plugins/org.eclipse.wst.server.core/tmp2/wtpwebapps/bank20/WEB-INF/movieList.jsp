<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<h3>��ȭ���</h3>
<div id="list"></div>
<script>
	let url = "firstMovieNm";
	$.ajax({url:url})
	.done(function(dates){
		$("list").html(datas);
	})
</script>

</body>
</html>