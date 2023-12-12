<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="memb/register" method="post" class="borderbox">
		<h1>회원가입</h1>
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pwd" placeholder="비밀번호"><br>
			<input type="text" name="email" placeholder="이메일"><br>
			<input type="text" name="age" placeholder="나이"><br>
			<button type="submit">회원가입</button>
			<a href="/index.jsp"><button type="button">취소</button></a> 
	</form>
	
	
</div>

</body>
</html>