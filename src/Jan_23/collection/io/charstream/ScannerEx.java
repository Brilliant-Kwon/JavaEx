package Jan_23.collection.io.charstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ScannerEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String fileName = dirName + "thieves.txt";

    public static void main(String[] args) {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            String name;
            float f1;
            float f2;

            //받아올 내용 있는지 확인
            while (scanner.hasNextLine()) {
                name = scanner.next();//공백 전 문자열 하나
                f1 = scanner.nextFloat();
                f2 = scanner.nextFloat();

                System.out.printf("%s, %f, %f\n", name, f1, f2);
                scanner.nextLine();//개행문자 전까지의 스트링
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
