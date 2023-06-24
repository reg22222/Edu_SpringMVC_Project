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
	<title>학생찾기</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 찾 기 페 이 지</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>아이디</th>
				<th>학생명</th>
				<th width="50%">학급명</th>
			</tr>
			<!-- DB에 연결해서 자료를 받아와서 여기에 출력하면 된다. -->
<%			if (find == null || find.size() == 0){%>
			<tr>
				<td colspan="3">찾으시는 학생이 없습니다.</td>
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