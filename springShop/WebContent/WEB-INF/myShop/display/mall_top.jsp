<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>쇼핑몰홈</title>
	<script type="text/javascript">
		function goProlist(code, cname){
			document.f1.code.value = code
			document.f1.cname.value = cname
			document.f1.submit()
		}
	</script>
</head>
<body>
	<div align="center">
		<table border="1" width="800">
			<tr height="50">
				<td align="center" colspan="2">
					HOME | 관리자홈 | 쇼핑몰홈 | 장바구니 | 회사소개			
				</td>
			</tr>
			<tr height="500">
				<td valign="top" width="20%" align="center">
					tree/view
					<table border="1">
					<c:forEach var="cdto" items="${listCategory}">
						<tr>
							<td>
								<a href="javascript:goProlist('${cdto.code}','${cdto.cname}')">
									${cdto.cname}[${cdto.code}]
								</a>
							</td>		
						</tr>
					</c:forEach>
					</table>
					<form name="f1" action="mall_cgProdList.do" method="post">
						<input type="hidden" name="code">
						<input type="hidden" name="cname">
					</form>
				</td>
				<td>
				