<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>회원관리</title>
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
		<div align="right">${loginMember.name}님이 로그인 중...</div>
	</c:if>
	<table border="1" width="800" height="650">
		<tr height="50">
			<th><a href="javascript:checkMember()">회원가입</a></th>
			<th><a href="member_list.do">회원보기</a></th>
			<th><a href="member_list.do?mode=find">회원찾기</a></th>
			<th>
				<c:if test="${empty loginMember}">
					<a href="login.do">로그인</a>
				</c:if>
				<c:if test="${not empty loginMember}">
					<a href="logout.do">로그아웃</a>
				</c:if>
			</th>
		</tr>
		<tr>
			<td colspan="4">
			
			
			
			
			
			
			
			