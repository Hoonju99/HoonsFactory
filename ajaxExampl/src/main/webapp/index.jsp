<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="main.do"> -> memberInsert.do -> memberList.jsp
<input type="submit">
</form> -->
이름: <input type="text" name="first_name"><br>
나이: <input type="number" name="salary"><br>
<button onclick="save_emp()">저장</button>


<div id="show"></div>

<script>
	function save_emp() {
		var fnElem = document.querySelector('input[name="first_name"]');
		var saElem = document.querySelector('input[name="salary"]');
		
		var fnv = fnElem.value;
		var sav = saElem.value;
		
		
		var xhtp = new XMLHttpRequest();
		xhtp.open('post', 'DataServlet.do');
		xhtp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhtp.send('firstName=' +fnv+'&salary='+sav);   // firstName=Par&salary=1000
		xhtp.onload = function() {
			console.log(xhtp.responseText);
			var result = JSON.parse(xhtp.responseText);
			var show = document.querySelector('#show>ul');
			
			var liTag = document.createElement('li');
			liTag.innerText = '이름:' + result.name + ', 나이:' + result.age;
			
			show.prepend(liTag);
		}
	}


	var xhtp = new XMLHttpRequest();  //  ajax: 비동기방식 데이터요청 처리
	xhtp.open('get', 'DataServlet.do');  //  data.json => DataServlet
	xhtp.send();
	xhtp.onload = function() {
		var result = xhtp.responseText;
		result = JSON.parse(result);   //  json -> object타입으로 변경
		console.log(result);
		var show = document.getElementById("show");
		var tag = "<ul>";
		for(let i=0; i<result.length; i++) {
			console.log('이름:' + result[i].name + ', 나이:' + result[i].age);
			tag += '<li>이름:' + result[i].name + ', 나이:' + result[i].age + '</li>';
		}
		tag += "<ul>";	
		show.innerHTML = tag;   //   {name:"HONG",age:20}
		
		
	}
	
</script>
</body>
</html>