<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- deletePro.jsp -->
<%
	String num = request.getParameter("num");
	String passwd = request.getParameter("passwd");
%>
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
	int res = bdao.deleteBoard(Integer.parseInt(num), passwd);
	String msg = null, url = null;
	if (res>0){
		msg = "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.";
		url = "list.jsp";
	}else if (res<0){
		msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
		url = "deleteForm.jsp?num=" + num;
	}else {
		msg = "�Խñ� ���� ����!! �Խñ� �󼼺����������� �̵��մϴ�.";
		url = "content.jsp?num=" + num;
	}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>






