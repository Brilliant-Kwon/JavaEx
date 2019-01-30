package JavaStudy.Jan_26.loof;
//4x4 2차원 배열 -> 1~10 랜덤 정수 생성 출력
public class problem07 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                arr[i][k] = (int)Math.round(Math.random()*9+1);
                System.out.print(arr[i][k]+"\t");
            }
            System.out.println();
        }
    }
}
