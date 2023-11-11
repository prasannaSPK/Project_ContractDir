

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import others.DatabaseConnection;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	//Boolean flag = false; // based on this flag,message values we display notification in userscreen.jsp 
	//String message = null;
	  int user_id;
	  String FIRST_NAME;
	  String LAST_NAME;
	  String EMAIL;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		   String email = request.getParameter("EmailAddress");
		   String password = request.getParameter("Password");
		   try {
			   
			   DatabaseConnection  dbc = new DatabaseConnection();
			   Connection c = dbc.initializeDatabase();
			   Statement stmt = c.createStatement();
			   ResultSet rs = stmt.executeQuery("select * from USERS where EMAIL = '"+email+"' and PASSWORD = '"+password+"'");
			 
			  int count = 0;
		
			  
			   while (rs.next()) {
				   this.user_id = rs.getInt("user_id");
				   this.FIRST_NAME = rs.getString("FIRST_NAME");
				   this.LAST_NAME = rs.getString("LAST_NAME");
				   this.EMAIL = rs.getString("EMAIL");
				   count++;
				   
			   }

				   
				   System.out.println(user_id + "..." + FIRST_NAME +"..."+ LAST_NAME  +"..." + "...." + EMAIL );
				
			   System.out.println("count value is : " +count);
			   if(count==1) {
				   Cookie ck = new Cookie("auth",email);// for sake of sessions
				   ck.setMaxAge(60 * 3); // session time 60 sec = 1min
				   response.addCookie(ck);

				   HttpSession session = request.getSession();
//				   // as a key, value pairs we are sending
				   session.setAttribute("EMAIL",email);// sending person email to other page ..simce we need to retreive respective mailbox letters.
				   session.setAttribute("FIRST_NAME", FIRST_NAME);
				   session.setAttribute("LAST_NAME", LAST_NAME);
	   
   
				    response.sendRedirect("UserScreen.jsp");
					return;
			   }		   
			   
			   
			   
			   response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String title = "Invalid Credentials !";
				String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
				out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
						+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + 
						"<h3>  please enter correct Email and Password!! </h3>" +
						"<BR>" +
	 	                "<form action ="+"index.jsp"+"  "+ "method="+">"+
	 	                "<input type=" + "\"submit\"" + " name = \"GOHOME\"" + "value=\"Go to Home\">" +
	 	                "</form>"
						+"</BODY></HTML>");	  
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		  
	}
	
	

}
