<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.text.*"%>
<!-- mall_cgProdList.jsp -->
<%@ include file="mall_top.jsp" %>
<jsp:useBean id="prolist" class="myshop.mall.ProductList" scope="session"/>
<%
	request.setCharacterEncoding("EUC-KR");
	String code = request.getParameter("code");
	String cname = request.getParameter("cname");
%>
<div align="center">
	<h3>Welcome to My Mall</h3>
<%	DecimalFormat df = new DecimalFormat("###,###");
	String upPath = config.getServletContext().getRealPath("/myShop/img");
	List<ProductDTO> plist = prolist.selectByCode(code);
	if (plist==null || plist.size()==0) {
		out.println("<b>"+cname+"상품이 없습니다.</b>");
	}else {%>
		<hr color="green" width="80%">
		<font size="3" color="red"><%=cname%></font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<%	int count = 0;
			for(ProductDTO pdto : plist){
				count++;%>
				<td align="center">
					<a href="mall_prodView.jsp?pnum=<%=pdto.getPnum()%>&select=<%=code%>">
						<img src="<%=upPath%>/<%=pdto.getPimage()%>" width="80" height="80"><br>
					</a>
					<%=pdto.getPname()%><br>
					<font color="red"><%=df.format(pdto.getPrice())%></font>원<br>
					<font color="green"><%=pdto.getPoint()%></font>
				</td>				
<%				if (count%3 == 0) {%>
				</tr><tr>
<%				}
			}%>
			</tr>
		</table>
<%	}%>
	
</div>	
<%@ include file="mall_bottom.jsp"%>