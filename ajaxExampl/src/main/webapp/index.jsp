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
�̸�: <input type="text" name="first_name"><br>
����: <input type="number" name="salary"><br>
<button onclick="save_emp()">����</button>


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
			liTag.innerText = '�̸�:' + result.name + ', ����:' + result.age;
			
			show.prepend(liTag);
		}
	}


	var xhtp = new XMLHttpRequest();  //  ajax: �񵿱��� �����Ϳ�û ó��
	xhtp.open('get', 'DataServlet.do');  //  data.json => DataServlet
	xhtp.send();
	xhtp.onload = function() {
		var result = xhtp.responseText;
		result = JSON.parse(result);   //  json -> objectŸ������ ����
		console.log(result);
		var show = document.getElementById("show");
		var tag = "<ul>";
		for(let i=0; i<result.length; i++) {
			console.log('�̸�:' + result[i].name + ', ����:' + result[i].age);
			tag += '<li>�̸�:' + result[i].name + ', ����:' + result[i].age + '</li>';
		}
		tag += "<ul>";	
		show.innerHTML = tag;   //   {name:"HONG",age:20}
		
		
	}
	
</script>
</body>
</html>