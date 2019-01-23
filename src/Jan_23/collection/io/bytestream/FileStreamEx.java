package Jan_23.collection.io.bytestream;

import java.io.*;

public class FileStreamEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String origianl = dirName + "img.jpg";//원본 파일
    private static String target = dirName + "img_copy.jpg";//타겟 파일

    public static void main(String[] args) {
        try {
            InputStream bis = new FileInputStream(origianl);
            OutputStream bos = new FileOutputStream(target);

            int data = 0;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            bos.close();
            bis.close();
            System.out.println("파일을 복사했습니다.");
        }  catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("복사 중 오류 발생");
        }
    }
}
