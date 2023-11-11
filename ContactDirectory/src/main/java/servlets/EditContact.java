package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.DatabaseConnection;
import model.DetailsBean;


@WebServlet("/editcontact")
public class EditContact extends HttpServlet {
	
	

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int contact_id    = Integer.parseInt(request.getParameter("contact_id"));
		String CFIRST_NAME = request.getParameter("CFIRST_NAME");
		String CLAST_NAME = request.getParameter("CLAST_NAME");
		String CPHONE = request.getParameter("CPHONE");
		String CEMAIL = request.getParameter("CEMAIL");
		LocalDate DOB = LocalDate.parse(request.getParameter("DOB"));
		String SOCIALPROFILE = request.getParameter("SOCIALPROFILE");
		String USEREMAIL = request.getParameter("USEREMAIL");
		
		System.out.println("welcome 2 edit contact");
		System.out.println(CFIRST_NAME + "...." + CLAST_NAME + "..."+ CPHONE); 

		
		DetailsBean deb = new DetailsBean();
		deb.setContact_id(contact_id);
		deb.setCFIRST_NAME(CFIRST_NAME);
		deb.setCLAST_NAME(CLAST_NAME);
		deb.setCPHONE(CPHONE);
		deb.setCEMAIL(CEMAIL);
		deb.setDOB(DOB);
		deb.setSOCIALPROFILE(SOCIALPROFILE);
		deb.setUSEREMAIL(USEREMAIL);
		
		
		PrintWriter out = response.getWriter();
		try {
			 String c_id =   request.getParameter("contact_id");
			 	DatabaseConnection dbc = new DatabaseConnection();
				Connection c = dbc.initializeDatabase();
				Statement stmt = c.createStatement();
				//ResultSet rs = stmt.executeQuery("UPDATE CDETAILS where contact_id = '"+c_id+"'");
				stmt.executeUpdate("update CDETAILS set CFIRST_NAME = '" + deb.getCFIRST_NAME() + "' ,CLAST_NAME='" +deb.getCLAST_NAME() + "',CPHONE='" + deb.getCPHONE() + "',CEMAIL='" + deb.getCEMAIL() + "',DOB='" + deb.getDOB() + "',SOCIALPROFILE = '" + deb.getSOCIALPROFILE() + "',USEREMAIL ='" + deb.getUSEREMAIL() + "'  where contact_id='" + deb.getContact_id() + "'");
				c.close();

				String title = "Update Contact Details";
				String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
				out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
						+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "  Successful" +"</H1>\n" + "<UL>\n" +
						"<BR>" +
						 "<form action ="+"UserScreen.jsp"+"  "+ "method="+">"+
		 	                "<input type=" + "\"submit\"" + " name = \"userscreen\"" + "value=\"Go to UserScreen\">" +
		 	                "</form>" +
						"</BODY></HTML>");
				return;

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println( e + "failed to update data");
		}
		
	}

	}
