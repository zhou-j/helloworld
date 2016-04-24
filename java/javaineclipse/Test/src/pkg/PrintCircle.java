package pkg;

import java.awt.Graphics;
import javax.swing.JApplet;

public class PrintCircle extends JApplet {
	@Override
	public void paint(Graphics g) {
  
    int x = 100;
    int y = 100;
    int r = 99;
    for(int i = 0;i<3600;i++)
	
    {
    	double b = Math.PI /180 * i;
    
        int x0 = (int)(x + r * Math.cos(b));
        int y0 = (int)(y-r*Math.sin(b));
	    g.drawString(".", x0, y0);
        
	
	}
	
	
	

}
}