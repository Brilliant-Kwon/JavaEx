package Jan_18.oop.staticmember;

class StaticEx {
    //필드
    public static int refCount;//   클래스 변수
    public static String classVar;//클래스 변수
    public String instanceVar;//    인스턴스 변수

    //static 블록을 이용한 클래스 변수의 초기화
    static {
        refCount = 0;
        classVar = "클래스 변수";
        System.out.println("static 블록 호출");

//        instanceVar = "인스턴스 변수";//오류
        //클래스 변수에서 인스턴스 변수 접근 불가

    }

    //생성자
    public StaticEx() {
        refCount++;//   인스턴스 -> 클래스 변수 접근 (역으로는 불가)
        instanceVar = "인스턴스 변수";
        System.out.println("생성자 호출");
    }

    @Override
    protected void finalize() {
        //객체 소멸될 때
        System.out.println("소멸자 호출");
        refCount--;
    }
}

public class StaticExApp {
    public static void main(String[] args) {
        StaticEx s1 = new StaticEx();
        System.out.println("RefCount : " + StaticEx.refCount);
        StaticEx s2 = new StaticEx();
        System.out.println("RefCount : " + StaticEx.refCount);

        s1 = null;//객체 해제
        System.gc();//Garbage Collector 강제 호출
        try {
            Thread.sleep(3000);//3초만 기다림
            System.out.println(StaticEx.refCount);
        } catch (Exception e) {

        }
    }
}
