<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/timeline/event.js"></script>
<script type="text/javascript" src="resources/js/timeline/submitValidation.js"></script>
<link rel="stylesheet" href="resources/css/timeline/loading.css">
<link href="https://unpkg.com/video.js/dist/video-js.css" rel="stylesheet">
<script src="https://unpkg.com/video.js/dist/video.js"></script>
<style>
#timeLine a {
	background:  linear-gradient(to right, rgba(255,255,255,0) 50%, #f3be00 50%);
	background-size: 200%;
	transition: .25s;
	cursor:pointer;
}
#timeLine a:hover {
	background-position: -100% 0;
}
</style>
</head>
<body>


<input id="token" value="${sessionScope.newToken }" type="hidden">

<hr>

<form action="upload" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">
    <input type="file" id="fileInput" name="file" accept="video/*">
    <input type="hidden" name="token" value="${sessionScope.newToken }" >
    <button type="submit">Upload Video</button>
</form>

<hr>

<% long currentTimestamp = System.currentTimeMillis();%>
<c:choose>
	<c:when test="${sessionScope.UploadedFileName != null }">
		<video width="640" height="480" class="video-js vjs-default-skin" id="userVideo" >
    		<source src="videos?${sessionScope.UploadedFileName }" type="video/mp4">
		</video>
			<button id="getTextData">분석하기</button>
	</c:when>
</c:choose>

<table>
	<tr>
		<td>
			<div id="loading-overlay">
			  <div class="loading-spinner"></div>
			  <p id="loading-message">이 작업은 조금 오래 걸릴 수 있습니다. 기다려주세요...</p>
			</div>
		</td>
	</tr>
</table>


<hr>

<table id="contentT">
	<tr>
			<td id="topWords"></td>
			<td id="ta"><textarea id="vtt_textArea"></textarea></td>
	</tr>
	<tr>
		<td colspan=2 id="timeLine"></td>
	</tr>
</table>

<input id=transcript type="hidden">
<button id="getSummary">요약하기</button>



</body>
</html>