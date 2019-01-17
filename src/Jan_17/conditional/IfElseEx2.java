package Jan_17.conditional;

import java.util.Scanner;

public class IfElseEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Java, 2. C, 3. C++, 4. Python\n과목을 입력하세요:");
        int num = scanner.nextInt();
        String roomName = "";

        if (num == 1) {
            roomName="R101";
        }else if (num==2){
            roomName="R202";
        }else if (num==3){
            roomName="R303";
        }else if (num==4){
            roomName="R405";
        }else{
            roomName="관리자에게 문의하세요";
        }

        System.out.println(roomName);
        scanner.close();
    }
}
