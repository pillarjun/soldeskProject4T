<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeBoard</title>
<link rel="stylesheet" href="resources/css/notice/board.css" type="text/css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
function selChange() {
	var sel = document.getElementById('cntPerPage').value;
	location.href="listBoard?nowPage=${paging.nowPage}&cntPerPage="+sel;
};
</script>
</head>
<body>

<!-- 게시판 행 갯수 지정 -->

<table id="selChangeTable">
	<tr>
		<td>
			<div class="selChange" >
				<select id="cntPerPage" name="sel"  class="selChange"  onchange="selChange()">
					<option value="5"  class="selChange"
						<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
					<option value="10" class="selChange"
						<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
					<option value="15" class="selChange"
						<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
					<option value="20" class="selChange"
						<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
				</select>
			</div>	
		</td>
</tr>
</table>

<!-- 게시판 본문 -->

<table id="homeTable" >
		<tr class="onerow">	
			<td>NO</td>
			<td>Title</td>
			<td>ID</td>
			<td>Date</td>
			<td>Views</td>
		</tr>
 		<c:forEach var="nb" items="${viewAll  }">
		<tr class="itemrow">
			<td><a name="nb_no"><fmt:formatNumber value="${nb.nb_no }" /></a></td>
			<td><a class="noticeBoardTitle" href="oneview.go?nb_no=${nb.nb_no} " value="nb_no" id="homeTableTitle">${nb.nb_title }</a>
					 <c:if test="${nb.nb_replycount !=0 }">
					 	<a class="replyCount">[${nb.nb_replycount }]</a>
					 </c:if>
					 </td>
			<td>${nb.nb_id }</td>
			<td>${nb.nb_when }</td>
			<td>${nb.nb_count }</td>
		</tr>
		</c:forEach>
</table>


<!-- 페이징 -->

<table>
<tr>
	<td>
		<div>		
			<c:if test="${paging.startPage != 1 }">
				<a class="otherPageNum"  href="listBoard?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b class="nowPageNum">${p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a class="otherPageNum" href="listBoard?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.endPage != paging.lastPage}">
				<a class="otherPageNum"   href="listBoard?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
			</c:if>
		</div>
	</td>
</tr>
</table>

<!-- 글 작성 버튼 -->

<table id="insertBtnTable">
<tr>
	<td class="insertBtnCell">
		<a href="insertview.go" id="insertBtn" class="hreftext">글 작성</a>
	</td>
</tr>
</table>
<hr>

<!-- 검색어 입력 -->

<form action="board.search" name="search-form">
	<select name="searchType" class="type-box">
		<option value="nb_title">Title</option>
		<option value="nb_id">ID</option>
		<option value="nb_content">Content</option>
	</select>
	<input type="text" name="keyword" id="searchKeyword" class="searchBox"
	placeholder="검색어 입력" autocomplete="off">
	<input type="submit" class="searchBtn" onclick="return searchKeyword();"
	value="검색" >
</form>

</body>
</html>