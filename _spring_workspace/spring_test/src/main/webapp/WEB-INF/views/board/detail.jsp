<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../layout/header.jsp"></jsp:include>


<div class="container-md">
<h2>상세페이지</h2>
<br>

<!-- var를 value로 쓰겠다. -->
<c:set value="${boardDTO.bvo}" var="bvo" />

<div class="mb-3">
  <label for="bno" class="form-label">번호</label>
  <input type="text" name="bno" class="form-control" id="bno" value="${bvo.bno }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" name="title" class="form-control" id="title" value="${bvo.title }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">작성자</label>
  <input type="text" name="writer" class="form-control" id="writer" value="${bvo.writer }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="content" class="form-label">내용</label>
  <input type="text" name="content" class="form-control" id="content" value="${bvo.content }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="reg_date" class="form-label">작성일</label>
  <input type="text" name="reg_date" class="form-control" id="reg_date" value="${bvo.reg_date }" readonly="readonly">
</div>
<div class="mb-3">
  <label for="read_count" class="form-label">조회수</label>
  <input type="text" name="read_count" class="form-control" id="read_count" value="${bvo.read_count }" readonly="readonly">
</div>

<!-- 파일표시라인 -->
<c:set value="${boardDTO.flist}" var="flist" />
<div>
	<ul>
	<!-- 파일 개수만큼 li를 추가하여 파일을 표시 , 타입이 1인경우만 표시 -->
	<!-- 
		li -> div => img 그림표시
			  div => 파일이름 , 작성일 , span size 
	 -->
	 <!-- 파일 리스트 중 하나만 가져와서 fvo로 저장 -->
	 <c:forEach items="${flist}" var="fvo">
		<li>
			<c:choose>
				<c:when test="${fvo.file_type > 0 }">
					<div>
						<!-- /upload/save_dir/uuid_file_name -->
						<img alt="" src="/upload/${fn:replace(fvo.save_dir, '\\' , '/') }/${fvo.uuid}_th_${fvo.file_name}">
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<!-- 아이콘 같은 모양 하나 가져와서 넣기 -->
					</div>
				</c:otherwise>
			</c:choose>
			<div>
				<!-- div => 파일이름 , 작성일 , span size  -->
				<div>${fvo.file_name }</div>
				${fvo.reg_date }
			</div>
			<span>${fvo.file_size }Byte</span>
		</li>
	 </c:forEach>
	</ul>
</div>




<a href="/board/list"><button type="button" class="btn btn-primary">리스트</button></a>
<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">수정하기</button></a>
<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-secondary">삭제하기</button></a>

<br>
<hr>
<br>


<!-- 댓글 등록라인 -->
<div class="input-group mb-3">
	<span id="cmtWriter" class="input-group-text">${ses.id }</span>
	<input type="text" id="cmtText" class="form-control" placeholder="댓글을 작성해주세요.." aria-label="Recipient's username" aria-describedby="button-addon2">
	  <button id="cmtAddBtn" class="btn btn-outline-secondary" type="button" id="button-addon2">등록</button>

</div>

<br>

<!-- 댓글 표시라인 -->

<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        no. cno , writer , reg_date
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <strong>댓글 표시라인</strong>
      </div>
    </div>
  </div>
</div>



 
</div>
<br>


<script>
	const bnoVal = `<c:out value="${bvo.bno}"/>`;
</script>


<script src="/resources/js/boardComment.js"></script>

<script type="text/javascript">
spreadCommentList(bnoVal);	
</script>



<jsp:include page="../layout/footer.jsp"></jsp:include>