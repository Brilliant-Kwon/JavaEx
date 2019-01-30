package JavaStudy.Jan_26.loof;

import java.util.Scanner;

//입력받은만큼 별 찍기
public class problem01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 >> ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            for(int k = num-i ; k>0;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
