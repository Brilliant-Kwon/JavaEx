package Jan_17.Practice01_1;

import java.util.Scanner;

public class Problem05 {
    //정수 다섯개를 입력받아 가장 큰 수를 출력
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 다섯개 중 가장 큰 수 출력");
        int[] array = new int[5];
        int best = 0;
        for(int i =0;i<5;i++) {
            System.out.print("["+(i+1)+"] 숫자를 입력하세요 : ");
            array[i] = scanner.nextInt();
            if(i==0)
                best = array[i];
            if(i>0&&array[i]>best)
                best = array[i];
//            System.out.println("best : "+best);
        }
        for(int i = 0; i<array.length;i++)
            System.out.print(array[i]+"\t\t");
        System.out.println("중 가장 큰 수는 "+best);
    }
}
