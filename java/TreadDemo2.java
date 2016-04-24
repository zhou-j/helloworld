class Demo extends Thread
{
     private String name;
     Demo(String name)
     {
          this.name = name;
      }
     public void run()
     {
          for(int x=0; x<10;x++)
          {    
              // for(int y=-99999999;y<99999999;y++){}
               System.out.println(name+"......x="+x);
           }
      }
}


class TreadDemo2
{
      public static void main(String[] args)
      {
           Demo d1 = new Demo("Íú²Æ");
           Demo d2 = new Demo("xiaoqiang");
           d1.start();
           d2.start();
       }
}