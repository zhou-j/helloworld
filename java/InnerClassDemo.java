class Outer
{
      private static int num = 31;
      
      class Inner
      {
           void show()
           {
                System.out.println("show run..."+num);
            }
       }
   
       public void method()
       {
             Inner in = new Inner();
             in.show();
        }
}

class InnerClassDemo
{
       public static void main(String[] args)
       {
            Outer.Inner in  = new Outer().new Inner();
            in.show();
        }
}