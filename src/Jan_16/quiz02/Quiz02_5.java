package Jan_16.quiz02;

public class Quiz02_5 {
    public static void main(String[] args) {
        int num1 = 13579;
        int num2 = 13579;
        //num1, num2의 초기값을 출력
        System.out.println("초기값) num1 : "+num1+"\nnum2 : "+num2);
        //두 값이 같은지 확인하는 문자열 result
        String result = (++num1 + 1) == (num2++ + 1)?"같음": "다름";
        //result, num1, num2를 출력
        System.out.println("++num1 + 1 과 num2++ + 1 은 서로 \" "+result+"\"");
        System.out.println("최종값) num1 : "+num1+"\nnum2 : "+num2);

        //2019.01.16 퀴즈 2 끝.
    }
}
