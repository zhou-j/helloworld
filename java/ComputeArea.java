import java.util.Scanner;

public class ComputeArea{
  
   public static void main(String[] args ){
 
     Scanner input = new Scanner(System.in);
     System.out.println("please enter the numbers: x1,y1,x2,y2,x3,y3");
     double x1 = input.nextDouble();
     double y1 = input.nextDouble();
     double x2 = input.nextDouble();
     double y2 = input.nextDouble();
     double x3 = input.nextDouble();
     double y3 = input.nextDouble();
     double side1,side2,side3,s,area;
     side1 = computeSide(x1,y1,x2,y2);
     side2 = computeSide(x2,y2,x3,y3);
     side3 = computeSide(x1,y1,x3,y3);
     s = (side1 + side2 + side3)/2 ;
     area =Math.pow(s*(s-side1)*(s-side2)*(s-side3),0.5);
     System.out.println("the Area is: " + area);
  
   }
   
   public static double computeSide(double x,double y,double x0,double y0){
         double side2 = (x-x0)*(x-x0)+(y-y0)*(y-y0);  
         double side = Math.pow(side2,0.5);
         return side ;
   }
}
       
     