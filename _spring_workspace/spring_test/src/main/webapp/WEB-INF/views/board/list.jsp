<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">
<h2>게시판</h2>
<br>

<!-- 검색라인 -->
<div>
	<form action="/board/list" method="get">
	<div  class="input-group">
		<select name="type" class="form-select" id="inputGroupSelect04" aria-label="Example select with button addon" style="width: 200px">
			<option ${ph.pgvo.type eq null ?  'selected' : ''}>검색종류선택</option>
			<option value="t" ${ph.pgvo.type == 't' ?  'selected' : ''}>제목</option>
			<option value="w" ${ph.pgvo.type eq 'w' ?  'selected' : ''}>작성자</option>
			<option value="c" ${ph.pgvo.type == 'c' ?  'selected' : ''}>내용</option>
			<option value="tw" ${ph.pgvo.type eq 'tw' ?  'selected' : ''}>제목 + 작성자</option>
			<option value="tc" ${ph.pgvo.type == 'tc' ?  'selected' : ''}>제목 + 내용</option>
			<option value="wc" ${ph.pgvo.type eq 'wc' ?  'selected' : ''}>작성자 + 내용</option>
			<option value="twc" ${ph.pgvo.type == 'twc' ?  'selected' : ''}>제목 + 작성자 + 내용</option>
		</select>
		<input class="form-control me-2" type="search" placeholder="검색단어입력..." aria-label="Search" name="keyword" style="width: 600px" value="${ph.pgvo.keyword }">
		<input type="hidden" name="pageNo" value="1">
		<input type="hidden" name="qty" value="10">
		<button type="submit" class="btn btn-primary position-relative">검색
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    ${ph.totalCount}
    <span class="visually-hidden">unread messages</span>
  </span>
</button>
	</div>
	</form>
</div>

	<table class="table">

		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성날짜</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${list }" var="bvo">

				<tr>
					<th scope="row">${bvo.bno }</th>
					<td><a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.reg_date }</td>
					<td>${bvo.read_count }</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

<!-- 페이지네이션 자리 -->

<nav aria-label="Page navigation example">
  <ul class="pagination">
  
  <!-- 이전 -->
  <c:if test="${ph.prev }">
    <li class="page-item">
      <a class="page-link" href="/board/list?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  </c:if>  
  
    <!-- 페이지번호 -->
    
    <c:forEach begin="${ph.startPage}" end="${ph.endPage }" var="i">
    <li class="page-item">
    <a class="page-link ${ph.pgvo.pageNo == i ? 'active' : '' }" href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}">${i}</a>
    </li>
	</c:forEach>
    
    <!-- 다음 -->
    <c:if test="${ph.next }">
    <li class="page-item">
      <a class="page-link" href="/board/list?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Next" >
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>  
    <li class="page-item">
    <a class="page-link" href="/board/list">전체보기</a>
    </li>
  </ul>
</nav>


</div>
<script>
	const isDel = `<c:out  value="${isDel}"/>`;
	if(isDel == 1){
		alert("게시글이 삭제되었습니다.");
	}
</script>

<jsp:include page="../layout/footer.jsp"></jsp:include>