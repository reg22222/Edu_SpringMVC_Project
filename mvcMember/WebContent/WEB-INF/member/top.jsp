<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>ȸ������</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
		function checkMember(){
			window.open("member_ssn.do", "", "width=650, height=400")
		}
	</script>
</head>
<body>
	<div align="center">
	<c:if test="${not empty loginMember}">
		<div align="right">${loginMember.name}���� �α��� ��...</div>
	</c:if>
	<table border="1" width="800" height="650">
		<tr height="50">
			<th><a href="javascript:checkMember()">ȸ������</a></th>
			<th><a href="member_list.do">ȸ������</a></th>
			<th><a href="member_list.do?mode=find">ȸ��ã��</a></th>
			<th>
				<c:if test="${empty loginMember}">
					<a href="login.do">�α���</a>
				</c:if>
				<c:if test="${not empty loginMember}">
					<a href="logout.do">�α׾ƿ�</a>
				</c:if>
			</th>
		</tr>
		<tr>
			<td colspan="4">
			
			
			
			
			
			
			
			