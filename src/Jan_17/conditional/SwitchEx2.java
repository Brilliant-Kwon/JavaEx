package Jan_17.conditional;

import java.util.Scanner;

public class SwitchEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("월을 입력하세요 : ");
        int month = scanner.nextInt();
        String days = "";//해당 월에 일수가 얼마인지 저장

        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = "31일";
                break;
            case 4: case 6: case 9: case 11:
                days = "30일";
                break;
            case 2:
                days = "28일(윤달 : 29일";
                break;
        }
        System.out.println(month+"월은 "+days+" 일 입니다.");

    }
}
