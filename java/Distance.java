import java.util.Scanner;


class Distance
{
     public static void main(String[] args)
      {
       Scanner input = new Scanner(System.in);
       double x1 = input.nextDouble();
       double y1 = input.nextDouble();
       double x2 = input.nextDouble();
       double y2 = input.nextDouble();
       double a=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
       double distance = Math.pow( a,0.5);
       System.out.println(distance);
       }
}
     