class Single
{
      private static Single s = null;
      private Single(){}
      
      public static Single getInstance()
      {
           if(s==null)
               s = new Single();
           return s;
       }
}

class SingleDemo
{
      public static void main(String[] args)
      {
            System.out.println("Hello World!");
       }
}