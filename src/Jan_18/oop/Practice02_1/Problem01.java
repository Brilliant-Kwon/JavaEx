package Jan_18.oop.Practice02_1;

//배열 데이터를 이용하여 3의 배수의 개수와 배수의 합을  출력하는 프로그램
public class Problem01 {
    public static void main(String[] args) {
        int[] data = {1, 3, 5, 8, 9, 11, 15, 19, 18, 20, 30, 33, 31};
        int num = getNum(data);
        int total = getTotal(data);
        System.out.println("주어진 배열에서 3의 배수의 개수 => " + num);
        System.out.println("주어진 배열에서 3의 배수의 개수 => " + total);
    }

    public static int getNum(int... arr) {
        int num = 0;
        for (int a : arr) {
            if (a % 3 == 0)
                num++;
        }
        return num;
    }

    public static int getTotal(int... arr) {
        int total = 0;
        for (int a : arr) {
            if (a % 3 == 0)
                total += a;
        }
        return total;
    }
}

