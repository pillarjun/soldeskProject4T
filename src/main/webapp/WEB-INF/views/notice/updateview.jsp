<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/notice/boardvalid.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<link rel="stylesheet" href="resources/css/notice/updateview.css" type="text/css">
</head>
<body>

<div class="Box">

<!-- 글 수정 양식 -->

<form action="board.update" method="post">
<input type="hidden" name="nb_no" value='${oneboard.nb_no}'">
<table class="updateviewTable">
	<tr>
		<td>
			<a>ID :  ${oneboard.nb_id }</a>
		</td>
	</tr>
	<tr>
		<td>
			Title : <input name="nb_title" id="nb_title.update"  autocomplete="off" 
			value="${oneboard.nb_title }"> <br>
		</td>
	</tr>
	<tr>
		<td>
			<textarea  name="nb_content" id="nb_content.update" placeholder="수정할 내용" 
			autocomplete="off"></textarea>
		</td>
	</tr>
	<tr>
		<td align="right">
			<button id="updateBtn"  type="submit"
			onclick="return validcheck2();">수정</button>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>