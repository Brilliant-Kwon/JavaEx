package Jan_16.helloworld;

public class LogicOperEx {
    public static void main(String[] args) {
        //관계연산, 논리연산
        int n1 = 7;
        int n2 = 3;

        //비교연산
        //>, <, >=, <=
        // == : equal, != : not equal
        System.out.println("n1 > n2 : "+(n1>n2));
        System.out.println("n1 == n2 : "+(n1==n2));
        System.out.println("n1 != n2 : "+(n1!=n2));

        //논리연산
        //AND(&&),OR(||),NOT(!)
        System.out.println(n1>n2 && n1<n2);//and
        System.out.println(n1>n2||n1<n2);//or
        System.out.println(n1>n2);
    }
}
