<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp"></jsp:include>


<form action="/board/modify" method="post">
<div class="container-md">
<h2>수정페이지</h2>
<br>


<div class="mb-3">
  <label for="bno" class="form-label">번호</label>
  <input type="text" name="bno" class="form-control" id="bno" placeholder="제목을 작성해주세요..." value="${bvo.bno }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" placeholder="제목을 작성해주세요..." value="${bvo.title }">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">작성자</label>
  <input type="text" name="writer" class="form-control" id="writer" placeholder="제목을 작성해주세요..." value="${bvo.writer }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="content" class="form-label">내용</label>
  <input type="text" name="content" class="form-control" id="content" placeholder="제목을 작성해주세요..." value="${bvo.content }">
</div>
<div class="mb-3">
  <label for="reg_date" class="form-label">작성일</label>
  <input type="text" name="reg_date" class="form-control" id="reg_date" placeholder="제목을 작성해주세요..." value="${bvo.reg_date }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="read_count" class="form-label">조회수</label>
  <input type="text" name="tiread_counttle" class="form-control" id="read_count" placeholder="제목을 작성해주세요..." value="${bvo.read_count }" readonly="readonly">
</div>

<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
<a href="/board/detail"> <button type="submit" class="btn btn-secondary">수정완료</button></a>


</div>
</form>




<jsp:include page="../layout/footer.jsp"></jsp:include>