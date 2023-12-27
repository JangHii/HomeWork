console.log("boardModify.js in");


async function removeImageFromServer(uuid){
    try{
        const url = "/board/removeImage/"+uuid;
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


document.addEventListener('click' , (e)=>{
    console.log(e.target);
    if(e.target.classList.contains("file-x")){ 
        // 필요한 cno 변수값을 얻기
        let uuidVal = e.target.dataset.uuid;
        let li = e.target.closest('li');
        li.remove();
        console.log(uuidVal);
        removeImageFromServer(uuidVal).then(result =>{
            if(result === "1"){
                console.log("파일 삭제 성공~!!");
            }
        })
    }
})