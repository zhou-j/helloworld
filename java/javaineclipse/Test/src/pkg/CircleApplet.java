package pkg;

import java.awt.Graphics;

import javax.swing.JApplet;

public class CircleApplet extends JApplet {

	public void paint(Graphics g) {
		
		int  x0 =100,y0 = 100;
		int r = 99;
		
		for(int i = 0;i< 3600;i++){
			double a  = Math.PI/180*i ;
			int x = (int) (x0 + r*Math.cos(a));
			int y = (int) (y0 + r*Math.sin(a));
			
			g.drawString(".",x,y);
			
			
			
		}

	}

}
