import java.util.Scanner;
public class CalendarDemo
{
      
      public static int daysOfMonth(int year,int month){
        
        int dayOfMonth = 31;
        if(month==2){
                  if(year%4==0&&year%100!=0 || year%400==0){
                     dayOfMonth = 29;
                   }
                   else{
                     dayOfMonth = 28;
                   }
              }
             else if(month==4||month==6||month==9||month==11)
                       dayOfMonth = 30;
               else
                       dayOfMonth = 31;

               return dayOfMonth;
               
      }
       public static void main(String[] args)
       {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入年份");
            int year = in.nextInt();
            System.out.println("请输入月份");
            int month = in.nextInt();
            int sum = 0;

            
               
             
            for(int i=1900;i<year;i++){
               
                  if(i%4==0&&i%100!=0 || i%400==0)
                     sum = sum + 366;
                 else
                   sum = sum + 365;
              }


            for(int i=1;i<month;i++){
           
           sum = sum + daysOfMonth(year,i);
           }
              int dayOfMonth = 31;
              dayOfMonth = daysOfMonth(year,month);
              sum = sum + 1;
              int space=sum%7;
          
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for(int i=1;i<=space;i++)
                System.out.print("\t");

            for(int i=1;i<=dayOfMonth;i++){
                if(sum%7==6)
                      System.out.print(i+"\n");
                else
                      System.out.print(i+"\t");
                sum++;
             }
         }
    }