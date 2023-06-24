<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<!-- content.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
	String num = request.getParameter("num");
	if (num == null || num.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
	
	BoardDTO dto = bdao.getBoard(Integer.parseInt(num), "content");
%>
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
				<td align="center" width="30%"><%=dto.getNum()%></td>
				<th bgcolor="yellow" width="20%">��ȸ��</th>
				<td align="center" width="30%"><%=dto.getReadcount()%></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td align="center" width="30%"><%=dto.getWriter()%></td>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td align="center" width="30%"><%=dto.getReg_date()%></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">������</th>
				<td align="center" colspan="3"><%=dto.getSubject()%></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�۳���</th>
				<td align="center" colspan="3">
					<textarea rows="10" cols="60"><%=dto.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="4">
					<input type="button" value="�ۼ���" 
					onclick="window.location='updateForm.jsp?num=<%=dto.getNum()%>'">
					<input type="button" value="�ۻ���" 
					onclick="window.location='deleteForm.jsp?num=<%=dto.getNum()%>'">
					<input type="button" value="�۸��" 
					onclick="window.location='list.jsp'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>














