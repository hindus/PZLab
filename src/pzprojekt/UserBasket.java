package pzprojekt;

import java.sql.*;

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
	private static JLabel lblKwota;
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
        
        Object[] kolumny = {"Przedmiot", "Cena", "Ilość", "Wartość"};
        
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
        
        lblKwota = new JLabel("");
        lblKwota.setBounds(530, 394, 90, 16);
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
        
        btnZamw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		Connection con = Database.getCon();
        		try {
					Statement st=con.createStatement();
					for(int i=0;i<model.getRowCount();i++){
	        			String nazwa=(String) model.getValueAt(i, 0);
	        			nazwa=nazwa.replaceAll("<html><b>", "");
	        			nazwa=nazwa.replaceAll("</b></html>", "");
	        			String ilosc=(String) model.getValueAt(i, 2);	        			
	        			st.addBatch("UPDATE czesci SET ilosc_dostepnych=ilosc_dostepnych-'"+ilosc+"' WHERE nazwa='"+nazwa+"'");	        			
	        		}
					st.executeBatch();
					st.close();
					
//					tutaj musi być kod do wrzucania zakupów do historii zakupów
//					
//					
//					
//					
//					
//					
//					
//					
//					
					for(int j=model.getRowCount()-1;j>=0;j--)
					model.removeRow(j);
					UserBasket.updateBskt();
					Okno.showEper("TABELA");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 		
        	}
        });
	}
	
	public static void updateBskt(){
		int koszt=0;
		for(int i=0;i<model.getRowCount();i++){			
			koszt+=Integer.parseInt(model.getValueAt(i, 3).toString().split(" ")[0]);
		}
		lblKwota.setText("<html><b>"+koszt+" zł</b></html>");
	}

	public static DefaultTableModel getModel() {
		return model;
	}
	
	public static JLabel getLabel() {
		return label;
	}
}
