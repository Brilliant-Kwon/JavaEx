package Jan_23.collection.io.charstream;

import java.io.*;

public class BufferedCharStreamEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String original = dirName + "last-leaf.txt";
    private static String target = dirName + "last-leaf_filtered.txt";

    public static void main(String[] args) {
        //last-leaf.txt 안쪽 문장 중에서
        //leaf, leaves가 있는 문장만 필터링 저장
        try {
            //메인 스트림
            Reader fr = new FileReader(original);
            Writer fw = new FileWriter(target);

            //보조 스트림
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            String line = "";

            while ((line = br.readLine()) != null) {//한줄씩 읽어서 더아시아 읽어들일 데이터가 없을 때까지
                if (line.toLowerCase().contains("leaf") || line.toLowerCase().contains("leaves")) {
                    bw.write(line);
                }
            }

            bw.flush();
            br.close();
            bw.close();

            System.out.println("필터링 완료");
        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
