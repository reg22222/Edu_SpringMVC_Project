<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- updatePro.jsp -->
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="bdto" class="board.BoardDTO"/>
<jsp:setProperty property="*" name="bdto"/>
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
	int res = bdao.updateBoard(bdto);
	String msg = null, url = null;
	if (res>0){
		msg = "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.";
		url = "list.jsp";
	}else if (res<0){
		msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
		url = "updateForm.jsp?num=" + bdto.getNum();
	}else {
		msg = "�Խñ� ���� ����!! �Խñ� �󼼺����������� �̵��մϴ�.";
		url = "content.jsp?num=" + bdto.getNum();
	}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>


