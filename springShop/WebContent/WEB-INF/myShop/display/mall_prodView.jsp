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
				��ǰ��ȣ : ${getProduct.pnum}<br>
				��ǰ�̸� : ${getProduct.pname}<br>
				��ǰ���� : <font color="red">${getProduct.price}</font>��<br>
				��ǰ����Ʈ : <font color="red">${getProduct.point}</font>point<br>
				��ǰ���� : <input type="text" name="pqty" size="3" value="1">��<br><br>
				<input type="hidden" name="select" value="${param.select}">
				<input type="hidden" name="pnum" value="${param.pnum}">
				<a href="javascript:goCart()">��ٱ���</a>
				<a href="javascript:goOrder()">��ñ���</a>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<b>��ǰ �� ����</b><br>
				 ${getProduct.pcontents}
			</td>
		</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>