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
	<div><h1>�� �� ��</h1></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">�� �� ��</th>
						<td width="200">
							<input type="email" id="id" name="id" placeholder="Enter your Email">
						</td>
					</tr>
					<tr>
						<th width="150">�н�����</th>
						<td width="200">
							<input type="password" id="password" name="password" placeholder="Enter your password">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="�α���">&nbsp;&nbsp;
				<input type="reset" value="�� ��">
			</div>
		</form>
	</div>
</div>
</body>
</html>