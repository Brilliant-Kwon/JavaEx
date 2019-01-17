package Jan_16.helloworld;

public class BooleanEx {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;

        //불린은 그 자체가 값인가
        System.out.println(b1);
        System.out.println(b2);

        boolean result;

        int v1 = 5;
        int v2 = 3;

        result = v1 < v2; // false임
        System.out.println(v1+"<"+v2+"="+result);
    }

}
