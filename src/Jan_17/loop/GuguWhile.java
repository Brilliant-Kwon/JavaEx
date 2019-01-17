package Jan_17.loop;

public class GuguWhile {
    public static void main(String[] args) {
        //while문 중복을 이용한 구구단 전체 출력
        int i = 2;
        while(i<=9){
            System.out.println("\n"+i+" 단 ");
            int j = 1;
            while(j<=9){
                System.out.println(i+" X "+j+" = "+i*j);
                j++;
            }
            i++;
        }
    }
}
