<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>insta</title>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    rel="stylesheet">
    <link rel="shortcut icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/modal.css">
</head>
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<body>
<%@include file="include/nav.jsp"%>
<%@include file="modal.jsp"%>

  <main id="feed">
			
		<c:forEach var="image" items="${images}">
			<div class="photo u-default-box">
				<header class="photo__header">
					<img src="/upload/${image.user.profileImage}"  onerror="this.onerror=null; this.src='/images/avatar.jpg'"/> 
					<div class="photo_user_info">
						<span class="photo__username">${image.user.username}</span>
						<span class="photo__location">${image.location}</span>
					</div>
				</header>
				<div class="photo_post_image">
					<img src="/upload/${image.postImage}" />
				</div>
				<div class="photo__info">
					<div class="photo__actions">
						<span class="photo__action"> 
							<c:choose>
								<c:when test="${image.heart eq true}">
									<i onclick="onFeedLoad(${image.id})" id = "${image.id}" class= "fa fa-heart heart heart-clicked"></i>
								</c:when>
								<c:otherwise>
								<i onclick="onFeedLoad(${image.id})" id="${image.id}" class="fa fa-heart-o heart"></i>
							</c:otherwise>
							</c:choose>
						</span> 
						
						<span class="photo__action"> 
						<i class="fa fa-comment-o"></i>
						</span>
					</div>
					<span class="photo__likes">좋아요 </span><span class="photo__likes"id="photo_likes_count_${image.id}">${image.likeCount}</span><span class="photo__likes">개</span>
					<div class="photo_caption">
						<span class="photo__username">
							${image.user.username}
						</span>
						${image.caption}
					</div>
		
					<div class="photo_tag">
						<c:forEach var="tag" items="${image.tags}">
							#${tag.name}  
						</c:forEach>
					</div>
					<ul class="photo__comments">
						<li class="photo__comment">
						<span class="photo__comment-author">${co.user}</span>
						 <span style="font-size:12px;">${co}</span>
						</li>
					</ul>
					<span class="photo__date">사진 등록일 ${image.createDate}</span>
					
					<div class="photo__add-comment-container">
					
					<form action="/comment/insert" method="POST" id="frm_${image.id}">
					<input type="hidden" name="user_Id" value="${principalId.vo.id}" />
					<input type="hidden" name="image_Id" value="${image.id}" />
						<textarea id="content_${image.id}" name = "content" placeholder="Add a comment..."></textarea>
					</form>
						<i class="fa fa-ellipsis-h" onclick ="commentSend(${image.id})"></i>
					</div>
				</div>
			</div>
						</c:forEach>
		
		
	</main>


<%@include file="include/footer.jsp"%>

<script src="/js/feed.js"></script>
<script src="/js/like.js"></script>
<script src="/js/Comment.js"></script>

</body>

</html>
    