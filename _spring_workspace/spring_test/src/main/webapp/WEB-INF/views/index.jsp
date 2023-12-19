<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         



<jsp:include page="layout/header.jsp"></jsp:include>

<!-- 여기서부터 모든 작업을 시작하면된다. -->


<h1>
	Hello world!  
</h1>

<c:if test="${ses.id ne null }">
	<div>

		<p>${ses.id }님 안녕하세요~!!</p>
		<span class="badge text-bg-secondary">${ses.last_login }</span>

	</div>
</c:if>






<script>

	const msg_login = `<c:out value="${msg_login}"/>`;
	if(msg_login === "1"){
		alert("로그인 실패~!!!");
	}
	
	const msg_modify = `<c:out value="${msg_modify}"/>`;
	if(msg_modify === "1"){
		alert("회원정보가 수정되었습니다~!!!");
	}
	
	const msg_logout = `<c:out value="${msg_logout}"/>`;
	if(msg_modify ==null && msg_logout === "1"){
		alert("로그아웃 되었습니다~!!!");
	}
	
	const msg_delete = `<c:out value="${msg_delete}"/>`;
	if(msg_delete === "1"){
		alert("회원탈퇴 되었습니다~!!!");
	}
	
	

</script>

<jsp:include page="layout/footer.jsp"></jsp:include>