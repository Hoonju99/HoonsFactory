<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>user_jquery.jsp</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form id="form1" name="form1" class="form-horizontal">
			<h2>사용자 등록 및 수정</h2>
			<div class="form-group">
				<label>아이디:</label> <input type="text" class="form-control"
					name="id">
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control"
					name="name">
			</div>
			<div class="form-group">
				<label>패스워드:</label> <input type="text" class="form-control"
					name="password">
			</div>
			<div class="form-group">
				<label>역할:</label> <select class="form-control" name="role">
					<option value="Admin">관리자</option>
					<option value="User">사용자</option>
				</select>
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록" id="btnInsert" /> 
				<input type="button" class="btn btn-primary" value="수정" id="btnUpdate" /> 
				<input type="button" class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<h2>사용자 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">아이디</th>
					<th class="text-center">패스워드</th>
					<th class="text-center">이름</th>
					<th class="text-center">롤</th>
					<th class="text-center"></th>
				</tr>
			</thead>
			
			<tbody>
				<!-- <tr>
					<td class="text-center">user</td>
					<td class="text-center">1111</td>
					<td class="text-center">홍길동</td>
					<td class="text-center">User</td>
					<td class="text-center">
						<button class="btnUpd">조회</button>
						<button class="btnDel">삭제</button>
					</td>
				</tr> -->
			</tbody>
		</table>
	</div>
	<script>	
	//등록버튼 :직접이벤트
	function userInsert(){	}
	
	//수정버튼 :직접이벤트
	function userUpdate(){	}

	//조회버튼  : 그룹이벤트
	function userSelect(){	}
		
	//삭제버튼  : 그룹이벤트
	function userDelete(){	}

	//목록조회
	function list() {
		$.ajax(url)
		 .done(function(datas){})
	}
	
	function makeTr(user) {	}
	
	$(function(){
		userInsert();
		userUpdate();
		userSelect();
		userDelete();
		list();
	})	
	</script>
</body>
</html>