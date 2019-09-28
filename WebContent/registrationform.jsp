<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="object.Registration" %>
<%@ page import="object.Qualification" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<!----- Using Update Form ----------------------------------------------------------->

<%
Registration registration = request.getAttribute("REGISTRATION")!=null?(Registration)request.getAttribute("REGISTRATION"):null;
String name = "";
String dob = "";
String email = "";
String mobile = "";
String gender = "";
String address = "";
String course = "";
int regnId = 0;
if(registration!=null) {
	name = registration.getName() != null && !"".equals(registration.getName()) ? registration.getName() :"";
	dob = registration.getDob() != null && !"".equals(registration.getDob()) ? registration.getDob() :"";
	email = registration.getEmail() != null && !"".equals(registration.getEmail()) ? registration.getEmail() :"";
	mobile = registration.getMobile() != null && !"".equals(registration.getMobile()) ? registration.getMobile() :"";
	gender = registration.getGender() != null && !"".equals(registration.getGender()) ? registration.getGender() :"";
	address = registration.getAddress() != null && !"".equals(registration.getAddress()) ? registration.getAddress() :"";
	course = registration.getCourse() != null && !"".equals(registration.getCourse()) ? registration.getCourse() :"";
	regnId = registration.getId();

}
%>

<%
String board_1 = "";
String persent_1 = "";
String passingyear_1 = "";
String board_2 = "";
String persent_2 = "";
String passingyear_2 = "";
String board_3 = "";
String persent_3 = "";
String passingyear_3 = "";
String board_4 = "";
String persent_4 = "";
String passingyear_4 = "";
String qualificationIds = "";
List<Qualification> qualificationList = request.getAttribute("QUALIFICATION_LIST")!=null?(List<Qualification>)request.getAttribute("QUALIFICATION_LIST"):null;
if(qualificationList != null && qualificationList.size() > 0) {
	for(Qualification qualification : qualificationList) {
		if(qualification != null) {
			if(qualification.getClassName().equalsIgnoreCase("Class X")) {
				board_1 = qualification.getBoard() != null && !"".equals(qualification.getBoard()) ? qualification.getBoard() :"";
				persent_1 = qualification.getPersentage() != null && !"".equals(qualification.getPersentage()) ? qualification.getPersentage() :"";
				passingyear_1 = qualification.getPassingYear() != null && !"".equals(qualification.getPassingYear()) ? qualification.getPassingYear() :"";
			} else if(qualification.getClassName().equalsIgnoreCase("Class XII")) {
					board_2 = qualification.getBoard() != null && !"".equals(qualification.getBoard()) ? qualification.getBoard() :"";
					persent_2 = qualification.getPersentage() != null && !"".equals(qualification.getPersentage()) ? qualification.getPersentage() :"";
					passingyear_2 = qualification.getPassingYear() != null && !"".equals(qualification.getPassingYear()) ? qualification.getPassingYear() :"";
			} else if(qualification.getClassName().equalsIgnoreCase("Graduation")) {
					board_3 = qualification.getBoard() != null && !"".equals(qualification.getBoard()) ? qualification.getBoard() :"";
					persent_3 = qualification.getPersentage() != null && !"".equals(qualification.getPersentage()) ? qualification.getPersentage() :"";
					passingyear_3 = qualification.getPassingYear() != null && !"".equals(qualification.getPassingYear()) ? qualification.getPassingYear() :"";
			} else if(qualification.getClassName().equalsIgnoreCase("PostGraduation")) {
					board_4 = qualification.getBoard() != null && !"".equals(qualification.getBoard()) ? qualification.getBoard() :"";
					persent_4 = qualification.getPersentage() != null && !"".equals(qualification.getPersentage()) ? qualification.getPersentage() :"";
					passingyear_4 = qualification.getPassingYear() != null && !"".equals(qualification.getPassingYear()) ? qualification.getPassingYear() :"";
			}
			int qualiId = qualification.getId();
			qualificationIds += qualiId +",";
		}
	}
}
%>
<!----- -------------------------------------------------- ----------------------------------------------------------->

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
  background: #a6a6c0;/* fallback for old browsers */
  background: -webkit-linear-gradient(right, #a6a6c0, #a6a6c0);
  background: -moz-linear-gradient(right, #a6a6c0, #a6a6c0);
  background: -o-linear-gradient(right, #a6a6c0, #a6a6c0);
  background: linear-gradient(to left, #a6a6c0, #a6a6c0);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}

h3{
  font-family: Calibri; 
  font-size: 15pt;         
  font-style: normal; 
  font-weight: bold; 
  color:SlateBlue;
  text-align: center; 
  text-decoration: underline
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
<form method="post" action="/StudentsPortal/registration-form">
<input type="hidden" name = "registration_id" value="<%=regnId%>">
<input type="hidden" name = "qualification_ids_str" value="<%=qualificationIds%>">
<input name="submit" value="1"/>
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
 
<!----- Gender ----------------------------------------------------------->
<tr>
<td>GENDER</td>
<td>
<input type="text" name="gender" maxlength="10" value="<%=gender %>"/>
</td>
</tr>
<!----- Address ---------------------------------------------------------->
<tr>
<td>ADDRESS <br /><br /><br /></td>
<td><textarea input type="text" name="address" rows="4" cols="80" value="<%=address %>"/><%=address %>
</textarea>
</td>
</tr>
<!----- Qualification---------------------------------------------------------->
<tr>
<td>QUALIFICATION <br /><br /><br /><br /><br /><br /><br /></td>
 
<td>
<table>
 
<tr>
<td align="center"><b>Sl.No.</b></td>
<td align="center"><b>Examination</b></td>
<td align="center"><b>Board</b></td>
<td align="center"><b>Percentage</b></td>
<td align="center"><b>Year of Passing</b></td>
</tr>
 
<tr>
<td>1</td>
<td>Class X</td>
<input type="hidden" name="class_1" value="Class X" maxlength="30"/>
<td><input type="text" name="board_1" maxlength="30"value="<%=board_1%>"/></td>
<td><input type="text" name="persentage_1" maxlength="30"value="<%=persent_1%>"/></td>
<td><input type="text" name="passingyear_1" maxlength="30"value="<%=passingyear_1%>"/></td>
</tr> 

<tr>
<td>2</td>
<td>Class XII</td>
<input type="hidden" name="class_2" value="Class XII" maxlength="30"/>
<td><input type="text" name="board_2" maxlength="30"value="<%=board_2%>"/></td>
<td><input type="text" name="persentage_2" maxlength="30"value="<%=persent_2%>"/></td>
<td><input type="text" name="passingyear_2" maxlength="30"value="<%=passingyear_2%>"/></td>
</tr> 
<tr>
<td>3</td>
<td>GRADUATION</td>
<input type="hidden" name="class_3" value="Graduation" maxlength="30"/>
<td><input type="text" name="board_3" maxlength="30"value="<%=board_3%>"/></td>
<td><input type="text" name="persentage_3" maxlength="30"value="<%=persent_3%>"/></td>
<td><input type="text" name="passingyear_3" maxlength="30"value="<%=passingyear_3%>"/></td>
</tr> 
<tr>
<td>4</td>
<td>POST GRADUATION</td>
<input type="hidden" name="class_4" value="PostGraduation" maxlength="30"/>
<td><input type="text" name="board_4" maxlength="30"value="<%=board_4%>"/></td>
<td><input type="text" name="persentage_4" maxlength="30"value="<%=persent_4%>"/></td>
<td><input type="text" name="passingyear_4" maxlength="30"value="<%=passingyear_4%>"/></td>
</tr> 
 
<tr>
<td></td>
<td></td>
<td align="center"></td>
<td align="center"></td>
</tr>
</table>
 
</td>

</tr>
 
<!----- Course ---------------------------------------------------------->
<tr>
<td>COURSE APPLIED FOR</td>
<td><input type="text" name="course" maxlength="100"  value="<%=course%>"/>
</td>
</tr>
 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<%if(registration!= null ) { %>
<input type="submit" value="Update">

<%} else { %>
<input type="submit" value="Submit">
<%} %>
 <input type="button" onclick="window.location.href = 'http://localhost:8080/StudentsPortal/welcome';" value="Back"/></br>
	<%if(null!=request.getAttribute("welcomeMessage")) { 
		out.println(request.getAttribute("welcomeMessage"));
	} %>
</td>
</tr>
</table>
</form>

</body>
</html>