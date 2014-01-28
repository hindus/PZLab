package pzprojekt;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;


public class UserPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JPasswordField passwordField;
    private JButton btnZaloguj;
    private JButton btnZarejestruj;
 	
public UserPanel(){
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{30, 0, 0, 201, 50, 0, 0, 198, 30, 0};
	    gbl_panel.rowHeights = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 30, 30, 0, 0};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    this.setLayout(gbl_panel);
	    
	    JLabel lblLogowanie = new JLabel("Logowanie");
	    GridBagConstraints gbc_lblLogowanie = new GridBagConstraints();
	    gbc_lblLogowanie.insets = new Insets(0, 0, 5, 5);
	    gbc_lblLogowanie.gridx = 3;
	    gbc_lblLogowanie.gridy = 0;
	    this.add(lblLogowanie, gbc_lblLogowanie);
	    
	    JLabel lblRejestracja = new JLabel("Rejestracja");
	    GridBagConstraints gbc_lblRejestracja = new GridBagConstraints();
	    gbc_lblRejestracja.insets = new Insets(0, 0, 5, 5);
	    gbc_lblRejestracja.gridx = 7;
	    gbc_lblRejestracja.gridy = 0;
	    this.add(lblRejestracja, gbc_lblRejestracja);
	    
	    JLabel login = new JLabel("Nazwa użytkownika");
	    GridBagConstraints gbc_login = new GridBagConstraints();
	    gbc_login.insets = new Insets(0, 0, 5, 5);
	    gbc_login.gridx = 1;
	    gbc_login.gridy = 2;
	    this.add(login, gbc_login);
	    
	    textField = new JTextField();
	    GridBagConstraints gbc_textField = new GridBagConstraints();
	    gbc_textField.insets = new Insets(0, 0, 5, 5);
	    gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField.gridx = 3;
	    gbc_textField.gridy = 2;
	    this.add(textField, gbc_textField);
	    textField.setColumns(10);
	    
	    passwordField = new JPasswordField();
	    GridBagConstraints gbc_passwordField = new GridBagConstraints();
	    gbc_passwordField.insets = new Insets(0, 0, 5, 5);
	    gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
	    gbc_passwordField.gridx = 3;
	    gbc_passwordField.gridy = 3;
	    this.add(passwordField, gbc_passwordField);
	    
	    JLabel lblNazwaUytkownika = new JLabel("Nazwa użytkownika");
	    GridBagConstraints gbc_lblNazwaUytkownika = new GridBagConstraints();
	    gbc_lblNazwaUytkownika.anchor = GridBagConstraints.WEST;
	    gbc_lblNazwaUytkownika.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNazwaUytkownika.gridx = 5;
	    gbc_lblNazwaUytkownika.gridy = 2;
	    this.add(lblNazwaUytkownika, gbc_lblNazwaUytkownika);
	    
	    textField_1 = new JTextField();
	    GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	    gbc_textField_1.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_1.gridx = 7;
	    gbc_textField_1.gridy = 2;
	    this.add(textField_1, gbc_textField_1);
	    textField_1.setColumns(10);
	    
	    JLabel password = new JLabel("Hasło");
	    GridBagConstraints gbc_password = new GridBagConstraints();
	    gbc_password.anchor = GridBagConstraints.WEST;
	    gbc_password.insets = new Insets(0, 0, 5, 5);
	    gbc_password.gridx = 1;
	    gbc_password.gridy = 3;
	    this.add(password, gbc_password);
	    
	    btnZaloguj = new JButton("Zaloguj");
	    
	    GridBagConstraints gbc_btnZaloguj = new GridBagConstraints();
	    gbc_btnZaloguj.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnZaloguj.insets = new Insets(0, 0, 5, 5);
	    gbc_btnZaloguj.gridx = 3;
	    gbc_btnZaloguj.gridy = 5;
	    this.add(btnZaloguj, gbc_btnZaloguj);
	    
	    JLabel lblHaso = new JLabel("Hasło");
	    GridBagConstraints gbc_lblHaso = new GridBagConstraints();
	    gbc_lblHaso.anchor = GridBagConstraints.WEST;
	    gbc_lblHaso.insets = new Insets(0, 0, 5, 5);
	    gbc_lblHaso.gridx = 5;
	    gbc_lblHaso.gridy = 3;
	    this.add(lblHaso, gbc_lblHaso);
	    
	    textField_2 = new JTextField();
	    GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	    gbc_textField_2.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_2.gridx = 7;
	    gbc_textField_2.gridy = 3;
	    this.add(textField_2, gbc_textField_2);
	    textField_2.setColumns(10);
	    
	    JLabel lblImi = new JLabel("Imię");
	    GridBagConstraints gbc_lblImi = new GridBagConstraints();
	    gbc_lblImi.anchor = GridBagConstraints.WEST;
	    gbc_lblImi.insets = new Insets(0, 0, 5, 5);
	    gbc_lblImi.gridx = 5;
	    gbc_lblImi.gridy = 4;
	    this.add(lblImi, gbc_lblImi);
	    
	    textField_3 = new JTextField();
	    GridBagConstraints gbc_textField_3 = new GridBagConstraints();
	    gbc_textField_3.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_3.gridx = 7;
	    gbc_textField_3.gridy = 4;
	    this.add(textField_3, gbc_textField_3);
	    textField_3.setColumns(10);
	                                      
	    JLabel lblNazwisko = new JLabel("Nazwisko");
	    GridBagConstraints gbc_lblNazwisko = new GridBagConstraints();
	    gbc_lblNazwisko.anchor = GridBagConstraints.WEST;
	    gbc_lblNazwisko.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNazwisko.gridx = 5;
	    gbc_lblNazwisko.gridy = 5;
	    this.add(lblNazwisko, gbc_lblNazwisko);
	    
	    textField_4 = new JTextField();
	    GridBagConstraints gbc_textField_4 = new GridBagConstraints();
	    gbc_textField_4.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_4.gridx = 7;
	    gbc_textField_4.gridy = 5;
	    this.add(textField_4, gbc_textField_4);
	    textField_4.setColumns(10);
	    
	    JLabel lblAdres = new JLabel("Adres");
	    GridBagConstraints gbc_lblAdres = new GridBagConstraints();
	    gbc_lblAdres.anchor = GridBagConstraints.WEST;
	    gbc_lblAdres.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAdres.gridx = 5;
	    gbc_lblAdres.gridy = 6;
	    this.add(lblAdres, gbc_lblAdres);
	    
	    textField_5 = new JTextField();
	    GridBagConstraints gbc_textField_5 = new GridBagConstraints();
	    gbc_textField_5.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_5.gridx = 7;
	    gbc_textField_5.gridy = 6;
	    this.add(textField_5, gbc_textField_5);
	    textField_5.setColumns(10);
	    
	    JLabel lblNumerTelefonu = new JLabel("Numer telefonu");
	    GridBagConstraints gbc_lblNumerTelefonu = new GridBagConstraints();
	    gbc_lblNumerTelefonu.anchor = GridBagConstraints.WEST;
	    gbc_lblNumerTelefonu.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNumerTelefonu.gridx = 5;
	    gbc_lblNumerTelefonu.gridy = 7;
	    this.add(lblNumerTelefonu, gbc_lblNumerTelefonu);
	    
	    textField_6 = new JTextField();
	    GridBagConstraints gbc_textField_6 = new GridBagConstraints();
	    gbc_textField_6.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_6.gridx = 7;
	    gbc_textField_6.gridy = 7;
	    this.add(textField_6, gbc_textField_6);
	    textField_6.setColumns(10);
	    
	    JLabel lblAdresEmail = new JLabel("Adres e-mail");
	    GridBagConstraints gbc_lblAdresEmail = new GridBagConstraints();
	    gbc_lblAdresEmail.anchor = GridBagConstraints.WEST;
	    gbc_lblAdresEmail.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAdresEmail.gridx = 5;
	    gbc_lblAdresEmail.gridy = 8;
	    this.add(lblAdresEmail, gbc_lblAdresEmail);
	    
	    textField_7 = new JTextField();
	    GridBagConstraints gbc_textField_7 = new GridBagConstraints();
	    gbc_textField_7.insets = new Insets(0, 0, 5, 5);
	    gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_7.gridx = 7;
	    gbc_textField_7.gridy = 8;
	    this.add(textField_7, gbc_textField_7);
	    textField_7.setColumns(10);
	    
	    btnZarejestruj = new JButton("Zarejestruj");
	    GridBagConstraints gbc_btnZarejestruj = new GridBagConstraints();
	    gbc_btnZarejestruj.insets = new Insets(0, 0, 0, 5);
	    gbc_btnZarejestruj.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnZarejestruj.gridx = 7;
	    gbc_btnZarejestruj.gridy = 10;
	    this.add(btnZarejestruj, gbc_btnZarejestruj);
	    
        btnZaloguj.addActionListener(new ActionListener() {
        	
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
        		if(Database.userlogin(textField.getText(),passwordField.getText())==true)
        		{			
	        		if(Database.isAdmin(textField.getText())==true)
	        			{	
		        			Okno.showLogin("KOSZYK");
		        			//cl.show(cards, "KOSZYK");
		        			//Okno.getTabbedPane().add(admin,"ADMINISTRACJA");
	        			}
	        		else
	        			//cl.show(cards, "KOSZYK");
	        			Okno.showLogin("KOSZYK");
	        		//label.setText(User.imie+" "+User.nazwisko);
        		}	
        		textField.setText("");
        		passwordField.setText("");
        		
        	}
        });     
        
        btnZarejestruj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String username=textField_1.getText();
        		String haslo=textField_2.getText();
        		String imie=textField_3.getText();
        		String nazwisko=textField_4.getText();
        		String adres=textField_5.getText();
        		String telefon=textField_6.getText();
        		String email=textField_7.getText();
        		
        		textField_1.setText("");
        		textField_2.setText("");
        		textField_3.setText("");
        		textField_4.setText("");
        		textField_5.setText("");
        		textField_6.setText("");
        		textField_7.setText("");
        		
        		Database.register(username,haslo,imie,nazwisko,adres,telefon, email);
        		//cl.show(cards, "KOSZYK");
        		Okno.showLogin("KOSZYK");
        		//label.setText(User.imie+" "+User.nazwisko);
        		Mail.sendRegister(email, username, imie, nazwisko, haslo);
        	}
        });
          
	}

public JTextField getTextField() {
	return textField;
}

public void setTextField(JTextField textField) {
	this.textField = textField;
}

public JTextField getTextField_1() {
	return textField_1;
}

public void setTextField_1(JTextField textField_1) {
	this.textField_1 = textField_1;
}

public JTextField getTextField_2() {
	return textField_2;
}

public void setTextField_2(JTextField textField_2) {
	this.textField_2 = textField_2;
}

public JTextField getTextField_3() {
	return textField_3;
}

public void setTextField_3(JTextField textField_3) {
	this.textField_3 = textField_3;
}

public JTextField getTextField_4() {
	return textField_4;
}

public void setTextField_4(JTextField textField_4) {
	this.textField_4 = textField_4;
}

public JTextField getTextField_5() {
	return textField_5;
}

public void setTextField_5(JTextField textField_5) {
	this.textField_5 = textField_5;
}

public JTextField getTextField_6() {
	return textField_6;
}

public void setTextField_6(JTextField textField_6) {
	this.textField_6 = textField_6;
}

public JTextField getTextField_7() {
	return textField_7;
}

public void setTextField_7(JTextField textField_7) {
	this.textField_7 = textField_7;
}

public JPasswordField getPasswordField() {
	return passwordField;
}

public void setPasswordField(JPasswordField passwordField) {
	this.passwordField = passwordField;
}

public JButton getBtnZaloguj() {
	return btnZaloguj;
}

public void setBtnZaloguj(JButton btnZaloguj) {
	this.btnZaloguj = btnZaloguj;
}

public JButton getBtnZarejestruj() {
	return btnZarejestruj;
}

public void setBtnZarejestruj(JButton btnZarejestruj) {
	this.btnZarejestruj = btnZarejestruj;
}
}
