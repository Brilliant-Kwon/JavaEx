package JavaStudy.Jan_26.loof;

import java.util.Scanner;

//알파벳 순위 낮은 모든 문자 출력
public class problem02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("알파벳 입력 >> ");
        String str = sc.next();
        char alphabet = str.charAt(0);//한글자만

        for (char i = alphabet; i >= 'a'; i--) {
            for (char k = 'a'; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
