package Jan_16.helloworld;

public class FloatDoubleEx {
    public static void main(String[] args) {
        float floatVar;//선언
        double doubleVar;

        floatVar = 0.12345678901234567890F;
        doubleVar = 0.12345678901234567890;

        System.out.println("float:" + floatVar);
        System.out.println("double:" + doubleVar);
        //결과창 : double형이 더 많은 소수점을 출력해줌

        // e 사용 표기법
        floatVar = 3E10F;
        doubleVar = 3e10;

        System.out.println("float:" + floatVar);
        System.out.println("double:" + doubleVar);

        System.out.println(01. * 3);//정밀도를 포기하고 표현 범위 넓힘
    }
}
