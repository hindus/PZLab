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
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt","root","moneta");
				st = con.createStatement();
			} 
		
		catch (Exception ex)
			{
				System.out.println("wedrujaca dupa");
			}
	}
	
	public static void main(String[] args)
	{
		 dbconnect();
		 userlogin("krzychu","haslo");
	}
	
	public static void userlogin(String username, String password)
	{
		try
			{
				String query = "select * from client where login='"+username+"'";

				rs=st.executeQuery(query);

				while(rs.next())
				{
					try
					{
							String password2 = rs.getString("PASSWORD");
							if(password.compareTo(password2)==1) User.LogIn(); //hasło poprawne, zaloguj i umieść dane w klasie User
							//w innym przypadku obsługa
					}
					
					catch(SQLException ex)
					{
						System.out.println(ex);
					}
				}
				st.close();
			} 
	
		catch (Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
}
