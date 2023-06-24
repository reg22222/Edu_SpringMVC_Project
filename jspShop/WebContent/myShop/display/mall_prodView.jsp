<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="myshop.*"%>
<!-- mall_prodView.jsp -->
<%
	String pnum = request.getParameter("pnum");
	String select = request.getParameter("select");
	String upPath = request.getServletContext().getRealPath("/myShop/img");
%>
<jsp:useBean id="prolist" class="myshop.mall.ProductList" scope="session"/>
<%
	ProductDTO pdto = prolist.getProduct(select, Integer.parseInt(pnum));
%>
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
	function goCart(){
		document.f.action="mall_cartAdd.jsp"
		document.f.submit()
	}
</script>
<div align="center">
	<table border="0" width="99%">
		<tr>
			<td>
				<img src="<%=upPath%>/<%=pdto.getPimage()%>" width="200" height="200">
			</td>
			<td>
				<form name="f" method="post">
				상품번호 : <%=pdto.getPnum()%><br>
				상품이름 : <%=pdto.getPname()%><br>
				상품가격 : <font color="red"><%=pdto.getPrice()%></font>원<br>
				상품포인트 : <font color="red"><%=pdto.getPoint()%></font>point<br>
				상품갯수 : <input type="text" name="pqty" size="3" value="1">개<br><br>
				<input type="hidden" name="select" value="<%=select%>">
				<input type="hidden" name="pnum" value="<%=pnum%>">
				<a href="javascript:goCart()">장바구니</a>
				<a href="javascript:goOrder()">즉시구매</a>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<b>상품 상세 설명</b><br>
				<%=pdto.getPcontents()%>
			</td>
		</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>