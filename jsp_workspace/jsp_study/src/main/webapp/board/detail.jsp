<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Detail page</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${bvo.moddate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bvo.readcount }</td>
		</tr>

	</table>
<c:if test="${ses.id eq bvo.writer }">
<a href="/brd/modify?bno=${bvo.bno }"><button>수정</button></a>
<a href="/brd/remove?bno=${bvo.bno }"><button>삭제</button></a>
</c:if>
<a href="/brd/list"><button>list</button></a>

<!-- comment line (댓글등록) -->
<hr>
<div>
	comment line <br>
	<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly"><br>
	<input type="text" id="cmtText" placeholder="댓글을 입력해주세요...">
	<button type="button" id="cmtAddBtn">댓글등록</button>
</div>

<!-- 댓글 표시라인 -->
<div id="commentLine">
	<div>cno , bno , writer</div>
	<div>content , regdate</div>
</div>

<script type="text/javascript">
const bnoVal = `<c:out value="${bvo.bno}" />`;
console.log(bnoVal);
</script>

<script src="/resources/board_detail.js"></script>

</body>
</html>