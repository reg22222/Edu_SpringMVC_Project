<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, board.*"%>
<!-- list.jsp -->
<html>
<head>
	<title>�Խ���</title>
</head>
<body>
	<div align="center">
		<b>�� �� ��</b><br>
		<table border="0" width="650">
			<tr bgcolor="yellow">
				<td align="right"><a href="writeForm.jsp">�۾���</a></td>
			</tr>
		</table>
		<table border="1" width="650">
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th width="40%">����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ</th>
				<th>IP</th>
			</tr>
		<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%		List<BoardDTO> list = bdao.listBoard(); 
		if (list == null || list.size() == 0){%>
			<tr>
				<td colspan="6">��ϵ� �Խñ��� �����ϴ�.</td>
			</tr>
<%		}else { 
			for(BoardDTO dto : list){%>
			<tr>
				<td><%=dto.getNum()%></td>
				<td><a href="content.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a></td>
				<td><%=dto.getWriter()%></td>
				<td><%=dto.getReg_date()%></td>
				<td><%=dto.getReadcount()%></td>
				<td><%=dto.getIp()%></td>
			</tr>
<%			} 
		}%>							
		</table>
		
	</div>
</body>
</html>











