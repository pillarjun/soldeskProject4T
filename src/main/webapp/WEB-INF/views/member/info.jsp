<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info</title>
</head>
<body>
	<table id="signupTbl">
		<form action="member.update" method="post" enctype="multipart/form-data">
			<tr>
				<td colspan="2">
					<input value="${sessionScope.loginMember.m_id }" name="m_id" placeholder="ID" autocomplete="off" maxlength="10" class="i1" readonly="readonly">
				</td>

			</tr>
			<tr>
				<td colspan="2">
					<input name="m_pw" placeholder="Password" autocomplete="off" autofocus="autofocus" maxlength="10" type="password" class="i1">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="m_pwChk"placeholder="Password Check" autocomplete="off" maxlength="10" type="password" class="i1">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="m_name" placeholder="User Name" autocomplete="off" maxlength="4" class="i1">
				</td>
			</tr>
			<tr>
				<td>
					<div class="fileBox">
						<input class="uploadName" value="${sessionScope.loginMember.m_photo }" placeholder="Profile Pic">
						<label for="m_photo">파일찾기</label>					
						<input id="m_photo" name="m_photo" type="file">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>계정 수정</button>
			</form>
			<form  action="member.resign">
					<button id="resignBtn">계정 삭제</button>
				</td>
			</tr>
			</form>
	</table>
</body>
</html>