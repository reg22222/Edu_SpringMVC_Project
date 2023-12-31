<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_edit.jsp -->
<%@ include file="top.jsp"%>
	<title>회원수정</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
		function check(){
			if (!f.passwd.value){
				alert("비밀번호를 입력하세요!!");
				f.passwd.focus();
				return;
			}
			document.f.submit();
		}
	</script>
<div align="center">
	<form name="f" method="POST" action="member_update_ok.do">
		<input type="hidden" name="no" value="${getMember.no}"/>
			<table width="600" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">회원수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box" value="${getMember.name}" readOnly>
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box" value="${getMember.id}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">비밀번호</td>
					<td class="m3">
						<input type="password" name="passwd" class="box" value="${getMember.passwd}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">주민번호</td>
					<td class="m3">
						<input type="text" name="ssn1" class="box" value="${getMember.ssn1}" readOnly> -
				<input type="password" name="ssn2" class="box" value="${getMember.ssn2}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="email" class="box" value="${getMember.email}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">연락처</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" size="3" maxlength="3" ${getMember.hp1}> -
						<input type="text" name="hp2" class="box" size="4" maxlength="4" ${getMember.hp2}> -
						<input type="text" name="hp3" class="box" size="4" maxlength="4" ${getMember.hp3}>
					</td>
  				</tr>
  				<tr>
					<td colspan="2" align="center">
						<a href="javascript:check()">[전송]</a>
						<a href="#">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
</div>
<%@ include file="bottom.jsp"%>