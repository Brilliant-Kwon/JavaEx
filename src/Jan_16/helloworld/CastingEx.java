package Jan_16.helloworld;

public class CastingEx {
    public static void main(String[] args) {
        //암묵적 형변환
        //표현 범위가 작은 데이터 타입 -> 큰 데이터 타입
        byte b = 25;//1바이트
        System.out.println(b);
        //조금 더 넓은 범위인 short으로 옮겨보자
        short s = b;//2바이트
        System.out.println(s);
        //short보다도 넓은 범위인 int로 옮기자
        int i = s;//4바이트
        System.out.println(i);
        //이번엔 long으로 넘겨보자
        long l = i;//8바이트
        System.out.println(l);

        float f= l;//4바이트
        System.out.println(f);

        double d = f;//8바이트
        System.out.println(d);

        //표현범위가 넓은 쪽-> 좁은 쪽으로 할당
        //강제로 변환 : 명시적 캐스팅
        byte b2;
        int i2 = 2019;
        float f2 = 3.14159f;

        b2 = (byte)i2;//4->1byte로 강제 변환
        System.out.println("int:"+i2+"->byte:"+b2);
        i2 = (int)f2;
        System.out.println("float:"+f2+"->int:"+i2);

        //명시적 형 변환시에는 데이터의 유실에 주의
    }
}
