<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script  type="text/javascript"  charset="utf-8">  
</script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
</head>
<body>
	<table id="siteLoginArea">
		<tr>
			<td>
				<a id="noticeBtn" href="noticeBoard.go">
					문의
				</a>
			</td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="${sessionScope.loginMember.m_id == null }">
						<a id="loginBtn" href="member.login.go">
							로그인
						</a>
					</c:when>
					<c:otherwise>
						<a id="logoutBtn" href="member.logout">
							로그아웃
						</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	<table id="siteSignupArea">
		<tr>
			<td>
				<c:choose>
				<c:when test="${sessionScope.loginMember.m_id == null }">
					<a id="signBtn" href="member.signup.go">
						회원가입
					</a>
				</c:when>
					<c:otherwise>
						<a id="infoBtn" href="member.info.go">
							회원정보
						</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	
	${r }
	
	<table id="siteLibraryArea">
		<tr>
			<td>
				<a href="libraryfirst.go">유튜브 도우미</a>
			</td>
		</tr>
	</table>
	<table id="siteContextArea">
		<tr>
			<td align="center">
				<jsp:include page="${cp }"/>
			</td>
		</tr>
	</table>
</body>
</html>