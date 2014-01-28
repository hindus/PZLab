package pzprojekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EperDetails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4009610015728591272L;
	private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JLabel lblNazwaCzesci;
    private JLabel lblCena;
    private JLabel lblSamochd;
	private JLabel lblDostpnaIlo;
	private JTextArea textArea;
	private JLabel lblIle;
	private static JButton btnDodajDoKoszyka;
	
	public EperDetails(){
		this.setBounds(0, 0, 588, 428);
        
        this.setLayout(null);
        
        lblDostpnaIlo = new JLabel("Dostępna ilość:");
        lblDostpnaIlo.setBounds(25, 117, 98, 16);
        this.add(lblDostpnaIlo);
        
        textArea = new JTextArea();
        textArea.setBounds(6, 156, 576, 158);
        this.add(textArea);
        textArea.setEditable(false);
        
        lblNazwaCzesci = new JLabel("Nazwa czesci");
        lblNazwaCzesci.setBounds(25, 25, 500, 25);
        this.add(lblNazwaCzesci);
        
        lblCena = new JLabel("Cena");
        lblCena.setBounds(25, 89, 98, 16);
        this.add(lblCena);
        
        btnDodajDoKoszyka = new JButton("Dodaj do koszyka");
        btnDodajDoKoszyka.setEnabled(false);
        btnDodajDoKoszyka.setBounds(278, 359, 157, 29);
        this.add(btnDodajDoKoszyka);
        
        
        lblSamochd = new JLabel("Samochód");
        lblSamochd.setBounds(25, 61, 98, 16);
        this.add(lblSamochd);
        
        textField_8 = new JTextField();
        textField_8.setBounds(170, 55, 134, 28);
        this.add(textField_8);
        textField_8.setColumns(10);
        textField_8.setEditable(false);
        
        textField_9 = new JTextField();
        textField_9.setBounds(170, 83, 134, 28);
        this.add(textField_9);
        textField_9.setColumns(10);
        textField_9.setEditable(false);
        
        textField_10 = new JTextField();
        textField_10.setBounds(170, 111, 134, 28);
        this.add(textField_10);
        textField_10.setColumns(10);
        textField_10.setEditable(false);
        
        lblIle = new JLabel("Ile:");
        lblIle.setBounds(447, 364, 25, 16);
        this.add(lblIle);
        
        textField_11 = new JTextField();
        textField_11.setBounds(472, 358, 73, 28);
        this.add(textField_11);
        textField_11.setColumns(10);
        
        btnDodajDoKoszyka.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String nazwa=lblNazwaCzesci.getText();
        		String cena=textField_9.getText();
        		String ilosc=textField_11.getText();
        		
        		if(!ilosc.equals("")){
        		
        		int wartosc=Integer.parseInt(ilosc)*Integer.parseInt(cena);
        		
        		
        			
        		UserBasket.getModel().addRow(new Object[]{nazwa, cena+" zł", ilosc, wartosc+" zł"});
        		JOptionPane.showMessageDialog(Okno.getFrame(), "Dodano do koszyka");
        		
        		} else {
        			JOptionPane.showMessageDialog(Okno.getFrame(), "Wpisz ilość");
        		}
        		
        		textField_11.setText("");
        	}
        });
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}

	public JTextField getTextField_10() {
		return textField_10;
	}

	public void setTextField_10(JTextField textField_10) {
		this.textField_10 = textField_10;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
	}

	public JLabel getLblNazwaCzesci() {
		return lblNazwaCzesci;
	}

	public void setLblNazwaCzesci(JLabel lblNazwaCzesci) {
		this.lblNazwaCzesci = lblNazwaCzesci;
	}

	public JLabel getLblCena() {
		return lblCena;
	}

	public void setLblCena(JLabel lblCena) {
		this.lblCena = lblCena;
	}

	public JLabel getLblSamochd() {
		return lblSamochd;
	}

	public void setLblSamochd(JLabel lblSamochd) {
		this.lblSamochd = lblSamochd;
	}

	public JLabel getLblDostpnaIlo() {
		return lblDostpnaIlo;
	}

	public void setLblDostpnaIlo(JLabel lblDostpnaIlo) {
		this.lblDostpnaIlo = lblDostpnaIlo;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JLabel getLblIle() {
		return lblIle;
	}

	public void setLblIle(JLabel lblIle) {
		this.lblIle = lblIle;
	}
	
	public static JButton getBtnDodaj(){
		return btnDodajDoKoszyka;
	}
}
