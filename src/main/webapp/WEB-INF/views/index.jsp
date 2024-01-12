<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice/index.css?after" rel="stylesheet">
<script type="text/javascript" src="resources/js/notice/replyvalid.js"></script>
<script  type="text/javascript"  charset="utf-8">  
</script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
</head>
<body class="indexBody">
	<div class="borderLine">
	<table id="siteLoginArea">
		<tr>
			<td>
				<a id="homeBtn" href="home.go">
					홈
				</a>
			</td>
		</tr>
		<tr>
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
	
	<div class="fixwindow">
	
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
					<a id="infoBtn" href="member.info.go" onclick="return pwcheck();">
	                  <input id="nb_pw" type="hidden" value="${sessionScope.loginMember.m_pw }" readonly="readonly">
	                     	회원정보
	                  </a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</div>
	</div>
	<table id="siteContextArea">
		<tr>
			<td align="center">
				<jsp:include page="${cp }"/>
			</td>
		</tr>
	</table>
</body>
</html>