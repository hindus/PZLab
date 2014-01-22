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
	
	public static void LogIn(){
		zalogowany=1;
	}
}
