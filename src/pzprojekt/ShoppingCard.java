package pzprojekt;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2324737019103682442L;
	private JTable table;
	private JLabel label;
	
	public ShoppingCard(){
		this.setBounds(6, 6, 439, 240);
        this.setLayout(null);
        
        JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
        lblZalogowanyJako.setBounds(19, 16, 110, 16);
        this.add(lblZalogowanyJako);
           
        JButton btnWyloguj = new JButton("Wyloguj");
        btnWyloguj.setBounds(660, 11, 94, 29);
        this.add(btnWyloguj);
        
        //------------------------------------TABELA
        
        Object[][] data = {
        	    {"Jakiś przedmiot", new Integer(100), new Integer(1), 100}      	 
        	};
        Object[] kolumny = {"Przedmiot",
                "Cena",
                "Ilość",
                "Wartość"};
        
        JLabel lblcznie = new JLabel("ŁĄCZNIE:");
        lblcznie.setBounds(496, 394, 61, 16);
        this.add(lblcznie);
        
        JButton btnZamw = new JButton("Zamów");
        btnZamw.setBounds(637, 389, 117, 29);
        this.add(btnZamw);
        
        table = new JTable(data, kolumny);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 44, 767, 338);
        this.add(scrollPane);
        
        label = new JLabel("Nie pamiętam");
        label.setBounds(141, 16, 200, 16);
        this.add(label);
        
        btnWyloguj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		User.LogOut();
        		//cl.show(cards, "LOGOWANIE");
        		Okno.showLogin("LOGOWANIE");
        	}
        });
	}
}
