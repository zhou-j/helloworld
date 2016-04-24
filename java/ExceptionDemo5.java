class Demo
{
      public int show(int index)throws ArrayIndexOutOfBoundsException
      {
          
            if(index<0)
                   throw new ArrayIndexOutOfBoundsException("Ô½½çÀ²!!");
            int[] arr = new int[3];
            return arr[index];
       }
}


class ExceptionDemo5
{
      public static void main(String[] args)
      {
          Demo d = new Demo();
          try
          {
               int num = d.show(-3);
               System.out.println("num"+num);
           }
           catch (ArrayIndexOutOfBoundsException e)
           {
               System.out.println("e.toString()");
               return ;
            }
           finally
           {
               System.out.println("finally");
            }
            System.out.println("over");
         


        
       }
}
