package pzprojekt;



/**
 * Klasa User przechowuje dane dotyczace uzytkownika.
 *
 */
public class User {
	public static String username, imie, nazwisko, adres, telefon, email;
	public static int userId;
	private static int zalogowany=0; 
	
	public static boolean isLogged(){
		if(zalogowany==0)
			return false;
		else
			return true;
	}
	
	public static void LogIn(int id, String user, String name, String surname, String address, String phone, String mail){
		System.out.println("Zalogowany!");
		username=user;
		imie=name;
		nazwisko=surname;
		adres=address;
		telefon=phone;
		email=mail;
		userId=id;
		
		zalogowany=1;
	}
	
	public static void LogOut(){
		System.out.println("Wylogowany!");
		zalogowany=0;
	}
}
