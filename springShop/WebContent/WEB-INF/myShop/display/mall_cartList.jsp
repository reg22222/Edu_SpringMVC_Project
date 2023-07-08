<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="mall_top.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table width="99%" border="1" align="center">
	<tr class="m2">
		<td colspan="6" align="center">
			<h4>장바구니 보기</h4>
		</td>
	</tr>
	<tr class="m1">
		<th width="10%">번호</th>
		<th width="30%">상품명</th>
		<th width="10%">수량</th>
		<th width="20%">단가</th>
		<th width="20%">금액</th>
		<th width="10%">삭제</th>
	</tr>
	<c:set var="cartTotalPrice" value="0"/>	
	<c:set var="cartTotalPoint" value="0"/>
	<c:if test="${empty cart}">
	<tr>
		<td colspan="6">장바구니가 비었습니다.</td>
	</tr>
	</c:if>
	<c:forEach var="dto" items="${cart}">
	<tr>
		<td align="center">${dto.pnum}</td>
		<td align="center">
			<img src="${upPath}/${dto.pimage}" width="40" height="40"><br>
			<b>${dto.pname}</b>
		</td>
		<td align="center">
			<form name="f" method="post" action="mall_cartEdit.do">
				<br>
				<input type="text" size="3" name="pqty" value="${dto.pqty}">개
				<input type="hidden" name="pnum" value="${dto.pnum}">
				<input type="submit" value="수정">
			</form>			
		</td>
		<td align="right">
			<b>
				<fmt:formatNumber value="${dto.price}" pattern="###,###"/>
			</b>원<br>
			[${dto.point}] point</b>
		</td>	
		<td align="right">
			<font color="red">
			<b><fmt:formatNumber value="${dto.price*dto.pqty}" pattern="###,###"/>원<br>
			[${dto.point*dto.pqty}] point</b>
			</font>
		</td>
		<td align="center">
			<a href="mall_cartDel.do?pnum=${dto.pnum}">삭제</a>	
		</td>
	</tr>
		<c:set var="cartTotalPrice" value="${dto.price*dto.pqty + cartTotalPrice}"/>
		<c:set var="cartTotalPoint" value="${dto.point*dto.pqty + cartTotalPoint}"/>
	</c:forEach>	
	<tr class="m1">
		<td colspan="4"><b>장바구니 총액</b> : 
			<font color="red"><fmt:formatNumber value="${cartTotalPrice}" pattern="###,###"/>원<br></font>
			<font color="green">총 적립 포인트 : [${cartTotalPoint}] point</font>	
		</td>
		<td colspan="2">
			<a href="mall_order.do">[주문하기]</a>
			<a href="javascript:history.go(-2);">[계속쇼핑]</a>
		</td>
	</tr>
		
</table>	
<%@ include file="mall_bottom.jsp"%>