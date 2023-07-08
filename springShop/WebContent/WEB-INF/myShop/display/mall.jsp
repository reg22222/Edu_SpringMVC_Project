<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.text.*"%>
    
<!-- mall.jsp -->
<%@ include file="mall_top.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="center">
	<h3>Welcome to My Mall</h3>
	<c:if test="${empty hit}">
		<b>HIT상품이 없습니다.</b>
	</c:if>
	<c:if test="${not empty hit}">
		<hr color="green" width="80%">
		<font size="3" color="red">H I T</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="pdto" items="${hit}">
		<c:set var="count" value="${count+1}"/>		
				<td align="center">
					<a href="mall_prodView.do?pnum=${pdto.pnum}&select=HIT">
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
	<c:if test="${empty best}">
		<b>BEST상품이 없습니다.</b>
	</c:if>
	<c:if test="${not empty best}">
		<hr color="green" width="80%">
		<font size="3" color="red">B E S T</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="pdto" items="${best}">
		<c:set var="count" value="${count+1}"/>		
				<td align="center">
					<a href="mall_prodView.do?pnum=${pdto.pnum}&select=BEST">
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
	<c:if test="${empty newa}">
		<b>NEW상품이 없습니다.</b>
	</c:if>
	<c:if test="${not empty newa}">
		<hr color="green" width="80%">
		<font size="3" color="red">N E W</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="pdto" items="${newa}">
		<c:set var="count" value="${count+1}"/>		
				<td align="center">
					<a href="mall_prodView.do?pnum=${pdto.pnum}&select=NEW">
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
				














