package pzprojekt;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DetailsCard extends JPanel {
	private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
	
	public DetailsCard(){
		this.setBounds(0, 0, 588, 428);
        
        this.setLayout(null);
        
        JLabel lblDostpnaIlo = new JLabel("Dostępna ilość:");
        lblDostpnaIlo.setBounds(25, 117, 98, 16);
        this.add(lblDostpnaIlo);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(6, 156, 576, 158);
        this.add(textArea);
        
        JLabel lblNazwaCzesci = new JLabel("Nazwa czesci");
        lblNazwaCzesci.setBounds(25, 33, 188, 16);
        this.add(lblNazwaCzesci);
        
        JLabel lblCena = new JLabel("Cena");
        lblCena.setBounds(25, 89, 98, 16);
        this.add(lblCena);
        
        JButton btnDodajDoKoszyka = new JButton("Dodaj do koszyka");
        btnDodajDoKoszyka.setBounds(278, 359, 157, 29);
        this.add(btnDodajDoKoszyka);
        
        JLabel lblSamochd = new JLabel("Samochód");
        lblSamochd.setBounds(25, 61, 98, 16);
        this.add(lblSamochd);
        
        textField_8 = new JTextField();
        textField_8.setBounds(170, 55, 134, 28);
        this.add(textField_8);
        textField_8.setColumns(10);
        
        textField_9 = new JTextField();
        textField_9.setBounds(170, 83, 134, 28);
        this.add(textField_9);
        textField_9.setColumns(10);
        
        textField_10 = new JTextField();
        textField_10.setBounds(170, 111, 134, 28);
        this.add(textField_10);
        textField_10.setColumns(10);
        
        JLabel lblIle = new JLabel("Ile:");
        lblIle.setBounds(447, 364, 25, 16);
        this.add(lblIle);
        
        textField_11 = new JTextField();
        textField_11.setBounds(472, 358, 73, 28);
        this.add(textField_11);
        textField_11.setColumns(10);
	}
}
