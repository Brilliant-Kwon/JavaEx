package Jan_23.collection.io.charstream;

import java.io.*;

public class CharStreamEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String fileName = dirName + "char.txt";

    public static void main(String[] args) {
        //FileWriter를 열어서 텍스트를 저장
        try {
            Writer fwriter = new FileWriter(fileName);
            fwriter.write("Java Programming\r\n");
            fwriter.write("Bit Computer\r\n");
            fwriter.write("2019.01");
            fwriter.close();

            System.out.println("텍스트 파일 생성");

            Reader freader = new FileReader(fileName);
            int data = 0;

            while ((data = freader.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            freader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("IOException : "+e.getMessage());
        }
    }
}
