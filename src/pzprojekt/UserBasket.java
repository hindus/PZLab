package pzprojekt;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserBasket extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2324737019103682442L;
	private JTable table;
	private static JLabel label;
	private static DefaultTableModel model;
	
	public UserBasket(){
		this.setBounds(6, 6, 439, 240);
        this.setLayout(null);
        
        JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
        lblZalogowanyJako.setBounds(19, 16, 110, 16);
        this.add(lblZalogowanyJako);
           
        JButton btnWyloguj = new JButton("Wyloguj");
        btnWyloguj.setBounds(660, 11, 94, 29);
        this.add(btnWyloguj);
        
        Object[] kolumny = {"Przedmiot",
                "Cena",
                "Ilość",
                "Wartość"};
        
        table = new JTable();
        
        model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
        model.setColumnIdentifiers(kolumny);
        table.setModel(model);
        
        JLabel lblcznie = new JLabel("ŁĄCZNIE:");
        lblcznie.setBounds(460, 394, 61, 16);
        this.add(lblcznie);
        
        JLabel lblKwota = new JLabel("kwota");
        lblKwota.setBounds(530, 394, 61, 16);
        this.add(lblKwota);
        
        JButton btnZamw = new JButton("Zamów");
        btnZamw.setBounds(637, 389, 117, 29);
        this.add(btnZamw);
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 44, 767, 338);
        this.add(scrollPane);
        
        label = new JLabel();
        label.setBounds(141, 16, 200, 16);
        this.add(label);
        
        btnWyloguj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		User.LogOut();
        		Okno.getTabbedPane().remove(Okno.getAdminPanel());
        		//cl.show(cards, "LOGOWANIE");
        		Okno.showLogin("LOGOWANIE");
        	}
        });
	}

	public static DefaultTableModel getModel() {
		return model;
	}
	
	public static JLabel getLabel() {
		return label;
	}
}
