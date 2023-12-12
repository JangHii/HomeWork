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
	background-color: black
}

.container{
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.borderbox{
	width: 700px;
	padding: 50px;
	background-color: black;
	text-align: center;
}

input[type="text"],input[type="password"]{
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



</style>
</head>
<body>

<!-- (a) get: 페이지이동(적은데이터) => 주소표시줄에 데이터를 ? 쿼리스트링으로 달고 이동 
	 (form) post: 데이터등록(많은데이터를 이동) => 별도의 저장공간에 담아서 이동  -->
<div class = 'container'>
	<form action="/memb/login" method="post" class="borderbox">
		<h1>핫냥 홈페이지</h1>
			<c:if test="${ses.id eq null}">
				<input type="text" name="id" placeholder="아이디"><br>
				<input type="password" name="pwd" placeholder="비밀번호"><br>
				<button type="submit">로그인</button>	
				<a href="/memb/join"><button type="button">회원가입</button></a>
			</c:if>
				<!-- != ne / == eq -->
				<c:if test="${ses.id ne null }">
					<a href="/brd/register"><button type="button">글쓰기</button></a>
					<a href="/brd/list"><button type="button">게시판 리스트</button></a>
					<a href="/memb/detail"><button type="button">회원정보수정</button></a>
					<a href="/memb/list"><button type="button">회원리스트</button></a>
					<a href="/memb/logout"><button type="button">로그아웃</button></a><br>
				</c:if>
	</form>
</div>









<script type="text/javascript">

	const msg_login = `<c:out value="${msg_login}" />`;
	console.log(msg_login);
	
	if(msg_login == '-1'){
		alert('로그인정보가 일치하지 않습니다.');
		
	}

	
	const msg_login1 = `<c:out value="${msg_login}" />`;
	const id = `<c:out value="${ses.id}" />`;
	console.log(msg_login);
	
	if(msg_login == '2' ){
		alert(`
		${ses.id }님이 로그인 하셨습니다.
		계정생성일 : ${ses.regdate }
		마지막접속 : ${ses.lastlogin }`);
	}
	
	
	
	const msg_modify = `<c:out value="${msg_modify}" />`;
	console.log(msg_modify);
	
	if(msg_modify == "ok"){
		alert('회원정보가 수정되었습니다. 다시 로그인해주세요.');
	}
	
	const msg_remove = `<c:out value="${msg_remove}" />`;
	console.log(msg_remove);
	
	if(msg_remove == "-1"){
		alert('더럽고 치사하다!!! 잘먹고잘살아라!!!!');
	}
</script>

</body>
</html>