<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- content.jsp -->
<html>
<head>
	<title>�ۻ󼼺���</title>
</head>
<body>
	<div align="center">
		<b>�۳��� ����</b>
		<table border="1" width="600">
			<tr>
				<th bgcolor="yellow" width="20%">�۹�ȣ</th>
				<td align="center" width="30%">${getBoard.num}</td>
				<th bgcolor="yellow" width="20%">��ȸ��</th>
				<td align="center" width="30%">${getBoard.readcount}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td align="center" width="30%">${getBoard.writer}</td>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td align="center" width="30%">${getBoard.reg_date}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">������</th>
				<td align="center" colspan="3">${getBoard.subject}</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�۳���</th>
				<td align="center" colspan="3">
					<textarea rows="10" cols="60">${getBoard.content}</textarea>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="4">
					<input type="button" value="�ۼ���" 
					onclick="window.location='board_update.do?num=${getBoard.num}'">
					<input type="button" value="�ۻ���" 
					onclick="window.location='board_delete.do?num=${getBoard.num}'">
					<input type="button" value="�۸��" 
					onclick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>














