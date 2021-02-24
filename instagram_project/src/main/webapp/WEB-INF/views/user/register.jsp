<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href=/css/register.css>
<title>Insert title here</title>
</head>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.js"></script>

<body>
<div id="login">

	
		<div class="loginBox">
 			<div class="loginBox2">
	 			<div class="logo"></div>
 					<div class="loginInput">
 						<form:form id="registerForm" method="post" modelAttribute="userVO" autocomplete="off">
 							<form:input path ="username" placeholder="아이디"  aria-required="true" name="username" type="text" class="Form Id" id="username"/>
 							<form:errors path="username"/>
 							<form:input path ="name" placeholder="사용자 이름" name="name" type="text" class="Form Id" id="name"/>
 							<form:errors path="name"/>
 							<form:password path = "password" placeholder="비밀번호" name="password" class="Form Pw" id="password"/>
 							<form:errors path="password"/>
 							<form:input path ="phone" placeholder="휴대폰 번호" name="phone" type="text" class="Form Id" id="phone"/>
 							<form:errors path="phone"/>
 							<button type="submit" class="registerBtn">가입</button>
 						</form:form>
 						
 						<div class="or">
                        	<div class="line"></div>
                        	<div class="lineText">또는</div>
                        	<div class="line"></div>
                  	  	</div>
                  	  	
 						<button class="facebookLogin">
 						<span class="facebookImage"></span>
 						<span class="facebookText">Facebook으로 로그인</span>
 						</button>
                    	<div class="forget">비밀번호를 잊으셨나요?</div>
                  	  	
 					</div>
 				
 			</div>
 			
 						<div class="join">
                  	  		<span>계정이 있으신가요?</span>
                  	  	 	<a href="/">로그인</a>
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
<script src="/js/register.js"></script>

</body>
</html>