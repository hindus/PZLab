package pzprojekt;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class LoginSklep 
{

	Connection con;
	Statement st;
	ResultSet rs;
	static JFrame f = new JFrame("Panel logowania");
	JLabel lUsername = new JLabel("Nazwa użytkownika");
	JLabel lPassword = new JLabel("Hasło");
	JTextField tUsername = new JTextField(20);
	JTextField tPassword = new JTextField(20);
	JButton button = new JButton("Zaloguj!");
	JLabel logged = new JLabel("Zalogowany!");
	int zalogowany = 0;
	
	
	
	public LoginSklep()
	{
		connect(); //polaczenie z bd
		frame(); // okienko
	}
	
	public static void refreshMethod()
	{
	    f.invalidate();
	    f.validate();
	}
	
	public void connect()
	{
		try
		{
			//String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			String driver = "com.mysql.jdbc.Driver"; 
			Class.forName(driver);
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt","root","hasllo");
			
			st = con.createStatement();

		
		
		} 
		catch (Exception ex)
		{
			
		}
	}
	
	public void frame()
	{
		f.setSize(900,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		final JPanel p = new JPanel();

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
					String klient = tUsername.getText().trim();
					String haslo = tPassword.getText().trim();
					String zapytanie = "select login,password from client where login = '"+klient+"'and password = '"+haslo+"'"; 
					rs = st.executeQuery(zapytanie);

					int zlicz = 0;
					while(rs.next())
					{
						try
						{
							zlicz++;
							String login = rs.getString("LOGIN");
							String password = rs.getString("PASSWORD");
							System.out.println("Dane: Login: "+login+" Haslo: "+password+"zlicz "+zlicz);
								
						}
						catch(SQLException ex)
						{
							System.out.println(ex);
						}
					}
					
					if(zlicz == 1)
					{

						JOptionPane.showMessageDialog(null, "Uzytkownik odnaleziony!");
						zalogowany = 1;
						p.add(logged);
						f.invalidate();
						f.validate();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Uzytkownik nieodnaleziony!");

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
		new LoginSklep();
		
	}
	
	
	
	
	
	
}
