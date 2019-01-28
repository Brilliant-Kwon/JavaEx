package JavaStudy.Jan26.loof;

import java.util.Scanner;

//정수 10개 입력받아 배열 저장 -> 증가하는 순서로 정렬 출력
public class problem06 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " 번째 숫자 입력 >>");
            arr[i] = sc.nextInt();
        }
        int temp = 0;
        if (arr[0] >= arr[1]) {
            temp = arr[0];
        } else
            temp = arr[1];
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] > arr[k]) {
                    temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
