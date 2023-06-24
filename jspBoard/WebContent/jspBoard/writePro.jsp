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
			alert("게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.")
			location.href="list.jsp"
		</script>	
<%	}else {%>
		<script type="text/javascript">
			alert("게시글 등록 실팩!! 게시글 등록 페이지로 이동합니다.")
			location.href="writeForm.jsp"
		</script>
<%	}%>