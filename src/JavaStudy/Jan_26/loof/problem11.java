package JavaStudy.Jan_26.loof;

import java.util.Scanner;

//액수를 분리, 반복문, 배열 사용
public class problem11 {
    public static void main(String[] args) {
        System.out.print("금액 입력 >>");
        Scanner sc = new Scanner(System.in);

        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int money = sc.nextInt();
        int num = 0;

        for (int i = 0; i < unit.length; i++) {
            while (true) {
                if (money >= unit[i]) {
                    money -= unit[i];
                    num++;
                } else {
                    System.out.println(unit[i] + "원 권 : " + num);
                    num = 0;
                    break;
                }
            }
        }

    }
}
