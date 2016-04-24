import java.util.Scanner;


class Demo
{
     public static void main(String[] args)
      {
           Scanner input = new Scanner(System.in);
           int n = input.nextInt();
           if(n<100)
           System.out.println("输入的数不在100~999之间:");
           else if(n>999)
           System.out.println("输入的数不在100~999之间:");
           else
           {
              int i,j,k;
              i = n%10;System.out.println(i);
              n = n/10;
              j = n%10;System.out.println(j);
              n = n/10;
              k = n%10;System.out.println(k);
             // n = n/10;
              
           }
       }
}