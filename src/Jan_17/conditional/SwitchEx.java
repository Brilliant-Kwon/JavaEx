package Jan_17.conditional;

import java.util.Scanner;

public class SwitchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Java, 2. C, 3. C++, 4. Python\n과목을 입력하세요:");
        int num = scanner.nextInt();
        String roomName = "";

        switch (num) {
            case 1:
                roomName = "R101";
                break;//###중요###
            case 2:
                roomName = "R202";
                break;
            case 3:
                roomName = "R303";
                break;
            case 4:
                roomName = "R404";
                break;
            default:
                roomName = "관리자에게 문의.";
                break;
        }

        System.out.println(roomName);
    }
}
