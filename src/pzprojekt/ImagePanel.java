package pzprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public void ladujObrazek(String adresObrazka)
    {
    	try {
			this.image = ImageIO.read(new File("pics/silnik/silnik.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public ImagePanel() {
    	this.setBackground(Color.WHITE);
       try {
    	   
          image = ImageIO.read(new File("pics/eper2.jpg"));
       } catch (IOException ex) {
           System.out.println("blad ladowania obrazka");

       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

}