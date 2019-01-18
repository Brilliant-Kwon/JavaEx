package Jan_18.oop.Practice02_1;

import java.util.Scanner;
//숫자 5개의 평균 구하는 프로그램
public class Problem02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0; i<5;i++){
            System.out.print((i+1)+"] 숫자를 입력하세요 : ");
            arr[i] =sc.nextInt();
            sum+=arr[i];
        }
        System.out.printf("평균 : %.1f",(float)(sum/5));
    }
}
