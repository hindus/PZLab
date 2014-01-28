package pzprojekt;

import java.sql.*;
import java.util.HashMap;
import java.util.Vector;

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
				System.out.println("Błąd połączenia z serwerem mysql!");
			}
	}
	
	public static void insert(String column, String value)
	{
		try
		{
			String query = "INSERT INTO "+column+" VALUES ('"+value+"')";
			st=con.createStatement();
			st.executeUpdate(query);		
			st.close();
		} 

	catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void delete(String column, String attribute, String value)
	{
		try
		{
			String query = "DELETE FROM "+column+" WHERE "+attribute+"="+value+"";
			st=con.createStatement();
			st.executeUpdate(query);		
			st.close();
		} 

	catch (Exception ex)
		{
			ex.printStackTrace();
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
	
	public static HashMap<String, String> pobierzInfo(String nazwa, String model){
		HashMap<String, String> przedmiot=new HashMap<String, String>();
		try {
			st=con.createStatement();
			String query = "select * from czesci where nazwa='"+nazwa+"' AND samochod='"+model+"'";
			rs=st.executeQuery(query);
			
			while(rs.next()){
				przedmiot.put("nazwa", rs.getString("nazwa"));
				przedmiot.put("ilosc", rs.getString("ilosc_dostepnych"));
				przedmiot.put("opis", rs.getString("opis"));
				przedmiot.put("cena", rs.getString("cena_szt"));
				przedmiot.put("model", rs.getString("samochod"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return przedmiot;	
	}
	
	
	public static ResultSet pobierzSamochody(){
		
		try {
			st=con.createStatement();
			String query = "select * from samochody";
			rs=st.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	}
	
public static Vector<String> pobierzKategorie(){
		Vector<String> kategorie=new Vector<String>();
		try {
			st=con.createStatement();
			String query = "select * from kategorie";
			rs=st.executeQuery(query);
			
			while(rs.next()){
				kategorie.add(rs.getString("nazwa"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kategorie;	
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
	
	public static boolean isAdmin(String username)
	{
		String admin1 = "krzychu";
		String admin2 = "mateusz";
		String admin3 = "roszk";

		if(username.equals(admin1) || username.equals(admin2) || username.equals(admin3))
		{				
			return true;
		}
		else
			return false;

		
	}
	
	
	
	public static boolean userlogin(String username, String password)
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
							
							if(password.compareTo(password2)==0) 
								{
									User.LogIn(username, imie, nazwisko, adres, telefon, email);
									return true;
								}
							else 
								return false;
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
		return false;
	}
	
}
