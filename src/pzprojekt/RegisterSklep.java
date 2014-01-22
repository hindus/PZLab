package pzprojekt;


import javax.swing.*;

import java.awt.event.*;
import java.sql.*;



public class RegisterSklep 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f = new JFrame("Panel rejestracji");
	JLabel lPolecenie = new JLabel("Wprowadź swoje dane osobowe");
	JLabel lUsername = new JLabel("Nazwa użytkownika");
	JLabel lPassword = new JLabel("Hasło");
	JTextField tUsername = new JTextField(20);
	JTextField tPassword = new JTextField(20);
	JButton button = new JButton("Zarejestruj!");

	public RegisterSklep()
	{
		connect(); //polaczenie z bd
		frame(); // okienko
	}
	
	public void connect()
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver"; 
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt","root","hasslo");
			st = con.createStatement();
		} 
		catch (Exception ex)
		{
			
		}
	}
	
	public void frame()
	{
		f.setSize(900,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JPanel p = new JPanel();
		p.add(lPolecenie);
		p.add(lUsername);
		p.add(tUsername);
		p.add(lPassword);
		p.add(tPassword);
		p.add(button);
		
		f.add(p);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String nowyKlient = tUsername.getText().trim();
					String noweHaslo = tPassword.getText().trim();
				
					//JOptionPane.showMessageDialog(null, "user: "+klient+" pass: "+haslo);

					String zapytanie = "select login,password from client where login = '"+nowyKlient+"'and password = '"+noweHaslo+"'"; 
					rs = st.executeQuery(zapytanie);

					
					//PROBLEM - laczy sie z baza danych, ale nie pracuje na wyciaganiu danych samych
					//sprostowanie problem polegał na tym, ze chcialme brac id z zapyttania, ktore nie wyciagalo id
					//wniosek - mozna operowac tylko na wartosciach ktore sie wyciaga zapytaniem z bazy
					
					int zlicz = 0;
					while(rs.next())
					{
						try
						{
								//int id = rs.getInt(1);
								zlicz++;
								String login = rs.getString("LOGIN");
								String password = rs.getString("PASSWORD");
								System.out.println("Dane: Login: "+login+" Haslo: "+password+"zlicz "+zlicz);
								
								//JOptionPane.showMessageDialog(null, "Uzytkownik odnaleziony! Dane: \n ID: "+id+" Imię: "+login+" haslo: "+password);

						}
						catch(SQLException ex)
						{
							System.out.println(ex);
						}
								//zlicz++;
					}
					
					if(zlicz == 1)
					{
//						String dane = "select login from client where login = '"+klient+"'"; 
//						rs = st.executeQuery(dane);
//						String imie = rs.getString("login");
						JOptionPane.showMessageDialog(null, "Podany uzytkownik juz istnieje w bazie!");
						
					}
					else
					{
						String insertNewClient = "insert into client (login,password) values ('"+nowyKlient+"','"+noweHaslo+"')"; 
						//System.out.println(insertNewClient);
//						rs = st.executeQuery(insertNewClient);
						st.executeUpdate(insertNewClient);
						JOptionPane.showMessageDialog(null, "Użytkownik "+nowyKlient+" dodany do bazy danych systemu!");

					}
				st.close();
				con.close();
					
				}
				catch (Exception ex)
				{
					
				}

				
				
			}
		});
	}
	
	
	public static void main(String[] args)
	{
		new RegisterSklep();
		
	}
	
	
	
	
}

