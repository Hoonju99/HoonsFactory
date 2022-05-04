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
	<div><h1>로 그 인</h1></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아 이 디</th>
						<td width="200">
							<input type="email" id="id" name="id" placeholder="Enter your Email">
						</td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td width="200">
							<input type="password" id="password" name="password" placeholder="Enter your password">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="로그인">&nbsp;&nbsp;
				<input type="reset" value="취 소">
			</div>
		</form>
	</div>
</div>
</body>
</html>