<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>
			비밀번호
		</td>
	</tr>
	<c:forEach var="Info" items="${getInfoPw }">
	<tr>
		<td>
			<a>${Info.m_pw }</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>