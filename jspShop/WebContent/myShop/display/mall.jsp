<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.text.*"%>
    
<!-- mall.jsp -->
<%@ include file="mall_top.jsp" %>
<jsp:useBean id="prolist" class="myshop.mall.ProductList" scope="session"/>
<div align="center">
	<h3>Welcome to My Mall</h3>
<%	DecimalFormat df = new DecimalFormat("###,###");
	String upPath = config.getServletContext().getRealPath("/myShop/img");
	List<ProductDTO> plist = prolist.selectByPspec("HIT");
	if (plist==null || plist.size()==0) {
		out.println("<b>HIT상품이 없습니다.</b>");
	}else {%>
		<hr color="green" width="80%">
		<font size="3" color="red">H I T</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<%	int count = 0;
			for(ProductDTO pdto : plist){
				count++;%>
				<td align="center">
					<a href="mall_prodView.jsp?pnum=<%=pdto.getPnum()%>&select=HIT">
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
<%	}
	List<ProductDTO> plist2 = prolist.selectByPspec("BEST");
	if (plist2==null || plist2.size()==0) {
		out.println("<b>BEST상품이 없습니다.</b>");
	}else {%>
		<hr color="green" width="80%">
		<font size="3" color="red">BEST</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<%	int count = 0;
			for(ProductDTO pdto : plist2){
				count++;%>
				<td align="center">
					<a href="mall_prodView.jsp?pnum=<%=pdto.getPnum()%>&select=BEST">
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
<%	}
	List<ProductDTO> plist3 = prolist.selectByPspec("NEW");
	if (plist3==null || plist3.size()==0) {
		out.println("<b>NEW상품이 없습니다.</b>");
	}else {%>
		<hr color="green" width="80%">
		<font size="3" color="red">N E W</font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
		<%	int count = 0;
			for(ProductDTO pdto : plist3){
				count++;%>
				<td align="center">
					<a href="mall_prodView.jsp?pnum=<%=pdto.getPnum()%>&select=NEW">
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
				














