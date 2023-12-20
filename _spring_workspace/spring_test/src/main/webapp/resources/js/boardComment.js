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
    }
})