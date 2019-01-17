package Jan_17.reftype;

public class ArrayEx {
    public static void main(String[] args) {
        //배열선언
        String[] names;
        int scores[];

        //배열 초기화
        names = new String[]{
                "김", "나", "박", "이"
        };

        //만약 초기화 값이 이미 있다면
        float height[] = {
                175.0f, 168.0f, 160.5f, 180.2f
        };//선언과 동시에 할 때만 가능

        scores = new int[4];

        //인덱스 접근 [인덱스 번호]
        // 0부터 시작 ~ 배열의 length - 1

        //인덱스 범위를 벗어나면 아웃 오브 바운드 오류
        /*
        scores[1] = 80;
        scores[2] = 70;
        scores[3] = 90;
        scores[4] = 60;
        */
        scores[0] = 80;
        scores[1] = 70;
        scores[2] = 90;
        scores[3] = 60;
        System.out.println("length : " + scores.length);

        for (int i = 0; i <= scores.length - 1; i++)
            System.out.printf("%s (%.2f) : score = %d\n",names[i],height[i],scores[i]);
    }
}
