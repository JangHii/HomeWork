<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       


<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">

	<h2>회원정보 수정페이지</h2>
	<form action="/member/modify" method="post">
<table>
	<tbody>
	
		<tr>
			<input type="hidden" name="id" value="${ses.id }">
			<th>아이디</th>
			<td>${ses.id }</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" placeholder="변경할 비밀번호를 입력해주세요..."></td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${ses.name }"></td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" value="${ses.email }"></td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td><input type="text" name="home" value="${ses.home }"></td>
		</tr>
		
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" value="${ses.age }"></td>
		</tr>
	
	
		
</tbody>
	</table>
		<a href="/"><button type="button" class="btsn btn-secondary">취소</button></a>
		<button type="submit" class="btn btn-secondary">수정하기</button>
		<a href="/member/delete?id=${ses.id }"><button type="button" class="btn btn-secondary">탈퇴하기</button></a>
</form>



</div>




<jsp:include page="../layout/footer.jsp"></jsp:include>