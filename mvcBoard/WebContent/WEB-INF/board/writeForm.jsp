<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeForm.jsp -->
<html>
<head>
	<title>�۾���</title>
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
		<form name="f" action="board_writePro.do" method="post"
			onsubmit="return check()">
			<table border="1" width="410">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">�� �� ��</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="subject" size="40"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�̸���</th>
					<td><input type="text" name="email" size="40"></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><textarea cols="40" rows="14" name="content"></textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">��й�ȣ</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="�۾���">
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