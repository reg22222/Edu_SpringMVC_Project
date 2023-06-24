<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, myshop.*"%>
<!-- prod_list.jsp -->
<%@ include file="top.jsp"%>
<jsp:useBean id="pdao" class="myshop.ProductDAO"/>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = window.confirm("정말로 삭제하시겠습니까?")
		if (isDel){
			location.href="prod_delete.jsp?pnum="+pnum+"&pimage="+pimage;
		}
	}
</script>
<%
	List<ProductDTO> plist = pdao.listProduct(); 
%>
<div align="center">
	<table border="1" width="100%">
		<caption>상품목록</caption>
		<tr>
			<th>번호</th>
			<th>코드</th>
			<th>상품명</th>
			<th>이미지</th>
			<th>가격</th>
			<th>제조사</th>
			<th>수량</th>
			<th>수정|삭제</th>
		</tr>
<%		if (plist == null || plist.size() == 0){ %>
		<tr>
			<td colspan="8">등록된 상품이 없습니다.</td>
		</tr>
<%		}else {
			String upPath = config.getServletContext().getRealPath("/myShop/img");
			for(ProductDTO pdto : plist){%>
		<tr>
			<td><%=pdto.getPnum()%></td>
			<td><%=pdto.getPcategory_fk()%></td>
			<td><%=pdto.getPname()%></td>
			<td>
				<a href="prod_view.jsp?pnum=<%=pdto.getPnum()%>">
					<img src="<%=upPath%>/<%=pdto.getPimage()%>" width="40" height="40">
				</a>
			</td>
			<td><%=pdto.getPrice()%></td>
			<td><%=pdto.getPcompany()%></td>
			<td><%=pdto.getPqty()%></td>
			<td>
				<a href="prod_update.jsp?pnum=<%=pdto.getPnum()%>">수정</a>|
				<a href="javascript:checkDel('<%=pdto.getPnum()%>','<%=pdto.getPimage()%>')">삭제</a></td>
		</tr>
<%			} 
		}%>		
	</table>
</div>
<%@ include file="bottom.jsp"%>