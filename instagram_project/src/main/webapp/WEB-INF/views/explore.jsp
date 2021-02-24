<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Explore | Jejugram</title>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    rel="stylesheet">
  <link rel="shortcut icon" href="images/favicon.ico">
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <nav class="navigation">
    <a href="/feed">
      <img src="images/logo.png" />
    </a>
    <input type="text" placeholder="Search">
    <div class="navigation__links">
      <a href="/explore" class="navigation__link">
          <i class="fa fa-compass"></i>
      </a>
      <a href="#" class="navigation__link">
          <i class="fa fa-heart-o"></i>
      </a>
      <a href="user/profile" class="navigation__link">
          <i class="fa fa-user-o"></i>
      </a>
    </div>
  </nav>
  <main id="explore">
    <ul class="explore__users u-default-box">
      <li class="explore__user">
        <div class="explore__content">
          <img src="images/avatar.jpg" />
          <div class="explore__info">
            <span class="explore__username">serranoarevalo</span>
            <span class="explore__full-name">Nicolás Serrano Arévalo</span>
          </div>
        </div>
        <button>Follow</button>
      </li>
      <li class="explore__user">
        <div class="explore__content">
          <img src="images/avatar.jpg" />
          <div class="explore__info">
            <span class="explore__username">serranoarevalo</span>
            <span class="explore__full-name">Nicolás Serrano Arévalo</span>
          </div>
        </div>
        <button>Follow</button>
      </li>
      <li class="explore__user">
        <div class="explore__content">
          <img src="images/avatar.jpg" />
          <div class="explore__info">
            <span class="explore__username">serranoarevalo</span>
            <span class="explore__full-name">Nicolás Serrano Arévalo</span>
          </div>
        </div>
        <button>Follow</button>
      </li>
      <li class="explore__user">
        <div class="explore__content">
          <img src="images/avatar.jpg" />
          <div class="explore__info">
            <span class="explore__username">serranoarevalo</span>
            <span class="explore__full-name">Nicolás Serrano Arévalo</span>
          </div>
        </div>
        <button>Follow</button>
      </li>
      <li class="explore__user">
        <div class="explore__content">
          <img src="images/avatar.jpg" />
          <div class="explore__info">
            <span class="explore__username">serranoarevalo</span>
            <span class="explore__full-name">Nicolás Serrano Arévalo</span>
          </div>
        </div>
        <button>Follow</button>
      </li>
    </ul>
  </main>
  <footer>
    <nav class="footer__nav">
      <ul class="footer__list">
        <li class="footer__item"><a href="#" class="footer__link">About us</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Support</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Blog</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Press</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Api</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Jobs</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Privacy</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Terms</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Directory</a></li>
        <li class="footer__item"><a href="#" class="footer__link">Language</a></li>
      </ul>
    </nav>
    <span class="footer__copyright">© 2017 jejugram</span>
  </footer>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="js/app.js"></script>
</body>
</html>
