import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppletDrawCircle extends Applet implements KeyListener {
     
      int x0 = 100;
      int y0 = 100;

      public void init(){
   
           this.setFocusable(true);
           this.addKeyListener(this);
      }
      public void paint(Graphics g) {
          //yuanxin(100,100£© °ë¾¶ r = 50
          int r = 50;
          double a  = Math.PI/180;
          for(int i = 0;i< 360;i++) {
               int x = (int)  (x0 + r*Math.cos(a*i));
               int y = (int)  (y0 - r*Math.sin(a*i));
               g.drawString("*",x,y);
      }
      //»­Ò»¸öÎå½ÇÐÇ
      for(int i = 0; i< 5;i++) {
          int x1 = (int) (x0 + r*Math.cos(Math.PI/2 +i*72*a));
          int y1 = (int) (y0 - r*Math.sin(Math.PI/2 +i*72*a));

         int x3 = (int) (x0 + r*Math.cos(Math.PI/2 +(i+2)*72*a));
         int y3 = (int) (y0 - r*Math.sin(Math.PI/2 +(i+2)*72*a));
         g.drawLine(x1,y1,x3,y3);
      }
}
public void keyPressed(KeyEvent e) {
  
          switch (e.getKeyCode()){
          case KeyEvent.VK_LEFT:
             x0 = x0 - 50;
             break;
          case KeyEvent.VK_RIGHT:
             x0 = x0 + 50;
             break;

          case KeyEvent.VK_UP:
             y0 = y0 - 50;
             break;
          case KeyEvent.VK_DOWN:
             y0 = y0 + 50;
             break;
          }
          repaint();
      }
      
      @Override
      public void keyReleased(KeyEvent arg0) {
         
       }
       @Override
       public void keyTyped(KeyEvent arg0) {
           
        }
}


