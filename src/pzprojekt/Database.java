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
	
	public static void register(String user, String haslo, String imie, String nazwisko, String adres, String telefon, String email)
	{
		try
		{
			String query = "INSERT INTO users (username, password, imie, nazwisko, adres, telefon, email) VALUES ('"+user+"','"+haslo+"','"+imie+"','"+nazwisko+"','"+adres+"','"+telefon+"','"+email+"')";
			st=con.createStatement();
			st.executeUpdate(query);
			
			userlogin(user, haslo);
			
			st.close();
		} 

	catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public static ResultSet pobierzDane(String samochod, String kategoria){
		
		try {
			st=con.createStatement();
			String query = "select * from czesci where samochod='"+samochod+"' AND kategoria=(SELECT id_kat FROM kategorie WHERE nazwa='"+kategoria+"')";
			rs=st.executeQuery(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
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
							String imie=rs.getString("IMIE");
							String nazwisko=rs.getString("NAZWISKO");
							String adres=rs.getString("ADRES");
							String telefon=rs.getString("TELEFON");
							String email=rs.getString("EMAIL");
							
							if(password.compareTo(password2)==0) User.LogIn(username, imie, nazwisko, adres, telefon, email);
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
