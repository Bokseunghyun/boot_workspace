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
	var likeCount = $("#photo_likes_count_"+imageId).text();
	if (msg ==="like"){
		//.toggleClass 있으면 제거 없으면 추가
		$("#"+imageId).toggleClass("heart-clicked fa-heart fa-heart-o");
		$("#photo_likes_count_"+imageId).text(Number(likeCount)+1);
	}else if(msg ==="nolike"){
		$("#photo_likes_count_"+imageId).text(Number(likeCount)-1);
		$("#"+imageId).toggleClass("heart-clicked fa-heart fa-heart-o");
	}
		else{
		console.log(msg);
	}
}