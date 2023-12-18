<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">
<h2>상세페이지</h2>
<br>

<div class="mb-3">
  <label for="title" class="form-label">번호</label>
  <input type="text" name="title" class="form-control" id="bno" value="${bvo.bno }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" value="${bvo.title }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">작성자</label>
  <input type="text" name="title" class="form-control" id="writer" value="${bvo.writer }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">내용</label>
  <input type="text" name="title" class="form-control" id="content" value="${bvo.content }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">작성일</label>
  <input type="text" name="title" class="form-control" id="reg_date" value="${bvo.reg_date }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">조회수</label>
  <input type="text" name="title" class="form-control" id="read_count" value="${bvo.read_count }" readonly="readonly">
</div>



<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">수정하기</button></a>
<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">삭제하기</button></a>
</div>





<jsp:include page="../layout/footer.jsp"></jsp:include>