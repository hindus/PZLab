package pzprojekt;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;





/**
 * Klasa Database odpowiedzialna jest za obsługę połączeń z bazą danych SQL oraz operacje na niej wykonywane. 
 *
 */
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
			String query = "INSERT INTO "+column+" (nazwa) VALUES ('"+value+"')";
			
			if(column.equals("samochody"))
			{
			    JFileChooser chooser = new JFileChooser("./");
			    chooser.setDialogTitle("Wczytaj plik..."); 
			    FileNameExtensionFilter filtr = new FileNameExtensionFilter("Pliki graficzne", ".jpg", ".gif", "jpeg", ".png");
			    chooser.addChoosableFileFilter(filtr);

			    if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			      {
			    	String sciezka = chooser.getSelectedFile().getPath();
			    	System.out.println(sciezka);
					query = "INSERT INTO "+column+" (nazwa, obrazek) VALUES ('"+value+"','"+sciezka+"')";

			      }
			}	
			else
				if(column.equals("kategorie"))
					query = "INSERT INTO "+column+" (nazwa) VALUES ('"+value+"')";	

			//
			System.out.println(query);
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
	
	public static HashMap<String, String> pobierzInfo(int id){
		HashMap<String, String> przedmiot=new HashMap<String, String>();
		try {
			st=con.createStatement();
			String query = "select * from czesci where id_czesci="+id;
			rs=st.executeQuery(query);
			
			while(rs.next()){
				przedmiot.put("id", id+"");
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
			System.out.println("błąd połączenia z bazą danych.");
		}
		return kategorie;	
	}

	public static Vector<String> pobierzCzesci(){
		Vector<String> czesci=new Vector<String>();
		try {
			st=con.createStatement();
			String query = "select * from czesci";
			rs=st.executeQuery(query);
			
			while(rs.next()){
				czesci.add(rs.getString("id_czesci")+" - "+rs.getString("nazwa")+rs.getString("samochod"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("błąd połączenia z bazą danych.");
		}
		return czesci;	
	}
	
	public static Vector<String> pobierzUserow(){
		Vector<String> users=new Vector<String>();
		try {
			st=con.createStatement();
			String query = "select * from users";
			rs=st.executeQuery(query);
			
			while(rs.next()){
				users.add(rs.getString("user_id")+" - "+rs.getString("username"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("błąd połączenia z bazą danych.");
		}
		return users;	
	}

	
	public static ResultSet pobierzDane(String samochod, String kategoria){
		
		try {
			st=con.createStatement();
			String query = "select * from czesci where samochod='"+samochod+"' AND kategoria=(SELECT id_kat FROM kategorie WHERE nazwa='"+kategoria+"')";
			rs=st.executeQuery(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("błąd połączenia z bazą danych.");
		}
		return rs;	
	}
	
	public static boolean isAdmin(String username)
	{
		try
		{
			String query = "select * from admins where login='"+username+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);

			while(rs.next())
			{
				try
				{
					String loginwBazie = rs.getString("login");

					if(username.compareTo(loginwBazie)==0 && !username.isEmpty()) 
						{
							return true;
						}
					else 
						return false;
				}
				
				catch(SQLException ex)
				{
				}
			}
			st.close();
		} 

	catch (Exception ex)
		{
			System.out.println("Błąd połaczenia z baza danych" + ex);
		}
		
		

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
	
	public static boolean checkAvailability(String username)
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
						String loginwBazie = rs.getString("USERNAME");

						if(username.compareTo(loginwBazie)==0 && !username.isEmpty()) 
							{
								return false;
							}
						else 
							return true;
						//Sprawdza, czy dany login jest dostępny
					}
					
					catch(SQLException ex)
					{
					}
				}
				st.close();
			} 
	
		catch (Exception ex)
			{
				System.out.println("Błąd połaczenia z baza danych" + ex);
			}
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
						int id=rs.getInt("user_id");
						
						if(password.compareTo(password2)==0 && !username.isEmpty()) 
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
