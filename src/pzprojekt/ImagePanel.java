package pzprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static HashMap<String, BufferedImage> bufor;
    private BufferedImage image;
    private Image img;

//    public void ladujObrazek(String adresObrazka)
//    {
//    	try {
//			this.image = ImageIO.read(new File("pics/silnik/silnik.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
//    
    
    public void setPicture(String obrazek)
    {
//    	try {
    		if(bufor.containsKey(obrazek)){
    			this.img=bufor.get(obrazek);
    		} else {
    			//this.img = ImageIO.read(new File(sciezka zapisu pobrana z bazy danych));
    			this.img=bufor.get("default");
    		}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	repaint();
    }
    
    public ImagePanel() {
    	bufor=new HashMap<String, BufferedImage>();
    	this.setBackground(Color.WHITE);
    	
    	try {
			bufor.put("default",ImageIO.read(new File("pics/eper2a.jpg")));
			bufor.put("156", ImageIO.read(new File("pics/background/156.png")));
			bufor.put("159", ImageIO.read(new File("pics/background/159.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setPicture("default");
    	//setPicture("");
    	//1 -> default background
//          image = ImageIO.read(new File("pics/eper2.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null); // see javadoc for more info on the parameters            
    }

	public static HashMap<String, BufferedImage> getBufor() {
		return bufor;
	}

	public static void setBufor(HashMap<String, BufferedImage> bufor) {
		ImagePanel.bufor = bufor;
	}

}