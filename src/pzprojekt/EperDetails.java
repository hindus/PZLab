package pzprojekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * Klasa EperDetails odpowiedzialna jest za wyswietlanie szczegolow dotyczacych danej kategorii czesci.
 *
 */
public class EperDetails extends JPanel {

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
	private int idczesci;
	
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
        		String cena=textField_9.getText().split(" ")[0];
        		String ilosc=textField_11.getText();
        		String autko=textField_8.getText();
        		autko=autko.split(" ")[2];
        		if(!ilosc.equals("")){
        		
        		int wartosc=Integer.parseInt(ilosc)*Integer.parseInt(cena);

        		UserBasket.getModel().addRow(new Object[]{nazwa, ""+idczesci, autko, cena+" zł", ilosc, wartosc+" zł"});
        		JOptionPane.showMessageDialog(Okno.getFrame(), "Dodano do koszyka");
        		UserBasket.updateBskt();
        		} else {
        			JOptionPane.showMessageDialog(Okno.getFrame(), "Wpisz ilość");
        		}
        		
        		textField_11.setText("");
        	}
        });
	}

	public void wypelnij(HashMap<String, String> info){
		lblNazwaCzesci.setText("<html><b>"+info.get("nazwa")+"</b></html>");
        textField_8.setText("Alfa Romeo "+info.get("model"));
        textField_9.setText(info.get("cena")+" zł");
        textField_10.setText(info.get("ilosc"));
        textArea.setText(info.get("opis"));
        idczesci=Integer.parseInt(info.get("id"));
	}
	
	public JTextField getTextField_8() {
		return textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public JTextField getTextField_10() {
		return textField_10;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public JLabel getLblNazwaCzesci() {
		return lblNazwaCzesci;
	}

	public JLabel getLblCena() {
		return lblCena;
	}

	public JLabel getLblSamochd() {
		return lblSamochd;
	}

	public JLabel getLblDostpnaIlo() {
		return lblDostpnaIlo;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JLabel getLblIle() {
		return lblIle;
	}

	public static JButton getBtnDodaj(){
		return btnDodajDoKoszyka;
	}
}
