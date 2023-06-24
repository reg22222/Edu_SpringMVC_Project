<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_delete.jsp -->
<%
	String cnum = request.getParameter("cnum");
%>
<jsp:useBean id="cdao" class="myshop.CategoryDAO"/>
<%
	int res = cdao.deleteCategory(Integer.parseInt(cnum));
	if (res>0){%>
		<script type="text/javascript">
			alert("카테고리 삭제 성공!! 카테고리 목록페이지로 이동합니다.")
			location.href="list.jsp";
		</script>	
<%	}else {%>
		<script type="text/javascript">
			alert("카테고리 삭제 실패!! 카테고리 목록페이지로 이동합니다.")
			location.href="list.jsp";
		</script>
<%	}%>