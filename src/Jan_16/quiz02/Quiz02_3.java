package Jan_16.quiz02;

public class Quiz02_3 {
    public static void main(String[] args) {
        int num = 13579;
        //100자리 미만을 버리는 코드
        int result = (int)(13579/100)*100;
        System.out.println(num+"의 100자리 미만을 버리면 "+result+"입니다.");
    }
}
