<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_list.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<table border="1" width="600">
		<caption>ī�װ����</caption>
		<tr bgcolor="yellow">
			<th>��ȣ</th>
			<th>ī�װ��ڵ�</th>
			<th>ī�װ� ��</th>
			<th>����</th>
		</tr>
	<c:if test="${empty listCate}">
		<tr>
			<td colspan="4">��ϵ� ī�װ��� �����ϴ�.</td>
		</tr>
	</c:if>
	<c:forEach var="cdto" items="${listCate}">
		<tr>
			<td>${cdto.cnum}</td>
			<td>${cdto.code}</td>
			<td>${cdto.cname}</td>
			<td>
				<a href="cate_delete.do?cnum=${cdto.cnum}">
					����
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>