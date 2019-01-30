package JavaStudy.Jan_26.ifandscan;

import java.util.Scanner;

//369게임
public class problem04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("1~99 사이의 정수를 입력하세요>>");

            int num = sc.nextInt();
            if (num >= 1 && num <= 99) {//숫자 범위
                if ((num - (num % 10)) % 30 == 0) {//10의자릿수 먼저 검사
                    if ((num % 10) % 3 == 0) {
                        System.out.println("박수 짝짝");
                    } else {
                        System.out.println("박수 짝");
                    }

                } else if ((num % 10) % 3 == 0) {//1의자릿수 검사
                    System.out.println("박수 짝");

                }

            } else {
                System.out.println("범위를 벗어났습니다.");
            }

        }

    }
}
