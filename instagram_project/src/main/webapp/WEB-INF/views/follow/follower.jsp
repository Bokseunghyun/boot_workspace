<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Costagram</title>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    rel="stylesheet">
  <link rel="shortcut icon" href="/images/favicon.ico">
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <%@ include file="../include/nav.jsp" %>
  
  <main id="explore">
  
    <ul class="explore__users u-default-box">
    
      <c:forEach var="follower" items="${followers}" varStatus="status">
	      <li class="explore__user">
	        <div class="explore__content">
	          <img src="/upload/${follower.following.profileImage}" onerror="this.onerror=null; this.src='/images/avatar.jpg'"/>
	          <div class="explore__info">
	            <span class="explore__username">${follower.following.username}</span>
	          </div>
	        </div>
	        
	        <div id="follow_item_${status.count}">
		        <c:if test="${principalId.vo.id ne follower.following.id}">
			        <c:choose>
			        	<c:when test="${follower.followState eq true}">
			        		<button onClick="follow(false, ${follower.following.id}, ${status.count})" class="following_btn">unFollow</button>		
			        	</c:when>
			        	<c:otherwise>
			        		<button onClick="follow(true, ${follower.following.id}, ${status.count})" class="follow_btn">Follow</button>
			        	</c:otherwise>
			        </c:choose>
		        </c:if>
	        </div>
	        
	      </li>
      </c:forEach>
      
    </ul>
  </main>
  
  <%@ include file="../include/footer.jsp" %>
  <script src="/js/follow.js"></script>
</body>
</html>