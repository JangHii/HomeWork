<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
<h2>글쓰기페이지</h2>
<br>
<form action="/board/register" method="post" enctype="multipart/form-data">

<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" placeholder="제목을 작성해주세요...">
</div>

<div class="mb-3">
  <label for="writer" class="form-label">작성자</label>
  <input type="text" name="writer" class="form-control" id="writer" placeholder="작성자이름들어가는곳">
</div>

<div class="mb-3">
  <label for="content" class="form-label">Content</label>
  <textarea class="form-control" name="content" id="content" rows="3" placeholder="내용을 작성해주세요..."></textarea>
</div>


<!-- file 입력 라인 추가 -->
<div class="mb-3">
  <label for="file" class="form-label">파일..</label>
  <input type="file" name="files" class="form-control" id="file" multiple="multiple" style="display:none;"> <!-- multiple : 한번에 여러개의 파일을 업로드할수있다. -->
  <button type="button" class="btn btn-secondary" id="trigger">파일업로드</button>
</div>

<!-- 파일 목록 표시라인 -->
<div class="mb-3" id="fileZone">
</div>

<hr>

<a href="/"><button type="button" class="btn btn-secondary">취소</button></a>
<button type="submit" class="btn btn-secondary" id="regBtn">전송</button>


</form>
</div>

<script src="/resources/js/boardRegister.js"></script>

<jsp:include page="../layout/footer.jsp"></jsp:include>
