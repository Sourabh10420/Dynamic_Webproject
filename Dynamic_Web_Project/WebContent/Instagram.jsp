<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Instagram Login</title>
    <link rel="stylesheet" href="InstStyle.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container">
      <div class="center">
        <div class="header">
         <h2>Login Page</h2>
        </div>
        <div class="inputElement">
          <input
            type="text"
            placeholder="Phone number,username or email"
            class="inputText"
          />
          <input type="password" placeholder="Password" class="inputText" />
            <div><center><a href="https://www.instagram.com/"><input type="submit" value="Log in" class="inputButton" /></a></center></div>
          
          <div class="line">
            <span class="arrow"></span>
            <span class="content">OR</span>
            <span class="arrow"></span>
          </div>
          <div class="social__icon">
            <a href="https://www.facebook.com/login/"> <span>Log in with facebook</span></a>
            <i class="fab fa-facebook-square"></i>
           
          </div>
          <div class="forgetPassword"><center><a href="https://www.instagram.com/accounts/password/reset/">Forget Password?</a></center></div>
        </div>
      </div>
      <div class="footer">
        <p>Don't have a accout? <a href="https://www.instagram.com/accounts/emailsignup/">SignUp</a></p>
      </div>
    </div>
  </body>
</html>
