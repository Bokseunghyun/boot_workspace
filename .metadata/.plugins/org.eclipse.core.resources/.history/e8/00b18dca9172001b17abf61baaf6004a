<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>insta Profile</title>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="shortcut icon" href="/images/favicon.ico">
  <link rel="stylesheet" href="/css/styles.css">
  <link rel="stylesheet" href="/css/modal.css">
  
</head>
<body>
 <%@ include file="../include/nav.jsp"%>
 
  <main id="profile">
  
    <header class="profile__header">
      <div class="avatar__container">
      
          <form id="frm_profile_img" action="/user/profileUpload" method="post" enctype="multipart/form-data">
            <input type="file" name="profileImage" id = "profileImage" style="display: none;"/>
          </form>
          <img src="/upload/${user.profileImage}" id="profile_image" onerror="this.onerror=null; this.src='/images/avatar.jpg'"style="cursor:pointer" />
      </div>
      <div class="profile__info">
        <div class="profile__title">
          <h1>${user.username}</h1>
          
          <c:if test="${principalId.vo.id ne user.id}">
          	<div id="follow_check">
          <c:choose>
			<c:when test="${followCheck eq  1}">
				<button onClick="follow(false, ${user.id})" class="profile_edit_btn">unFollow</button>
			</c:when>
			<c:otherwise>
				<button onClick="follow(true, ${user.id})" class="profile_follow_btn">Follow</button>
			</c:otherwise>
		</c:choose>

			</div>
          </c:if>
          
          <c:if test="${principalId.vo.id eq user.id}">
          <a href="/image/upload">
            <button class="profile_edit_btn">사진 업로드</button>
          </a>
          <a href="../edit-profile">
            <button class="profile_edit_btn">프로필수정</button>
          </a>
          </c:if>
          
          <i class="fa fa-cog fa-lg"></i>
        </div>

        <ul class="profile__stats">
          <li class="profile__stat">
            <span class="profile__stat-number">${imageCount}</span> posts
          </li>
          <li class="profile__stat">
            <span class="profile__stat-number">${followerCount}</span><a href="/follow/follower/${user.id}">Follower</a>
          </li>
          <li class="profile__stat">
            <span class="profile__stat-number">${followCount}</span><a href="/follow/follow/${user.id}">Following</a>
          </li>
        </ul>
        <p class="profile__bio">
          <span class="profile__fullname">Nicolás Serrano Arévalo</span>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit.
          Voluptas repellendus cumque quo voluptatum voluptatem,
          maxime nobis. Quae incidunt cum expedita facilis libero officiis,
          delectus inventore tempore, ex nulla dolore cumque.
          <a href="http://serranoarevalo.com" class="profile__link">serranoarevalo.com</a>
        </p>
      </div>
    </header>
    <div class="profile__photo-grid">
      <div class="profile__photo-row">
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
      </div>
      <div class="profile__photo-row">
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
      </div>
      <div class="profile__photo-row">
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
        <div class="profile__photo">
          <a href="image-detail.html">
            <img src="/images/feedPhoto.jpg">
            <div class="profile__photo-overlay">
              <span class="profile__photo-stat">
                <i class="fa fa-heart"></i> 504
              </span>
              <span class="profile__photo-stat">
                <i class="fa fa-comment"></i> 22
              </span>
            </div>
          </a>
        </div>
      </div>
    </div>
  </main>
 <div class="profile__overlay">
    <i class="fa fa-times"></i>
    <div class="profile__overlay-container">
      <a href="#" class="profile__overlay-link">Change password</a>
      <a href="#" class="profile__overlay-link">Authorize Apps</a>
      <a href="#" class="profile__overlay-link">Notifications</a>
      <a href="#" class="profile__overlay-link" id="logout">Log Out</a>
      <a href="#" class="profile__overlay-link" id="cancel">Cancel</a>
    </div>
  </div>
<%@include file="../include/footer.jsp"%>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="/js/app.js"></script>
  <script src="/js/profileFollow.js"></script>
  
  <script>
  	var userId = ${user.id};
  	var principalId = ${principalId.vo.id};
  	$(function() {
		//이미지 클릭시 업로드창 실행
		$('#profile_image').click(function() {
			if(userId === principalId){
				$("input[name='profileImage']").click();
			}
		})
		//이미지 변경
		$("input[name='profileImage']").change(function() {
			
			$("#frm_profile_img").submit();
		})
	})
    </script>
</body>

</html>