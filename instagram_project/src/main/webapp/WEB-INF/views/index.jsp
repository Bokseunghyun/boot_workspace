<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href=/css/index.css>
 <link rel="shortcut icon" href="#">
<title>Insert title here</title>
</head>

<body>


<div id="login">
	<div class = "loginLeft">
		<div class="leftImage"></div>
	</div>
	
		<div class="loginBox">
 			<div class="loginBox2">
	 			<div class="logo"></div>
 					<div class="loginInput">
 						<form id="loginForm" method="post">
 							<input placeholder="전화번호, 사용자 이름 또는 이메일" aria-required="true" name="username" id="username" type="text" class="Form Id"/>
 							<input placeholder="비밀번호" name="password" id="password" type="password" class="Form Pw"/>
 							<button role="submit" class="loginBtn" name="loginBtn">로그인</button>
 						</form>
 						
 						<div class="or">
                        	<div class="line"></div>
                        	<div class="lineText">또는</div>
                        	<div class="line"></div>
                  	  	</div>
                  	  	
 						<button class="facebookLogin">
 						<span class="facebookImage"></span>
 						<span class="facebookText" onclick="location.href='/login/facebook'">Facebook으로 로그인</span>
 						</button>
                    	<div class="forget">비밀번호를 잊으셨나요?</div>
                  	  	
 					</div>
 				
 			</div>
 			
 						<div class="join">
                  	  		<span>계정이 없으신가요?</span>
                  	  	 	<a href="/user/register">가입하기</a>
                  	  	</div>
                  	  	
            			<div class="downloadApp">
                			<span>앱을 다운로드하세요.</span>
                			<div class="downloadImage">
                    			<div class="appStore"><a href="https://apps.apple.com/app/instagram/id389801252?vt=lo"></a></div>
                    			<div class="googlePlay"><a href="https://play.google.com/store/apps/details?id=com.instagram.android&referrer=utm_source%3Dinstagramweb%26utm_campaign%3DloginPage%26ig_mid%3D9446C131-33F4-463C-A2B1-D088E9F481AE%26utm_content%3Dlo%26utm_medium%3Dbadge"></a></div>
                			</div>
						</div>
</div>
</div>


<script src="js/login.js"></script>

<%@include file="include/footer.jsp"%>
</body>
</html>