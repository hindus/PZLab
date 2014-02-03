package pzprojekt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Klasa EperTree odpowiedzialna jest za wyświetlanie drzewa samochodów i ich części.
 *
 */
public class EperTree extends JPanel {
	private static JTree tree;
	
	public EperTree() {
		this.setLayout(null);
    	this.setBackground(Color.WHITE);		
    	tree=new JTree();
    	
    	//------------------POBIERANIE SAMOCHODÓW
    	ustawDrzewo();
			

	    this.setBounds(0, 0, 257, 427);
	    this.add(tree);
	    tree.setBounds(0, 0, 257, 427);
	    
	    tree.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent me) {
    			TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
    		    if (tp != null)
    		    {
    		    	if(tp.getPathCount()>2){
    		    		Okno.wypelnijTabele(tp.getPathComponent(1).toString(),tp.getPathComponent(2).toString());
    		      		Okno.showEper("TABELA");
    		    	} else {
    		    		Okno.showEper("EPERp");
    		    		if(tp.getPathCount()>1) { 
    		    			Okno.getImgpanel().setPicture(tp.getPathComponent(1).toString());
    		    		} else {
    		    			Okno.getImgpanel().setPicture("");
    		    		}
    		    	}
    		    } 
    		  }    		
    	});
	    
	}

	public static void ustawDrzewo()
	{
		tree.setModel(new DefaultTreeModel(
		    	new DefaultMutableTreeNode("Alfa Romeo") {
		    		{	    	    					
		    			DefaultMutableTreeNode node;

		    			try {
		    				Vector<String> kategorie=Database.pobierzKategorie();
		    				
		    				ResultSet rs=Database.pobierzSamochody();
		    				while(rs.next())
		    				{
		    					String nazwa=rs.getString("nazwa");				
		    					
		    					node = new DefaultMutableTreeNode(nazwa);
		    					add(node);
		    					
		    					for(int i=0;i<kategorie.size();i++){
		    						node.add(new DefaultMutableTreeNode(kategorie.get(i)));
		    					}    	    					
		    				}
		    				
		    			} catch (SQLException e) {
		    				System.out.println("Błąd połaczenia z baza danych!");
		    			}
		    		}
		    	}
		    ));
	}
	
	public static JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
}
