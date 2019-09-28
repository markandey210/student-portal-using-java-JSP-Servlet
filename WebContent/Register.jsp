<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login Page</title>
<%
	String msg = request.getAttribute("Message") != null ? (String) request.getAttribute("Message") : "";
%>
</head>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #a6a6c0;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #a6a6c0;
}

.form .message {
	margin: 15px 0 0;
	color: #a6a6c0;
	font-size: 12px;
}

.form .message a {
	color: #a6a6c0;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #a6a6c0;
}

.container .info span {
	color: #a6a6c0;
	font-size: 12px;
}

.container .info span a {
	color: #a6a6c0;
	text-decoration: none;
}

.container .info span .fa {
	color: #a6a6c0;
}

body {
	background: #a6a6c0; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #a6a6c0, #a6a6c0);
	background: -moz-linear-gradient(right, #a6a6c0, #a6a6c0);
	background: -o-linear-gradient(right, #a6a6c0, #a6a6c0);
	background: linear-gradient(to left, #a6a6c0, #a6a6c0);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
</style>
<div class="login">
	<div class="form">
		<form class="register-form" method="post" action="">
			<input type="text" placeholder="name" /> <input type="password"
				placeholder="password" /> <input type="text"
				placeholder="email address" />
			<button>create</button>
			<p class="message">
				Already registered? <a href="">Sign In</a>
			</p>
		</form>
		<form class="signup-form" method="post"
			action="/StudentsPortal/signup">
<input class="text" type="text" name="Name" placeholder="Name" required=" "></br>
					<input class="text " type="text" name="Contact_No" placeholder="Contact" required=""></br>
					<input class="text" type="text" name="User_Name" placeholder="Username" required="">
					<input class="text w3lpass" type="password" name="Password" placeholder=" Password" required="">			<button type="submit">SIGN-UP</button>
			<p class="message">
				Already have an Account?<a
					href="http://localhost:8080/StudentsPortal/login">Login Now!</a>
			</p>
			</br>
			<center>
				<h2>${someMessage}</h2>
			</center>
			</div>
			</div>
			</body>
			</form>
			</div>
			</div>
			</html>