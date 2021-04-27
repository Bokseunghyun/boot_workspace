function addComment(image_Id,username) {
	var commentInput = $("#content_"+image_Id);
	var commentList = $("#co_"+image_Id);
	console.log(commentInput.val());
	  var _data = {
			    image_Id: image_Id,
			    username: username,
			    commentText: commentInput.val()
	};
	  
	if (_data.commentText == "" || commentInput == null) {
		alert("댓글 입력이 필요합니다.");
		return;
	}


	fetch(`/comment/insert/${image_Id}`, {
		method: "post",
		body: _data.commentText,
		contentType: "plain/text; charset=utf-8",
		  dataType: "json"
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
		var co= res.data;
		var content = `
			 <ul class="photo__comments" id="co_${image_Id}">
				<li class="photo__comment">
				<span class="photo__comment-author">${_data.username}</span>
				<span style="font-size:12px;">${_data.commentText}</span>  
				</li>
				</ul>
				`;
			
			  commentList.prepend(content);
			$("#content_"+image_Id).val('');
			console.log("성공");
			location.reload();
	});
}


function deleteComment(commentId) {
	fetch("/comment/"+commentId, {
		method: "delete",
		dataType:"json"
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
		$("#co_"+commentId).remove();
		//alert("댓글 삭제 성공");
	});
}