<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice/home.css" rel="stylesheet">
</head>
<body>	

<!-- 유튜브 도우미 버튼 -->
	<a href="libraryfirst.go">
		<table id="youtubeGuideBtn">
			<tr>
				<td>
				</td>
			</tr>
		</table>
	</a>

<!-- 영상 분석 버튼 -->
	<c:choose>
		<c:when test="${sessionScope.loginMember.m_id != null }">
			<a href="timeline.go">
				<table id="timelineBtn">
					<tr>
						<td>
						</td>
					</tr>
				</table>
			</a>
		</c:when>
		<c:otherwise>
			<a href="member.login.go">
				<table id="timelineFailBtn">
					<tr>
						<td>
						</td>
					</tr>
				</table>
			</a>
		</c:otherwise>
	</c:choose>

</body>
</html>

