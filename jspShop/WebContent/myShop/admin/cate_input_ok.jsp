<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_input_ok.jsp -->
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="cdto" class="myshop.CategoryDTO"/>
<jsp:setProperty property="*" name="cdto"/>
<jsp:useBean id="cdao" class="myshop.CategoryDAO"/>
<%
	int res = cdao.insertCategory(cdto);
	String msg = null, url = null;
	if (res>0){
		msg = "카테고리등록성공!! 카테고리 목록페이지로 이동합니다.";
		url = "cate_list.jsp";
	}else {
		msg = "카테고리등록실패!! 카테고리 등록페이지로 이동합니다.";
		url = "cate_input.jsp";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>