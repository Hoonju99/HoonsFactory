<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>ȸ�����</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="150">���̵�</th>
					<th width="150">�� ��</th>
					<th width="150">��ȭ��ȣ</th>
					<th width="150">�� ��</th>
					<th width="150">�� ��</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList }" var="member">
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.tel }</td>
						<td>${member.address }</td>
						<td>${member.author }</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div><br>
	<div>
		<button type="button" onclick="location.href='home.do'">Ȩ ����</button>
	</div>
</div>
</body>
</html>