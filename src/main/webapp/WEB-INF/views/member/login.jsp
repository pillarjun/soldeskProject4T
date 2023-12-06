<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="member.login" method="post">
		<table id="loginTbl">
			<tr>
				<td align="center">
					로그인
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="m_id" placeholder="ID" autocomplete="off" autofocus="autofocus" maxlength="10" class="i1"> 
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="m_pw" placeholder="Password" autocomplete="off" maxlength="10" type="password" class="i1">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>