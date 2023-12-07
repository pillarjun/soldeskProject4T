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
				<td>
					<input name="m_id" placeholder="ID" autocomplete="off" autofocus="autofocus"> 
				</td>
			</tr>
			<tr>
				<td>
					<input name="m_pw" placeholder="Password" autocomplete="off" type="password">
				</td>
			</tr>
			<tr>
				<td>
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>