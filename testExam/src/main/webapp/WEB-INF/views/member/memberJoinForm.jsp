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
	<div><h1>ȸ������</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">���̵�</th>
						<td width="300">
							<input type="email" id="id" name="id">
						</td>
					</tr>
					<tr>
						<th width="100">�н�����</th>
						<td width="200">
							<input type="password" id="password" name="password">
						</td>
					</tr>
					<tr>
						<th width="100">�н����� Ȯ��</th>
						<td width="200">
							<input type="password" id="pwd" name="pwd">
						</td>
					</tr>
					<tr>
						<th width="100">�� ��</th>
						<td width="200">
							<input type="text" id="name" name="name">
						</td>
					</tr>
					<tr>
						<th width="100">�� ��</th>
						<td width="200">
							<input type="text" id="address" name="address">
						</td>
					</tr>
					<tr>
						<th width="100">��ȭ��ȣ</th>
						<td width="200">
							<input type="text" id="tel" name="tel">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="ȸ������">&nbsp;&nbsp;&nbsp;
				<input type="button" value="Ȩ ����" onclick="location.href='home.do'">	
			</div>				
		</form>
	</div>
</div>
</body>
</html>