<#macro page>
    <!DOCTYPE html >
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Телефонная книга</title>
        <style>
            .colortextred {
                color: red; /* Красный цвет выделения */
            }

            .colortextblue {
                color: lightskyblue; /* Синий цвет выделения */
            }

            .tableCursor {
                cursor: pointer;
            }
            .colortextwhite {
                color: white;
            }
            table, nav {
                font-family: sans-serif;
            }
            @font-face {
                font-family: "Russo One";
                src: url("static/fonts/RussoOne-Regular.ttf");
            }

        </style>
        <link href="/static/css/bootstrap.css"
              rel="stylesheet">
        <link href="/static/css/style.css"
              rel="stylesheet">

    </head>
    <body>
    <div class="container mt-3 shadow-blue p-3 mb-5 bg-opacity-25 text-center text-light w-auto">
        <#nested >
    </div>
    <div id="intro" class="img-fluid fixed-top" style=" z-index: -200000; ">
        <video style="min-width: 100%; min-height: 100%; " playsinline autoplay muted loop>
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
    <script src="/static/js/bootstrap.js"></script>
    </body>
    </html>
</#macro>