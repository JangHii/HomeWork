<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Form 태그로 전달한 파리미터 받기 </h2>

이름 : ${param.name }<br>
나이 : ${param.age }<br>

<!-- c:if로 나이가 18세 미만이면 미성년자입니다. 라고 출력 -->

<c:if test="${param.age < 18 }">
	미성년자입니다.
</c:if>

</body>
</html>