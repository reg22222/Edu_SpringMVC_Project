<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list.jsp -->
<html>
<head>
	<title>�л����</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>���̵�</th>
				<th>�л���</th>
				<th width="50%">�б޸�</th>
			</tr>
			<!-- DB�� �����ؼ� �ڷḦ �޾ƿͼ� ���⿡ ����ϸ� �ȴ�. -->
		<c:if test="${empty listStudent}">
			<tr>
				<td colspan="3">��ϵ� �л��� �����ϴ�.</td>
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







