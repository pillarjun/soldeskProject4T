<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Second</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/library.js"></script>
<link rel="stylesheet" href="resources/css/temp.css">
</head>
<body>

<button id="copyBtn">복사</button>

<table>
	<tr>
		<td>
			<input type="checkbox" id="contentBtn" checked="checked"> 영상 설명
		    <input type="checkbox" id="contentWriteBtn">
		    <br>
			<textarea id="libraryContent" name="libraryContent" readonly="readonly" >${readLibrary.libraryContent }</textarea>
		</td>
		
		<td rowspan="8" align="center">
			<a>→</a>
		</td>
		
		<!-- 결과창 -->
		<td rowspan="8" id="libraryAll">
			<ul class="sortableList" id="libraryAllList">
      			<li class="item" draggable="true">
     			   <div class="details">
						<p id="libraryFinishContentAll" >
						<!-- [영상 설명] -->
						<a id="libraryFinishContent" style="white-space:pre-wrap">${libraryContent }</a>
						</p>
					</div>
       				<i class="uil uil-draggabledots"></i>
      			</li>
     			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishNoticeAll" class="libraryFinish">
						<!-- [문의] -->
						<a id="libraryFinishNotice" style="white-space:pre-wrap">${libraryNotice }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishBgmAll" class="libraryFinish">
						<!-- [bgm출처] -->
						<a id="libraryFinishBgm" style="white-space:pre-wrap">${libraryBgm }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishPhotoAll" class="libraryFinish">
						<!-- [사진출처] -->
						<a id="libraryFinishPhoto" style="white-space:pre-wrap">${libraryPhoto }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishChannelAll" class="libraryFinish">
						<!-- [채널 더 알아보기] -->
						<a id="libraryFinishChannel" style="white-space:pre-wrap">${libraryChannel }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishEventAll" class="libraryFinish">
						<!-- [이벤트] -->
						<a id="libraryFinishEvent" style="white-space:pre-wrap">${libraryEvent }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishTagAll" class="libraryFinish">
						<!-- [해시태그] -->
						<a id="libraryFinishTag" style="white-space:pre-wrap">${libraryTag }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      			<li class="item" draggable="true">
        			<div class="details">
						<p id="libraryFinishEtcAll" class="libraryFinish">
						<!-- [미분류] -->
						<a id="libraryFinishEtc" style="white-space:pre-wrap">${libraryEtc }</a>
						</p>
					</div>
        			<i class="uil uil-draggabledots"></i>
      			</li>
      		</ul>
		</td>	
	</tr>
	<tr>
		<td>
		    <input type="checkbox" id="notBtn" checked="checked"> 문의
		    <input type="checkbox" id="noticeWriteBtn">
		    <br>
			<textarea id="libraryNotice" name="libraryNotice" readonly="readonly" >${readLibrary.libraryNotice }</textarea>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="bgmBtn" checked="checked"> BGM 출처
			<input type="checkbox" id="bgmWriteBtn">
			<br>
			<textarea id="libraryBgm" name="libraryBgm" readonly="readonly">${readLibrary.libraryBgm }</textarea>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="photoBtn" checked="checked"> 사진 출처
			<input type="checkbox" id="photoWriteBtn">
			<br>
			<textarea id="libraryPhoto" name="libraryPhoto" readonly="readonly" >${readLibrary.libraryPhoto }</textarea>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="channelBtn" checked="checked"> 관련 채널
			<input type="checkbox" id="channelWriteBtn">
			<br>
			<textarea id="libraryChannel" name="libraryChannel" readonly="readonly">${readLibrary.libraryChannel }</textarea>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="eventBtn" checked="checked"> 이벤트
			<input type="checkbox" id="eventWriteBtn">
			<br>
			<textarea id="libraryEvent" name="libraryEvent" readonly="readonly"></textarea>
		</td>
	</tr>
	<tr>
		<td>
        	<input type="checkbox" id="tagBtn" checked="checked"> 해시 태그
        	<input type="checkbox" id="tagWriteBtn">
			<br>
			<textarea id="libraryTag" name="libraryTag" readonly="readonly"></textarea>
		</td>
	</tr>
	<tr>
		<td>
        	<input type="checkbox" id="etcBtn" checked="checked"> 미분류
        	<input type="checkbox" id="etcWriteBtn">
			<br>
			<textarea id="libraryEtc" name="libraryEtc" readonly="readonly"></textarea>
		</td>
	</tr>
</table>

</body>
</html>