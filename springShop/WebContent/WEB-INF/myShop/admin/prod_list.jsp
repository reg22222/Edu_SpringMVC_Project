<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_list.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = window.confirm("정말로 삭제하시겠습니까?")
		if (isDel){
			location.href="prod_delete.do?pnum="+pnum+"&pimage="+pimage;
		}
	}
</script>
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
		<c:if test="${empty listProduct}">
		<tr>
			<td colspan="8">등록된 상품이 없습니다.</td>
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
				<a href="prod_update.do?pnum=${pdto.pnum}">수정</a>|
				<a href="javascript:checkDel('${pdto.pnum}','${pdto.pimage}')">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>