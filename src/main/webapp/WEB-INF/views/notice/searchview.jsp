<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
function selChange() {
	var sel = document.getElementById('cntPerPage').value;
	location.href="board.search?searchType=${pagingSearch.searchType}&keyword=${pagingSearch.keyword}&nowPage=${pagingSearch.nowPage}&cntPerPage="+sel;
};
</script>
<body>


<!-- 게시판 행 갯수 지정 -->

'${pagingSearch.keyword }' 에 대한 검색결과 : ${pagingSearch.total } 개
<div class="selChange" >
	<select id="cntPerPage" name="sel"  class="selChange"  onchange="selChange()">
		<option value="5"  class="selChange"
			<c:if test="${pagingSearch.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
		<option value="10" class="selChange"
			<c:if test="${pagingSearch.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
		<option value="15" class="selChange"
			<c:if test="${pagingSearch.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
		<option value="20" class="selChange"
			<c:if test="${pagingSearch.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
	</select>
</div>	



<!-- 게시판 본문 -->

<table id="homeTable" border="1">
		<tr class="onerow">	
			<td>NO</td>
			<td >Title</td>
			<td>ID</td>
			<td>Date</td>
			<td>Views</td>
		</tr>
 		<c:forEach var="m" items="${viewSearch }">
		<tr class="homeTableRow">
			<td><a name="nb_no"><fmt:formatNumber value="${m.nb_no }" /></a></td>
			<td><a href="oneview.go?nb_no=${m.nb_no} " value="nb_no" 
			id="homeTableTitle" class="hreftext">${m.nb_title }</a>
			<c:if test="${m.nb_replycount !=0 }">
					 	<a class="replyCount">[${m.nb_replycount }]</a>
					 </c:if>
			</td>
			<td>${m.nb_id }</td>
			<td>${m.nb_when }</td>
			<td>${m.nb_count }</td>
		</tr>
		</c:forEach>
</table>


<!-- 페이징 -->

<table>
<tr>
	<td>
	</td>
	<td>
		<div>		
			<c:if test="${pagingSearch.startPage != 1 }">
				<a class="otherPageNum"  href="board.search?searchType=${pagingSearch.searchType}&keyword=${pagingSearch.keyword}&nowPage=${p }&nowPage=${pagingSearch.startPage - 1 }&cntPerPage=${pagingSearch.cntPerPage}">&lt;</a>
			</c:if>
			<c:forEach begin="${pagingSearch.startPage }" end="${pagingSearch.endPage }" var="p">
				<c:choose>
					<c:when test="${p == pagingSearch.nowPage }">
						<b class="nowPageNum">${p }</b>
					</c:when>
					<c:when test="${p != pagingSearch.nowPage }">
						<a class="otherPageNum" href="board.search?searchType=${pagingSearch.searchType}&keyword=${pagingSearch.keyword}&nowPage=${p }&cntPerPage=${pagingSearch.cntPerPage}">${p }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${pagingSearch.endPage != pagingSearch.lastPage}">
				<a class="otherPageNum"   href="board.search?searchType=${pagingSearch.searchType}&keyword=${pagingSearch.keyword}&nowPage=${pagingSearch.endPage+1 }&cntPerPage=${pagingSearch.cntPerPage}">&gt;</a>
			</c:if>
		</div>
	</td>
</tr>
</table>

<!-- 글 작성 버튼 -->

<table>
<tr>
	<td class="insertBtnCell">
		<a href="insertview.go" id="insertBtn" class="hreftext">글 작성</a>
	</td>
</tr>
</table>


<!-- 검색어 입력 -->

<form action="board.search" name="search-form">
	<select name="searchType" class="type-box" >
		<option value="">Search Type</option>
		<option value="nb_title">Title</option>
		<option value="nb_id">ID</option>
		<option value="nb_content">Content</option>
	</select>
	<input type="text" name="keyword" id="searchKeyword" class="searchBox"
	placeholder="검색어 입력" autocomplete="off" >
	<input type="submit" class="searchBtn" onclick="return searchKeyword();"
	value="검색" >
</form>

</body>
</html>