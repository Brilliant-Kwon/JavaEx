package Jan_17.loop;

import java.util.Scanner;

public class WihleEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("단을 입력하세요 : ");

        int dan = scanner.nextInt();
        System.out.println(dan+" 단 )");
        int i = 1;
        while(i<=9){
            System.out.println(dan + " X "+i+" = "+i*dan);
            i++;
        }
    }
}
