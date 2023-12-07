<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>

	<h1>Board Register Page</h1>

	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br> 작성자 : <input
			type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		내용 : <br>
		<textarea rows="10" cols="30" name="content"></textarea>
		<br>

		<!-- accept : 어떤 파일을 올릴건지 걸러내는 예)jpg만 / jpg,gif만 ....등등 -->
		첨부파일 : <input type="file" name="image_file" accept="image/png , image/jsp , image/gif , image/jpeg , image/jfif"> 

		<button type="submit">전송</button>
		<br>
	</form>
	<button type="button">리스트로</button>
</body>
</html>