<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/idsearchok.css?after" rel="stylesheet">
</head>
<body>
<div class="whiteBack">
<a id="back" onclick="history.go(-1)">◁ 아이디 목록</a>
<table id="idsearchokTbl">
	<tr>
		<th>
			해당 계정의 아이디 목록
		</th>
	</tr>
	<c:forEach var="Info" items="${getInfoId }">
	<tr>
		<td>
			<a>${Info.m_id }</a>
		</td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>