<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, student.*"%>
<!-- list.jsp -->
<html>
<head>
	<title>�л����</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>���̵�</th>
				<th>�л���</th>
				<th width="50%">�б޸�</th>
			</tr>
			<!-- DB�� �����ؼ� �ڷḦ �޾ƿͼ� ���⿡ ����ϸ� �ȴ�. -->
<jsp:useBean id="stdao" class="student.StudentDAO"/>			
<%			List<StudentDTO> list = stdao.listStudent(); 
			if (list == null || list.size() == 0){%>
			<tr>
				<td colspan="3">��ϵ� �л��� �����ϴ�.</td>
			</tr>	
<%			}else {
				for(StudentDTO dto : list){%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getCname()%></td>
			</tr>
<%				}
			}%>			
		</table>
	</div>
</body>
</html>








