package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.DatabaseConnection;
import model.DetailsBean;
@WebServlet("/addcontact")
public class AddContact extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CFIRST_NAME = request.getParameter("CFIRST_NAME");
		String CLAST_NAME = request.getParameter("CLAST_NAME");
		String CPHONE = request.getParameter("CPHONE");
		String CEMAIL = request.getParameter("CEMAIL");
		String DOB = request.getParameter("DOB");
		String SOCIALPROFILE = request.getParameter("SOCIALPROFILE");
		String USEREMAIL = request.getParameter("USEREMAIL");
		
		LocalDate date_of_birth = LocalDate.parse(DOB);
		
		//contact_id	CFIRST_NAME	CLAST_NAME	CPHONE	CEMAIL	DOB	SOCIALPROFILE	USEREMAIL
		
		PrintWriter out = response.getWriter();
		try {
			DatabaseConnection dbc = new DatabaseConnection();
			Connection c = dbc.initializeDatabase();
			Statement stmt = c.createStatement();
			DetailsBean deb = new DetailsBean();
			
			deb.setCFIRST_NAME(CFIRST_NAME);
			deb.setCLAST_NAME(CLAST_NAME);
			deb.setDOB(date_of_birth);
			deb.setCPHONE(CPHONE);
			deb.setCEMAIL(CEMAIL);
			deb.setSOCIALPROFILE(SOCIALPROFILE);
			deb.setUSEREMAIL(USEREMAIL);
			
			System.out.println(deb.getDOB() +"..."+ deb.getUSEREMAIL());
			
			stmt.executeUpdate("INSERT INTO CDETAILS(CFIRST_NAME,CLAST_NAME,CPHONE,CEMAIL,DOB,SOCIALPROFILE,USEREMAIL)"+ "VALUES('"+ deb.getCFIRST_NAME() + "','" +  deb.getCLAST_NAME() + "','" + deb.getCPHONE() + "','" +  deb.getCEMAIL() + "','" + deb.getDOB() + "','" + deb.getSOCIALPROFILE() + "','" + deb.getUSEREMAIL() +"')");
			//stmt.executeUpdate("INSERT INTO CDETAILS(CFIRST_NAME,CLAST_NAME,CPHONE,CEMAIL,SOCIALPROFILE)"+ "VALUES('"+ deb.getCFIRST_NAME() + "','" +  deb.getCLAST_NAME() + "','" + deb.getCPHONE() + "','" +  deb.getCEMAIL() + "','"  + deb.getSOCIALPROFILE() +" ')");
			String title = "Add Contact";
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
			System.err.println("failed to insert data");
		}
		
	}
	

}
