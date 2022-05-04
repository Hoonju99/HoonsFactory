<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<br />
</div>
<div align="center">
	<div>
		<h3>문의사항</h3>
	</div>
	<form id="frm" name="frm" action="notice.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>
			<c:forEach var="vo" items="#">
				<tr onclick="#">
					<td align="center"></td>
					<td align="center"></td>
					<td align="center"></td>
					<td align="center"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		&nbsp;&nbsp;&nbsp;
		<c:if test="">
			<button type="button" onClick="location.href='noticeForm.do'">등록</button>
		</c:if>
	</div>
	<div>
		
	</div>
</div>