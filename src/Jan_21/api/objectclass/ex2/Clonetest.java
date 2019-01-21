package Jan_21.api.objectclass.ex2;

public class Clonetest {
    public static void main(String[] args) {
        shallowCopy();//얕은 복제
        deepCopy();//깊은 복제
    }

    //얕은 복제
    private static void shallowCopy() {
        Point p1 = new Point(10, 20);
        System.out.println("p1 : " + p1);

        //p를 복제
        Point p2 = p1.getClone();
        System.out.println("p2 : " + p2);

        //p1과 p2의 hashcode비교
        System.out.println(p1 == p2);
        //p1과 p2의 내부 값 비교
        System.out.println(p1.equals(p2));
    }

    //깊은 복제
    private static void deepCopy() {
        Scoreboard s1 = new Scoreboard(new int[]{10, 20, 30, 40});
        System.out.println("s1 : " + s1);

        //복제 시도
        Scoreboard s2 = s1.getClone();
        System.out.println("s2 : " + s2);

        s2.getScores()[1] = 0;//s2객체 속 배열의 1번 인덱스를 바꿔줌
        System.out.println("s1 : " + s1);//1번도 바뀌는 문제 발생
        //clone객체를 오버라이드 해서 배열을 직접 카피해서 사용하면 문제 해결
        System.out.println("s2 : " + s2);
        //내부에 참조 타입을 필드로 갖고 있는 객체는
        //내부 참조 객체도 함께 복사
    }
}
