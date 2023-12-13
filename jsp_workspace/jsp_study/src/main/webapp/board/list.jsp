<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link
	href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"></script>
</head>
<body>

	<!-- search line  -->

	<div>

		<form action="/brd/list" method="get">
			<c:set value="${ph.pgvo.type }" var="typed"></c:set>
			<select name="type">
				<option ${typed == null ? 'selected' : '' }>Choose...</option>
				<option value="t" ${typed eq 't' ? 'selected' : '' }>title</option>
				<option value="w" ${typed eq 'w' ? 'selected' : '' }>writer</option>
				<option value="c" ${typed eq 'c' ? 'selected' : '' }>content</option>
				<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>title&content</option>
				<option value="tw" ${typed eq 'tw' ? 'selected' : '' }>title&writer</option>
				<option value="wc" ${typed eq 'wc' ? 'selected' : '' }>writer&content</option>
				<option value="twc" ${typed eq 'twc' ? 'selected' : '' }>title&writer&content</option>
			</select> <input type="text" name="keyword" placeholder="Search"
				value="${ph.pgvo.keyword }"> <input type="hidden"
				name="pageNo" value="1"> <input type="hidden" name="qty"
				value="${ph.pgvo.qty }">
			<button type="submit">Search</button>
			<span>${ph.totalCount }</span>
		</form>
	</div>


	<table class="table table-dark table-hover">
		<tr>
			<th>번호</th>
			<th>썸네일</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>

		<!-- DB에서 가져온 리스트를 c:foreach를 통해 반복 -->
		<c:forEach items="${list }" var="bvo">
			<tr>

				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
				<td><a href="/brd/detail?bno=${bvo.bno }">
				<img alt="" src="/_fileUpload/th_${bvo.imageFile }"></a></td>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.regdate }</td>
				<td>${bvo.readcount }</td>
			</tr>

		</c:forEach>
	</table>

	<!-- 페이지네이션 표시구역  -->
	<div>

		<!-- prev(이전) -->
		<c:if test="${ph.prev }">
			<a
				href="brd/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
				◁ 이전 </a>
		</c:if>

		<!-- paging -->
		<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
			<a
				href="/brd/list?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
				${i} </a>
		</c:forEach>

		<!-- next(다음) -->
		<c:if test="${ph.next }">
			<a
				href="/brd/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
				다음 ▷ </a>
		</c:if>
	</div>


	<a href="/brd/register"><button>글쓰기</button></a>
	<a href="/index.jsp"><button>홈으로</button></a>
</body>
</html>