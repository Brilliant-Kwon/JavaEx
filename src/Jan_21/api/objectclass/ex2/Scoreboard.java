package Jan_21.api.objectclass.ex2;

import java.util.Arrays;

public class Scoreboard implements Cloneable {
    //필드 : 참조형
    private int scores[];

    //생성자
    public Scoreboard(int[] scores) {
        this.scores = scores;
    }

    //Code - generate - toString()
    @Override
    public String toString() {
        return "Scoreboard{" +
                "scores=" + Arrays.toString(scores) +
                '}';
    }

    public Scoreboard getClone(){
        Scoreboard clone = null;
        try {
            clone = (Scoreboard)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    //깊은 복제를 위해서는
    //Object의 clone 메서드를 오버라이드
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        //얕은 복제를 시도
        Scoreboard clone = (Scoreboard)super.clone();
        //내부 참조 객체도 복제 시도 -> 깊은 복제
        clone.scores = Arrays.copyOf(scores, scores.length);//배열 복사 내장 메서드
        return clone;
    }
}
