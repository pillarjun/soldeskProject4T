<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/info.css?after" rel="stylesheet">
<script type="text/javascript">
$(function() {
	$('#pwChk').blur(function() {
		const inputpwChk = $(this).val();
		const inputpw = $('#pw').val();
		const $resultMsg = $('#pwCheckMessage');
		
		if(inputpw === inputpwChk){
			$resultMsg.html('비밀번호 일치');
			$resultMsg.css('color','green');
		}else{
			$resultMsg.html('비밀번호 불일치');
			$resultMsg.css('color','red');
		}
	})
});
</script>
</head>
<body>
<div class="info">
	<a id="back" onclick="history.go(-1)">◁ 회원정보</a>
	<br>
	<table id="signupTbl">
		<form action="member.update" method="post" enctype="multipart/form-data">
			<tr>
				<td colspan="2">
				<p>아이디</p>
					<input value="${sessionScope.loginMember.m_id }" name="m_id" placeholder="ID" autocomplete="off" readonly="readonly">
				</td>

			</tr>
			<tr>
				<td colspan="2">
				<p>비밀번호</p>
					<input id="pw" name="m_pw" placeholder="Password" autocomplete="off" autofocus="autofocus" type="password">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="pwChk" name="m_pwChk"placeholder="Password Check" autocomplete="off" type="password">
					<span id="pwCheckMessage"></span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<p>이름</p>
					<input value="${sessionScope.loginMember.m_name }"  name="m_name" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<p>이메일</p>
					<input value="${sessionScope.loginMember.m_email }"  name="m_email" autocomplete="off" readonly="readonly">
				</td>
			</tr>		
			<tr>
				<td>
					<div class="fileBox">
					<p>프로필 사진</p>
						<input class="uploadName" value="${sessionScope.loginMember.m_photo }" placeholder="Profile Pic">
						<label id="photoSearch" for="m_photo">파일찾기</label>	
						<br>				
						<input id="reUploadPhoto" name="m_photo" type="file">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<img id="photo" width="100px" src="resources/img/${sessionScope.loginMember.m_photo }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="updateMemberBtn">계정 수정</button>
				</td>
			</form>
			<form  action="member.resign">
				<td>
					<button id="deleteMemberBtn">계정 삭제</button>
				</td>
			</tr>
			</form>
	</table>
</div>
</body>
</html>