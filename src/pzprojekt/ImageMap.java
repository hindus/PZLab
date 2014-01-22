package pzprojekt;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class ImageMap extends MouseInputAdapter {
	 public void mousePressed(MouseEvent e) {
	        int x = e.getX();
	        int y = e.getY();
	        System.out.println("x: "+x+" y: "+y);
	    }
}
