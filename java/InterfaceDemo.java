interface A
{
     public void show();
}

interface Z
{
      public void show();
}

class Test implements A,Z
{
      public void show()
      {
         
       }
}

class InterfaceDemo
{
       public static void main(String[] args)
        {
            Test t = new Test();
            t.show();
   }
}