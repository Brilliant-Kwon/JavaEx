package Jan_17.loop;

public class WhileEx {
    public static void main(String[] args) {
        //1부터 100까지의 정수를 합산해서 결과를 출력
        int total = 0;
        int num = 1;
        while(num <= 100){
            total += num;
            //반복 조건을 개발자가 직접 설정
            num++;
        }
        System.out.println("1~100까지의 합 : "+total);
    }
}
