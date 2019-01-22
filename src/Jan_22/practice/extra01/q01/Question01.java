package Jan_22.practice.extra01.q01;

public class Question01 {
    public void printAnswer(int toNum) {
        //	TODO: 이곳에 해답을 작성합니다.
        for (int i = 1; i <= toNum; i++) {
            if (i % 2 == 0 || i % 3 == 0)
                System.out.printf("*");
            else
                System.out.print(i);

            if (i==toNum)
                System.out.println();
        }
    }
}
