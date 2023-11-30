<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Detail Page</h1>
	
<form action="/memb/modify" method="post">	
	ID : <input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
	PW : <input type="text" name="pwd" placeholder="${ses.pwd }"><br>
	EMAIL : <input type="text" name="email" placeholder="${ses.email }"><br>
	AGE : <input type="text" name="age" placeholder="${ses.age }"><br>
<button type="submit">수정</button>
</form>
<a href="/memb/remove"><button type="button">회원탈퇴</button></a>


	</body>
</html>