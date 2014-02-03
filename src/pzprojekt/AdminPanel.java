package pzprojekt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

public class AdminPanel extends JPanel implements ActionListener
{
	public AdminPanel()
	{
		this.setBounds(0, 12, 697, 487);
		this.setLayout(null);
		this.setBounds(0, 0, 441, 456);
		
		final DefaultComboBoxModel<String> samochody = new DefaultComboBoxModel<String>();
		ResultSet rs=Database.pobierzSamochody();
		try {
			while(rs.next())
			{
				String nazwa=rs.getString("nazwa");
				samochody.addElement(nazwa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
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
		
		final JTextField textField = new JTextField();
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
		
		final JComboBox comboBox = new JComboBox(samochody);
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
		
		final JTextField textField_1 = new JTextField();
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
		
		final JComboBox comboBox_1 = new JComboBox(Database.pobierzKategorie());
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		this.add(comboBox_1, gbc_comboBox_1);
		
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
		
		final JTextField textField_2 = new JTextField();
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
		
		final JComboBox comboBox_2 = new JComboBox(Database.pobierzCzesci());
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 5;
		this.add(comboBox_2, gbc_comboBox_2);
		
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
		
		final JComboBox comboBox_3 = new JComboBox(Database.pobierzUserow());
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 1;
		gbc_comboBox_3.gridy = 6;
		this.add(comboBox_3, gbc_comboBox_3);
		
		JButton button_4 = new JButton("Usuń");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 6;
		this.add(button_4, gbc_button_4);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("dodaj samochod");
				String nazwaSamochodu = textField.getText();
				textField.setText("");
				Database.insert("samochody",nazwaSamochodu);
				
			}
		});


		btnNewButton_1.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("usun samochod");
					String nazwaSamochodu = comboBox.getSelectedItem().toString();
					Database.delete("samochody","nazwaS",nazwaSamochodu);
			}
		});



		button.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Dodaj kategorie");
				String nazwaKategorii = textField_1.getText();
				Database.insert("kategorie",nazwaKategorii);
				textField_1.setText("");

			}
		});

		button_2.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("usun kategorie");
				String nazwaKategorii = comboBox_1.getSelectedItem().toString();
				Database.delete("kategorie","nazwaK",nazwaKategorii);
		}
	});


		button_1.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent arg0) {
				String nazwaCzesci = textField_2.getText();
				Database.insert("czesci",nazwaCzesci);
				textField_2.setText("");
				System.out.println("Dodaj czesc");

			}
		});


		button_3.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("usun czesc");
				String nazwaCzesci = comboBox_2.getSelectedItem().toString();
				Database.delete("czesci","nazwaC",nazwaCzesci);
		}
	});

		button_4.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("usun uzytkownika");
				String nazwaUzytkownika = comboBox_3.getSelectedItem().toString();
				Database.delete("kategorie","nazwaK",nazwaUzytkownika);
		}
	});
	}	
		
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		
	}
}
