<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="myshop.*"%>
<!-- prod_update.jsp -->
<%@ include file="top.jsp"%>
<jsp:useBean id="pdao" class="myshop.ProductDAO"/>
<%
	String pnum = request.getParameter("pnum");
	ProductDTO pdto = pdao.getProduct(Integer.parseInt(pnum));
	String upPath = config.getServletContext().getRealPath("/myShop/img");
%>
<div align="center">
<form name="f" action="prod_update_ok.jsp" method="post" 
				enctype="multipart/form-data">
	<input type="hidden" name="pnum" value="<%=pnum%>">				
	<table border="1" width="70%">
		<caption>상품수정</caption>
		<tr>
			<th width="20%" bgcolor="orange">카테고리</th>
			<td>
				<input type="text" name="pcategory_fk" 
				value="<%=pdto.getPcategory_fk()%>" disabled>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품번호</th>
			<td align="left"><%=pdto.getPnum()%></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품명</th>
			<td align="left"><input type="text" name="pname" 
						value="<%=pdto.getPname()%>"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">제조회사</th>
			<td align="left"><input type="text" name="pcompany"
						value="<%=pdto.getPcompany()%>"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품이미지</th>
			<td align="left">
				<img src="<%=upPath%>/<%=pdto.getPimage()%>" width="60" height="60">
				<input type="file" name="pimage">
				<input type="hidden" name="pimage2" value="<%=pdto.getPimage()%>">
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품수량</th>
			<td align="left"><input type="text" name="pqty" value="<%=pdto.getPqty()%>"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품가격</th>
			<td align="left"><input type="text" name="price" value="<%=pdto.getPrice()%>"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품스팩</th>
			<td align="left">
				<select name="pspec">
<%					String[] spec = new String[]{"NORMAL", "HIT", "BEST", "NEW"};
					for(String str : spec){
						if (str.equals(pdto.getPspec())){%>
					<option value="<%=str%>" selected><%=str.toLowerCase()%></option>		
<%						}else {%>
					<option value="<%=str%>"><%=str.toLowerCase()%></option>								
<%						}
					}%>			
				</select>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품소개</th>
			<td align="left">
				<textarea name="pcontents" rows="5" cols="50"><%=pdto.getPcontents()%></textarea>
			</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="orange">상품포인트</th>
			<td align="left"><input type="text" name="point" value="<%=pdto.getPoint()%>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="상품 수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>			
</form>
</div>

<%@ include file="bottom.jsp"%>