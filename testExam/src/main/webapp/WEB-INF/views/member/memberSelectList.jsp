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
	<div><h1>회원목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="150">아이디</th>
					<th width="150">이 름</th>
					<th width="150">전화번호</th>
					<th width="150">주 소</th>
					<th width="150">권 한</th>
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
		<button type="button" onclick="location.href='home.do'">홈 가기</button>
	</div>
</div>
</body>
</html>