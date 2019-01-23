package Jan_23.collection.io.charstream;

import java.io.*;
import java.util.StringTokenizer;

public class StringTokenizerEx {
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\files\\";
    private static String fileName = dirName + "thieves.txt";

    public static void main(String[] args) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String thief;

            while ((thief = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(thief, " ");
                while (st.hasMoreTokens()) {//내용이 더 남아 있으면
                    String token = st.nextToken();
                    System.out.println("TOKEN : " + token);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
