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
<link href="https://unpkg.com/video.js/dist/video-js.css" rel="stylesheet">
<script src="https://unpkg.com/video.js/dist/video.js"></script>

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



<c:choose>
	<c:when test="${sessionScope.UploadedFileName != null }">
		<h2>Uploaded Videos</h2>
		<video width="640" height="480" class="video-js vjs-default-skin" id="userVideo">
    		<source src="videos" type="video/mp4">
		</video>
			<button id="getTextData">분석하기</button>
	</c:when>
</c:choose>

<hr>
<table id="contentT">
<tr>
<td id="timeLine"></td>
</tr>
</table>





</body>
</html>