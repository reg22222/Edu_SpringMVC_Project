<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_list.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = window.confirm("������ �����Ͻðڽ��ϱ�?")
		if (isDel){
			location.href="prod_delete.do?pnum="+pnum+"&pimage="+pimage;
		}
	}
</script>
<div align="center">
	<table border="1" width="100%">
		<caption>��ǰ���</caption>
		<tr>
			<th>��ȣ</th>
			<th>�ڵ�</th>
			<th>��ǰ��</th>
			<th>�̹���</th>
			<th>����</th>
			<th>������</th>
			<th>����</th>
			<th>����|����</th>
		</tr>
		<c:if test="${empty listProduct}">
		<tr>
			<td colspan="8">��ϵ� ��ǰ�� �����ϴ�.</td>
		</tr>
		</c:if>
		<c:forEach var="pdto" items="${listProduct}">
		<tr>
			<td>${pdto.pnum}</td>
			<td>${pdto.pcategory_fk}</td>
			<td>${pdto.pname}</td>
			<td>
				<a href="prod_view.do?pnum=${pdto.pnum}">
					<img src="${upPath}/${pdto.pimage}" width="40" height="40">
				</a>
			</td>
			<td>${pdto.price}</td>
			<td>${pdto.pcompany}</td>
			<td>${pdto.pqty}</td>
			<td>
				<a href="prod_update.do?pnum=${pdto.pnum}">����</a>|
				<a href="javascript:checkDel('${pdto.pnum}','${pdto.pimage}')">����</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>