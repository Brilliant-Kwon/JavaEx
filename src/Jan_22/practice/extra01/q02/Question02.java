package Jan_22.practice.extra01.q02;

//toNum까지 1부터 모든 정수들의 최소 공배수
public class Question02 {
    public int getAnswer(int toNum) {
        //	TODO: 이곳에 해답을 작성합니다.
        int result = 1;
        int temp = 2;
        for (int i = 2; i <= toNum; i++) {
            while (true) {
                if (temp % i == 0 && temp%result==0) {
                    result = temp;
                    break;
                }
                temp++;
            }
        }
        return result;
    }
}
