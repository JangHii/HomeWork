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
<h1>Detail page</h1>

<form action="/brd/edit" method="post">
<%-- <input type="hidden" name="bno" value="${bvo.bno }"> --%> <!-- 18번줄과 동일함 -->
	<table border="1">
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

	</table>
</form>

<a href="/brd/modify?bno=${bvo.bno }"><button type="submit">modify</button></a>
<a href="/brd/remove?bno=${bvo.bno }"><button type="button">remove</button></a>

<a href="/brd/list"><button>list</button></a>
</body>
</html>