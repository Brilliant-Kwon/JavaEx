package JavaStudy.Jan_26.loof;

import java.util.Scanner;

//정수 10개 입력받아 배열 저장 -> 3의 배수인 수만 골라 출력
public class problem05 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " 번째 숫자 입력 >>");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                System.out.println("3의 배수 > "+arr[i]);
            }
        }
    }
}
