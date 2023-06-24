<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, student.*"%>
<!-- find.jsp -->
<%
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	if (name == null || name.trim().equals("")){
		response.sendRedirect("student.jsp");
		return;
	}
%>
<jsp:useBean id="stdao" class="student.StudentDAO" />
<%
	List<StudentDTO> find = stdao.findStudent(name);
%>
<html>
<head>
	<title>�л�ã��</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� ã �� �� �� ��</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>���̵�</th>
				<th>�л���</th>
				<th width="50%">�б޸�</th>
			</tr>
			<!-- DB�� �����ؼ� �ڷḦ �޾ƿͼ� ���⿡ ����ϸ� �ȴ�. -->
<%			if (find == null || find.size() == 0){%>
			<tr>
				<td colspan="3">ã���ô� �л��� �����ϴ�.</td>
			</tr>	
<%			}else {
				for(StudentDTO dto : find){%>
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