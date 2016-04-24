import java.util.Scanner;

class QHDemo
{
     public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       if(n<0)
      {
       System.out.println("输入的不是0~1000之间的整数");
       }
       else if(n>=1000) 
      {
       System.out.println("输入的不是0~1000之间的整数");
       }
       else
      {
         int i,j,k;
         i = n%10;n=n/10;
         j = n%10;n=n/10;
         k = n%10;n=n/10;
         System.out.println("该整数的各位数相加之和是:");
         System.out.println(i+j+k);
     }
   }
}