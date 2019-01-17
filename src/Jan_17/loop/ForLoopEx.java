package Jan_17.loop;

import java.util.Scanner;

public class ForLoopEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dan = 0;

        System.out.print("(구구단 프로그램)\n단을 입력하세요 : ");
        dan = scanner.nextInt();

        System.out.println("( "+dan+" 단)");

        for(int i =1 ; i<=9;i++)
            System.out.println(dan + " X "+i+" = "+i*dan);

        scanner.close();
    }
}
