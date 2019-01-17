package Jan_17.reftype;

//배열의 복제, Enhanced For Loop
public class ArrayCopyEx {
    public static void main(String[] args) {
        //배열은 크기변경 되지 않으므로, 새 배열을 만들어서 복사
        int source[] = {1, 3, 5};
        int target[] = new int[10];

        for (int i = 0; i < source.length; i++) {
            System.out.print("변경 전) source : " + source[i] + " target : " + target[i]);
            target[i] = source[i];
            System.out.println("변경 후) source : " + source[i] + " target : " + target[i]);
        }
        //System.arraycopy를 이용한 복사
        int target2[] = new int[10];
        System.arraycopy(source//원본 배열
                , 0//시작 인덱스
                ,target2,//복사 대상 배열
                4//대상 배열의 복사 시작 인덱스
                ,source.length);//복사할 길이
//        for(int i = 0;i<target2.length;i++)
        for(int i : target2)
            System.out.println("tartget2 : "+ i);


    }
}
