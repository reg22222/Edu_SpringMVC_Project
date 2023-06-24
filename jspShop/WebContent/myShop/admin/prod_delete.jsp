<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.io.*"%>
<!-- prod_delete.jsp -->
<%
	String pnum = request.getParameter("pnum");
	String pimage = request.getParameter("pimage");
	String upPath = request.getServletContext().getRealPath("/myShop/img");
%>
<jsp:useBean id="pdao" class="myshop.ProductDAO"/>
<%
	int res = pdao.deleteProduct(Integer.parseInt(pnum));
	String msg = null, url = "prod_list.jsp";
	if (res>0){
		File file = new File(upPath, pimage);
		if (file.exists()){
			file.delete();
			msg = "파일삭제성공(이미지도 삭제 성공)!! 상품목록페이지로 이동합니다.";
		}else {
			msg = "파일삭제성공(이미지 삭제는 실패)!! 상품목록페이지로 이동합니다.";
		}
	}else {
		msg = "파일삭제실패!! 상품목록페이지로 이동합니다.";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>








