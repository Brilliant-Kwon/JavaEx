package JavaStudy.Jan_31.allCalendar;

import Jan_21.Practice03_1.problem04.Book;

import java.util.Scanner;

public class calApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("연 입력 >> ");
            int year = sc.nextInt();
            System.out.print("월 입력 >>");
            int month = sc.nextInt();
            sc.nextLine();//오류 방지용

            //당 연도가 윤년인지 판단
            Boolean year_check = false;
            if (year % 4 == 0) {
                if (year % 100 != 0 || year % 400 == 0)
                    year_check = true;
            }

            //전체 일 수 total 구하기
            //전년도까지의 날짜 수
            int total = (year - 1) * 365 + ((year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400);

            //전월까지의 총 날짜 수
            int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month - 1; i++) {
                if (i != 1)
                    total += m[i];//total에 더해준다.
                else {
                    if (year_check == true) {
                        total += m[i];
                        total++;
                    } else {
                        total += m[i];
                    }
                }
            }

            //요일 구하기
            int wday = (total) % 7 + 1; //0~6 일~토 - 해당 월 첫번째 날의 요일

            //달력 출력
            int printday = wday;//달력 출력용 임시 변수
            System.out.println("일\t월\t화\t수\t목\t금\t토\t");
            if (printday > 0) {
                for (int k = 0; k < printday; k++) {
                    System.out.print("\t");//첫 줄 앞 공백 입력
                }
            }
            for (int i = 1; i < m[month - 1]; i++) {
                System.out.print(i + "\t");//일 출력
                if ((printday + i) % 7 == 0) {
                    //공백과 일수가 합쳐졌을 때 7로 나뉘어 떨어지면 한줄 띄움
                    System.out.println();
                }
            }
            System.out.println("\n------------------------------");
            String con;
            while (true) {
                System.out.print("다시 입력? Y/N >>");
                con = sc.nextLine();
                if (con.equals("Y") || con.equals("N"))
                    break;
                else
                    System.out.println("이외의 문자를 입력하였습니다. 다시 입력하세요.");
            }
            if (con.equals("N")) {
                System.out.println("프로그램 종료.");
                break;
            }
        }


    }
}
