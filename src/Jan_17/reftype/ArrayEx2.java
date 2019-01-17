package Jan_17.reftype;

//2차원 배열
public class ArrayEx2 {
    public static void main(String[] args) {
        //2차원 배열의 선언
        int[][] towDimen = new int[5][10];

        //초기 데이터가 있을 경우
        int table[][] = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        //Java의 다차원 배열은 배열의 배열

        System.out.println("table.length : " + table.length);
        System.out.println("table[0].length : " + table[0].length);

        //table 이차원 배열의 모든 값 합산
        int total = 0;
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                total += table[i][j];
        System.out.println("table total : " + total);
    }
}
