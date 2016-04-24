class Fu
{
     int num1 = 4;
}

class Zi extends Fu
{
     int num2 = 5;
     void show()
    {
        System.out.println(num2+"......"+num1);
     }
}


class  ExtendsDemo2
{
     public static void main(String[] args)
     {
       Zi z = new Zi();
       z.show();
      }
}