package Jan_18.oop.Practice02_1;

//공백-> ',' 로 변경 후 출력
public class Problem03 {
    public static void main(String[] args) {
        char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l'};
        char comma[] = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ')
                comma[i] = ',';
            else
                comma[i] = c[i];
        }
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
        for (int i = 0; i < comma.length; i++) {
            System.out.print(comma[i]);
        }
    }
}
