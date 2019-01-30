package JavaStudy.Jan_26.ifandscan;

import java.util.Scanner;

//액수를 분리
public class problem03 {
    public static void main(String[] args) {
        System.out.print("금액 입력 >>");
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        int num = 0;

        while (true) {
            if (money >= 50000) {
                money -= 50000;
                num++;
            }else {
                System.out.println("5만원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 10000) {
                money -= 10000;
                num++;
            }else {
                System.out.println("1만원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 5000) {
                money -= 5000;
                num++;
            }else {
                System.out.println("5천원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 1000) {
                money -= 1000;
                num++;
            }else {
                System.out.println("1천원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 500) {
                money -= 500;
                num++;
            }else {
                System.out.println("5백원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 100) {
                money -= 100;
                num++;
            }else {
                System.out.println("1백원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 50) {
                money -= 50;
                num++;
            }else {
                System.out.println("5십원 권 : "+num);
                num=0;
                break;
            }
        }

        while (true) {
            if (money >= 10) {
                money -= 10;
                num++;
            }else {
                System.out.println("1십원 권 : "+num);
                num=0;
                break;
            }
        }
    }
}
