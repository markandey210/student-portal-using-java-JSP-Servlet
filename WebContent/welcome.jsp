<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="object.User" %>
<!DOCTYPE html>
	<head>	
	<meta charset="ISO-8859-1">
	<title>Welcome Page</title>
	</head>
		<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidation");

%>
	
	<%User usr = session.getAttribute("USER")!=null?(User)session.getAttribute("USER"):null; %>
	 <h3>successfuly loggedin</h3>
     <h3><%=usr!=null?usr.getName():"" %></h3>
     <h3><%=usr!=null?usr.getPhone():"" %></h3>
<html lang="en">
<title>Welcome Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
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
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
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
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
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

body {font-family: "Lato", sans-serif}
.mySlides {display: none}
.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: left;
  display: block;
  color: #a6a6c0;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 18px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}

</style>
<body>

<div class="navbar">
  <a href="http://localhost:8080/StudentsPortal/registration-form">Registration Form</a>
  <a href="http://localhost:8080/StudentsPortal/exam-form">Regular Exam Form</a>
  <a href="http://localhost:8080/StudentsPortal/backpaper-form">Supplementry Exam Form</a>
    <a href="http://localhost:8080/StudentsPortal/result">Result</a>
      <a href="http://localhost:8080/StudentsPortal/logout">Logout</a>   
</div>
</body>
</html>
