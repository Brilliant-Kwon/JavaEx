package Jan_23.collection.practice.extra02.problem01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CalcApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String s = scanner.nextLine();
            if(s.equals("/q")) {
                System.out.println("종료합니다.");
                break;
            }
            StringTokenizer st = new StringTokenizer(s, " ");
            int[] values = new int[3];
            String oper = "";
            for (int i = 0; i < 3; i++) {
                String token = st.nextToken();
//                System.out.println("TOKEN : " + token);
                if (i == 0 || i == 2) {
                    values[i] = Integer.parseInt(token);
//                    System.out.println("Value " + i + " ) : " + values[i]);
                } else {
                    oper = token;
//                    System.out.println(oper);
                }
            }

            switch (oper) {
                case "+":
                    Add a = new Add();
                    a.setValue(values[0],values[2]);
                    System.out.println(a.calculate());
                    break;
                case "-":
                    Sub b = new Sub();
                    b.setValue(values[0],values[2]);
                    System.out.println(b.calculate());
                    break;
                case "*":
                    Mul c = new Mul();
                    c.setValue(values[0],values[2]);
                    System.out.println(c.calculate());
                    break;
                case "/":
                    Div d = new Div();
                    d.setValue(values[0],values[2]);
                    System.out.println(d.calculate());
                    break;
                default:
                    System.out.println("알 수 없는 연산입니다.");
                    break;
            }
        }

    }
}
