package JavaStudy.Jan_29.Jan_29.StringStack;

public class StackApp {
    public static void main(String[] args) {
        StringStack ss = new StringStack(3);
        System.out.println("스택 길이 : " + ss.length());
        ss.push("1번");
        ss.push("2번");
        ss.push("3번");
        System.out.println("스택 길이 : " + ss.length());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println("스택 길이 : " + ss.length());
    }
}
