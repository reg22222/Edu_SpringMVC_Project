<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_view.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<form name="f" action="prod_list.do" method="post">
		<table border="1" width="80%">
			<caption>��ǰ�󼼺���</caption>
			<tr>
				<th bgcolor="orange" width="15%">ī�װ�</th>
				<td width="35%">${getProduct.pcategory_fk}</td>
				<th bgcolor="orange" width="15%">��ǰ��ȣ</th>
				<td width="35%">${getProduct.pnum}</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">��ǰ��</th>
				<td width="35%">${getProduct.pname}</td>
				<th bgcolor="orange" width="15%">����ȸ��</th>
				<td width="35%">${getProduct.pcompany}</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">��ǰ��</th>
				<td align="center" colspan="3">
					<img src="${upPath}/${getProduct.pimage}" width="80" height="80">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">��ǰ����</th>
				<td width="35%">${getProduct.pqty}</td>
				<th bgcolor="orange" width="15%">��ǰ����</th>
				<td width="35%">${getProduct.price}</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">��ǰ����</th>
				<td width="35%">${getProduct.pspec}</td>
				<th bgcolor="orange" width="15%">��ǰ����Ʈ</th>
				<td width="35%">${getProduct.point}</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">��ǰ�Ұ�</th>
				<td colspan="3">
					<textarea name="pcontents" rows="5" cols="70">${getProduct.pcontents}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="���ư���">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>