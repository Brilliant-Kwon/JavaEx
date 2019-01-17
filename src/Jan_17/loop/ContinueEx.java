package Jan_17.loop;

public class ContinueEx {
    public static void main(String[] args) {
        //1에서 20까지의 수
        //2의 배수와 3의 배수는 출력 않고 다른 수는 출력
        for (int i = 1; i<= 20; i++){
            if(i%2==0||i%3==0)
                continue;//다음 문장 실행하지 않고 다음 루프로 진행함
            System.out.println(i);
        }
    }
}
