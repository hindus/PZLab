package pzprojekt;

public class User {
	public static String username, imie, nazwisko, adres, telefon;
	private static int zalogowany=0; 
	
	public static boolean isLogged(){
		if(zalogowany==0)
			return false;
		else
			return true;
	}
	
	public static void LogIn(String user, String name, String surname, String address, String phone){
		System.out.println("Zalogowany!");
		username=user;
		imie=name;
		nazwisko=surname;
		adres=address;
		telefon=phone;
		
		zalogowany=1;
	}
	
	public static void LogOut(){
		System.out.println("Wylogowany!");
		zalogowany=0;
	}
}
