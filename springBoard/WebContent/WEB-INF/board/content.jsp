<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- content.jsp -->
<html>
<head>
	<title>글상세보기</title>
</head>
<body>
	<div align="center">
		<b>글내용 보기</b>
		<table border="1" width="600">
			<tr>
				<th bgcolor="yellow" width="20%">글번호</th>
				<td align="center" width="30%">${getBoard.num}</td>
				<th bgcolor="yellow" width="20%">조회수</th>
				<td align="center" width="30%">${getBoard.readcount}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">작성자</th>
				<td align="center" width="30%">${getBoard.writer}</td>
				<th bgcolor="yellow" width="20%">작성일</th>
				<td align="center" width="30%">${getBoard.reg_date}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글제목</th>
				<td align="center" colspan="3">${getBoard.subject}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글내용</th>
				<td align="center" colspan="3">
					<textarea rows="10" cols="60">${getBoard.content}</textarea>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="4">
					<input type="button" value="글수정" 
					onclick="window.location='board_update.do?num=${getBoard.num}'">
					<input type="button" value="글삭제" 
					onclick="window.location='board_delete.do?num=${getBoard.num}'">
					<input type="button" value="글목록" 
					onclick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>














