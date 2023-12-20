<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	$('#pwMailCheckBtn').click(function() {
		const email = $('#pwUserEmail1').val() + $('#pwUserEmail2').val(); 
		console.log('완성된 이메일 : ' + email);
		const checkInput = $('.mailCheckInput') 
/* 		$('input[name=m_email]').attr('value', email) */
		$.ajax({
			type : 'get',
			url : '<c:url value ="/mailCheck?email="/>' + email, 
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				code =data;
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});
$(function() {
	$('.mailCheckInput').blur(function () {
		const inputCode = $(this).val();
		const $resultMsg = $('#pwMailCheckMessage');
		if(inputCode === code){
			$resultMsg.html('인증번호 일치');
			$resultMsg.css('color','green');
			$('#pwMailCheckBtn').attr('disabled',true);
			$('#pwUserEmail1').attr('readonly',true);
			$('#pwUserEmail2').attr('readonly',true);
			$('#pwUserEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	        $('#pwUserEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
			$('#pwCheckBtn').attr('disabled',false);
		}else{
			$resultMsg.html('인증번호 불일치');
			$resultMsg.css('color','red');
		}
	});
});
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<input type="text" name="pwUserEmail1" id="pwUserEmail1" placeholder="Email" >
				<select name="pwUserEmail2" id="pwUserEmail2" >
					<option>@naver.com</option>
					<option>@daum.net</option>
					<option>@gmail.com</option>
					<option>@hanmail.com</option>
				</select>
				<button type="button" id="pwMailCheckBtn">본인인증</button>
			</td>
		</tr>
		<tr>
			<td>
				<input class="form-control mailCheckInput" placeholder="인증번호 6자리" disabled="disabled" maxlength="6">
				<span id="pwMailCheckMessage"></span>
			</td>
		</tr>
		<tr>
			<form action="member.pwsearchOk" method="post">
		<tr>
			<td>
				<input type="text" name="m_id" placeholder="ID">
			</td>
		</tr>
			<td>
				<button id="pwCheckBtn" disabled="disabled" >PW 확인</button>
			</td>
			</form>
		</tr>
	</table>
</body>
</html>