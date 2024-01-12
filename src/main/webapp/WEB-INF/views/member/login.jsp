<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/login.css?after" rel="stylesheet">
</head>
<body class="loginBody">
	<form action="member.login" method="post">
	<div class="whiteBack">
		<a id="back" onclick="history.go(-1)">◁ 로그인</a>

		<table id="loginTbl">
			<tr class="inputText">
				<td>
					<input name="m_id" placeholder="ID" autocomplete="off" autofocus="autofocus"> 
				</td>
			</tr>
			<tr class="inputText">
				<td>
					<input name="m_pw" placeholder="Password" autocomplete="off" type="password">
				</td>
			</tr>
			<tr>
				<td>
					<button id="loginBtn" class="button btnPush btnRed" onclick="login();">로그인하기</button>
				</td>
			</tr>
			</form>
			<tr>
				<td align="center">
					<div class="findBtns">
						<form action="member.idsearch" method="get">
									<button id="findId">아이디 찾기</button>
						</form>
						<form action="member.pwsearch" method="get">
									<button id="findPw">비밀번호 찾기</button>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>