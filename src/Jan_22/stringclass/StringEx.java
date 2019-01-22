package Jan_22.stringclass;

public class StringEx {
    public static void main(String[] args) {
//        stringBasic();
//        methods();
        stringBufferEx();
    }

    //문자열의 생성
    private static void stringBasic() {
        // 문자열의 생성
        String s1 = "Java"; //리터럴
        String s2 = new String("Java"); //객체 생성
        String s3 = "Java";  //리터럴

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        //배열 이용 문자열생성
        char[] letters = {'J', 'a', 'v', 'a'};
        String s4 = new String(letters);
        System.out.println(s4);

        //다른 타입을 문자열로 변환하여 할당 : String.valueOf
        String s5 = String.valueOf(Math.PI);
        System.out.println(s5);
    }

    private static void methods() {
        String str = "Java Programming is Fun?";

        //문자열의 길이 : length()
        System.out.println(str);
        System.out.println("길이 : " + str.length());

        //변환 메서드 여러 개
        System.out.println("대문자로 : " + str.toUpperCase());
        System.out.println("소문자로 : " + str.toLowerCase());

        //검색 메서드 : indexOf
        System.out.println("5번 인덱스의 문자 : " + str.charAt(5));
        System.out.println(str.indexOf("Fun"));
        System.out.println(str.indexOf("fun"));//찾는 값이 없으면 -1
        System.out.println(str.lastIndexOf("Fun"));//검색 방향이 반대

        //문자열 추출
        System.out.println(str.substring(5));//두번째 인자가 없으면 끝까지 자름
        System.out.println(str.substring(5, 16));//두번째 인자가 자르는 마지막인덱스

        //문자열 치환
        System.out.println(str.replace('?', '!')); // 발견된 문자나 문자열 하나만 바꿔줌
        System.out.println(str.replaceAll("a", "A")); // 발견된 모든 '문자열'을 바꾸어줌

        //공백 문자 제거 : trim()
        String s1 = "                      Hello                ";
        String s2 = "   , Java";

        System.out.println(s1 + s2);//공백이 들어간 단순 연결
        System.out.println(s1.trim() + s2.trim());//공백을 제거한 연결
        s1 = s1.trim();
        s2 = s2.trim();
        System.out.println(s1 + s2);//이하 동문

        //문자열 분리 : split()
        String[] chunk = str.split(" ");

        for (String value : chunk) {
            System.out.println(value);
        }

        //문자열 비교 : Unicode 값의 비교
        System.out.println("Java".compareTo("Java"));
        System.out.println("Java".compareTo("java"));
        System.out.println("Java".compareToIgnoreCase(" "));
    }

    //StringBuffer
    private static void stringBufferEx() {
        //  StringBuffer 생성
        StringBuffer sb = new StringBuffer("This");
        //  문자열 수정
        sb.append(" is pencil");
        //  문자열 삽입 insert(index, 문자열)
        sb.insert(8, "my");
        //  문자열 치환 : replace(beginindex, endindex, 문자열)
        sb.replace(8, 10, "your ");

        System.out.println(sb);

        //  메서드 체이닝 method chaining
        StringBuffer sb2 = new StringBuffer("This").append(" is pencil").insert(8, "my").replace(8, 10, "your ");
        System.out.println(sb2);


    }
}
