
//true -> unFollow , false -> Follow
//userId = id값(기본키)
//i=팔로우수
function follow(check, userId){
	let url = "/follow/"+userId;
	if(check){
		//fetch의 url요청이 이루어진 후 then함수 실행됨 (then은 fetch요청을 하고 난 후 행동을 정의)
		fetch(url,{
			method: "POST"
	    }).then(function(res){
			return res.text();							
		}).then(function(res){
			if(res === "ok"){
				var follow_check_ = document.querySelector("#follow_check");
				follow_check_.innerHTML = `<button onClick="follow(false, ${userId})" class="profile_edit_btn">unFollow</button>`;
			}
		});
	}else{
		fetch(url,{
			method: "DELETE"
	    }).then(function(res){
			return res.text();							
		}).then(function(res){
			if(res === "ok"){
				var follow_check = document.querySelector("#follow_check");
				follow_check.innerHTML = `<button onClick="follow(true, ${userId})" class="profile_follow_btn">Follow</button>`;
			}
		});
	}
}