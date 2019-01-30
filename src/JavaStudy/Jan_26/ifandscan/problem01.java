package JavaStudy.Jan_26.ifandscan;

import java.util.Scanner;

//Scanner클래스를 이용하여 키보드에서 영문자 한 자를 입력받아 소문자이면 대문자로, 대문자이면 소문자로 출력
//영문자가 아니면 "영문자가 아닙니다." 출력
public class problem01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int diff = (int) 'a' - (int) 'A';//대문자와 소문자의 유니코드값 비교해서 차이값을 저장
        //유니코드 표에서 소문자가 대문자보다 숫자값이 크다.
        System.out.print("영문자 입력 : ");
        String input = sc.next();
        char alphabet = input.charAt(0); // 혹시나 긴 문장이 입력되었을 경우 첫번째 것만 사용

        if (alphabet >= 'a' && alphabet <= 'z') { //소문자이면
            alphabet = (char) (alphabet - diff);
            System.out.println("소문자 -> 대문자 : " + alphabet);
        } else if (alphabet >= 'A' && alphabet <= 'Z') { //대문자이면
            alphabet = (char) (alphabet + diff);
            System.out.println("대문자 -> 소문자 : " + alphabet);
        } else {
            System.out.println("영문자가 아닙니다.");
        }


    }


}
