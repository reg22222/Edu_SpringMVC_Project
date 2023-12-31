<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_input.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<form name="f" action="prod_input.do" method="post" 
				enctype="multipart/form-data">
	<table border="1" width="70%">
		<caption>상품등록카테고리</caption>
		<tr>
			<th width="20%" bgcolor="orange">카테고리</th>
			<td align="left">
				<select name="code">
				<c:forEach var="cdto" items="${listCate}">
					<option value="${cdto.code}">
						${cdto.cname}[${cdto.code}]
					</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품명</th>
			<td align="left"><input type="text" name="pname"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품코드</th>
			<td align="left"><input type="text" name="pcode"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">제조회사</th>
			<td align="left"><input type="text" name="pcompany"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품이미지</th>
			<td align="left">
				<input type="file" name="pimage">
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품수량</th>
			<td align="left"><input type="text" name="pqty"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품가격</th>
			<td align="left"><input type="text" name="price"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품스팩</th>
			<td align="left">
				<select name="pspec">
					<option value="NORMAL">normal</option>
					<option value="HIT">hit</option>
					<option value="BEST">best</option>
					<option value="NEW">new</option>
				</select>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품소개</th>
			<td align="left">
				<textarea name="pcontents" rows="5" cols="50"></textarea>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품포인트</th>
			<td align="left"><input type="text" name="point"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="상품 등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>			
</form>
</div>
<%@ include file="bottom.jsp"%>
















