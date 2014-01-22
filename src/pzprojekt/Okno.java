package pzprojekt;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.CardLayout;

public class Okno {

	private JFrame frame;
	private JTextField textField;
    private JPasswordField passwordField;
    private JLabel label;
    private JPanel cards;
    private CardLayout cl;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database.dbconnect();
					Okno window = new Okno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Okno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//super(new GridLayout(1, 1));
        
        //------------------------------------TabbedPane, główne okno
        
        JTabbedPane tabbedPane = new JTabbedPane();
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        JSplitPane splitpanel = new JSplitPane();
        JPanel drzewo = new JPanel();
    	drzewo.setBackground(Color.WHITE);
    	
    	AdminPanel admin = new AdminPanel();
        
        //tabbedPane.remove(admin);
    	
    	//------------------------------------Tree panel
    	
    	TreePanel drzewko = new TreePanel();
        ImagePanel a = new ImagePanel();
        
        //------------------------------------Mapowanie imagePanel
        
        ImageMap listener = new ImageMap();
        a.addMouseListener(listener);
        a.addMouseMotionListener(listener);
        
        //------------------------------------Ustawienia splitPane
        
        splitpanel.setDividerLocation(180);
        splitpanel.setLeftComponent(drzewko);
        splitpanel.setRightComponent(a);
        tabbedPane.addTab("EPER", splitpanel);

        //------------------------------------Dodawanie kart
        
        cards = new JPanel(new CardLayout());
        tabbedPane.addTab("Sklep", cards);
        
        //cards.setPreferredSize(new Dimension(800, 500));
        
        //------------------------------------Generowanie paneli
        
        JPanel panel = new JPanel();
        cards.add(panel, "LOGOWANIE");
        
        JPanel panel_1 = new JPanel();
        cards.add(panel_1, "KOSZYK");

        cl = (CardLayout)(cards.getLayout());
        
        
        //------------------------------------Panel logowania
  
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{30, 0, 0, 201, 50, 0, 0, 198, 30, 0};
        gbl_panel.rowHeights = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 30, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JLabel lblLogowanie = new JLabel("Logowanie");
        GridBagConstraints gbc_lblLogowanie = new GridBagConstraints();
        gbc_lblLogowanie.insets = new Insets(0, 0, 5, 5);
        gbc_lblLogowanie.gridx = 3;
        gbc_lblLogowanie.gridy = 0;
        panel.add(lblLogowanie, gbc_lblLogowanie);
        
        JLabel lblRejestracja = new JLabel("Rejestracja");
        GridBagConstraints gbc_lblRejestracja = new GridBagConstraints();
        gbc_lblRejestracja.insets = new Insets(0, 0, 5, 5);
        gbc_lblRejestracja.gridx = 7;
        gbc_lblRejestracja.gridy = 0;
        panel.add(lblRejestracja, gbc_lblRejestracja);
        
        JLabel login = new JLabel("Nazwa użytkownika");
        GridBagConstraints gbc_login = new GridBagConstraints();
        gbc_login.insets = new Insets(0, 0, 5, 5);
        gbc_login.gridx = 1;
        gbc_login.gridy = 2;
        panel.add(login, gbc_login);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 3;
        gbc_textField.gridy = 2;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblNazwaUytkownika = new JLabel("Nazwa użytkownika");
        GridBagConstraints gbc_lblNazwaUytkownika = new GridBagConstraints();
        gbc_lblNazwaUytkownika.anchor = GridBagConstraints.WEST;
        gbc_lblNazwaUytkownika.insets = new Insets(0, 0, 5, 5);
        gbc_lblNazwaUytkownika.gridx = 5;
        gbc_lblNazwaUytkownika.gridy = 2;
        panel.add(lblNazwaUytkownika, gbc_lblNazwaUytkownika);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 7;
        gbc_textField_1.gridy = 2;
        panel.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        JLabel password = new JLabel("Hasło");
        GridBagConstraints gbc_password = new GridBagConstraints();
        gbc_password.anchor = GridBagConstraints.WEST;
        gbc_password.insets = new Insets(0, 0, 5, 5);
        gbc_password.gridx = 1;
        gbc_password.gridy = 3;
        panel.add(password, gbc_password);
        
        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 3;
        gbc_passwordField.gridy = 3;
        panel.add(passwordField, gbc_passwordField);
        
        JLabel lblHaso = new JLabel("Hasło");
        GridBagConstraints gbc_lblHaso = new GridBagConstraints();
        gbc_lblHaso.anchor = GridBagConstraints.WEST;
        gbc_lblHaso.insets = new Insets(0, 0, 5, 5);
        gbc_lblHaso.gridx = 5;
        gbc_lblHaso.gridy = 3;
        panel.add(lblHaso, gbc_lblHaso);
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 7;
        gbc_textField_2.gridy = 3;
        panel.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        JLabel lblImi = new JLabel("Imię");
        GridBagConstraints gbc_lblImi = new GridBagConstraints();
        gbc_lblImi.anchor = GridBagConstraints.WEST;
        gbc_lblImi.insets = new Insets(0, 0, 5, 5);
        gbc_lblImi.gridx = 5;
        gbc_lblImi.gridy = 4;
        panel.add(lblImi, gbc_lblImi);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 7;
        gbc_textField_3.gridy = 4;
        panel.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        JButton btnZaloguj = new JButton("Zaloguj");
              
        GridBagConstraints gbc_btnZaloguj = new GridBagConstraints();
        gbc_btnZaloguj.insets = new Insets(0, 0, 5, 5);
        gbc_btnZaloguj.gridx = 3;
        gbc_btnZaloguj.gridy = 5;
        panel.add(btnZaloguj, gbc_btnZaloguj);
                                          
        JLabel lblNazwisko = new JLabel("Nazwisko");
        GridBagConstraints gbc_lblNazwisko = new GridBagConstraints();
        gbc_lblNazwisko.anchor = GridBagConstraints.WEST;
        gbc_lblNazwisko.insets = new Insets(0, 0, 5, 5);
        gbc_lblNazwisko.gridx = 5;
        gbc_lblNazwisko.gridy = 5;
        panel.add(lblNazwisko, gbc_lblNazwisko);
        
        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 7;
        gbc_textField_4.gridy = 5;
        panel.add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);
        
        JLabel lblAdres = new JLabel("Adres");
        GridBagConstraints gbc_lblAdres = new GridBagConstraints();
        gbc_lblAdres.anchor = GridBagConstraints.WEST;
        gbc_lblAdres.insets = new Insets(0, 0, 5, 5);
        gbc_lblAdres.gridx = 5;
        gbc_lblAdres.gridy = 6;
        panel.add(lblAdres, gbc_lblAdres);
        
        textField_5 = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 7;
        gbc_textField_5.gridy = 6;
        panel.add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNumerTelefonu = new JLabel("Numer telefonu");
        GridBagConstraints gbc_lblNumerTelefonu = new GridBagConstraints();
        gbc_lblNumerTelefonu.anchor = GridBagConstraints.WEST;
        gbc_lblNumerTelefonu.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumerTelefonu.gridx = 5;
        gbc_lblNumerTelefonu.gridy = 7;
        panel.add(lblNumerTelefonu, gbc_lblNumerTelefonu);
        
        textField_6 = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 7;
        gbc_textField_6.gridy = 7;
        panel.add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);
        
        JButton btnZarejestruj = new JButton("Zarejestruj");
        GridBagConstraints gbc_btnZarejestruj = new GridBagConstraints();
        gbc_btnZarejestruj.insets = new Insets(0, 0, 0, 5);
        gbc_btnZarejestruj.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnZarejestruj.gridx = 7;
        gbc_btnZarejestruj.gridy = 9;
        panel.add(btnZarejestruj, gbc_btnZarejestruj);

        //------------------------------------Panel koszyka
	    
        panel_1.setBounds(6, 6, 439, 240);
        
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{33, 103, 147, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
        GridBagConstraints gbc_lblZalogowanyJako = new GridBagConstraints();
        gbc_lblZalogowanyJako.insets = new Insets(0, 0, 5, 5);
        gbc_lblZalogowanyJako.gridx = 1;
        gbc_lblZalogowanyJako.gridy = 0;
        panel_1.add(lblZalogowanyJako, gbc_lblZalogowanyJako);
        
        label = new JLabel("");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 0;
        panel_1.add(label, gbc_label);
        
        JButton btnWyloguj = new JButton("Wyloguj");
        GridBagConstraints gbc_btnWyloguj = new GridBagConstraints();
        gbc_btnWyloguj.insets = new Insets(0, 0, 5, 0);
        gbc_btnWyloguj.gridx = 3;
        gbc_btnWyloguj.gridy = 0;
        panel_1.add(btnWyloguj, gbc_btnWyloguj);
        
        JLabel label_1 = new JLabel("Zawartość Twojego koszyka:");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 1;
        gbc_label_1.gridy = 2;
        panel_1.add(label_1, gbc_label_1);
        
        JLabel lblNazwaPrzedmiotu = new JLabel("Nazwa przedmiotu");
        GridBagConstraints gbc_lblNazwaPrzedmiotu = new GridBagConstraints();
        gbc_lblNazwaPrzedmiotu.anchor = GridBagConstraints.WEST;
        gbc_lblNazwaPrzedmiotu.insets = new Insets(0, 0, 5, 5);
        gbc_lblNazwaPrzedmiotu.gridx = 1;
        gbc_lblNazwaPrzedmiotu.gridy = 3;
        panel_1.add(lblNazwaPrzedmiotu, gbc_lblNazwaPrzedmiotu);
        
        JLabel lblSztuk = new JLabel("Sztuk");
        GridBagConstraints gbc_lblSztuk = new GridBagConstraints();
        gbc_lblSztuk.insets = new Insets(0, 0, 5, 5);
        gbc_lblSztuk.gridx = 2;
        gbc_lblSztuk.gridy = 3;
        panel_1.add(lblSztuk, gbc_lblSztuk);
        
        JLabel lblNaleno = new JLabel("Należność");
        GridBagConstraints gbc_lblNaleno = new GridBagConstraints();
        gbc_lblNaleno.insets = new Insets(0, 0, 5, 0);
        gbc_lblNaleno.gridx = 3;
        gbc_lblNaleno.gridy = 3;
        panel_1.add(lblNaleno, gbc_lblNaleno);

        //------------------------------------ActionListenery dla logowania i wylogowania
        
        btnZaloguj.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		Database.userlogin(textField.getText(),passwordField.getText());
        		label.setText(User.imie+" "+User.nazwisko+" "+User.adres+" tel. "+User.telefon);
        		cl.show(cards, "KOSZYK");
        	}
        });     
        
        btnWyloguj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		User.LogOut();
        		label.setText("Nie zalogowany");
        		cl.show(cards, "LOGOWANIE");
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
        		
        		Database.register(username,haslo,imie,nazwisko,adres,telefon);
        		cl.show(cards, "KOSZYK");
        	}
        });
        
        //------------------------------------Sterowanie kartami za pomocą klawiszy
        
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
                
        //------------------------------------Tabbed pane
        
        drzewo.setLayout(null);
        //add(tabbedPane);
      
	}

}
