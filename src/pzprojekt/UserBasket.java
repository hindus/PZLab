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

/**
 * Klasa UserBasker przechowuje dane o stanie koszyka uzytkownika.
 *
 */
public class UserBasket extends JPanel {

	private static final long serialVersionUID = 2324737019103682442L;
	private JTable table;
	private static JLabel label;
	private static JLabel lblKwota;
	private static DefaultTableModel model;
	
	public UserBasket(){
		this.setBounds(6, 6, 439, 240);
        this.setLayout(null);
        
        JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
        lblZalogowanyJako.setBounds(10, 16, 130, 16);
        this.add(lblZalogowanyJako);
           
        JButton btnWyloguj = new JButton("Wyloguj");
        btnWyloguj.setBounds(660, 11, 94, 29);
        this.add(btnWyloguj);
        
        Object[] kolumny = {"Przedmiot", "Numer", "Model samochodu", "Cena", "Ilość", "Wartość"};
        
        table = new JTable();
        
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        
        model.setColumnIdentifiers(kolumny);
        table.setModel(model);
        
        JLabel lblcznie = new JLabel("ŁĄCZNIE:");
        lblcznie.setBounds(460, 394, 81, 16);
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
        		
        		for(int i=model.getRowCount()-1;i>-1;i--)
        			model.removeRow(i);
        		
        		
        	}
        });
        
        btnZamw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		Connection con = Database.getCon();
        		
        		Statement zam;
				try {
					zam = con.createStatement();
					String kwota=lblKwota.getText().split(" ")[0];
					kwota=kwota.replaceAll("<html><b>", "");
					int war=Integer.parseInt(kwota);
					String query="INSERT INTO zamowione (id_klienta, wartosc) VALUES ("+User.userId+", "+war+")";
					zam.addBatch(query);
					zam.executeBatch();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        		int ajdizamowienia=Database.ostatnieZam(User.userId);
        		
        		try {
					Statement st=con.createStatement();
					
					for(int i=0;i<model.getRowCount();i++){
						
	        			String nazwa=(String) model.getValueAt(i, 0);
	        			int id_czesci=Integer.parseInt((String)model.getValueAt(i, 1));
	        			nazwa=nazwa.replaceAll("<html><b>", "");
	        			nazwa=nazwa.replaceAll("</b></html>", "");
	        			String ilosc=(String) model.getValueAt(i, 4);	 
	        			String cena=(String) model.getValueAt(i, 3);
	        			cena=cena.split(" ")[0];
	        			String wartosc=(String) model.getValueAt(i, 5);
	        			wartosc=wartosc.split(" ")[0];
	        			String autko=(String) model.getValueAt(i,2);	        			
	        			int cena1=Integer.parseInt(cena);
	        			int wart1=Integer.parseInt(wartosc);
	
	        			st.addBatch("UPDATE czesci SET ilosc_dostepnych=ilosc_dostepnych-'"+ilosc+"' WHERE id_czesci='"+id_czesci+"'");	   
	        			st.addBatch("INSERT INTO historia (idZ, id_czesci, idKlienta, nazwa, liczba, cena, wartosc, samochod) VALUES ("+ajdizamowienia+","+id_czesci+","+User.userId+",'"+nazwa+"','"+ilosc+"',"+cena1+","+wart1+","+autko+")");
	        		}
					st.executeBatch();
					st.close();

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
			koszt+=Integer.parseInt(model.getValueAt(i, 5).toString().split(" ")[0]);
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
