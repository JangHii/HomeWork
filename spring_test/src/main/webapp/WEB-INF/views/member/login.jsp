<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       



<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h2>로그인 페이지</h2>
	
	<form action="/member/login" method="post">
	
	
	<div class="mb-3">
			<label for="id" class="form-label">아이디</label> 
			<input type="text"name="id" class="form-control" id="id" placeholder="아이디를 입력해주세요..">
		</div>
	
		<div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label> 
			<input type="password"name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력해주세요..">
		</div>
		
		<a href="/"><button type="button" class="btn btn-secondary">취소</button></a>
		<button type="submit" class="btn btn-secondary">로그인하기</button>
	
	
	</form>
	
	
	
</div>




<jsp:include page="../layout/footer.jsp"></jsp:include>
