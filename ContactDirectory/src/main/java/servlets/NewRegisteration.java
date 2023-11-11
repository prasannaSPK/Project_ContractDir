
package servlets;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsersBean;
import others.DatabaseConnection;

@WebServlet("/newuserregister")
public class NewRegisteration extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String EmailAddress = request.getParameter("EmailAddress");
		//System.out.println(FirstName +"..." + LastName + "..." +EmailAddress);
		
		try {
			 //final String driver =  "com.mysql.jdbc.Driver";// depricated so using below
			DatabaseConnection  dbc = new DatabaseConnection();
			Connection c = dbc.initializeDatabase();
			Statement stmt = c.createStatement();

			System.out.println("Creating Tables!!!");
			
			
			UsersBean user1 = new UsersBean(); // connecting to model here
			user1.setFIRST_NAME(FirstName);
			user1.setLAST_NAME(LastName);
			user1.setEMAIL(EmailAddress);
			
           //System.out.println(FirstName +"..." + LastName + "..." +EmailAddress);
          // System.out.println("*hello **" +user1.getFIRST_NAME() +"..." +  user1.getLAST_NAME()+ "..." + user1.getEMAIL());
			
		stmt.executeUpdate("INSERT INTO USERS(FIRST_NAME,LAST_NAME,EMAIL)"+ "VALUES('"+ user1.getFIRST_NAME() + "','" + user1.getLAST_NAME()+ "','" +user1.getEMAIL() + "')");
           
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Registering";
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"  + "</UL>\n" + "<h1> Sucessfully Registered !! </h1>" +
					"<BR>" +
					"click here to"+ "<a href="+"'UserRegisteration.jsp'"+">RegisterNewUser</a>" +
					 "<br>"+
 	                "<form action ="+"index.jsp"+"  "+ "method="+">"+
 	                "<input type=" + "\"submit\"" + " name = \"GOHOME\"" + "value=\"Go to Home\">" +
 	                "</form>"+
					"</BODY></HTML>");
			return;

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("failed to insert data!!!!");
			e.printStackTrace();
		}
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Registering";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + "failed to register" + "</H1>\n" + "<UL>\n" +
			  
"<BR>" +
"click here to"+ "<a href="+"'UserRegisteration.jsp'"+">RegisterNewUser</a>" +
 "<br>"+
 "<form action ="+"index.jsp"+"  "+ "method="+">"+
 "<input type=" + "\"submit\"" + " name = \"GOHOME\"" + "value=\"Go to Home\">" +
 "</form>"
				+"</BODY></HTML>");
		
		

	}
	

	
}
