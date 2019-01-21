package Jan_21.api.objectclass.ex1;

public class LangClassTest {
    public static void main(String[] args) {
        objectBasic();
        equalsEx();
    }

    //equals 오버라이드
    private static void equalsEx() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));//두 객체의 hashcode() 비교
    }

    //Object의 기본 내용과 toString
    private static void objectBasic() {
        Point p = new Point(10, 10);

        //Java 최상위 클래스는 Object
        //      Object의 모든 멤버는 다른 모든 클래스에서 사용
        System.out.println(p.getClass().getName());
        System.out.println(p.hashCode());//객체 식별자 메모리 주소값
        System.out.println(p);//객체 자체를 프린트
        System.out.println(p.toString());//문자열로

        //p의 부모 객체를 얻어와 보자
        System.out.println(p.getClass().getSuperclass().getName());
        System.out.println(p.getClass().getSuperclass().hashCode());
    }
}
