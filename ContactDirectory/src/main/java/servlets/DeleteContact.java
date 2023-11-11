package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.DatabaseConnection;


@WebServlet("/deletecontact")
public class DeleteContact extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //System.out.println(request);
		PrintWriter out = response.getWriter();
		 try {
			 //System.out.println(request.getParameter("contact_id"));
			    String contact_id =   request.getParameter("contact_id");
			 	DatabaseConnection dbc = new DatabaseConnection();
				Connection c = dbc.initializeDatabase();
				Statement stmt = c.createStatement();
				
				stmt.execute("DELETE from CDETAILS where contact_id = '"+contact_id+"'");
				c.close();
				
				response.setContentType("text/html");
				
				String title = "Deleted Contact";
				String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
				out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
						+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<UL>\n" +
						"<BR>" +
						"<form action ="+"UserScreen.jsp"+"  "+ "method="+">"+
	 	                "<input type=" + "\"submit\"" + " name = \"userscreen\"" + "value=\"Go Back to UserScreen\">" +
	 	                "</form>" +
						"</BODY></HTML>");
				return;

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("failed to DELETE contact");
			
			String title = "Failed to Delete Contact";
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<UL>\n" +
					"<BR>" +
					"</BODY></HTML>");
		}
			 
			 
		 }


}
