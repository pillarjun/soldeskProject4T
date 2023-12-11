<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertview</title>
<script type="text/javascript" src="resources/js/boardvalid.js"></script>
</head>
<body>

<!-- 글 작성 양식 -->

<form name="insertBaordForm" action="board.insert" >
<table>
	<tr>
		<td>
			<input name="nb_id" id="nb_id.insert" autocomplete="off" placeholder="ID">
		</td>
		<td colspan="2">
			<input name="nb_pw" id="nb_pw.insert" autocomplete="off" placeholder="Password">
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<input name="nb_title" id="nb_title.insert" autocomplete="off" placeholder="Title">
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<textarea  name="nb_content" id="nb_content.insert" autocomplete="off" placeholder="Content"></textarea>
		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td>
			<button id="insertBtn"  type="submit" onclick="return validcheck();">작성</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>