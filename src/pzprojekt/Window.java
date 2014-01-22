package pzprojekt;

 
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
//asdf
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JPasswordField;

import java.awt.Insets;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
 
public class Window extends JPanel {
        private JTextField textField;
        private JPasswordField passwordField;
        private JLabel label;
    public Window() {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
         
        JSplitPane pan1 = new JSplitPane();
        JPanel pan1pan1 = new JPanel();
    	pan1pan1.setBackground(Color.WHITE);
    	
    	TreePanel drzewko = new TreePanel();
        
        ImagePanel a = new ImagePanel();
        
        ImageMap listener = new ImageMap();
        a.addMouseListener(listener);
        a.addMouseMotionListener(listener);
        
        pan1.setDividerLocation(180);
        pan1.setLeftComponent(drzewko);

        pan1.setRightComponent(a);
        tabbedPane.addTab("EPER", pan1);



        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
          
        //JComponent panel2 = makeTextPanel("Panel #2");
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Sklep", panel2);
        panel2.setPreferredSize(new Dimension(800, 500));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel panel = new JPanel();
        panel2.add(panel);
       
        
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JLabel login = new JLabel("Nazwa użytkownika:");
        GridBagConstraints gbc_login = new GridBagConstraints();
        gbc_login.insets = new Insets(0, 0, 5, 5);
        gbc_login.gridx = 0;
        gbc_login.gridy = 1;
        panel.add(login, gbc_login);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);
        JLabel password = new JLabel("Hasło:");
        GridBagConstraints gbc_password = new GridBagConstraints();
        gbc_password.anchor = GridBagConstraints.WEST;
        gbc_password.insets = new Insets(0, 0, 5, 5);
        gbc_password.gridx = 0;
        gbc_password.gridy = 2;
        panel.add(password, gbc_password);
        
        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 2;
        gbc_passwordField.gridy = 2;
        panel.add(passwordField, gbc_passwordField);
        
        JButton btnZarejestruj = new JButton("Zarejestruj");
        GridBagConstraints gbc_btnZarejestruj = new GridBagConstraints();
        gbc_btnZarejestruj.insets = new Insets(0, 0, 5, 5);
        gbc_btnZarejestruj.gridx = 0;
        gbc_btnZarejestruj.gridy = 3;
        panel.add(btnZarejestruj, gbc_btnZarejestruj);
        
        JButton btnZaloguj = new JButton("Zaloguj");
        btnZaloguj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Database.userlogin(textField.getText(),passwordField.getText());
        		String name=User.username;
        		label.setText(name);
        	}
        });
        
        GridBagConstraints gbc_btnZaloguj = new GridBagConstraints();
        gbc_btnZaloguj.insets = new Insets(0, 0, 5, 5);
        gbc_btnZaloguj.gridx = 2;
        gbc_btnZaloguj.gridy = 3;
        panel.add(btnZaloguj, gbc_btnZaloguj);

        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
          
        tabbedPane.addTab("Przykładowe okienko sklepu", panel3);
        panel3.setPreferredSize(new Dimension(800, 500));

        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        pan1pan1.setLayout(null);
        add(tabbedPane);
   
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 6, 439, 240);
        panel.add(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{103, 147, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
        GridBagConstraints gbc_lblZalogowanyJako = new GridBagConstraints();
        gbc_lblZalogowanyJako.insets = new Insets(0, 0, 5, 5);
        gbc_lblZalogowanyJako.gridx = 0;
        gbc_lblZalogowanyJako.gridy = 0;
        panel_1.add(lblZalogowanyJako, gbc_lblZalogowanyJako);
        
        label = new JLabel("");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
        panel_1.add(label, gbc_label);
        
        JButton btnWyloguj = new JButton("Wyloguj");
        btnWyloguj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		User.LogOut();
        		label.setText("Nie zalogowany");
        	}
        });
        GridBagConstraints gbc_btnWyloguj = new GridBagConstraints();
        gbc_btnWyloguj.insets = new Insets(0, 0, 5, 0);
        gbc_btnWyloguj.gridx = 2;
        gbc_btnWyloguj.gridy = 0;
        panel_1.add(btnWyloguj, gbc_btnWyloguj);
        
        JLabel label_1 = new JLabel("Zawartość Twojego koszyka:");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 2;
        panel_1.add(label_1, gbc_label_1);
        
        JLabel lblNazwaPrzedmiotu = new JLabel("Nazwa przedmiotu");
        GridBagConstraints gbc_lblNazwaPrzedmiotu = new GridBagConstraints();
        gbc_lblNazwaPrzedmiotu.anchor = GridBagConstraints.WEST;
        gbc_lblNazwaPrzedmiotu.insets = new Insets(0, 0, 5, 5);
        gbc_lblNazwaPrzedmiotu.gridx = 0;
        gbc_lblNazwaPrzedmiotu.gridy = 3;
        panel_1.add(lblNazwaPrzedmiotu, gbc_lblNazwaPrzedmiotu);
        
        JLabel lblSztuk = new JLabel("Sztuk");
        GridBagConstraints gbc_lblSztuk = new GridBagConstraints();
        gbc_lblSztuk.insets = new Insets(0, 0, 5, 5);
        gbc_lblSztuk.gridx = 1;
        gbc_lblSztuk.gridy = 3;
        panel_1.add(lblSztuk, gbc_lblSztuk);
        
        JLabel lblNaleno = new JLabel("Należność");
        GridBagConstraints gbc_lblNaleno = new GridBagConstraints();
        gbc_lblNaleno.insets = new Insets(0, 0, 5, 0);
        gbc_lblNaleno.gridx = 2;
        gbc_lblNaleno.gridy = 3;
        panel_1.add(lblNaleno, gbc_lblNaleno);
        return panel;
    }
     
   
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500); 
        //Add content to the window.
        frame.getContentPane().add(new Window(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Database.dbconnect();
                //Turn off metal's use of bold fonts
            	UIManager.put("swing.boldMetal", Boolean.FALSE);
            	createAndShowGUI();
            }
        });
    }
}
