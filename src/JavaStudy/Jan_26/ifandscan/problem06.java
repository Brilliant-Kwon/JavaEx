package JavaStudy.Jan_26.ifandscan;

import java.util.Scanner;

//특정연도 입력 - 윤년인지 아닌지 판별
public class problem06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연도 입력 >>");
        int year = sc.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("윤년입니다.");
                } else {
                    System.out.println("평년입니다.");
                }
            } else {
                System.out.println("윤년입니다.");
            }
        } else {
            System.out.println("평년입니다.");
        }
    }
}
