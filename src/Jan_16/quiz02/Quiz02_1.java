package Jan_16.quiz02;

public class Quiz02_1 {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        char c ='A';

        //a는 짝수입니까?
        System.out.println("a는 짝수? "+(a%2==0));
        //b는 3의 배수입니까?
        System.out.println("b는 3의 배수? "+(a%3==0));
        //"a는 짝수" AND "b는 3의 배수이다" 를 r1에 저장
        boolean r1 = (a%2==0)&&(b%3==0);
        //r1 출력
        System.out.println("\"a는 짝수\" & \"b는 3의 배수이다\" : "+r1);
        //c의 4글자 뒤의 문자는 무엇인가? r2에 저장
        char r2 = (char)(c+4);
        System.out.println("char형 변수 c : "+c+"\n4글자 뒤의 문자 : "+r2);

    }
}
