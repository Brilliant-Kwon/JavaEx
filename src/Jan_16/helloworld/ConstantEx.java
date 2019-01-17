package Jan_16.helloworld;

import java.util.Calendar;

public class ConstantEx {
    //상수 선언
        //static final로 선언
        //대문자로 표현하는 것이 관례
    static final double PI = 3.141592;
    static final int SPEED_LIMIT = 110;//여러단어일 경우 _로 구분해줌
    public static void main(String[] args) {
        System.out.println(PI);
        System.out.println(SPEED_LIMIT);

        System.out.println("제한속도는 "+SPEED_LIMIT+"입니다.");
        System.out.println(SPEED_LIMIT+"km 이하로 주행해 주세요.");

        //재할당 불가 ->안정성을 위하여
//        SPEED_LIMIT = 100; //불가능

        //자바는 기본 상수를 많이 가지고 있다. 찾아서 사용 가능
        System.out.println(Math.PI);
        System.out.println(Calendar.JANUARY);
    }
}
