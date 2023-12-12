<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>

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
	padding: 30px;
	background-color: black;
	text-align: center;
}

input[type="text"],input[type="password"],input[type="file"]{
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

textarea{
	text-align: center;
	color: white;
	margin-bottom: 30px;
	background: none;
	border: 2px solid white;
	width: 300px;
	height: 300px;
	border-radius: 30px;
	padding: 10px;
}

</style>
</head>
<body>

<div class="container">
	<form action="/brd/insert" method="post" enctype="multipart/form-data" class="borderbox">

	<h1>게시글 작성</h1>

		<input type="text" name="title" placeholder="제목"><br> 
		<input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		<textarea rows="10" cols="30" name="content" placeholder="내용"></textarea>
		<hr>

		<!-- accept : 어떤 파일을 올릴건지 걸러내는 예)jpg만 / jpg,gif만 ....등등 -->
		첨부파일 : <input type="file" name="image_file" accept="image/png , image/jsp , image/gif , image/jpeg , image/jfif"> 
		<hr>

		<button type="submit">전송</button>
		<a href="/brd/list"><button type="button">리스트로</button>
	</form>
</div>
</body>
</html>