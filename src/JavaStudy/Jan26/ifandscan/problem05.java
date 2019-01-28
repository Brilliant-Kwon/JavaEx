package JavaStudy.Jan26.ifandscan;

import java.util.Scanner;

//정수 3개 입력 - 삼각형 만들 수 있는지
public class problem05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 1번 : ");
        int a = sc.nextInt();
        System.out.print("정수 2번 : ");
        int b = sc.nextInt();
        System.out.print("정수 3번 : ");
        int c = sc.nextInt();

        if (a < (b + c)) {
            if (b < (a + c)) {
                if (c < (a + b)) {
                    System.out.println("삼각형을 만들 수 있습니다.");
                } else {
                    System.out.println("삼각형이 성립하지 않습니다.");
                }
            } else {
                System.out.println("삼각형이 성립하지 않습니다.");
            }
        } else {
            System.out.println("삼각형이 성립하지 않습니다.");
        }
    }
}
