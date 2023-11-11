<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
<%
String EMAIL = (String) session.getAttribute("EMAIL");
%>

<p> <%=EMAIL%></p>
<BODY BGCOLOR="#FDF5E6">

<H1 ALIGN="CENTER">Add Contact Screen</H1>
	
<FORM ACTION="addcontact" METHOD="post">
  FirstName:  <INPUT TYPE="TEXT" NAME="CFIRST_NAME" ><BR>
  LastName:  <INPUT TYPE="TEXT" NAME="CLAST_NAME"><BR>
  Phone:  <INPUT TYPE="TEXT" NAME="CPHONE"><BR>
  EmailAddress:  <INPUT TYPE="TEXT" NAME="CEMAIL"><BR>
  DOB:  <INPUT TYPE="DATE" NAME="DOB"><BR>
  SOCIALPROFILE:  <INPUT TYPE="TEXT" NAME="SOCIALPROFILE"><BR>
   <INPUT TYPE="hidden" NAME="USEREMAIL" VALUE=<%=EMAIL%>><BR>
  <CENTER><INPUT TYPE="SUBMIT" VALUE="ADD"></CENTER>
</FORM>





</body>
</html>