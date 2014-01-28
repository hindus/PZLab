package pzprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

public class EperImage extends JPanel{
	private static HashMap<String, BufferedImage> bufor;
    private BufferedImage image;
    private Image img;
    
    public void setPicture(String obrazek)
    {

    		if(bufor.containsKey(obrazek)){
    			this.img=bufor.get(obrazek);
    		} else {
    			this.img=bufor.get("default");
    		}

    	repaint();
    }
    
    public EperImage() {
    	bufor=new HashMap<String, BufferedImage>();
    	this.setBackground(Color.WHITE);
    	
    	try {
			bufor.put("default",ImageIO.read(new File("pics/background/default.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	setPicture("default");
    	
    	ResultSet rs=Database.pobierzSamochody();
		try {
			while(rs.next())
			{
				String nazwa=rs.getString("nazwa");
				String obrazek=rs.getString("obrazek");			    					
				
				try {
					EperImage.getBufor().put(nazwa, ImageIO.read(new File(obrazek)));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);        
    }

	public static HashMap<String, BufferedImage> getBufor() {
		return bufor;
	}

	public static void setBufor(HashMap<String, BufferedImage> bufor) {
		EperImage.bufor = bufor;
	}

}
