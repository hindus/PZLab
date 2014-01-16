package pzprojekt;

/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */
 
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
import javax.swing.tree.DefaultMutableTreeNode;

import sun.reflect.generics.tree.Tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
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
 
public class Window extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
    public Window() {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
         
        //tabbedPane.addTab("EPER", panel1);
        JSplitPane pan1 = new JSplitPane();
        JPanel pan1pan1 = new JPanel();
        JPanel pan1pan2 = new JPanel();
        pan1.setDividerLocation(250);
        pan1.setLeftComponent(pan1pan1);
        pan1.setRightComponent(pan1pan2);
        tabbedPane.addTab("EPER", pan1);

        //panel1.setPreferredSize(new Dimension(800, 500));
//        JSplitPane pan1 = new JSplitPane();
//        JPanel pan1pan1 = new JPanel();
//        JPanel pan1pan2 = new JPanel();
//        pan1.setLeftComponent(pan1pan1);
//        pan1.setRightComponent(pan1pan2);
        //panel1.add(pan1);



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
        GridBagConstraints gbc_btnZaloguj = new GridBagConstraints();
        gbc_btnZaloguj.insets = new Insets(0, 0, 5, 5);
        gbc_btnZaloguj.gridx = 2;
        gbc_btnZaloguj.gridy = 3;
        panel.add(btnZaloguj, gbc_btnZaloguj);

        
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Autorzy", panel3);
        panel3.setPreferredSize(new Dimension(800, 500));

        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//        //chujowe drzewko
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        root.add(child1);
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        root.add(child2);
        pan1pan1.setLayout(null);
        JTree tree = new JTree(root);
        tree.setBounds(0, 0, 249, 406);
        pan1pan1.add(tree);
//        //koniec chujowego drzewka
        add(tabbedPane);
        
        

        

        
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
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
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}
