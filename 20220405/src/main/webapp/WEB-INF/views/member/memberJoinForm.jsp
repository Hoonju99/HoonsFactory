<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<td width="300">
							<input type="email" id="id" name="id">
							<span><button type="button" onclick="idCheck()">중복체크</button></span>
						</td>
					</tr>
					<tr>
						<th width="100">패스워드</th>
						<td width="200">
							<input type="password" id="password" name="password">
						</td>
					</tr>
					<tr>
						<th width="100">패스워드 확인</th>
						<td width="200">
							<input type="password" id="pwd" name="pwd">
						</td>
					</tr>
					<tr>
						<th width="100">이 름</th>
						<td width="200">
							<input type="text" id="name" name="name">
						</td>
					</tr>
					<tr>
						<th width="100">주 소</th>
						<td width="200">
							<input type="text" id="address" name="address">
						</td>
					</tr>
					<tr>
						<th width="100">전화번호</th>
						<td width="200">
							<input type="text" id="tel" name="tel">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취 소">&nbsp;&nbsp;&nbsp;
				<input type="button" value="홈 가기" onclick="location.href='home.do'">	
			</div>				
		</form>
	</div>
</div>
<script>
	function idCheck(){
		var id = frm.id.value;
		var url = "ajaxIdCheck.do?id="+id;
/*		
		fetch(url,{
			method  :'post',
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded',
			},
			body : 'id='+id
		})
			.then(response => response.text())
//			.then( successFunction(response)) 함수를 이용해서 처리하는 경우
			.then(text=>alert(text)) */
		var xhtp = new XMLHttpRequest();
		xhtp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				if(this.responseText == 'Yes'){
					idCheckSuccess();
				}else{
					 idCheckFail();
				}
			}
		};
		xhtp.open('get', url);
		xhtp.send();
	}
	
	function idCheckSuccess(){
		alert("이미 존재하는 아이디 입니다.");		
		frm.id.value="";
		frm.id.focus();
	}
	
	function idCheckFail(){
		alert("사용 가능한 아이디 입니다.");
		frm.password.focus();		
	}
</script>
</body>
</html>