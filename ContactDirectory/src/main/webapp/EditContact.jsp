<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*,java.time.LocalDate"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
<BODY BGCOLOR="#FDF5E6">

<!-- <H1 ALIGN="CENTER">Edit Contact page ${param.contact_id} </H1> -->

<H1 ALIGN="CENTER">Edit Contact Screen </H1>



<%

String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/phonebook";

String userid = "root";
String password = "";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
 int contact_id = -100;
 String CFIRST_NAME = null;
 String CLAST_NAME = null;
 String CPHONE = null;
 String CEMAIL = null;
 LocalDate DOB = null;
 String SOCIALPROFILE = null;
 String USEREMAIL = null;
%>


  <%	
	// now we try to fetch contact details saved by respective users
	connection = DriverManager.getConnection(connectionUrl, userid, password);
	Statement stmt1 = connection.createStatement();
	//String contact_id = ${param.contact_id} + "" ;
	String c_id =   request.getParameter("contact_id");
	int cont_id = Integer.parseInt(c_id);
	ResultSet rs = stmt1.executeQuery("select * from CDETAILS where contact_id = '" + cont_id +"'" );
	
	  while (rs.next()) {
		   contact_id = rs.getInt("contact_id");
		   CFIRST_NAME = rs.getString("CFIRST_NAME");
		   CLAST_NAME = rs.getString("CLAST_NAME");
		   CPHONE = rs.getString("CPHONE");
		   CEMAIL = rs.getString("CEMAIL");  ;
		   DOB   = LocalDate.parse(rs.getDate("DOB")+"");// for simplicity we are changing to string 
		   SOCIALPROFILE = rs.getString("SOCIALPROFILE");;
		   USEREMAIL = rs.getString("USEREMAIL");
	   }
	  connection.close();
	
%>

<FORM ACTION="editcontact" METHOD="post">
	<INPUT TYPE="hidden" NAME="contact_id" VALUE=<%=contact_id %> >
  FirstName:  <INPUT TYPE="TEXT" NAME="CFIRST_NAME" VALUE=<%=CFIRST_NAME %> ><BR>
  LastName:  <INPUT TYPE="TEXT" NAME="CLAST_NAME" VALUE=<%=CLAST_NAME %>><BR>
  Phone:  <INPUT TYPE="TEXT" NAME="CPHONE" VALUE=<%=CPHONE %>><BR>
  EmailAddress:  <INPUT TYPE="TEXT" NAME="CEMAIL" VALUE=<%=CEMAIL %>><BR>
  DOB:  <INPUT TYPE="DATE" NAME="DOB" VALUE=<%=DOB %>><BR>
  SOCIALPROFILE:  <INPUT TYPE="TEXT" NAME="SOCIALPROFILE" VALUE=<%=SOCIALPROFILE %>><BR>
   <INPUT TYPE="hidden" NAME="USEREMAIL" VALUE=<%=USEREMAIL %>><BR>
  <CENTER><INPUT TYPE="SUBMIT" VALUE="UPDATE"></CENTER>
</FORM>

</head>
<body>

</body>
</html>