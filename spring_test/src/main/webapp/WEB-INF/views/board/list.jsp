<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">
<h2>게시판</h2>
<br>

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

</div>
<script>
	const isDel = `<c:out  value="${isDel}"/>`;
	if(isDel == 1){
		alert("게시글이 삭제되었습니다.");
	}
</script>

<jsp:include page="../layout/footer.jsp"></jsp:include>