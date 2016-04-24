

abstract class Employee
{
     private String name;
     private String id;
     private double pay;
     Employee(String name,String id,double pay)
     {
        this.name = name;
        this.id = id;
        this.pay = pay;
      }
     public abstract void work();
}

class Programmer extends Employee
{
     Programmer(String name,String id,double pay)
     {
          super(name,id,pay);
      }
      public void work()
      {
           System.out.println("code......");
       }
}

class Manager extends Employee
{
     private int bonus;
     Manager(String name,String id,double pay,int bonus)
     {
       super(name,id,pay);
       this.bonus = bonus;
     }
     public void work()
     {
          System.out.println("manage");
      }
}
    
class AbstractTest
{
    public static void main(String[] args)
    {
         System.out.println("Hello World");
     }
}

