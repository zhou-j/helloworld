public class ArrayToolDemo
{

   public static void main(String[] args)
   {
     
      int[] arr = {4,8,2,9,72,6};
     
      int max = ArrayTool.getMax(arr);
      System.out.println("max="+max);
      int index = ArrayTool.getIndex(arr,10);
      System.out.println("index="+index);
    }

}