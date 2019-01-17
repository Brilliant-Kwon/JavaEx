package Jan_17.Practice01_1;

public class Problem03 {
    //    구구단을 가로로 2~9단까지 출력
    //각 단은 세로로 나열되어야함
    public static void main(String[] args) {
        for(int i=1;i<=9;i++)
            for(int j=2;j<=9;j++)
                if(j!=9)
                    System.out.print(j+"X"+i+"="+(i*j)+"\t");
                else
                    System.out.println(j+"X"+i+"="+(i*j)+"\t");
    }
}
