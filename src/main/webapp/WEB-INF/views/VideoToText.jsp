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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/timeline/VideoToText.css?after" rel="stylesheet">
<link href="https://unpkg.com/video.js/dist/video-js.css" rel="stylesheet">
<script src="https://unpkg.com/video.js/dist/video.js"></script>
</head>
<body>

<input id="token" value="${sessionScope.newToken }" type="hidden">

<div class="Box">
<div class="Box1">
<table id="videoT">
	<tr>
		<td>
<form action="upload" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">
    <input type="file" id="fileInput" name="file" accept="video/*">
    <input type="hidden" name="token" value="${sessionScope.newToken }" >
    <br>
    <button id="UploadBtn" class="button btnPush btnRed" type="submit">Upload Video</button>
</form>
			</td>
		</tr>
		<tr>
			<td height="60px" align="left">
				<div id="loading-overlay">
					<div class="loading-spinner">
					</div>
					 <a id="loading-message">이 작업은 조금 오래 걸릴 수 있습니다. 기다려주세요...</a>
				</div>
		</td>
	</tr>
	<tr>
		<td>
			<c:choose>
				<c:when test="${sessionScope.UploadedFileName != null }">
					<video width="480" height="320" class="video-js vjs-default-skin" id="userVideo" controls>
			    		<source src="videos?${sessionScope.UploadedFileName}" type="video/mp4">
					</video>
						<button id="getTextData" class="button btnPush btnRed">분석하기</button>
				</c:when>
			</c:choose>
		</td>
	</tr>
</table>

</div>

<div class="Box2">

<table id="contentT">
	<tr>
		<td id="topWords"></td>
	</tr>
	<tr>
		<td id="ta"><textarea id="vtt_textArea" ></textarea></td>
	</tr>
	<tr>
		<td colspan=2 id="timeLine"></td>
	</tr>
</table>

<input id=transcript type="hidden">
<button id="getSummary" class="button btnPush btnRed" >요약하기</button>


</div>
</div>

</body>

</html>