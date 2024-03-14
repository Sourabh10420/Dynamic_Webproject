<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
body{
	line-height: 1.5;
	font-family: 'Poppins', sans-serif;
}
*{
	margin:0;
	padding:0;
	box-sizing: border-box;
}
.container{
	max-width: 1170px;
	margin:auto;
}
.row{
	display: flex;
	flex-wrap: wrap;
}
ul{
	list-style: none;
}
.footer{
	background-color: #24262b;
    margin-block: 34%;
   
   
}
.footer-col{
   width: 25%;
   padding: 0 15px;
}
.footer-col h4{
	font-size: 18px;
	color: #ffffff;
	text-transform: capitalize;
	margin-bottom: 35px;
	font-weight: 500;
	position: relative;
}
.footer-col h4::before{
	content: '';
	position: absolute;
	left:0;
	bottom: -10px;
	background-color: #e91e63;
	height: 2px;
	box-sizing: border-box;
	width: 50px;
}
.footer-col ul li:not(:last-child){
	margin-bottom: 10px;
}
.footer-col ul li a{
	font-size: 16px;
	text-transform: capitalize;
	color: #ffffff;
	text-decoration: none;
	font-weight: 300;
	color: #bbbbbb;
	display: block;
	transition: all 0.3s ease;
}
.footer-col ul li a:hover{
	color: #ffffff;
	padding-left: 8px;
}
.footer-col .social-links a{
	display: inline-block;
	height: 40px;
	width: 40px;
	background-color: rgba(255,255,255,0.2);
	margin:0 10px 10px 0;
	text-align: center;
	line-height: 40px;
	border-radius: 50%;
	color: #ffffff;
	transition: all 0.5s ease;
}
.footer-col .social-links a:hover{
	color: red;
	background-color: red;
}

/*responsive*/
@media(max-width: 767px){
  .footer-col{
    width: 50%;
    margin-bottom: 30px;
}
}
@media(max-width: 574px){
  .footer-col{
    width: 100%;
}
}

</style>
</head>
<body>
	<footer class ="footer">
		<div class = "container">
			<div class = "row">
				<div class ="footer-col">
					<h4>Inquiry</h4>
					<ul>
					<li><a href ="#">Department</a></li>
					<li><a href ="#">Schems</a></li>
					<li><a href ="#">Syllabus</a></li>
					<li><a href ="#">E-library</a></li>
					
					</ul>
				</div>
				<div class ="footer-col">
					<h4>Contact Us</h4>
					<ul>
					<li><a href ="#">Download Forms</a></li>
					<li><a href ="#">Student Welfare</a></li>
					<li><a href ="#">Email</a></li>
					
					</ul>
				</div>
				<div class ="footer-col">
					<h4>About</h4>
					<ul>
					<li><a href ="#">Offline Login</a></li>
					<li><a href ="#">Photo Gallery</a></li>
					<li><a href ="#">The Campus</a></li>
					
					</ul>
				</div>
				<div class="footer-col">
  	 			<h4>follow us</h4>
  	 			<div class="social-links">
  	 				<a href="#"><i class="fab fa-facebook">Fb</i></a>
  	 				<a href="#"><i class="fab fa-twitter">Tw</i></a>
  	 				<a href="#"><i class="fab fa-instagram">In</i></a>
  	 				<a href="#"><i class="fab fa-linkedin-in">Ln</i></a>
  	 			</div>
  	 		</div>
			</div>
		</div>
	
	</footer>
</body>
</html>