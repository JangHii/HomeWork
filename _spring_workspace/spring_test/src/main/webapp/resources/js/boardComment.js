console.log("boardComment.js in");
console.log(">>> bno {}" + bnoVal);

document.getElementById("cmtAddBtn").addEventListener('click',()=>{
    const cmtText = document.getElementById("cmtText").value;
    const cmtWriter = document.getElementById("cmtWriter").innerText;
    
    if(cmtText =="" || cmtText == null){
        alert("댓글을 입력하고 등록하세요");
        document.getElementById('cmtText').focus();
        return false;
    }else{
        let cmtDate={
            bno : bnoVal,
            writer : cmtWriter,
            content : cmtText
        };
        console.log(cmtDate);
        postCommentToServer(cmtDate).then(result=>{
            console.log(result);
            if(result === '1'){
                alert("댓글이 등록되었습니다.");
                // 화면에 뿌리기
                getCommentList(bnoVal);
            }
        })
    }
})

    // 비공기 통신 구문
    async function postCommentToServer(cmtDate){
        try{
            // 목적지 경로
            const url = "/comment/post";
            const config={
                // post : 데이터를 삽입
                // get : 조회 => 생략가능
                // put(patch)  : 수정
                //delete : 삭제
                method : "post",
                headers:{ // headers를 받을떄는 무조건 객체여야한다
                    "content-type":"application/json; charset=utf-8"
                },
                // 제이슨은 무조건 string으로 바꿔서 보내야한다.
                body:JSON.stringify(cmtDate)
            };
            const resp = await fetch(url , config);
            const result = resp.text();
            return result;
        }catch(error){
            console.log(error);
        }
    }


    async function getCommentListFromServer(bno){
        try{
            const resp = await fetch("/comment/"+bno);
            const result = resp.json();
            return result;
        }catch(error){
            console.log(error)
        }
    }

    // 댓글 뿌리기
    function  spreadCommentList(bno){
        getCommentListFromServer(bno).then(result=>{
            console.log(result);
            const div = document.getElementById('accordionExample');
            if(result.length > 0){ //값이 있을때
                div.innerHTML = "";
                for(let i=0; i<result.length; i++){
                    let add = `<div class="accordion-item">`;
                    add += `<h2 class="accordion-header">`;
                    add += `<button class="accordion-button" type="button"`;
                    add += `data-bs-toggle="collapse" data-bs-target="#collapse${i}"`;
                    add += `aria-expanded="true" aria-controls="collapse${i}">`;
                    add += ` No. ${result[i].cno}  ${result[i].writer}  ${result[i].reg_date} </button> </h2>`;
                    add += `<div id="collapse${i}" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">`;
                    add += `<div class="accordion-body">`;
                    add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-success btn-sm cmtModBtn">수정</button>`;
                    add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-danger btn-sm cmtDelBtn">삭제</button>`;
                    add += `<input type="text" class="form-control cmtText" value="${result[i].content}">`;
                    add += `</div> </div> </div>`;
                    div.innerHTML += add;
                }
            }else{ //값이 없을때
                div.innerHTML = `<div class="accordion-body"><div>댓글이 없습니다.</div>`;
            }
        })
    }


    async function removeCommentDromServer(cnoVal){
        try{
            const url = "/comment/remove/"+cnoVal;
            const config ={
                method : "delete"
            }
            const resp = await fetch(url , config);
            const result = await resp.text();
            return result;
        }catch(error){
            console.log(error)
        }
    }



async function updateCommentToServer(cmtData){
    try{
        const url = "/comment/modify";
        const config = {
            method : "put",
            headers:{
                'content-type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
        }
        const resp = await fetch(url , config);
        const result = resp.text();
        return result;
    }catch(error){
        console.log(error);
    }
}




    document.addEventListener('click' , (e)=>{
        console.log(e.target);
        if(e.target.classList.contains('cmtDelBtn')){ 
            // 필요한 cno 변수값을 얻기
            let cnoVal = e.target.dataset.cno;
            console.log(cnoVal);
            removeCommentDromServer(cnoVal).then(result =>{
                if(result === "1"){
                    alert("댓글 삭제 성공~!!");
                    spreadCommentList(bnoVal);
                }
            })
        }
        if(e.target.classList.contains('cmtModBtn')){
            let cnoVal = e.target.dataset.cno;
            let div = e.target.closest('div');
            let cmtText = div.querySelector(".cmtText").value;
            let cmtData = {
                cno : cnoVal,
                content : cmtText
            };
            console.log(cmtData);
            updateCommentToServer(cmtData).then(result =>{
                if(result === "1"){
                    alert("댓글 수정 성공");
                    spreadCommentList(bnoVal);
                }
            })
        }
    })








