<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library First</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/library.js"></script>
<link rel="stylesheet" href="resources/css/library.css" type="text/css">
</head>
<body>
<form action="">
<table>
	<tr>
		<td>
			영상에 대한 설명을 작성해주세요.
		</td>
	</tr>
	<tr>
		<td>
			<textarea id="libraryOriginal" name="libraryOriginal"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<button>▽ 분류하기</button>
		</td>
	</tr>
</table>
</form>
<form action="librarysecond.go" method="post">
<table>
	<tr>
		<td>
		         영상 설명
				<textarea id="libraryContent" name="libraryContent"></textarea>
		</td>
	</tr>
	<tr>
		<td>
		         문의
				<textarea id="libraryNotice" name="libraryNotice"></textarea>
		</td>
	</tr>
	<tr>
		<td>
		         BGM 출처
				<textarea id="libraryBgm" name="libraryBgm"></textarea>
		</td>
	</tr>
	<tr>
		<td>
		         사진 출처
				<textarea id="libraryPhoto" name="libraryPhoto"></textarea>
		</td>
	</tr>
	<tr>
		<td>
		         관련 채널
				<textarea id="libraryChannel" name="libraryChannel"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<button>▷ 다음</button>
		</td>
	</tr>
</table>
</form>

</body>
</html>