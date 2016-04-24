class LanPingException extends Exception
{
      LanPingException(String msg)
      {
            super(msg);
       }
}
class MaoYanException extends Exception
{
      MaoYanException(String msg)
      {
            super(msg);
       }
}
class NoPlanException extends Exception
{
      NoPlanException(String msg)
      {
            super(msg);
       }
}




class Computer
{
     private int state = 2;
     public void run()throws LanPingException,MaoYanException
     {
           if(state==1)
               throw new LanPingException("电脑蓝屏了!!");
           if(state==2)
               throw new MaoYanException("电脑冒烟了!!");
           System.out.println("电脑运行");
       }
      public void reset()
     {
           state = 0;
           System.out.println("电脑重启");
      }
}
           


   


class Teacher
{
      private String name;
      private Computer comp;
      Teacher(String name)
      {
           this.name = name;
           comp = new Computer();
       }
       
      public void prelect() throws NoPlanException
      {
            try
            {
                 comp.run();
                 System.out.println(name+"讲课");
             }
             catch(LanPingException e)
             {
                  System.out.println(e.toString());
                  comp.reset();
                  prelect();
              }
     
              catch(MaoYanException e)
             {
                  System.out.println(e.toString());
                  test();
                  throw new NoPlanException("课时进度无法完成，原因:"+e.getMessage());
               }
         }
         public void test()
         {
               System.out.println("大家练习");
          }
}
class ExceptionTest
{
      public static void main(String[] args)
      {
          Teacher t = new Teacher("毕老师");
          try
          {
               t.prelect();
           }
           catch (NoPlanException e)
           {
                 System.out.println(e.toString()+".....");
                 System.out.println("换人");
            }
       }
}