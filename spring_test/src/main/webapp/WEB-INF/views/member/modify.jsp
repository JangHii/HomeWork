<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       


<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">

	<h2>회원정보 수정페이지</h2>

	<form action="/member/modify" method="post">
	
		<div class="mb-3">
			<label for="id" class="form-label">아이디</label> 
			<input type="text"name="id" class="form-control" id="id" value="${ses.id }" readonly="readonly">
		</div>
	
		<div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label> 
			<input type="password"name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력해주세요..">
		</div>
	
		<div class="mb-3">
			<label for="name" class="form-label">이름</label> 
			<input type="text"name="name" class="form-control" id="name" value="${ses.name }">
		</div>
	
		<div class="mb-3">
			<label for="email" class="form-label">이메일</label> 
			<input type="email"name="email" class="form-control" id="email" value="${ses.email }">
		</div>
		
		<div class="mb-3">
			<label for="home" class="form-label">주소</label> 
			<input type="text"name="home" class="form-control" id="home" value="${ses.home }">
		</div>
	
		<div class="mb-3">
			<label for="age" class="form-label">나이</label> 
			<input type="text"name="age" class="form-control" id="age" value="${ses.age }">
		</div>
	
		<a href="/"><button type="button" class="btn btn-secondary">취소</button></a>
		<button type="submit" class="btn btn-secondary">회원수정완료</button>

	</form>




</div>




<jsp:include page="../layout/footer.jsp"></jsp:include>