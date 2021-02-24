<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel ="stylesheet" href=/css/main.css>
<title>Insert title here</title>
</head>
<body>
	<nav id="nav">
		<div class = "navBox">
			<div class="logo">
				<div class = "logoImage"></div>
			</div>
		</div>
		
		<input type="text" class="search" placeholder="검색" />
		<div class = "navImage">
		<a class = "home" href = "/" role="button"></a>
		<a class = "dm" href = "#" role="button"></a>
		<a class = "explore" href = "/explore" role="button"></a>
		<a class = "heart" href = "#" role="button"></a>
		<a class = "human" href = "#" role="button"></a>
		</div>
	</nav>	
	
	<main>
		<div class = "feeds">
			<article>
				<div class="top">
					<div class="topProfile">
						<div class="topProfile-Img"></div>
						<div class="topProfile-Name">이름</div>
					</div>
					<div class="topMore"></div>				
				</div>
				
			 <div class="articleImg"></div>
                  <div class="articleLove">
                      <div class="likeIcons">
                          <div class="likeIcons-left">
                              <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/heart.png">
                            <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/comment.png">
                            <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/share.png">  
                          </div>
                          <div class="likeIcons-right">
                              <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/bookmark.png">
                          </div>
                      </div>
			        <div class="like">ad_tiazz님 외 12명이 좋아합니다.</div>
                  </div>
                  
                  <div class="comment">
                      <div class="commented">
                          <div class="commented-User">유저1</div>
                          <div class="commented-Text">test</div>
                      </div>
                      <div class="moreComment">댓글 12개 모두 보기</div>
                      <div id="commentedArea"></div>
                  </div>
                  
                  <div class="articleTime">24분 전</div>
                  <div class="pushComment">
                      <input type="text" id="inputComment" placeholder="댓글 달기...">
                      <span id="inputBtn">게시</span>
                  </div>
              </article>
          </div>
	
                
	
	
	
	</main>
	
</body>
</html>