package Jan_23.collection.io.bytestream;

import java.io.*;
//보조스트림
public class BufferedStreamEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String original = dirName + "img.jpg";
    private static String target = dirName + "img_copy_buffed.jpg";
    public static void main(String[] args) {
        try {
            //메인 스트림
            InputStream bis = new FileInputStream(original);
            OutputStream bos = new FileOutputStream(target);

            //보조 스트림 연결 - 파일 복사 속도 업
            BufferedInputStream buffIs = new BufferedInputStream(bis);
            BufferedOutputStream buffOs = new BufferedOutputStream(bos);

            //버퍼 선언
            byte[] data = new byte[1024];//1KB
            int size = 0;

            while ((size = buffIs.read(data))!= -1){
                System.out.println(size + "바이트 복사 했습니다.");
                buffOs.write(data);
            }

            //스트림을 닫습니다. 보조스트림을 닫으면 주 스트림도 닫힙니다.
            buffIs.close();
            buffOs.close();

        } catch (FileNotFoundException e) {
            System.out.println("파일 없음.");
        } catch (IOException e) {
            System.out.println("IOException : "+e.getMessage());
        }
    }
}
