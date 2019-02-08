package JavaStudy.Jan_31.YSH.Quiz01;

import java.util.Scanner;

/*
 * 연도가 4의배수이면서 100의 배수가 아니거나 400의 배수이면 2월은 29일까지 (윤년)
 * 나머지 2월은 28일 (평년)
 */
public class ManCalendar {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int yearScan=0;
      int monthScan=0;
      int []lastDays={31,28,31,30,31,30,31,31,30,31,30,31};

      // 총 날의 수 = 평년의 날의수 + 윤년의 날의 수
      // 요일 = 전체날의 수 % 7
      // 0~7 일요일부터 월요일
      for(;;){
         int totalDays=0; //1월1일부터 구하고싶은달 전달까지의 총 날짜의 수
         int day=0;  //요일구하기위한 변수
         int yunYearCount=0; //윤년의 수 저장 위한 변수
         int pyungYearCount=0; // 평년의 수 저장 위한 변수
         System.out.print("년도를 입력하시오:");
         yearScan=sc.nextInt();
         System.out.print("월을 입력하시오");
         monthScan=sc.nextInt();
         for(int i=1;i<yearScan;i++){
            if((i%4==0&&i%100!=0)||i%400==0){
               yunYearCount++;
            }else{
               pyungYearCount++;
            }
         }
         if((yearScan%4==0&&yearScan%100!=0)||yearScan%400==0){
            //         System.out.println("윤년입니다.");
            lastDays[1]=29;  //윤년인 경우의 2월의 마지막날은 29일
         }else{
            //         System.out.println("평년입니다.");
            lastDays[1]=28;  //평년인 경우의 2월의 마지막날은 28일
         }
         //      System.out.println("입력한 년도 전의 평년의 수:"+pyungYearCount);
         //      System.out.println("입력한 년도 전의 윤년의 수:"+yunYearCount);
         totalDays=(pyungYearCount*365)+(yunYearCount*366);
         //      System.out.println("입력한 년도 전의 총 날의 수 :"+totalDays);
         for(int i=0;i<monthScan-1;i++)
         {
            totalDays+=lastDays[i];
         }
         //      System.out.println("입력한 년도 및 해당월 전달까지의 날의 수:"+totalDays);
         totalDays++; // 원하는 년도 해당월의 1일 을구하기 위해 ++
         day=totalDays%7;
         System.out.println(" sun  mon  tue  wed  thur  fri  sat");


         for(int j=0;j<day;j++){
            System.out.print("     ");
         }

         for(int i=1;i<=lastDays[monthScan-1];i++){
            if(day%7!=6)
            {
               System.out.printf("%5d",i);
               day++;
            }
            else if(day%7==6)
            {
               System.out.printf("%5d\n",i);
               day++;
            }

         }
         System.out.println();
      }

   }
}