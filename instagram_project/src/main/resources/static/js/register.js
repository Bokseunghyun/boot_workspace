/**
 * 
 */

var id = document.getElementById('username');
var pw = document.getElementById('password');
var name = document.getElementById('name');
var registerBtn = document.getElementsByClassName('registerBtn')[0];
id.addEventListener('keyup', registerCheck);
pw.addEventListener('keyup', registerCheck);


//회원가입 버튼 색 활성화
function registerCheck() {
    if(id.value !== "" && pw.value !== "" && name.value !=="") {
    	registerBtn.style.backgroundColor = "#0095f6";
    	registerBtn.disabled=false;
    } else {
    	registerBtn.style.backgroundColor = "#b2dffc";
    	registerBtn.disabled=true;
    }
}



/*$(function(){

	$("#registerForm").validate({
	
		rules:{
			userId:{
				required : true,
				remote : {
					url: "/checkId",
					type: "post",
					data: {
						userId : function(){
						return $('#userId').val();
					}
				}
			}
		},
		userName:{
			required : true,
		},
		userPw:{
			required : true,
		}
	}
	
	})
})
*/