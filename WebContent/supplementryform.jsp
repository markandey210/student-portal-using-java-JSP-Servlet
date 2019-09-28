<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="object.Supplementry" %>
     <%@ page import="object.Semester" %>           
<!DOCTYPE html>
<html>
<head>
<title>Student Supplementry Form</title>
</head>

<%
Supplementry supplementry = request.getAttribute("SUPPLEMENTRY")!=null?(Supplementry)request.getAttribute("SUPPLEMENTRY"):null;
String name = "";
String dob = "";
String email = "";
String mobile = "";
String reg = "";
String backsem = "";
String address = "";
String course = "";
int suppId = 0;

if(supplementry!=null) {
	name = supplementry.getName() != null && !"".equals(supplementry.getName()) ? supplementry.getName() :"";
	dob = supplementry.getDob() != null && !"".equals(supplementry.getDob()) ? supplementry.getDob() :"";
	email = supplementry.getEmail() != null && !"".equals(supplementry.getEmail()) ? supplementry.getEmail() :"";
	mobile = supplementry.getMobile() != null && !"".equals(supplementry.getMobile()) ? supplementry.getMobile() :"";
	reg = supplementry.getRegistration() != null && !"".equals(supplementry.getRegistration()) ? supplementry.getRegistration() :"";
	backsem = supplementry.getSupplementrySem() != null && !"".equals(supplementry.getSupplementrySem()) ? supplementry.getSupplementrySem() :"";
	address = supplementry.getAddress() != null && !"".equals(supplementry.getAddress()) ? supplementry.getAddress() :"";
	course = supplementry.getCourse() != null && !"".equals(supplementry.getCourse()) ? supplementry.getCourse() :"";
	suppId = supplementry.getId();

}
%>

<%
String persent_1 = "";
String passingyear_1 = "";
String persent_2 = "";
String passingyear_2 = "";
String persent_3 = "";
String passingyear_3 = "";
String persent_4 = "";
String passingyear_4 = "";
String persent_5 = "";
String passingyear_5 = "";
String persent_6 = "";
String passingyear_6 = "";
String persent_7 = "";
String passingyear_7 = "";
String persent_8 = "";
String passingyear_8 = "";
String semesterIds = "";
List<Semester> semesterList = request.getAttribute("SEMESTER_LIST")!=null?(List<Semester>)request.getAttribute("SEMESTER_LIST"):null;
if(semesterList != null && semesterList.size() > 0) {
	for(Semester semester : semesterList) {
		if(semester != null) {
			if(semester.getSemName().equalsIgnoreCase("1st Sem")) {
				persent_1 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_1 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("2nd Sem")) {
				persent_2 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_2 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("3rd Sem")) {
				persent_3 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_3 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("4th Sem")) {
				persent_4 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_4 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("5th Sem")) {
				persent_5 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_5 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("6th Sem")) {
				persent_6 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_6 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("7th Sem")) {
				persent_7 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_7 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			} else if(semester.getSemName().equalsIgnoreCase("8th Sem")) {
				persent_8 = semester.getPersentage() != null && !"".equals(semester.getPersentage()) ? semester.getPersentage() :"";
				passingyear_8 = semester.getPassingYear() != null && !"".equals(semester.getPassingYear()) ? semester.getPassingYear() :"";
			}
			int semId = semester.getId();
			semesterIds += semId + ",";
		}
	}
}
%>
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
<form method="post" action="/StudentsPortal/backpaper-form">
<input type="hidden" name = "supplementry_id" value="<%=suppId%>">
<input type="hidden" name = "semester_ids_str" value="<%=semesterIds%>">
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

<tr>
<td>REGISTRATION NO</td>
<td>
<input type="text" name="registration" maxlength="10" value="<%=reg%>"/>
</td>
</tr>

  <tr>
<td>SUPPLEMENTRY SEM</td>
<td>
<input type="text" name="sem" maxlength="10" value="<%=backsem%>"/>
</td>
</tr>
 
 
<tr>
<td>ADDRESS <br /><br /><br /></td>
<td><textarea input type="text" name="address" rows="4" cols="80" value="<%=address %>"/><%=address %>
</textarea>
</td>
</tr>
 
<!----- Qualification---------------------------------------------------------->
<tr>
<td>SEMESTER MARKS <br /><br /><br /><br /><br /><br /><br /></td>
 
<td>
<table>
 
<tr>
<td align="center"><b>Sl.No.</b></td>
<td align="center"><b>Examination</b></td>
<td align="center"><b>Percentage</b></td>
<td align="center"><b>Year of Passing</b></td>
</tr>
 

<tr>
<td>1</td>
<td>1st Sem</td>
<input type="hidden" name="sem_1" value="1st Sem" maxlength="30"/>
<td><input type="text" name="persentage_1" maxlength="30" value="<%=persent_1%>"/></td>
<td><input type="text" name="passingyear_1" maxlength="30" value="<%=passingyear_1%>"/></td>
</tr>
 
<tr>
<td>2</td>
<td>2nd Sem</td>
<input type="hidden" name="sem_2" value="2nd Sem" maxlength="30"/>
<td><input type="text" name="persentage_2" maxlength="30"value="<%=persent_2%>"/></td>
<td><input type="text" name="passingyear_2" maxlength="30"value="<%=passingyear_2%>"/></td>
</tr>
 
<tr>
<td>3</td>
<td>3rd Sem</td>
<input type="hidden" name="sem_3" value="3rd Sem" maxlength="30"/>
<td><input type="text" name="persentage_3" maxlength="30"value="<%=persent_3%>"/></td>
<td><input type="text" name="passingyear_3" maxlength="30"value="<%=passingyear_3%>"/></td>
</tr>
 
<tr>
<td>4</td>
<td>4th Sem</td>
<input type="hidden" name="sem_4" value="4th Sem" maxlength="30"/>
<td><input type="text" name="persentage_4" maxlength="30"value="<%=persent_4%>"/></td>
<td><input type="text" name="passingyear_4" maxlength="30"value="<%=passingyear_4%>"/></td>
</tr>
<tr>
<td>5</td>
<td>5th Sem</td>
<input type="hidden" name="sem_5" value="5th Sem" maxlength="30"/>
<td><input type="text" name="persentage_5" maxlength="30" value="<%=persent_5%>"/></td>
<td><input type="text" name="passingyear_5" maxlength="30"value="<%=passingyear_5%>"/></td>
</tr>
<tr>
<td>6</td>
<td>6th Sem</td>
<input type="hidden" name="sem_6" value="6th Sem" maxlength="30"/>
<td><input type="text" name="persentage_6" maxlength="30" value="<%=persent_6%>"/></td>
<td><input type="text" name="passingyear_6" maxlength="30"value="<%=passingyear_6%>"/></td>
</tr>
<tr>
<td>7</td>
<td>7th Sem</td>
<input type="hidden" name="sem_7" value="7th Sem" maxlength="30"/>
<td><input type="text" name="persentage_7" maxlength="30"value="<%=persent_7%>"/></td>
<td><input type="text" name="passingyear_7" maxlength="30"value="<%=passingyear_7%>"/></td>
</tr>
<tr>
<td>8</td>
<td>8th Sem</td>
<input type="hidden" name="sem_8" value="8th Sem" maxlength="30"/>
<td><input type="text" name="persentage_8" maxlength="30"value="<%=persent_8%>"/></td>
<td><input type="text" name="passingyear_8" maxlength="30"value="<%=passingyear_8%>"/></td>

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
<td>COURSE APPLIED</td>
<td>
<input type="text" name="course" maxlength="10" value="<%=course%>"/>
</td>
</tr>
 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<%if(supplementry!= null ) { %>
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