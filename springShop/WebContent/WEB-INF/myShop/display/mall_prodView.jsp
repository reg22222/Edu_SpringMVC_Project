<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_prodView.jsp -->
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
	function goCart(){
		document.f.action="mall_cartAdd.do"
		document.f.submit()
	}
</script>
<div align="center">
	<table border="0" width="99%">
		<tr>
			<td>
				<img src="${upPath}/${getProduct.pimage}" width="200" height="200">
			</td>
			<td>
				<form name="f" method="post">
				상품번호 : ${getProduct.pnum}<br>
				상품이름 : ${getProduct.pname}<br>
				상품가격 : <font color="red">${getProduct.price}</font>원<br>
				상품포인트 : <font color="red">${getProduct.point}</font>point<br>
				상품갯수 : <input type="text" name="pqty" size="3" value="1">개<br><br>
				<input type="hidden" name="select" value="${param.select}">
				<input type="hidden" name="pnum" value="${param.pnum}">
				<a href="javascript:goCart()">장바구니</a>
				<a href="javascript:goOrder()">즉시구매</a>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<b>상품 상세 설명</b><br>
				 ${getProduct.pcontents}
			</td>
		</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>