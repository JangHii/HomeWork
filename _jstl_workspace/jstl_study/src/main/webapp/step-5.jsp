<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 메뉴판을 체크박스 형태로 만들어 step-6.jsp로 전송 -->
	<!-- step-6.jsp에서 주문자명 어떤 메뉴를 주문했는지 순서대로 출력 -->
	<!-- 주문버튼 -->
	
	<form action="step-6.jsp" method="post">
	주문자명 : <input type="text" name="name">
	<br>
	<hr>
	<input type="checkbox" name="food" value="삼겹살">삼겹살<br>
	<input type="checkbox" name="food" value="육회">육회<br>
	<input type="checkbox" name="food" value="햄버거">햄버거<br>
	<input type="checkbox" name="food" value="치킨">치킨<br>
	<input type="checkbox" name="food" value="게장">게장<br>
	<hr>
	<button type="submit">주문하기</button>
	</form>
</body>
</html>