<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, myshop.*"%>
<!-- cate_list.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<table border="1" width="600">
		<caption>카테고리목록</caption>
		<tr bgcolor="yellow">
			<th>번호</th>
			<th>카테고리코드</th>
			<th>카테고리 명</th>
			<th>삭제</th>
		</tr>
	<jsp:useBean id="cdao" class="myshop.CategoryDAO"/>
<%	List<CategoryDTO> clist = cdao.listCategory(); 
	if (clist == null || clist.size() == 0){%>
		<tr>
			<td colspan="4">등록된 카테고리가 없습니다.</td>
		</tr>
<%	}else { 
		for (CategoryDTO dto : clist){%>
		<tr>
			<td><%=dto.getCnum()%></td>
			<td><%=dto.getCode()%></td>
			<td><%=dto.getCname()%></td>
			<td>
				<a href="cate_delete.jsp?cnum=<%=dto.getCnum()%>">
					삭제
				</a>
			</td>
		</tr>
<%		} 
	}%>			
	</table>
</div>
<%@ include file="bottom.jsp"%>