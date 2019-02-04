package JavaStudy.Jan_29.Jan_29.stack;

public class StringMain {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        StringStack root = new StringStack("스택이 비었습니다. ");
        StringStack ss1 = new StringStack("1번 스택");
        StringStack ss2 = new StringStack("2번 스택");
        StringStack ss3 = new StringStack("3번 스택");
        root.push(ss1);
        ss1.push(ss2);
        ss2.push(ss3);
        System.out.println("길이:" + root.length());
        ss2.pop();
        System.out.println("길이:" + root.length());
        ss1.pop();
        System.out.println("길이:" + root.length());
        root.pop();
        System.out.println("길이:" + root.length());


//        while (true) {
//            System.out.println("=================");
//            System.out.println("***스택***\n1.삽입 / 2.삭제 / 3.길이 / 4.종료");
//            System.out.println("=================");
//            System.out.print(">>");
//            int num = sc.nextInt();
//            sc.nextLine();//오류방지용
//            switch (num) {
//                case 1:
//                    System.out.print("스택 삽입\n>>삽입할 문자열 : ");
//                    root.push(new StringStack(sc.nextLine()));
//                    break;
//
//                case 2:
//                    System.out.print("스택 삭제\n");
//                    root.pop();
//                    break;
//
//                case 3:
//                    System.out.println(root.length());
//                    break;
//                case 4:
//                    break;
//                default:
//            }
//
//            if (num == 4) {
//                System.out.println("종료합니다.");
//                break;
//            }
////            StringStack st1 = new StringStack("1번입니다.");
////            StringStack st2 = new StringStack("2번입니다.");
//
////            st1.pop();
////        st1.pop();
//
//        }
    }
}
