package Jan_17.consoleio;

import java.util.Scanner;

//콘솔 입력 예제: Scanner 사용
public class ConsoleInputEx {
    public static void main(String[] args) {
        //스캐너 생성
        Scanner scanner = new Scanner(System.in);

        //인풋 데이터 포맷에 맞게 메서드를 생성
        //TODO : 예외처리 필요
        System.out.print("이름을 입력하시오 : ");
        String name = scanner.next();//문자열 하나를 받아옴

        System.out.print("나이를 입력하시오 : ");
        int age = scanner.nextInt();//Int형 변수 하나를 받아옴.
        System.out.println("당신의 이름은 "+name+", 나이는 "+age+"입니다.");

        scanner.close();
    }
}
