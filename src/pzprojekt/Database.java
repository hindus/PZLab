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
				con = DriverManager.getConnection("jdbc:mysql://mysql-717926.vipserv.org/pzlab_user","pzlab_user","password");
				//
			} 
		
		catch (Exception ex)
			{
				System.out.println("wedrujaca dupa");ex.printStackTrace();
			}
	}
	
	public static void main(String[] args)
	{
		 dbconnect();
		 userlogin("test","test");
		 User.LogOut();
	}
	
	public static void userlogin(String username, String password)
	{
		try
			{
				String query = "select * from users where username='"+username+"'";
				st=con.createStatement();
				rs=st.executeQuery(query);

				while(rs.next())
				{
					try
					{
							String password2 = rs.getString("PASSWORD");
							if(password.compareTo(password2)==0) User.LogIn();
							//hasło poprawne, zaloguj i umieść dane w klasie User
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
