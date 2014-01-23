package pzprojekt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPanel extends JPanel implements ActionListener
{
	public AdminPanel()
	{
		
		this.setBounds(0, 12, 697, 487);
		this.setLayout(null);
		

	
		this.setBounds(0, 0, 441, 456);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel_1);
		
		JLabel lblDodajSamochd = new JLabel("Dodaj samochód");
		GridBagConstraints gbc_lblDodajSamochd = new GridBagConstraints();
		gbc_lblDodajSamochd.anchor = GridBagConstraints.WEST;
		gbc_lblDodajSamochd.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodajSamochd.gridx = 0;
		gbc_lblDodajSamochd.gridy = 0;
		this.add(lblDodajSamochd, gbc_lblDodajSamochd);
		
		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		this.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		this.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblUsuSamochd = new JLabel("Usuń samochód");
		GridBagConstraints gbc_lblUsuSamochd = new GridBagConstraints();
		gbc_lblUsuSamochd.anchor = GridBagConstraints.WEST;
		gbc_lblUsuSamochd.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuSamochd.gridx = 0;
		gbc_lblUsuSamochd.gridy = 1;
		this.add(lblUsuSamochd, gbc_lblUsuSamochd);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		this.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_1 = new JButton("Usuń");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		this.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblDodajKategori = new JLabel("Dodaj kategorię");
		GridBagConstraints gbc_lblDodajKategori = new GridBagConstraints();
		gbc_lblDodajKategori.anchor = GridBagConstraints.WEST;
		gbc_lblDodajKategori.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodajKategori.gridx = 0;
		gbc_lblDodajKategori.gridy = 2;
		this.add(lblDodajKategori, gbc_lblDodajKategori);
		
		JTextField textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		this.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("Dodaj");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 2;
		this.add(button, gbc_button);
		
		JLabel label_3 = new JLabel("Usuń kategorię");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		this.add(label_3, gbc_label_3);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		this.add(comboBox_1, gbc_comboBox_1);
		
		JLabel label = new JLabel("ID:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		this.add(label, gbc_label);
		
		JComboBox comboBox_5 = new JComboBox();
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_5.gridx = 3;
		gbc_comboBox_5.gridy = 3;
		this.add(comboBox_5, gbc_comboBox_5);
		
		JButton button_2 = new JButton("Usuń");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 3;
		this.add(button_2, gbc_button_2);
		
		JLabel lblDodajCz = new JLabel("Dodaj część");
		GridBagConstraints gbc_lblDodajCz = new GridBagConstraints();
		gbc_lblDodajCz.anchor = GridBagConstraints.WEST;
		gbc_lblDodajCz.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodajCz.gridx = 0;
		gbc_lblDodajCz.gridy = 4;
		this.add(lblDodajCz, gbc_lblDodajCz);
		
		JTextField textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		this.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("Dodaj");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 4;
		this.add(button_1, gbc_button_1);
		
		JLabel lblUsuCz = new JLabel("Usuń część");
		GridBagConstraints gbc_lblUsuCz = new GridBagConstraints();
		gbc_lblUsuCz.anchor = GridBagConstraints.WEST;
		gbc_lblUsuCz.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuCz.gridx = 0;
		gbc_lblUsuCz.gridy = 5;
		this.add(lblUsuCz, gbc_lblUsuCz);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 5;
		this.add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_1 = new JLabel("ID:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 5;
		this.add(label_1, gbc_label_1);
		
		JComboBox comboBox_6 = new JComboBox();
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_6.gridx = 3;
		gbc_comboBox_6.gridy = 5;
		this.add(comboBox_6, gbc_comboBox_6);
		
		JButton button_3 = new JButton("Usuń");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 5;
		this.add(button_3, gbc_button_3);
		
		JLabel lblUsuUytkownika = new JLabel("Usuń użytkownika");
		GridBagConstraints gbc_lblUsuUytkownika = new GridBagConstraints();
		gbc_lblUsuUytkownika.anchor = GridBagConstraints.WEST;
		gbc_lblUsuUytkownika.insets = new Insets(0, 0, 0, 5);
		gbc_lblUsuUytkownika.gridx = 0;
		gbc_lblUsuUytkownika.gridy = 6;
		this.add(lblUsuUytkownika, gbc_lblUsuUytkownika);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 1;
		gbc_comboBox_3.gridy = 6;
		this.add(comboBox_3, gbc_comboBox_3);
		
		JLabel label_2 = new JLabel("ID:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 6;
		this.add(label_2, gbc_label_2);
		
		JComboBox comboBox_7 = new JComboBox();
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_7.gridx = 3;
		gbc_comboBox_7.gridy = 6;
		this.add(comboBox_7, gbc_comboBox_7);
		
		JButton button_4 = new JButton("Usuń");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 6;
		this.add(button_4, gbc_button_4);
		
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		
	}
}
