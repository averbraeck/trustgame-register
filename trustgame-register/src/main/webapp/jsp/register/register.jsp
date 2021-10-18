<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>TrustGame Registration</title>

    <link rel="stylesheet" type="text/css" href="/trustgame-register/css/register.css" />
    <script src="/trustgame-register/js/register.js"></script>

    <style>
    table, th, td {
    	border: 1px solid gray;
    	border-spacing: 0px;
    	border-collapse: collapse;
    	padding: 5px;
    	vertical-align: top;
    }
    
    body {
    	line-height: 1.2;
    }
    </style>

  </head>

  <body onload="initPage()">
    <div class="tg-page">
      <div class="tg-header">
        <span class="tg-freightbooking">TransSonic FreightBooking Game</span>
        <!--  span class="tg-slogan">Game Self Registration</span -->
      </div>
      <div class="tg-header-right">
        <img src="images/nwo.png" />
        <img src="images/tudelft.png" />
      </div>

      <div class="tg-register-body">
      
        <div class="tg-register-top-message">
          <h1>Registration for the FreightBooking Game</h1> 
        </div>
      
        <div class="tg-register" id="tg-register">
          ${registerData.getContentHtml()}
        </div>
        
        <div class="tg-register-bottom-message">
          <p>This game is part of the research project Trans-SONIC 
            (<a href="https://transsonic.nl" target="_blank">https://transsonic.nl</a>) in which we 
            aim to explore the influence of trust on technology-mediated collaborations. 
          </p>
          <p> 
            This self registration app has been tested with the latest versions of <b>Chrome</b>, <b>Firefox</b> and <b>Edge</b>. 
            The self registration works best on a HD screen with a resolution of 1920 x 1080 pixels, and has <b>not</b> been
            designed for a mobile phone.
          </p>
          <p> 
            If you have any questions about the game or the research, feel free to contact 
            Anique Kuijpers at TU Delft (<a href="mailto:a.g.j.kuijpers@tudelft.nl">a.g.j.kuijpers@tudelft.nl</a>).
          </p>
      </div>
      
      </div> <!-- tg-body -->
      
    </div> <!-- tg-page -->
    
    <!-- modal window for the client information within an order -->
    
    ${registerData.getModalWindowHtml()}

  </body>

</html>