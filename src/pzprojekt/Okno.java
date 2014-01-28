package pzprojekt;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Okno {

	private JFrame frame;
    private static JPanel cards;
    private static JPanel eper;
    private static CardLayout cl;
    public static CardLayout clep;
    private static JTabbedPane tabbedPane;
    static Focus newPolicy;
    private JTable table_1;
    private static DefaultTableModel model;


	/**
	 * Uruchomienie aplikacji
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database.dbconnect();
					Okno window = new Okno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Generowanie GUI
	 */
	public Okno() {
		initialize();
	}


	@SuppressWarnings("serial")
	private void initialize() {
		
		//------------------------------------GŁÓWNE OKNO
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        //------------------------------------Ustawienia splitPane
        
	    JSplitPane splitpanel = new JSplitPane();
	
    	eper = new JPanel();
    	JPanel drzewko = new TreePanel();
        
        splitpanel.setDividerLocation(180);
        splitpanel.setLeftComponent(drzewko);
        splitpanel.setRightComponent(eper);
        
        ImagePanel imgpanel=new ImagePanel();

        tabbedPane.addTab("EPER", splitpanel);
  
        //------------------------------------Tabela części dla EPER 
        
        eper.setLayout(null);
        eper.setLayout(new CardLayout(0, 0));

        Object[] nazwykolumn = {"Przedmiot",
                "Cena",
                "Ilość"};
       
        table_1 = new JTable(); 
        JScrollPane scrollPane_1 = new JScrollPane(table_1);
        scrollPane_1.setBounds(-2720, -1400, 588, 428);
        scrollPane_1.setViewportView(table_1);
        
        model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
        model.setColumnIdentifiers(nazwykolumn);

        table_1.setModel(model); 
        table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_1.setFillsViewportHeight(true);
        
        //------------------------------------Dodawanie kart dla epera
        
        DetailsCard details=new DetailsCard();
        
        eper.add(imgpanel, "EPERp");
        eper.add(scrollPane_1, "TABELA");
        eper.add(details, "DETALE");
        
        clep=(CardLayout)(eper.getLayout());
   
        //------------------------------------SKLEP/KOSZYK
        
        cards = new JPanel(new CardLayout());

        tabbedPane.addTab("LOGOWANIE", cards);

        UserPanel panel=new UserPanel();
        ShoppingCard panel_1=new ShoppingCard();
        
        cards.add(panel, "LOGOWANIE");
        cards.add(panel_1, "KOSZYK");
        
        cl = (CardLayout)(cards.getLayout());
                        
        //------------------------------------FOCUS TRAVERSAL POLICY
        
        Vector<Component> order = new Vector<Component>(7);
        order.add(panel.getTextField());
        order.add(panel.getPasswordField());
        order.add(panel.getBtnZaloguj());
        order.add(panel.getTextField_1());
        order.add(panel.getTextField_2());
        order.add(panel.getTextField_3());
        order.add(panel.getTextField_4());
        order.add(panel.getTextField_5());
        order.add(panel.getTextField_6());
        order.add(panel.getTextField_7());
        order.add(panel.getBtnZarejestruj());
        newPolicy = new Focus(order);
        frame.setFocusTraversalPolicy(newPolicy);
      
	}
	
	
	
	public static void showEper(String str)
		{
			Okno.clep.show(eper, str);
		}
	
	public static void showLogin(String str)
	{
		Okno.cl.show(cards, str);
	}
	
	public static void wypelnijTabele(String samochod, String kategoria)
		{
		
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount()-1;i>-1;i--) {
		        model.removeRow(i);
		    }
		}
		
		ResultSet rs = Database.pobierzDane(samochod, kategoria);
		
        try {
			while(rs.next())
				{
					String nazwa = rs.getString("nazwa");
					String dostepnych = rs.getString("ilosc_dostepnych");
					String cena = rs.getString("cena_szt"); 
					model.addRow(new Object[]{nazwa, cena, dostepnych});
				}
		} catch (SQLException e) {
				e.printStackTrace();//
				
		}
	}
	
	public static class Focus extends FocusTraversalPolicy
    	{
			Vector<Component> order;

			public Focus(Vector<Component> order) {
				this.order = new Vector<Component>(order.size());
				this.order.addAll(order);
			}
			
			public Component getComponentAfter(Container focusCycleRoot,
                             Component aComponent)
			{
				int idx = (order.indexOf(aComponent) + 1) % order.size();
				return order.get(idx);
			}

			public Component getComponentBefore(Container focusCycleRoot,
                              Component aComponent)
			{
				int idx = order.indexOf(aComponent) - 1;
				if (idx < 0) {
					idx = order.size() - 1;
				}
				return order.get(idx);
			}

			public Component getDefaultComponent(Container focusCycleRoot) {
				return order.get(0);
			}

			public Component getLastComponent(Container focusCycleRoot) {
				return order.lastElement();
			}

			public Component getFirstComponent(Container focusCycleRoot) {
				return order.get(0);
			}
    	}

	public static JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public static void setTabbedPane(JTabbedPane tabbedPane) {
		Okno.tabbedPane = tabbedPane;
	}
}
