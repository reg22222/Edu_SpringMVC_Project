<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writePro.jsp -->
<% request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bdto" class="board.BoardDTO"/>
<jsp:setProperty property="*" name="bdto"/>
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
	String ip = request.getRemoteAddr();
	bdto.setIp(ip);
	int res = bdao.insertBoard(bdto);
	if (res>0){%>
		<script type="text/javascript">
			alert("�Խñ� ��� ����!! �Խñ� ��� �������� �̵��մϴ�.")
			location.href="list.jsp"
		</script>	
<%	}else {%>
		<script type="text/javascript">
			alert("�Խñ� ��� ����!! �Խñ� ��� �������� �̵��մϴ�.")
			location.href="writeForm.jsp"
		</script>
<%	}%>