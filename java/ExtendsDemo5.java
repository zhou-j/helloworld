class Fu
{
       Fu()
        {
              super();
              show();
              return;
         }
    
        void show()
         {
            System.out.println("fu show");
          }

}

class Zi extends Fu
{
        int num = 8;
        Zi()
        {
                super();
                return;
         }
         void show()
         {
             System.out.println("zi show...."+num);
          }
}

class  ExtendsDemo5
{
      public static void main(String[] args)
      {
              Zi z = new Zi();
              z.show();
       }
}