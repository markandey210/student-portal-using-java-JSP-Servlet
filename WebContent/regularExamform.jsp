<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="object.Regular" %>
    
<!DOCTYPE html>
<html>
<head>
<%
Regular regular = request.getAttribute("REGULAR")!=null?(Regular)request.getAttribute("REGULAR"):null;
String name = "";
String dob = "";
String email = "";
String mobile = "";
String recipt = "";
String gender = "";
String address = "";
String course = "";
int regid = 0;

if(regular!=null) {
	name = regular.getName() != null && !"".equals(regular.getName()) ? regular.getName() :"";
	dob = regular.getDob() != null && !"".equals(regular.getDob()) ? regular.getDob() :"";
	email = regular.getEmail() != null && !"".equals(regular.getEmail()) ? regular.getEmail() :"";
	mobile = regular.getMobile() != null && !"".equals(regular.getMobile()) ? regular.getMobile() :"";
	recipt = regular.getRecipt() != null && !"".equals(regular.getRecipt()) ? regular.getRecipt() :"";
	gender = regular.getGender() != null && !"".equals(regular.getGender()) ? regular.getGender() :"";
	address = regular.getAddress() != null && !"".equals(regular.getAddress()) ? regular.getAddress() :"";
	course = regular.getCourse() != null && !"".equals(regular.getCourse()) ? regular.getCourse() :"";
	regid = regular.getId();
}
%>


<title>Student Regular Form</title>
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


table{
  font-family: Calibri; 
  color:white; 
  font-size: 11pt; 
  font-style: normal;
  font-weight: bold;
  text-align:; 
  background-color: skyblue; 
}
table.inner{
  border: 5px
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
<form method="post" action="/StudentsPortal/exam-form">
<input name="submit" value="1"/>
<input type="hidden" name="regular_id" value="<%=regid%>"/>
<table align="center" cellpadding = "18"> 
<tr>
<td></td>
<td>
</td>
</tr>
 
<tr>
<td>NAME</td>
<td><input type="text" name="name" maxlength="30" value="<%=name%>"/>
</td>
</tr>
 
 
<!----- Date Of Birth -------------------------------------------------------->
<tr>
<td>DATE OF BIRTH</td>
<td>
<input type="text" name="dob" value="<%=dob %>"/>
</td>
</tr>
 
<!----- Email Id ---------------------------------------------------------->
<tr>
<td>EMAIL ID</td>
<td><input type="text" name="email" maxlength="100" value="<%=email %>" /></td>
</tr>
 
<!----- Mobile Number ---------------------------------------------------------->
<tr>
<td>MOBILE NUMBER</td>
<td>
<input type="text" name="mobileno" maxlength="10" value="<%=mobile%>"/>
</td>
</tr>
  
 <!----- RECIPT NO ---------------------------------------------------------->
<tr>
<td>RECIPT NO</td>
<td>
<input type="text" name="reciptno" maxlength="10" value="<%=recipt%>"/>
</td>
</tr>
 
<!----- Gender ----------------------------------------------------------->
<tr>
<td>GENDER</td>
<td>
<input type="text" name="gender" maxlength="10"value="<%=gender%>"/>
</tr>
<!----- Address ---------------------------------------------------------->
<tr>
<td>ADDRESS <br /><br /><br /></td>
<td><textarea input type="text" name="address" rows="4" cols="80" value="<%=address %>"/><%=address %>
</textarea>
</td>
</tr>
<!----- Course ---------------------------------------------------------->
<tr>
<td>COURSE APPLIED FOR</td>
<td><input type="text" name="course" maxlength="100"  value="<%=course%>"/>
</td>td>
</tr>
 
<!----- Submit and Back ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<%if(regular!= null ) { %>
<input type="submit" value="Update">

<%} else { %>
<input type="submit" value="Submit">

<%} %>
 <input type="button" onclick="window.location.href = 'http://localhost:8080/StudentsPortal/welcome'" value="Back"/></br>
	<%if(null!=request.getAttribute("welcomeMessage")) { 
		out.println(request.getAttribute("welcomeMessage"));
	} %>

</td>
</tr>
</table>
</form>
</body>
</html>