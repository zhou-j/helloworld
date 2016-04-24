

class Fu
{
    Fu(int x)
    {
       System.out.println("fu run");
     }
}

class Zi extends Fu
{
     Zi()
     {
        super(4);
        System.out.println("zi run");
      }

}

class  ExtendsDemo4
{
    public static void main(String[] args)
    {
        new Zi();
     }

}
