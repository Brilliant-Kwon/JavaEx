package Jan_23.collection.io.bytestream;

import java.io.*;

public class DataStreamEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String fileName = dirName + "primitives.txt";

    public static void main(String[] args) {
        //스트림을 열어서 기본 타입을 저장
        try {
            OutputStream fos = new FileOutputStream(fileName);
            //기본 타입출력을 위해 DataOutputStream을 연결
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("홍길동");
            dos.writeBoolean(true);
            dos.writeInt(25);
            dos.writeFloat(80.9f);

            dos.writeUTF("장길산");
            dos.writeBoolean(false);
            dos.writeInt(38);
            dos.writeFloat(99.9f);

            dos.flush();
            dos.close();

            System.out.println("저장 완료!");

            //불러와 봅시다
            InputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);

            for (int i = 0; i < 2; i++) {
                //주의 : 출력한 순서대로 불러와야 한다.
                String s = dis.readUTF();
                boolean b = dis.readBoolean();
                int val = dis.readInt();
                float f = dis.readFloat();

                System.out.printf("%s, %b, %d, %f \n", s, b, val, f);
            }
            dis.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }
    }
}
