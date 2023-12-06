<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<script type="text/javascript">
	$(function() {
		asdf();
	});
	
	function asdf() {
		$("button").click(function() {
			let idd = $("#signup_m_id").val();
			if (idd == "") {
				alert("아이디를 입력해주세요.");
				return false;
			}
			return true;
		});
	}
	
	$('#mailCheckBtn').click(function() {
		const email = $('#m_email').val();
		console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
		const checkInput = $('.mailCheckInput') // 인증번호 입력하는곳 
		
		$.ajax({
			type : 'get',
			url : '<c:url value ="/user/mailCheck?email="/>'+email,
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				code =data;
				alert('인증번호가 전송되었습니다.')
			}			
		});
	});
	$('.mailCheckInput').blur(function () {
		const inputCode = $(this).val();
		const $resultMsg = $('#mailCheckWarn');
		
		if(inputCode === code){
			$resultMsg.html('인증번호 확인');
			$resultMsg.css('color','green');
			$('#mailCheckBtn').attr('disabled',true);
			$('#userEamil1').attr('readonly',true);
			$('#userEamil2').attr('readonly',true);
			$('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	         $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
		}else{
			$resultMsg.html('인증번호 불일치');
			$resultMsg.css('color','red');
		}
	});
	
</script>
</head>
<body>
<form action="member.signup" method="post" enctype="multipart/form-data">
		<table id="signupTbl">
			<tr>
				<td colspan="2">
					<input id="signup_m_id" name="m_id" placeholder="ID" autocomplete="off" autofocus="autofocus" maxlength="10" class="i1">
					<div id="msg"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="m_pw" placeholder="Password" autocomplete="off" maxlength="10" type="password" class="i1">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="m_pwChk"placeholder="Password Check" autocomplete="off" maxlength="10" type="password" class="i1">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="m_name" placeholder="User Name" autocomplete="off" class="i1">
				</td>
			</tr>
			
			<tr>
				<td>
					<input name="m_email" placeholder="Email" autocomplete="off" class="i1">
					<a href="emailCheck?m_email=rabbitstree@naver.com" id="mailCheckBtn">인증번호 발송</a>
				</td>
				<td>
					<div class="mailCheckBox">
						<input class="formControl_mailCheckInput" placeholder="인증번호 6자리" disabled="disabled" maxlength="6">
					</div>
						<span id="mailCheckWarn"></span>
				</td>
			</tr>
			<tr>
			
				<td>
					<div class="fileBox">
						<input class="uploadName" value="Profile Pic" placeholder="Profile Pic">
						<label for="m_photo">파일찾기</label>					
						<input id="m_photo" name="m_photo" type="file">
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<button>Sign Up</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

