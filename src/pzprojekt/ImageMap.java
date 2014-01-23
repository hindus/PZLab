package pzprojekt;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class ImageMap extends MouseInputAdapter {
	 public void mousePressed(MouseEvent e) {
	        int x = e.getX();
	        int y = e.getY();
	        //if(x>120 && x<240 && y>120 && y<240) Okno.showEper("TABELA");
	        System.out.println("x: "+x+" y: "+y);
	    }
}
