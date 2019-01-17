package Jan_16.helloworld;

public class CharEx {
    public static void main(String[] args) {
        //1개의 유니코드 문자를 저장
        char ch1 = 'A';
        char ch2 = '한';//유니코드

        System.out.println(ch1);
        System.out.println(ch2);

        System.out.println(ch1 + ch2);

        //문자열을 쓸 때는 String
        String str1 = "나는 BRooT입니다. ";
        String str2 = "notGroot";
        String str3 = str1+str2;

        System.out.println(str1+str2+"\n"+str3);

    }
}
