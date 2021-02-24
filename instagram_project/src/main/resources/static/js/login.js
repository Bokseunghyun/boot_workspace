/**
 * 
 */

var img = document.getElementsByClassName('leftImage')[0];
var loginBtn = document.getElementsByClassName('loginBtn')[0];
var id = document.getElementById('username');
var pw = document.getElementById('password');

id.addEventListener('keyup', loginCheck);
pw.addEventListener('keyup', loginCheck);


//로그인 버튼 색 활성화
function loginCheck() {
    if(id.value !== "" && pw.value !== "") {
        loginBtn.style.backgroundColor = "#0095f6";
        loginBtn.disabled=false;
    } 
    else {
        loginBtn.style.backgroundColor = "#b2dffc";
        loginBtn.disabled=true;
    }
}

//휴대폰 속 이미지 넘기기
var imgNum = 1;
//setInterval()는 일정한 시간 간격으로 함수를 반복 실행 
setInterval(changeImgs, 3000);

function changeImgs() {
    if (imgNum > 5) {
        imgNum = 1;
    }
    img.style.backgroundImage = `url('images/image${imgNum}.jpg')`;
    imgNum++;
}



