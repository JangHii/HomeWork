<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../layout/header.jsp"></jsp:include>



<h2>상세페이지</h2>
<br>

<div class="mb-3">
  <label for="bno" class="form-label">번호</label>
  <input type="text" name="bno" class="form-control" id="bno" value="${bvo.bno }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" value="${bvo.title }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">작성자</label>
  <input type="text" name="writer" class="form-control" id="writer" value="${bvo.writer }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="content" class="form-label">내용</label>
  <input type="text" name="content" class="form-control" id="content" value="${bvo.content }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="regAt" class="form-label">작성일</label>
  <input type="text" name="regAt" class="form-control" id="regAt" value="${bvo.regAt }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="readCount" class="form-label">조회수</label>
  <input type="text" name="readCount" class="form-control" id="readCount" value="${bvo.readCount }" readonly="readonly">
</div>



<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">수정하기</button></a>
<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">삭제하기</button></a>

<br>
<hr>
<br>


<jsp:include page="../layout/footer.jsp"></jsp:include>