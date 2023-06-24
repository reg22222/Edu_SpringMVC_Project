<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="myshop.*"%>
<!-- prod_view.jsp -->
<%@ include file="top.jsp"%>
<jsp:useBean id="pdao" class="myshop.ProductDAO"/>
<%
	String pnum = request.getParameter("pnum");
	ProductDTO pdto = pdao.getProduct(Integer.parseInt(pnum));
	String upPath = config.getServletContext().getRealPath("/myShop/img");
%>
<div align="center">
	<form name="f" action="prod_list.jsp" method="post">
		<table border="1" width="80%">
			<caption>상품상세보기</caption>
			<tr>
				<th bgcolor="orange" width="15%">카테고리</th>
				<td width="35%"><%=pdto.getPcategory_fk()%></td>
				<th bgcolor="orange" width="15%">상품번호</th>
				<td width="35%"><%=pdto.getPnum()%></td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">상품명</th>
				<td width="35%"><%=pdto.getPname()%></td>
				<th bgcolor="orange" width="15%">제조회사</th>
				<td width="35%"><%=pdto.getPcompany()%></td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">상품명</th>
				<td align="center" colspan="3">
					<img src="<%=upPath%>/<%=pdto.getPimage()%>" width="80" height="80">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">상품수량</th>
				<td width="35%"><%=pdto.getPqty()%></td>
				<th bgcolor="orange" width="15%">상품가격</th>
				<td width="35%"><%=pdto.getPrice()%></td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">상품스팩</th>
				<td width="35%"><%=pdto.getPqty()%></td>
				<th bgcolor="orange" width="15%">상품포인트</th>
				<td width="35%"><%=pdto.getPoint()%></td>
			</tr>
			<tr>
				<th bgcolor="orange" width="15%">상품소개</th>
				<td colspan="3">
					<textarea name="pcontents" rows="5" cols="70"><%=pdto.getPcontents()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="돌아가기">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>