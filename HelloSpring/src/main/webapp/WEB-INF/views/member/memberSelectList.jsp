<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	����� ��� ����� ���� �ִ� ��	<p>
<h1>${message }</h1>
		<c:forEach items="${members }" var="member">
	${member.id } : ${member.password } : ${member.name }
</c:forEach>
		<a href="home.do">Ȩ ����</a>
</body>
</html>