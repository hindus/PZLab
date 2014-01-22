package pzprojekt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreePanel extends JPanel 
{
	private JTree tree;
	
	public TreePanel()
	{
		this.setLayout(null);
		tree = new JTree();
    	this.setBackground(Color.WHITE);		
	    tree.setModel(new DefaultTreeModel(
	    	new DefaultMutableTreeNode("Alfa Romeo") {
	    		{
	    			DefaultMutableTreeNode node_1;
	    			node_1 = new DefaultMutableTreeNode("156");
	    				node_1.add(new DefaultMutableTreeNode("Układ napędowy"));
	    				node_1.add(new DefaultMutableTreeNode("Układ wydechowy"));
	    				node_1.add(new DefaultMutableTreeNode("Układ hamulcowy"));
	    			add(node_1);
	    			node_1 = new DefaultMutableTreeNode("159");
	    				node_1.add(new DefaultMutableTreeNode("Układ napędowy"));
	    				node_1.add(new DefaultMutableTreeNode("Układ wydechowy"));
	    				node_1.add(new DefaultMutableTreeNode("Układ hamulcowy"));
	    			add(node_1);
	    		}
	    	}
	    ));
	    tree.setBounds(0, 0, 257, 427);

	    tree.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(MouseEvent m) {
	        doMouseClicked(m);
	      }
	    });
	    this.add(tree);
	}
	void doMouseClicked(MouseEvent me) {
	    TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
	    if (tp != null)
	    {
	      System.out.println("Kliknieto: "+tp.toString());
	      if(tp.toString().equals("[Alfa Romeo, 156, Układ napędowy]"))
		      System.out.println("kliknales uklad napedowy buebue bue chuj.");
	    }
	      else
		  System.out.println("Rozwijam.");

	  }
}
