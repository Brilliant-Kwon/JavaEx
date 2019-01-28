package JavaStudy.Jan26.ifandscan;

import java.util.Scanner;

//입력받은문자열 -으로 분리하여 주민번호 앞자리만 출력
public class problem02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\s|-");//공백 또는 - 를 분리문자로 사용

        System.out.print("문자열을 입력하세요 : ");
        String str = sc.next();//다음 분리문자 전까지만 저장
        System.out.println(str);
    }
}
