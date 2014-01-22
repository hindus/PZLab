package pzprojekt;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
	    this.add(tree);
	}
}
