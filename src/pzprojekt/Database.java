package pzprojekt;

import java.sql.*;

public class Database {

	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public static void dbconnect()
	{
		try
			{
				String query="SELECT username FROM users WHERE password='haslo'";
				String driver = "com.mysql.jdbc.Driver"; 
				Class.forName(driver);
				con = DriverManager.getConnection("jdbc:mysql://mysql.hostinger.pl/u365162046_pzlab","u365162046_pzlab","pzlabka");
			} 
		
		catch (Exception ex)
			{
				;
			}
	}
	
	public static void userlogin(String username, String password)
	{
		
	}
	
}
