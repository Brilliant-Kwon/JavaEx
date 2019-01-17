package Jan_16.helloworld;

public class OperatorEx {
    public static void main(String[] args) {
        int a = 7;
        int b = 3;

        //사칙 연산
        System.out.println(a/b);//정수 나누기 정수
        System.out.println(a%b);//나머지 구하기

        System.out.println((float)a / (float)b);
        System.out.println((float)a/b);

        //증감연산자: ++,--;
        //위치에 주의하자
        System.out.println("Origin: "+a);
        System.out.println("++a: "+ ++a);
        System.out.println("Final: "+ a);

        System.out.println("Origin: "+b);
        System.out.println("b++: "+ b++);
        System.out.println("Final: "+b);
        //증감 연산자는 가능하면 타 연산식 속에 포함시키지말자
        //헷갈림 유발

//        System.out.println(4/0);//Error
        System.out.println(4.0/0);

        //현재 데이터값이 유한한 값인지 확인
        System.out.println(Double.isFinite(4.0/0));
        System.out.println(Double.isFinite(4.0/2));
        //NaN
        System.out.println(Double.isNaN(4.0/0));
    }
}
