<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- updateForm.jsp -->
<html>
<head>
	<title>�ۼ���</title>
	<script type="text/javascript">
		function check(){
			if (f.writer.value == ""){
				alert("�̸��� �Է��� �ּ���!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value == ""){
				alert("������ �Է��� �ּ���!!")
				f.subject.focus()
				return false
			}
			if (f.content.value == ""){
				alert("������ �Է��� �ּ���!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value == ""){
				alert("��й�ȣ�� �Է��� �ּ���!!")
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
			<h3>�� �� ��</h3>
			<table border="1" width="410">
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="writer"
					 value="${getBoard.writer}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="subject" size="40"
					value="${getBoard.subject}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�̸���</th>
					<td><input type="text" name="email" size="40"
					value="${getBoard.email}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><textarea cols="40" rows="14" name="content">${getBoard.content}</textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">��й�ȣ</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="�ۼ���">
						<input type="reset" value="�ٽ��ۼ�">
						<input type="button" value="��Ϻ���" 
						onclick="window.location='board_list.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>