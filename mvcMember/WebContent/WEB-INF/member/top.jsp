<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
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
	<table border="1" width="800" height="650">
		<tr height="50">
			<th><a href="javascript:checkMember()">회원가입</a></th>
			<th>회원보기</th>
			<th>회원찾기</th>
			<th>로그인</th>
		</tr>
		<tr>
			<td colspan="4">