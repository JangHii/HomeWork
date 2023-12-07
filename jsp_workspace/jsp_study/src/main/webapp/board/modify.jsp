<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정페이지</h1>
<br>
<img alt="" src="/_fileUpload/${bvo.imageFile }">

<form action="/brd/edit" method="post" enctype="multipart/form-data">
 <input type="hidden" name="bno" value="${bvo.bno }">
	<table border="1" >
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
</form>

<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>

<a href="/brd/list"><button>리스트</button></a>
</body>
</html>