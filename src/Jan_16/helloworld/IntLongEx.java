package Jan_16.helloworld;

public class IntLongEx {

    public static void main(String[] args) {
        //int 변수 - Java의 기본 정수 처리 방식
        int intVar1;
        int intVar2;

        intVar1=2019;//정수값으로 초기화
        //범위를 초과한 데이터는 저장 x(int형은 정수가 범위이다. 긴 숫자나 실수x)
//        intVar2=1234567890123L;//int 형에는 정수만 초기화 가능
        intVar2=123456789;

        //long 타입
        long longVar1;
        long longVar2;
        longVar1 = 2019;
        longVar2 = 1234567890123L;

        // 2진수, 8진수, 16진수 데이터 할당
        int bin, oct, hex;
        bin = 0b0110;   //2진수 데이터
        oct = 072;      //8진수 데이터
        hex = 0xFF;     //16진수 데이터
        System.out.println("bin : "+bin+"\noct : "+oct+"\nhex : "+hex);

    }
}
