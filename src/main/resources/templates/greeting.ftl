<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Телефонная книга</title>

    <link href="static/css/bootstrap.css"
          rel="stylesheet">
    <link href="/static/css/style.css"
          rel="stylesheet">
    <style>
        @font-face {
            font-family: "Russo One";
            src: url("static/fonts/RussoOne-Regular.ttf");
        }
    </style>
</head>
<body>
<#--<a class="btn btn-outline-info m-2 text-light" href="/login">Войти</a>-->
<div class="greetingContainer">
    <h1 class="greetingText">Добро пожаловать! Перейдите в телефонный справочник предприятия: АО «ЭлектроСИГНАЛ»</h1>
    <br>
    <a class="greetingBtn" href="/phoneBook">
    <span class="button__line button__line--top"></span>
    <span class="button__line button__line--right"></span>
    <span class="button__line button__line--bottom"></span>
    <span class="button__line button__line--left"></span>
        Телефонный справочник
    </a>
</div>
<div id="intro" class="img-fluid position-fixed top-50 start-50 translate-middle shadow-1-strong "
     style="z-index: -2000000;">
    <video style="min-width: 100%; min-height: 100%;" playsinline autoplay muted loop>
        <source class="h-100" src="/static/video/Lines.mp4" type="video/mp4"/>
    </video>
    <div class="mask" style="
        background: linear-gradient(
          45deg,
          rgba(29, 236, 197, 0.7),
          rgba(91, 14, 214, 0.7) 100%
        );
      ">
    </div>
</div>

<script src="static/js/bootstrap.js"></script>
</body>
</html>