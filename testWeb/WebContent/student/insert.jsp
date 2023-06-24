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
			alert("학생등록성공!! 학생목록페이지로 이동합니다.")
			location.href="list.jsp"
		</script>
<%	}else {%>
		<script type="text/javascript">
			alert("학생등록실패!! 학생관리페이지로 이동합니다.")
			location.href="student.jsp"
		</script>
<%	}%>