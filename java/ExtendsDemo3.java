class Fu
{
   void show()
   {
      System.out.println("Fu show run");
    }
}


class Zi extends Fu
{
    void show()
    {
       System.out.println("Zi show run");
     }
}


class ExtendsDemo3
{
      public static void main(String[] args)
      {
         Zi  z = new Zi();
         z.show();
       }
}