package Jan_16.helloworld;

public class ConditionalOperEx {
    public static void main(String[] args) {
        //3항 연산자
        int a = 10, b = 30;
        boolean result;

        //a는 짝수인가?
        result = (a % 2 == 0 ? true : false);
        System.out.println("a가 짝수인가? " + result);
        //a>b인가?
        result = (a > b ? true : false);
        System.out.println("a > b 인가?" + result);

        int score[] = {85, 20, 60};
        //80점이상이면 good, 50점 미만이면 fail, 그 사이값이면 pass
        String msg=null;
        for (int i = 0; i < 3; i++) {
            msg = (score[i] >= 80) ? "good" : ((score[i] < 50) ? "fail" : "pass");
            System.out.println(msg);
        }


    }
}
