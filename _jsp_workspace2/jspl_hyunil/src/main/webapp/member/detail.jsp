<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
		width: 300px;
		padding: 50px;
		background-color: black;
		text-align: center;
	}
	
	input[type="text"],input[type="password"]{
		text-align: center;
		color: white;
		margin-bottom: 30px;
		background: none;
		border: 2px solid white;
		width: 180px;
		height: 20px;
		border-radius: 30px;
		padding: 10px;
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
	
	</style>

</head>
<body>

<div class="container">
	<form action="/memb/modify" method="post" class="borderbox">	
		<h1>회원정보 수정</h1>
		<input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
		<input type="text" name="pwd" placeholder="수정할 비밀번호"><br>
		<input type="text" name="email" placeholder="수정할 이메일"><br>
		<input type="text" name="age" placeholder="수정할 나이"><br>
		<button type="submit">수정</button>
		<a href="/index.jsp"><button type="button">취소</button></a> <br>
		<a href="/memb/remove"><button type="button">회원탈퇴</button></a>
	</form>
</div>

</body>
</html>