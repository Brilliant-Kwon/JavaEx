package Jan_17.loop;

import java.util.Scanner;

public class StarEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[별찍기 프로그램]\n숫자를 입력하시오 : ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            int c = i, l = (num - i) / 2, r = (num - i) / 2;
            if (num % 2 == 1) {
                if (i % 2 == 1) {
                    for (int k = 0; k < l; k++)
                        System.out.print("_");
                    for (int k = 0; k < c; k++)
                        System.out.print("*");
                    for (int k = 0; k < r; k++)
                        System.out.print("_");
                    System.out.println();
                } else {
                    l++;
                    for (int k = 0; k < l; k++)
                        System.out.print("_");
                    for (int k = 0; k < c; k++)
                        System.out.print("*");
                    for (int k = 0; k < r; k++)
                        System.out.print("_");
                    System.out.println();
                }
            } else {
                if (i % 2 == 1) {
                    l++;
                    for (int k = 0; k < l; k++)
                        System.out.print("_");
                    for (int k = 0; k < c; k++)
                        System.out.print("*");
                    for (int k = 0; k < r; k++)
                        System.out.print("_");
                    System.out.println();
                } else {
                    for (int k = 0; k < l; k++)
                        System.out.print("_");
                    for (int k = 0; k < c; k++)
                        System.out.print("*");
                    for (int k = 0; k < r; k++)
                        System.out.print("_");
                    System.out.println();
                }
            }
        }


    }
}
