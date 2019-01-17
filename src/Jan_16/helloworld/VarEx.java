package Jan_16.helloworld;

public class VarEx {
    public static void main(String[] args) {
        //식별자 규칙
        //문자, 숫자, _, $
        //숫자로 시작하면 안됨

        //변수면 관례 :
        //첫 글자를 소문자 - 꼭은 아니지만 지키는 것이 좋다.
        int myAge; //선언
        myAge = 48; //초기화

        String myName = "BRooT";// 선언과 동시에 초기화

//        myAge = "BRooT";// 이미 선언된 변수는 타입 변경 x
        //출력해서 확인
        System.out.println(myName);
        System.out.println(myAge);

        //여러 변수를 한꺼번에 선언할 때
        int a = 10, b = 20, c = 30;
        System.out.println("a : "+a+"\nb : "+b+"\nc : "+c);//출력해서 확인해보자
        //같은 값을 여러 변수에 할당할 때
        a = b = c = 100;
        System.out.println("a : "+a+"\nb : "+b+"\nc : "+c);

    }
}
