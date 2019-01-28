package JavaStudy.Jan26.loof;

import java.util.Scanner;

//최대 공약수
public class problem04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 1 : ");
        int a = sc.nextInt();
        System.out.print("정수 2 : ");
        int b = sc.nextInt();
        int bigger = 0;//반복문을 위해서 둘중 큰것 저장
        int result = 0;

        if (a >= b) {
            bigger = a;
        } else {
            bigger = b;
        }

        for (int i = 2; i <= bigger; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                result = i;
            }
        }

        if (result == 0) {
            System.out.println("최대 공약수가 없습니다.");
        } else {
            System.out.println("최대 공약수 : " + result);
        }
    }
}
