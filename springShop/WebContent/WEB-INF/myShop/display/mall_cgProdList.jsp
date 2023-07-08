<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.text.*"%>
<!-- mall_cgProdList.jsp -->
<%@ include file="mall_top.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div align="center">
	<h3>Welcome to My Mall</h3>
	<c:if test="${empty code}">
		<b>${param.cname} 상품이 없습니다.</b>
	</c:if>	
	<c:if test="${not empty code}">
		<hr color="green" width="80%">
		<font size="3" color="red">${param.cname}</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="pdto" items="${code}">
		<c:set var="count" value="${count+1}"/>	
				<td align="center">
					<a href="mall_prodView.do?pnum=${pdto.pnum}&select=${param.code}">
						<img src="${upPath}/${pdto.pimage}" width="80" height="80"><br>
					</a>
					${pdto.pname}<br>
					<font color="red">
						<fmt:formatNumber value="${pdto.price}" pattern="###,###"/></font>원<br>
					<font color="green">${pdto.point}</font>
				</td>				
				<c:if test="${count%3 == 0}">
					</tr><tr>
				</c:if>	
			</c:forEach>
			</tr>
		</table>
	</c:if>
	
</div>	
<%@ include file="mall_bottom.jsp"%>