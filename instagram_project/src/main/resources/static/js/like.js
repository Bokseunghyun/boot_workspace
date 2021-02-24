/**
 * 
 */

async function like(imageId){
	var response = await fetch(`/like/${imageId}`, {
		method: "POST"
	});


	
	var msg = await response.text();
	return msg;
}


//비동기 처리
async function onFeedLoad(imageId){
	var msg = await like(imageId);
	if (msg ==="ok"){
		//.toggleClass 있으면 제거 없으면 추가
		$("#"+imageId).toggleClass("heart-clicked fa-heart fa-heart-o");	
	}else{
		console.log(msg);
	}
}