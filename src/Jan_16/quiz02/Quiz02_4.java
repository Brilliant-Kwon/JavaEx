package Jan_16.quiz02;

public class Quiz02_4 {
    public static void main(String[] args) {
        char ch = 'A';
        //ch를 소문자로 변환할 것
        //'A' = 65 / 'a' = 97
        //ch에는 대문자만 담긴다.
        int lower = 'a' - ch;
        char ch_upper = (char)(ch+lower);
        System.out.println("ch"+ch+"의 소문자는 "+ch_upper+"입니다.");
    }
}
