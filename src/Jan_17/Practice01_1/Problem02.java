package Jan_17.Practice01_1;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        //숫자를 입력받아 아래와 같이 출력
        /*
        숫자를 입력하세요.
        7
        1
        22
        333
        4444
        55555*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(i);
            System.out.println();
        }
    }
}
