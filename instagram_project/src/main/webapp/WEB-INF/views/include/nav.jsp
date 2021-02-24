<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principalId" />
</sec:authorize>
  <nav class="navigation">
    <a href="/feed">
      <img src="/images/logo.png" />
    </a>
    <input type="text" placeholder="Search">
    <div class="navigation__links">
      <a href="/explore/" class="navigation__link">
          <i class="fa fa-compass"></i>
      </a>
      <a href="#" class="navigation__link follow_popup">
          <i class="fa fa-heart-o"></i>
      </a>
      <a href="/user/profile/${principalId.vo.id}" class="navigation__link">
          <i class="fa fa-user-o"></i>
      </a>
    </div>
  </nav>
  
  <!-- Modal 시작 -->
<div id="modal">
  <div id="follow_popup_list">

    <div class="follow_popup_item"> 

    </div>

    
  </div>
  
</div>
<!-- Modal 끝 --> 