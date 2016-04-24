class FuShuIndexException extends RuntimeException
{
      FuShuIndexException()
      {}
      FuShuIndexException(String msg)
      {
          super(msg);
       }
}


   class Demo
{
      public int method(int[] arr,int index)//throws FuShuIndexException
      {
              if(arr==null)
                
                throw new NullPointerException("数组的引用不能为空");

               if(index>=arr.length)
              {
                 throw  new ArrayIndexOutOfBoundsException("数组的脚标越界了!");
               }

               if(index<0)
               {
                  throw new FuShuIndexException("数组的脚标不能为负数!");
                }

               
                  

             return arr[index];
       }
}

class  ExceptionDemo2
{
       public static void main(String[] args)//throws FuShuIndexException
       {
            int[] arr = new int[3];
      
            Demo d = new Demo();
           int num = d.method(arr ,-30);
      //     System.out.println("num="+num);
      //     System.out.println("over");
         }
}