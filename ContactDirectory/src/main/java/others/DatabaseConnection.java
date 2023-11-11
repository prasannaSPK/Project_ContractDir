

package others;
import java.sql.*;


public class DatabaseConnection {
	
	public static Connection initializeDatabase()  throws SQLException, ClassNotFoundException {
	
			
			 final String driver =  "com.mysql.cj.jdbc.Driver";
			 final String username = "root";
			 final String password = "";
			 String dBurl = "jdbc:mysql://localhost:3306/phonebook";
			 Class.forName(driver);
			 Connection con = DriverManager.getConnection(dBurl,username,password);
			 
			 return con;
			
		
		
		 
	}
}
