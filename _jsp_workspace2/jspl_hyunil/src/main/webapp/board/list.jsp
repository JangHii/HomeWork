<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List page</title>

<style>

	html{
		background-color: black;
	}
	
	.container{
		height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.borderbox{
		width: 500px;
		padding: 50px;
		background-color: black;
		text-align: center;
	}
	
	button{
		width: 100px;
		height: 50px;
		background: none;
		border: 2px solid white;
		border-radius: 30px;
		color: white;
	}
	
	h1{
		color: white;
		font-size: 40px;
	}
	
	h3{
		color: white;
		font-size: 25px;
	}
	
	th{
		border-style: solid;
		color: white;
	}
	
	td{
		border-style: solid;
		color: white;
	}
	
	table{
		
		margin-left:auto;
		margin-right:auto;
	}
	
	textarea{
		background-color: black;
		color: white;
	}
	
	input{
		background-color: black;
		color: white;
	}
	
	</style>
</head>
<body>

	<!-- search line  -->

	<div class="container">

		<form action="/brd/list" method="get" class="borderbox">
			<h1>핫냥홈페이지</h1>
			<h3>게시판</h3>
			<c:set value="${ph.pgvo.type }" var="typed"></c:set>
			<select name="type">
				<option ${typed == null ? 'selected' : '' }>검색종류선택</option>
				<option value="t" ${typed eq 't' ? 'selected' : '' }>제목</option>
				<option value="w" ${typed eq 'w' ? 'selected' : '' }>작성자</option>
				<option value="c" ${typed eq 'c' ? 'selected' : '' }>내용</option>
				<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>제목&내용</option>
				<option value="tw" ${typed eq 'tw' ? 'selected' : '' }>제목&작성자</option>
				<option value="wc" ${typed eq 'wc' ? 'selected' : '' }>작성자&내용</option>
				<option value="twc" ${typed eq 'twc' ? 'selected' : '' }>제목&작성자&내용</option>
			</select> <input type="text" name="keyword" placeholder="검색어를입력해주세요"
				value="${ph.pgvo.keyword }"> <input type="hidden"
				name="pageNo" value="1"> <input type="hidden" name="qty"
				value="${ph.pgvo.qty }">
			<button type="submit">검색</button>
			<span>${ph.totalCount }</span>
			
			
			<table>
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
						
						<td>${bvo.bno }</td>
						<td><a href="/brd/detail?bno=${bvo.bno }"><img alt="" src="/_fileUpload/th_${bvo.imageFile }"></a></td>
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
			<a href="/brd/register"><button type="button">글쓰기</button></a>
	<a href="/index.jsp"><button type="button">홈으로</button></a>
		</form>
	</div>




	
</body>
</html>