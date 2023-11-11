<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Screen</title>
</head>
<body>

<%
String EMAIL = (String) session.getAttribute("EMAIL");
String	FIRST_NAME  = 	 (String) session.getAttribute("FIRST_NAME");
String  LAST_NAME   =     (String) session.getAttribute("LAST_NAME");
%>



  
  <%

	connection = DriverManager.getConnection(connectionUrl, userid, password);
	Statement stmt1 = connection.createStatement();
	Statement stmt2 = connection.createStatement();
	ResultSet rs1 = stmt1.executeQuery("select * from cdetails where USEREMAIL='" + EMAIL +"'");


	
	%>
	
	<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/phonebook" user="root" password="" />

	<sql:query dataSource="${snapshot}" var="result">
 SELECT * from cdetails where USEREMAIL = ?
 <sql:param value="${EMAIL}" />
	</sql:query>
	
	
	<h2>Hello ..Welcome ,<%=FIRST_NAME  %> <%=LAST_NAME %> || <%=EMAIL %> </h2>




 
 
	<%
	Cookie[] cks = request.getCookies();// using cookies for sessions purpose

	if (cks != null) {
		for (int i = 0; i < cks.length; i++) {
			String name = cks[i].getName();
			String value = cks[i].getValue();

			if (name.equals("auth")) {
		break; // exit the loop and continue the page
			}
			if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
			{
		response.sendRedirect("login.jsp");
		return; // to stop further execution
			}
			//i++;
		}
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
	%>



	<table border="1" width="30%">
		<tr>
			<th>FIRST_NAME</th>
			<th>LAST_NAME</th>
			<th>PHONE</th>
			<th>EMAIL</th>
			<th>Date of Birth</th>
			<th>SOCIALPROFILE</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.CFIRST_NAME}" /></td>
				<td><c:out value="${row.CLAST_NAME}" /></td>
				<td><c:out value="${row.CPHONE}" /></td>
				<td><c:out value="${row.CEMAIL}" /></td>
				<td><c:out value="${row.DOB}" /></td>
				<td><c:out value="${row.SOCIALPROFILE}" /></td>
				<td>
				<form action = "EditContact.jsp"  method="post">
					<input type="hidden" name="contact_id" value = "${row.contact_id}"  />
					<input type="submit" value= "EDIT" >
				</form>
				</td>
				<td>
				<form action = "deletecontact"  method="post">
					<input type="hidden" name="contact_id" value = "${row.contact_id}"  />
					<input type="submit" value= "DELETE" >
				</form>
				
				</td>
				
			</tr>
		</c:forEach>
	</table>



<form action = "AddContact.jsp" method="post">
	<p style="float: left; width: 250px">	<input type="submit"  value="Add Contact" > </p>
</form>





<form action="ResetPassword.jsp" method="post">
	<p style="float:center; width: 250px">	<input type="submit" value="change password"></p>
</form>




<form action="logout" method="post">
	<p style="float: right; width: 130px">	<input type="submit" value="Logout"> </p>
</form>




	








	
	

	
	


	

	

    


















</body>
</html>