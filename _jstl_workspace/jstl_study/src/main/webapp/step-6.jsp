<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    // post 방식의 한글처리
    // 자바에서 처리해야함
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>주문자명 : ${param.name }</h3>

주문하신 메뉴 <br>
<c:forEach items="${paramValues.food }" var="foods" varStatus="st">
	${st.count } : ${foods }<br>
</c:forEach>
주문완료 <br>

<a href="step-7.jsp">step-7.jsp로 이동</a>

</body>
</html>