<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List page</title>
</head>
<body>
<h1>List Page</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<!-- DB에서 가져온 리스트를 c:foreach를 통해 반복 -->
	<c:forEach items = "${list }" var="bvo">
	<tr>
		<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
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
<a href="brd/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty }"> ◁ 이전 </a>
</c:if>

<!-- paging -->
<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
<a href="/brd/list?pageNo=${i }&qty=${ph.pgvo.qty}"> ${i} </a>
</c:forEach>

<!-- next(다음) -->
<c:if test="${ph.next }">
<a href="/brd/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}"> 다음 ▷ </a>
</c:if>
</div>


<a href="/brd/register"><button>register</button></a>
<a href="/index.jsp"><button>index</button></a>
</body>
</html>