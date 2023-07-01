<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_list.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<table border="1" width="600">
		<caption>카테고리목록</caption>
		<tr bgcolor="yellow">
			<th>번호</th>
			<th>카테고리코드</th>
			<th>카테고리 명</th>
			<th>삭제</th>
		</tr>
	<c:if test="${empty listCate}">
		<tr>
			<td colspan="4">등록된 카테고리가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="cdto" items="${listCate}">
		<tr>
			<td>${cdto.cnum}</td>
			<td>${cdto.code}</td>
			<td>${cdto.cname}</td>
			<td>
				<a href="cate_delete.do?cnum=${cdto.cnum}">
					삭제
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>