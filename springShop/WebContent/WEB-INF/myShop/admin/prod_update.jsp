<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_update.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<form name="f" action="prod_update.do" method="post" 
				enctype="multipart/form-data">
	<input type="hidden" name="pnum" value="${getProduct.pnum}">				
	<table border="1" width="70%">
		<caption>��ǰ����</caption>
		<tr>
			<th width="20%" bgcolor="orange">ī�װ�</th>
			<td>
				<input type="text" name="pcategory_fk" 
				value="${getProduct.pcategory_fk}" disabled>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ��ȣ</th>
			<td align="left">${getProduct.pnum}</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ��</th>
			<td align="left"><input type="text" name="pname" 
						value="${getProduct.pname}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">����ȸ��</th>
			<td align="left"><input type="text" name="pcompany"
						value="${getProduct.pcompany}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ�̹���</th>
			<td align="left">
				<img src="${upPath}/${getProduct.pimage}" width="60" height="60">
				<input type="file" name="pimage">
				<input type="hidden" name="pimage2" value="${getProduct.pimage}">
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ����</th>
			<td align="left"><input type="text" name="pqty" value="${getProduct.pqty}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ����</th>
			<td align="left"><input type="text" name="price" value="${getProduct.price}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ����</th>
			<td align="left">
				<select name="pspec">
					<c:forTokens var="spec" items="NORMAL,HIT,BEST,NEW" delims=",">
						<c:if test="${getProduct.pspec == spec}">
							<option value="${spec}" selected>${spec}</option>
						</c:if>
						<c:if test="${getProduct.pspec != spec}">
							<option value="${spec}">${spec}</option>
						</c:if>
					</c:forTokens>
				</select>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ�Ұ�</th>
			<td align="left">
				<textarea name="pcontents" rows="5" cols="50">${getProduct.pcontents}</textarea>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">��ǰ����Ʈ</th>
			<td align="left"><input type="text" name="point" value="${getProduct.point}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="��ǰ ����">
				<input type="reset" value="���">
			</td>
		</tr>
	</table>			
</form>
</div>

<%@ include file="bottom.jsp"%>