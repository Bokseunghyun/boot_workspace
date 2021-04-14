function addComment(image_Id,username) {
	var commentInput = $("#content_"+image_Id);
	var commentList = $("#co_"+image_Id);
	console.log(commentInput);
	  let _data = {
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
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
		}
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