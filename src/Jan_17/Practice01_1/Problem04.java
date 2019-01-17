package Jan_17.Practice01_1;

public class Problem04 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i+j+"\t");
                if(j==10)
                    System.out.println();
            }
        }
    }
}
