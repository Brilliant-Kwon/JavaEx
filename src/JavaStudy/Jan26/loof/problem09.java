package JavaStudy.Jan26.loof;

import java.util.Scanner;

public class problem09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] spl = str.split(" ");

        int sum = 0;
        for (int i = 0; i < spl.length; i++) {
            sum += Integer.parseInt(spl[i]);
        }
        double avg = (double)sum/spl.length;
        System.out.println(avg);
    }
}
