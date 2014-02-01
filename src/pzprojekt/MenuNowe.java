package pzprojekt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class MenuNowe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuNowe window = new MenuNowe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuNowe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 200, 633, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 597, 44);
		frame.getContentPane().add(panel);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 51, 255)));
		panel_1.setBounds(12, 12, 50, 25);
		JLabel eper = new JLabel("EPER");
		panel_1.add(eper);
		panel_1.setBackground(new Color(51, 153, 255));
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(51, 51, 255)));
		panel_2.setBounds(74, 12, 50, 25);
		JLabel sklep = new JLabel("SKLEP");
		panel_2.add(sklep);
		panel_2.setBackground(new Color(51, 153, 255));
		panel.add(panel_2);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 51, 255)));
		panel_3.setBounds(136, 12, 116, 25);
		JLabel admin = new JLabel("ADMINISTRACJA");
		panel_3.add(admin);
		panel_3.setBackground(new Color(51, 153, 255));
		panel.add(panel_3);
		
		panel_1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				panel_1.setBounds(panel_1.getX(), panel_1.getY()+10, panel_1.getWidth(), panel_1.getHeight()-10);				
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				panel_1.setBounds(panel_1.getX(), panel_1.getY()-10, panel_1.getWidth(), panel_1.getHeight()+10);				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		panel_2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				panel_2.setBounds(panel_2.getX(), panel_2.getY()+10, panel_2.getWidth(), panel_2.getHeight()-10);				
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				panel_2.setBounds(panel_2.getX(), panel_2.getY()-10, panel_2.getWidth(), panel_2.getHeight()+10);				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		panel_3.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				panel_3.setBounds(panel_3.getX(), panel_3.getY()+10, panel_3.getWidth(), panel_3.getHeight()-10);				
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				panel_3.setBounds(panel_3.getX(), panel_3.getY()-10, panel_3.getWidth(), panel_3.getHeight()+10);				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		panel.setLayout(null);
		panel.add(panel_1);
		



		

	}
}
