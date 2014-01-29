package pzprojekt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;

public class Database {

	static Connection con;
	static Statement st;
	static ResultSet rs;
	static String adres; //mysql-717926.vipserv.org
	static String user; //pzlab_user
	static String password; //password
	static String database;//pzlab_user
	
	public static void dbconnect()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try {
			 
			input = new FileInputStream("props.properties");

			prop.load(input);

			adres=prop.getProperty("adres");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			database=prop.getProperty("database");			
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
		try
			{
				String driver = "com.mysql.jdbc.Driver"; 
				Class.forName(driver);
				con = DriverManager.getConnection("jdbc:mysql://"+adres+"/"+database,user,password);
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
	
	public static int ostatnieZam(int userid){
		int id=0;
		try {
			st=con.createStatement();
			String query = "select id_zamowienia from zamowione where id_klienta="+userid+" ORDER BY 1 DESC LIMIT 1";
			rs=st.executeQuery(query);
			
			while(rs.next()){
				id=rs.getInt("id_zamowienia");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return id;	
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
							int id=rs.getInt("user_id");
							
							if(password.compareTo(password2)==0) 
								{
									User.LogIn(id, username, imie, nazwisko, adres, telefon, email);
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

	public static Connection getCon() {
		return con;
	}
}
