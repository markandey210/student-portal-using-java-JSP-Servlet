<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Result</title>
</head>
<style>
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
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidation");

%>

<div class="navbar">
  <a href="http://localhost:8080/StudentsPortal/registration-form">Registration Form</a>
  <a href="http://localhost:8080/StudentsPortal/exam-form">Regular Exam Form</a>
  <a href="http://localhost:8080/StudentsPortal/backpaper-form">Supplementry Exam Form</a>
    <a href="http://localhost:8080/StudentsPortal/result">Result</a>
      <a href="http://localhost:8080/StudentsPortal/logout">Logout</a>   
</div>
<form method="post" action="/StudentsPortal/result"></form>

</body>
<body>
</body>
</html>