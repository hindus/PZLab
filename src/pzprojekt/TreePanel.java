package pzprojekt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreePanel extends JPanel {
	private JTree tree;
	
	public TreePanel(){
		this.setLayout(null);
    	this.setBackground(Color.WHITE);		
    	tree=new JTree();
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
    		    	}
    		    } 
    		  }    		
    	});
	    
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
}
