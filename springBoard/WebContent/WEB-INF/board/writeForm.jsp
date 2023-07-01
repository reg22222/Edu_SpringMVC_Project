<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeForm.jsp -->
<html>
<head>
	<title>글쓰기</title>
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
		<form name="f" action="board_write.do" method="post"
			onsubmit="return check()">
			<table border="1" width="410">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">글 쓰 기</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">이 름</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">제 목</th>
					<td><input type="text" name="subject" size="40"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">이메일</th>
					<td><input type="text" name="email" size="40"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">내 용</th>
					<td><textarea cols="40" rows="14" name="content"></textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="글쓰기">
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