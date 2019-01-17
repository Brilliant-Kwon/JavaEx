package Jan_17.loop;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {
        int total = 0;
        int num = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("합 계산기 (0이면 끝납니다.)");

        //숫자를 입력받아 합산, 0이면 종료
        do { // 최소 1회는 실행, 조건검사는 뒷부분
            System.out.print("숫자를 입력하세요 : ");
            num = scanner.nextInt();
            total += num;
        }while (num!=0);

        System.out.println("합 : "+total);
    }
}
