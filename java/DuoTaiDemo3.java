class Fu
{
    int num = 3 ;
}
  
class Zi extends Fu
{
       int num = 4;
}



class DuoTaiDemo3
{
       public static void main(String[] args)
       {
          Fu f = new Zi();
          System.out.println(f.num);
        }
}