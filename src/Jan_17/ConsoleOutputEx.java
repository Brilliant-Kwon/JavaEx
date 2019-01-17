package Jan_17;

public class ConsoleOutputEx {
    public static void main(String[] args) {
//        System.out.print("Hello ");       //개행X
//        System.out.println("java"); //개행
//        System.out.printf("");      //포맷문자열출력

        System.out.print("Hello ");       //개행X
        System.out.println("java");     //개행

        //이스케이프 문자
        System.out.println("Hello\nJava");  //개행 \n
        System.out.println("Hello\tJava");  //tab \t
        //Hello, "Java"
        System.out.println("Hello, \"Java\"");  //쌍따옴표 사용 \"
        //문자열 내 \ 써야할 경우
        String dir = "c:\\windows\\system32\\cmd";
        System.out.println(dir);
    }
}
