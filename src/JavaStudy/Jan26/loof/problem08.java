package JavaStudy.Jan26.loof;

//4x4 배열 - 임의의 위치에 1~10 8개만 생성
public class problem08 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int count = 8;
        //일단 0으로
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                arr[i][k] = 0;
//                System.out.print(arr[i][k] + "\t");
            }
//            System.out.println();
        }
        //랜덤 배정
        while (count > 0) {
            int ran = (int) Math.round(Math.random() * 15);
//            System.out.println(ran + "\t" + ran / 4 + "\t" + ran % 4);
            if (arr[ran / 4][ran % 4] == 0) {
                arr[ran / 4][ran % 4] = (int) Math.round(Math.random() * 9 + 1);
                count--;
            }
        }
        //출력
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                System.out.print(arr[i][k] + "\t");
            }
            System.out.println();
        }
    }
}
