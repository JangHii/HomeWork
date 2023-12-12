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
	width: 500px;
	padding: 50px;
	background-color: black;
	text-align: center;
}

/* input{
	text-align: center;
	color: white;
	background-color: black;
	margin-bottom: 30px;
	background: none;
	border: 2px solid white;
	width: 180px;
	height: 20px;
	border-radius: 30px;
	padding: 10px;
} */

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

textarea{
	background-color: black;
	color: white;
}

input{
	background-color: black;
	color: white;
}

</style>
</head>
<body>
	<br>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
	
	<div class="container">
		
		<form action="/brd/edit" method="post" enctype="multipart/form-data" class="borderbox">
			<h1>핫냥 홈페이지</h1>
	<h3>수정페이지</h3>
 <input type="hidden" name="bno" value="${bvo.bno }">
	<table>
		<tr>
			<th>번호</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${bvo.title }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="30" name="content">${bvo.content }</textarea></td>
		</tr>	
		<tr>
			<th>image_file</th>
			<td>
				<input type="hidden" name="image_file" value="${bvo.imageFile }">
				<input type="file" name="new_file" >
			</td>	
		</tr>
	</table>

	<a href="/brd/modify?bno=${bvo.bno }"><button type="submit">수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
	<a href="/brd/list"><button type="button">리스트</button></a>
</form>
</div>
</body>
</html>