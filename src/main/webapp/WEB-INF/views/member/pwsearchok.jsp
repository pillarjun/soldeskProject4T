<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/pwsearchok.css?after" rel="stylesheet">
</head>
<body>
<div class="whiteBack">
<a id="back" onclick="history.go(-1)">◁ 비밀번호 찾기</a>
<table id="pwsearchokTbl">
	<tr>
		<th>
			비밀번호
		</th>
	</tr>
	<c:forEach var="Info" items="${getInfoPw }">
	<tr>
		<td>
			<a>${Info.m_pw }</a>
		</td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>