<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_input.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<form name="f" action="cate_input.do" method="post">
		<table border="1" width="300" height="150">
			<caption>카테고리 등록</caption>
			<tr>
				<th bgcolor="yellow" width="40%">카테고리코드</th>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="40%">카테고리이름</th>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="orange" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>	
	</form>
</div>
<%@ include file="bottom.jsp"%>