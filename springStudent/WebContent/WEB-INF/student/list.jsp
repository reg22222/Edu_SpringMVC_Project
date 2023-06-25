<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list.jsp -->
<html>
<head>
	<title>학생목록</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 목 록 페 이 지</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>아이디</th>
				<th>학생명</th>
				<th width="50%">학급명</th>
			</tr>
			<!-- DB에 연결해서 자료를 받아와서 여기에 출력하면 된다. -->
		<c:if test="${empty listStudent}">
			<tr>
				<td colspan="3">등록된 학생이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${listStudent}">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.cname}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>








