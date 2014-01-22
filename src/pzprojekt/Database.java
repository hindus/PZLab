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
		try
			{
				String query="SELECT password FROM users WHERE username="+username;
				st=con.createStatement();
				rs=st.executeQuery(query);
			
				if(rs.getString(1).compareTo(password)==0) System.out.println("Zalogowano"); //zmienna zalogowany w klasie użytkownika w górę
				st.close();
			} 
	
		catch (Exception ex)
			{
				;
			}
	}
	
}
