<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
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
	width: 800px;
	padding: 50px;
	background-color: black;
	text-align: center;
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

h3{
	color: white;
	font-size: 25px;
}

th{
	border-style: solid;
	color: white;
}

td{
	border-style: solid;
	color: white;
}

table{
	
	margin-left:auto;
	margin-right:auto;
}



</style>
</head>
<body>
<div class="container">
<div class="borderbox">


<h1>핫냥 홈페이지</h1>
<h3>회원정보 (관리자용)</h3>
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>나이</th>
		<th>가입날짜</th>
		<th>마지막로그인날짜</th>
	</tr>
	<br>
	
	<c:forEach items="${list }" var="mvo">
		<tr>
			<td>${mvo.id }</td>
			<td>${mvo.pwd }</td>
			<td>${mvo.email }</td>
			<td>${mvo.age }</td>
			<td>${mvo.regdate }</td>
			<td>${mvo.lastlogin }</td>
		</tr>
	</c:forEach>

	
</table>
<a href="/index.jsp"> <button type="button">홈으로</button> </a>
</div>
</div>
</body>
</html>