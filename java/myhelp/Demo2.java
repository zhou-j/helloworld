import java.util.Scanner;


class Demo2
{
     public static void main(String[] args)
      {
           Scanner input = new Scanner(System.in);
           int n = input.nextInt();
           if(n<4)
           System.out.println("输入的数不在4~7之间:");
           else if(n>7)
           System.out.println("输入的数不在4~7之间:");
           else
           {
             
              System.out.println(n%2);
              n = n/2;
              System.out.println(n%2);
              n = n/2;
              System.out.println(n%2);
             // n = n/10;
              
           }
       }
}