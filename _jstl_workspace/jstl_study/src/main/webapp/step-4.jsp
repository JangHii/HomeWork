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

<br>
<hr>
<br>

과일 1 : ${paramValues.food[0] }<br>
과일 2 : ${paramValues.food[1] }<br>
과일 3 : ${paramValues.food[2] }<br>
과일 4 : ${paramValues.food[3] }<br>
과일 5 : ${paramValues.food[4] }<br>

<h3>c:forEach를 사용한 출력</h3>
<!-- varStatus index(0번지부터시작) , count(1부터시작) -->
<c:forEach items="${paramValues.food }" var="foods" varStatus="st">
	과일 ${st.index} / ${st.count} : ${foods }<br>
</c:forEach>

<%
	String friends[] = {"삼겹살" , "소주" , "족발" , "맥주"};
	// java Controller에서 jsp로 데이터를 보낼 떄 사용
	request.setAttribute("f", friends);
%>

<br><hr>

<c:forEach items="${f }" var="fname" varStatus="st"> <!-- "${requestScope.f }" = requestScope 안써도댐 -->
	count : ${st.count } /
	index : ${st.index } /
	${fname }<br>

</c:forEach>

<br>
<hr>

<!-- begin="시작숫자" end="끝숫자" var="요소저장변수"-->
<c:forEach begin="1" end="10" var="i"> <!-- for문 -->
	${i }
</c:forEach>

</body>
</html>