<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.oreilly.servlet.*, java.io.*"%>
<!-- prod_update_ok.jsp -->
<%
	MultipartRequest mr = null;
	String upPath = config.getServletContext().getRealPath("/myShop/img");
	try{
		mr = new MultipartRequest(request,upPath,10*1024*1024,"EUC-KR");
	}catch(IOException e){
		out.println("<h2>파일 업로드 실패</h2>");
		e.printStackTrace();
	}
%>
<jsp:useBean id="pdao" class="myshop.ProductDAO"/>
<%
	int res = pdao.updateProduct(mr);	
	if (res>0){%>
		<script type="text/javascript">
			alert("상품수정 성공!! 상품목록페이지로 이동합니다.")
			location.href="prod_list.jsp"
		</script>
<%	}else {%>  
		<script type="text/javascript">
			alert("상품수정 실패!! 상품수정페이지로 이동합니다.")
			location.href="prod_update.jsp?pnum="+mr.getParameter("pnum");
		</script>
<%	}%>





