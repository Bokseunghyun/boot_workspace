/**
 * 
 */

async function commentSend(image_Id) {
	var content = $("#content_"+image_Id).val();
	console.log(content);
	if (content == "" || content == null) {
		alert("댓글 입력이 필요합니다.");
		return;
	}

	var data = $("#frm_"+image_Id).serialize();
	console.log(1, data);

	await fetch("/comment/insert", {
		method: "post",
		body: data,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
		}
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
			$("#content_"+image_Id).val('');
			console.log("성공");
	});
}


function commentDelete(commentId) {
	fetch("/comment/"+commentId, {
		method: "delete"
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
		//alert("댓글 삭제 성공");
		location.reload();
	});
}