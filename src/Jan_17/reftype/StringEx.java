package Jan_17.reftype;

public class StringEx {
    public static void main(String[] args) {
        String str1 = "Java"; // 리터럴 (소스코드 안에 직접 입력)
        String str2 = "Java";
        String str3 = new String("Java");
        //세 값을 같다.

        System.out.println("str1 == str2 ? "+(str1==str2));
        System.out.println("str1 == str3 ? "+(str1==str3));

        //참조 차팅ㅂ의 ==, !=은 객체 주소를 비교하는 것이다.
        //실제 내용의 비교는 equals 메서드를 사용
        System.out.println("str1.equals(str2) ? "+str1.equals(str2));
        System.out.println("str1.equals(str3) ? "+str1.equals(str3));
    }
}
