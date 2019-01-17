package Jan_17.conditional;

import java.util.Scanner;

//조건문 if 예제
public class IfElseEx {
    public static void main(String[] args) {
        //Scanner 열기
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("정수를 입력하세요 : ");

            int num = scanner.nextInt();

            //num이 0인지, 양수인지, 음수인지
            if (num == 0) {
                System.out.println(num + " : 0입니다.");
            } else if (num > 0) {
                System.out.println(num + " : 양수입니다.");
            } else if (num == -999) {
                break;
            } else {
                System.out.println(num + " : 음수입니다.");
            }
        }
    }
}
