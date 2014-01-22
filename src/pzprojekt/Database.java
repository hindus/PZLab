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
				//dbc:mysql://localhost:3306/projekt","root","hasllo"
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
				//String query="SELECT password FROM client WHERE login="+username;
				String query = "select login,password from client where login = '"+username+"'";

				//st=con.createStatement();
				rs=st.executeQuery(query);

			
				//System.out.println(rs.getString("login"));
				//if(rs.getString(1).compareTo(password)==0) System.out.println("Zalogowano");
				//else System.out.println("Nie zalogowano"); //zmienna zalogowany w klasie użytkownika w górę
				while(rs.next())
				{
					try
					{
							//int id = rs.getInt(1);
							String login = rs.getString("login");
							String password2 = rs.getString("PASSWORD");
							System.out.println("Dane: Login: "+login+" Haslo: "+password2+"  --> zalogowano");
							
							//JOptionPane.showMessageDialog(null, "Uzytkownik odnaleziony! Dane: \n ID: "+id+" Imię: "+login+" haslo: "+password);

					}
					catch(SQLException ex)
					{
						System.out.println(ex);
					}
							//zlicz++;
				}
				
				st.close();
			} 
	
		catch (Exception ex)
			{
				ex.printStackTrace();


			}
	}
	
}
