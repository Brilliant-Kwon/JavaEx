package Jan_22.practice.extra01.q03;

import java.util.Scanner;

public class Question03 {
	public void printAnswer() {
		int num;
		Scanner scanner;
		
		System.out.println("정수를 입력하세요:");
			
		scanner = new Scanner(System.in);
		num = scanner.nextInt();
		scanner.close();
		
		//	TODO: 이곳에 코드를 작성합니다.

        for (int i = 2; i <= num; i++) {
            if (num == 2) {
                System.out.println(num + "은 소수입니다.");
                break;
            }
            if(num%i==0){
                System.out.println(num+"은 소수가 아닙니다.");
                break;
            }
            if(i==num-1) {
                System.out.println(num + "은 소수입니다.");
                break;
            }
        }
	}
}
