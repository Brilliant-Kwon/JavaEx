package JavaStudy.Jan26.loof;

import java.util.Scanner;

public class problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] spl = str.split(" ");

        int sum = 0;
        for (int i = 0; i < spl.length; i++) {
            try {
                sum += Integer.parseInt(spl[i]);
            } catch (NumberFormatException e) {

            }
        }
        System.out.println(sum);
    }
//        double avg = (double)sum/spl.length;
//        System.out.println(avg);
}
