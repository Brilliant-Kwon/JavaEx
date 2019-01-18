package Jan_18.oop.Practice02_1;

//배열 내에서 85점 이상만 뽑아, 합,평균값 산출
public class Problem05 {
    public static void main(String[] args) {
        int scoreboard[][] = {
                {80, 75, 90, 95, 78},
                {92, 88, 89, 92, 70},
                {78, 80, 85, 86, 63},
                {83, 84, 89, 87, 75},
                {89, 83, 93, 94, 78}
        };
        int sum = 0;
        int num=0;
        for (int i = 0; i < scoreboard.length; i++) {
            for (int j = 0; j < scoreboard[0].length; j++) {
                if (scoreboard[i][j] >= 85) {
                    sum += scoreboard[i][j];
                    num++;
                }
            }
        }
        System.out.println("합 : "+sum+" 평균 : "+sum/num);
    }
}
