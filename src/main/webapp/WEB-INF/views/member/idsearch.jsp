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
	$('#idMailCheckBtn').click(function() {
		const email = $('#idUserEmail1').val() + $('#idUserEmail2').val(); 
		console.log('완성된 이메일 : ' + email);
		const checkInput = $('.mailCheckInput') 
		$('input[name=m_email]').attr('value', email)
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
		const $resultMsg = $('#idMailCheckMessage');
		if(inputCode === code){
			$resultMsg.html('인증번호 일치');
			$resultMsg.css('color','green');
			$('#idMailCheckBtn').attr('disabled',true);
			$('#idUserEmail1').attr('readonly',true);
			$('#idUserEmail2').attr('readonly',true);
			$('#idUserEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	        $('#idUserEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
			$('#idCheckBtn').attr('disabled',false);
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
				<input type="text" name="idUserEmail1" id="idUserEmail1" placeholder="Email" >
				<select name="idUserEmail2" id="idUserEmail2" >
					<option>@naver.com</option>
					<option>@daum.net</option>
					<option>@gmail.com</option>
					<option>@hanmail.com</option>
				</select>
				<button type="button" id="idMailCheckBtn">본인인증</button>
			</td>
		</tr>
		<tr>
			<td>
				<input class="form-control mailCheckInput" placeholder="인증번호 6자리" disabled="disabled" maxlength="6">
				<span id="idMailCheckMessage"></span>
			</td>
		</tr>
		<tr>
			<form action="member.idsearchOk" method="post">
			<td>
				<input type="hidden" name="m_email" value="">
				<button id="idCheckBtn" disabled="disabled" >ID 확인</button>
			</td>
			</form>
		</tr>
	</table>
</body>
</html>