<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/replyvalid.js"></script>
</head>
<body>

<!-- 게시물 하나에 대한 디테일 : 제목, 아이디, 본문 -->

<table>
	<tr>
		<td class="oneviewTitle">${oneboard.nb_title }</td>
	</tr>
	<tr>
		<td class="oneviewId" >${oneboard.nb_id }</td>
	</tr>
	<tr>
		<td class="oneviewContent" >${oneboard.nb_content }</td>
	</tr>
</table>

<!-- 게시물 하나에 대한 디테일 : 시간, 조회수, 댓글 -->

<table>
	<tr>
		<td width="500px">
			 <a class="oneviewWhen" >최근 변경 시간 : ${oneboard.nb_when }</a>
		</td>
		<td width="140px">
			 <a class="oneviewCount" >조회수 : ${oneboard.nb_count }</a>
		</td>
		<td width="240px">
			 <a class="oneviewReplyCount" >댓글 : ${oneboard.nb_replycount } 개</a>
		</td>
		
		<!-- 수정 버튼, 삭제 버튼 -->
		
		<td width="140px" align="right">
			<form name="oneform" action="board.update.go" >
				<input type="hidden" id="nb_no"  name="nb_no" value="${oneboard.nb_no }">
				<input type="hidden" id ="nb_pw" value="${oneboard.nb_pw}">
				<button id="boardUpdateBtn" type="submit"
				onclick="return pwcheck();">게시물 수정</button>
			</form>
		</td>
		<td width="140px" align="right">
			<form name="oneform" action="board.delete" >
				<input type="hidden" id="nb_no" name="nb_no" value="${oneboard.nb_no }">
				<input type="hidden" id="nb_pw" value="${oneboard.nb_pw}">
				<button id="boardDeleteBtn" type="submit"
				onclick="return pwcheck();">게시물 삭제</button>
			</form>
		</td>
	</tr>
</table>

<hr> <!--  댓글 내용란 -->

<table>
	<c:forEach var="r" items="${ replyAll }" >
	<tr>
		<form name="oneform" action="reply.delete" >
			<input type="hidden" id="r_pw" value="${r.r_pw}">
			<td class="replyId">${r.r_id } </td>
			<td class="replyContent">${r.r_content} </td>
			<td class="replyWhen">${r.r_when } </td>
			<td><button id="replyDeleteBtn" type="submit"  
					onclick="return replypwcheck();">X</button></td>
			<input type="hidden" name="nb_no" value="${oneboard.nb_no }">
			<input type="hidden" name="r_no" value="${ r.r_no}">
		</form>
	</tr>
	</c:forEach>
</table>
<br>

<!-- 댓글 입력란 -->

<table>
	<form action="reply.insert">
		<input type="hidden" name="nb_no" value="${oneboard.nb_no }">
		<tr class="replyInsertTable">
			<td width="150px">
				<input name="r_id" id="r_id.insert" autocomplete="off" 
				placeholder="ID">
			</td>
			<td rowspan="2">
				<textarea name="r_content" id="r_content.insert"  placeholder="Comment"
				autocomplete="off"></textarea>
			</td>
			<td rowspan="2" width="50px">
				<button id="replyUpdateBtn" type="submit"  
				onclick="return replyvalidcheck();">댓글 작성</button>
			</td>
		</tr>
		<tr class="replyInsertTable">
			<td>
				<input name= "r_pw" id="r_pw.insert" autocomplete="off" placeholder="Password"> <br>
			</td>
		</tr>
	</form>
</table>
</body>
</html>