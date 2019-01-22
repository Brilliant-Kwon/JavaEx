package Jan_22.practice.extra01.q05;

public class Question05 {
    private int scores[];

    public Question05(int scores[]) {
        this.scores = scores;
    }

    public int getTotal() {
        int total = 0;
        //	TODO: 여기에 로직 코드를 작성합니다
        for (int i = 0; i < this.scores.length; i++) {
            if(scores[i]<=100&&scores[i]>=0)
                total+=scores[i];
        }
        return total;
    }

    public double getAverage() {
        int total = 0, count = 0;
        //	TODO: 여기에 로직 코드를 작성합니다
        total = getTotal();
        for (int i = 0; i < this.scores.length; i++) {
            if(scores[i]<=100&&scores[i]>=0)
                count++;
        }
        return total / count;
    }
}
