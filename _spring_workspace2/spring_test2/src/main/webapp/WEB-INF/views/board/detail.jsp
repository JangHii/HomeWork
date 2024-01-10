<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../layout/header.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<div class="container-md">
	<br>
	<h2>Board Detail Page</h2>
	<br>
	<div class="mb-3">
		<label for="bno" class="form-label">#</label> <input type="text"
			name="bno" class="form-control" id="bno" value="${bvo.bno }"
			readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="title" class="form-label">Title</label> <input type="text"
			name="title" class="form-control" id="title" placeholder="title"
			value="${bvo.title }">
	</div>
	<div class="mb-3">
		<label for="writer" class="form-label">writer</label> <input
			type="text" name="writer" class="form-control" id="writer"
			value="${bvo.writer }" readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="regAt" class="form-label">regdate</label> <input
			type="text" name="regAt" class="form-control" id="regAt"
			value="${bvo.regAt }" readonly="readonly"> <span
			class="badge bg-secondary">${bvo.readCount}</span>
	</div>
	<div class="mb-3">
		<label for="content" class="form-label">content</label>
		<textarea class="form-control" name="content" id="content" rows="3">${bvo.content }</textarea>
	</div>

	<!-- 파일 표시 라인 -->
<%-- 	<c:set value="${boardDTO.flist }" var="flist" />
	<div class="mb-3">
		<ul class="list-group list-group-flush">
		<!-- 파일 개수만큼 li를 추가하여 파일을 표시, 타입이 1인 경우만 표시 -->
		<!-- 
			li -> div => img 그림표시
				  div => 파일이름, 작성일, span size
		 -->
		 <!-- 파일 리스트 중 하나만 가져와서 fvo로 저장 -->
		 <c:forEach items="${flist }" var="fvo">
		 <div>
			<li class="list-group-item">
				<c:choose>
					<c:when test="${fvo.file_type > 0 }">
						<div>
						<!-- /upload/ -> servlet-context에 매핑 설정되어 있어서 사용함 -->
						<!-- /upload/save_dir/uuid_file_name -->
						<!-- 썸네일 버전 : src="/upload/${fn:replace(fvo.save_dir, '\\', '/') }/${fvo.uuid}_th_${fvo.file_name}" -->
							<img alt="" src="/upload/${fn:replace(fvo.save_dir, '\\', '/') }/${fvo.uuid}_${fvo.file_name}">
						</div>
					</c:when>
					<c:otherwise>
						<div>
							<!-- 아이콘 같은 모양 하나 가져와서 넣기 -->
						</div>
					</c:otherwise>
				</c:choose>
				<div>
				<!-- div => 파일이름, 작성일, span size -->
					<div>${fvo.file_name }</div>
					<div>${fvo.reg_date }</div>
					<div><span class="badge text-bg-warning">${fvo.file_size }byte</span></div>
				</div>
			</li>
			</div>
		</c:forEach>
		</ul>
		--%>
		<br><br>
	<div class="position-relative">
	<div class="position-absolute bottom-0 end-0">
		<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-primary">Modify</button></a> 
		<a href="/board/list"><button type="button" class="btn btn-secondary">list..</button></a>
	</div>
	</div>
	<br>
	
   <!-- 댓글 등록 라인 -->
   <div class="input-group mb-3">
	  <span class="input-group-text" id="cmtWriter">${bvo.writer }</span>
	  <input type="text" class="form-control" id="cmtText" aria-label="Amount (to the nearest dollar)">
	  <button type="button" class="btn btn-success" id="cmtPostBtn">Post</button>
	</div>
   
   <!-- 댓글 표시 라인 -->
   <ul class="list-group list-group-flush" id="cmtListArea">
	  <li class="list-group-item">
	  	<div class="mb-3">
	  		<div class="fw-bold">Writer</div>
	  		content
	  	</div>
	  	<span class="badge rounded-pill text-bg-warning">modAt</span>
	  </li>
	</ul>
	
	<!-- 댓글 더보기 버튼 -->
	<div>
		<button type="button" id="moreBtn" data-page="1" class="btn btn-outline-dark" style="visibility:hidden">댓글더보기</button>
	</div>
	
	<!-- 모달창 라인 -->
	<div class="modal" id="myModal" tabindex="-1">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title">Writer</h5>
        			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      			</div>
      			<div class="modal-body">
        			<div class="input-group mb-3">
        				<input type="text" class="form-control" id="cmtTextMod">
        				<button type="button" class="btn btn-primary" id="cmtModBtn">Post</button>
        			</div>
      			</div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      			</div>
    		</div>
  		</div>
	</div>
	
	
	<%--
	<hr>
	<!-- 댓글 등록 라인 -->
	<div class="input-group">
		<span id="cmtWriter" class="input-group-text">${ses.id }</span> <input
			type="text" id="cmtText" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2"
			placeholder="Add Comment...">
		<button class="btn btn-outline-secondary" type="button" id="cmtAddBtn">Add</button>
	</div>
	<br>

	<!-- 댓글 표시 라인 -->
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">cno,
					writer, ref_date</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Add comment...</strong>
				</div>
			</div>
		</div>
	</div> --%>



</div>

<br>


<script type="text/javascript">
let bnoVal = `<c:out value="${bvo.bno}" />`;
console.log(bnoVal);
</script>
<script src="/resources/js/boardComment.js"></script>
<script type="text/javascript">
spreadCommentList(bnoVal);
</script>

<!-- <script>
	const bnoVal = `<c:out value="${bvo.bno}"/>`;
</script>
<
<script src="/resources/js/boardComment.js"></script>
<script>
	getCommentList(bnoVal);
</script> -->

<jsp:include page="../layout/footer.jsp"></jsp:include>