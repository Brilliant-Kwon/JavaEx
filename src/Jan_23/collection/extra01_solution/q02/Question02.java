package Jan_23.collection.extra01_solution.q02;

//toNum까지 1부터 모든 정수들의 최소 공배수
public class Question02 {
    public int getAnswer(int toNum) {
        int num = toNum;

        while (true) {
            boolean pass = true;

            for (int i = 2; i <= toNum; i++) {
                if (num % i != 0) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                break;
            }
            num++;
        }

        return num;
    }
}
