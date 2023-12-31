<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- updateForm.jsp -->
<html>
<head>
	<title>글수정</title>
	<script type="text/javascript">
		function check(){
			if (f.writer.value == ""){
				alert("이름을 입력해 주세요!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value == ""){
				alert("제목을 입력해 주세요!!")
				f.subject.focus()
				return false
			}
			if (f.content.value == ""){
				alert("내용을 입력해 주세요!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value == ""){
				alert("비밀번호을 입력해 주세요!!")
				f.passwd.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>
	<div align="center">
		<form name="f" action="board_update.do" method="post"
			onsubmit="return check()">
			<input type="hidden" name="num" value="${getBoard.num}"/>
			<h3>글 수 정</h3>
			<table border="1" width="410">
				<tr>
					<th bgcolor="yellow" width="20%">이 름</th>
					<td><input type="text" name="writer"
					 value="${getBoard.writer}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">제 목</th>
					<td><input type="text" name="subject" size="40"
					value="${getBoard.subject}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">이메일</th>
					<td><input type="text" name="email" size="40"
					value="${getBoard.email}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">내 용</th>
					<td><textarea cols="40" rows="14" name="content">${getBoard.content}</textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="글수정">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" 
						onclick="window.location='board_list.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>