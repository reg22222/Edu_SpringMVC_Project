<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- insert.jsp -->
<% request.setCharacterEncoding("EUC-KR");  %>
<jsp:useBean id="stdto" class="student.StudentDTO"/>
<jsp:setProperty property="*" name="stdto"/>
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<%
	int res = stdao.insertStudent(stdto);
	if (res > 0){%>
		<script type="text/javascript">
			alert("�л���ϼ���!! �л������������ �̵��մϴ�.")
			location.href="list.jsp"
		</script>
<%	}else {%>
		<script type="text/javascript">
			alert("�л���Ͻ���!! �л������������� �̵��մϴ�.")
			location.href="student.jsp"
		</script>
<%	}%>