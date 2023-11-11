

package others;

import java.sql.*;


public class TablesCreate {
		public static void main(String[] args) {

			try {
				 final String driver =  "com.mysql.cj.jdbc.Driver";
				 final String username = "root";
				 final String password = "";
				 Class.forName(driver);

				String url = "jdbc:mysql://localhost:3306/phonebook";
				
				Connection con = DriverManager.getConnection(url,username,password);
				Statement stmt = con.createStatement(); 
	
				System.out.println("Creating Tables!!!");
				
				
				
				String createTableUsers = "CREATE TABLE USERS " + "( user_id int NOT NULL AUTO_INCREMENT, FIRST_NAME varchar(255) NOT NULL,LAST_NAME varchar(255) NOT NULL,EMAIL varchar(255) NOT NULL UNIQUE,PASSWORD varchar(255) NOT NULL DEFAULT 12345,PRIMARY KEY(user_id))";	
				//System.out.println("passed");
				
				//String createTableContactDetails = "CREATE TABLE CDETAILS " + "( contact_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, CFIRST_NAME varchar(255) NOT NULL,CLAST_NAME varchar(255),CPHONE varchar(255) NOT NULL,CEMAIL varchar(255),DOB DATE,SOCIALPROFILE varchar(255),USEREMAIL varchar(255),FOREIGN KEY(USEREMAIL) REFERENCES USERS(EMAIL))";
				String createTableContactDetails = "CREATE TABLE CDETAILS " + "( contact_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, CFIRST_NAME varchar(255) NOT NULL,CLAST_NAME varchar(255),CPHONE varchar(255) NOT NULL,CEMAIL varchar(255),DOB DATE,SOCIALPROFILE varchar(255),USEREMAIL varchar(255))";
				stmt.executeUpdate(createTableUsers);
				stmt.executeUpdate(createTableContactDetails);
				
				
				
				
				
			} catch (Exception e) {

				System.err.println( e.getMessage());
				return;
			}
			System.err.println("Tables Created Successfully");
			
		}
}
