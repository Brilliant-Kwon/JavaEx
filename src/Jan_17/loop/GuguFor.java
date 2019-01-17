package Jan_17.loop;

public class GuguFor {
    public static void main(String[] args) {
//        for문 중첩을 이용하여 구구단 전체 출력하기
        for(int i =2;i<=9;i++){
            System.out.println("\n"+i+" 단");
            for(int j = 1;j<=9;j++)
                System.out.println(i+" X "+j+" = "+i*j);
        }
    }
}
