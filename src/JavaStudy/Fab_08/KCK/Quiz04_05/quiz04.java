package JavaStudy.Fab_08.KCK.Quiz04_05;

import java.io.*;
import java.util.Scanner;

public class quiz04 {
    //가져올 텍스트 파일이 있는 경로명 dir 문자열에 저장
    static String dir = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\KCK\\Quiz04_05\\";
    //새로 저장할 파일의 경로명 + 파일명 f_new 문자열에 저장
    static String f_new = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\KCK\\Quiz04_05\\file_new.txt";
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //파일이름 입력받음 (.txt 입력x)
            System.out.println("텍스트 파일 이름 두개 입력할 것 (.txt 입력 X, 자동으로 입력됨)");
            System.out.print("첫번째 텍스트 파일 이름 : ");
            String f1 = dir + sc.nextLine()+".txt";//
            System.out.print("두번째 텍스트 파일 이름 : ");
            String f2 = dir + sc.nextLine()+".txt";

            //입력받은 파일명을 기반으로
            // BufferedReader br1, br2 / BufferedWriter bw_new 객체 생성
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            BufferedWriter bw_new = new BufferedWriter(new FileWriter(f_new));

            //파일에서 읽어온 한 줄을 임시로 저장할 line 문자열 선언
            String line = null;

            //읽어온 문자열이 없을 때까지 br1과 br2를 각각 반복 시켜줌
            while((line = br1.readLine())!=null){
                bw_new.write(line+"\r\n");
                //읽어온 문자열 line과 개행문자들을 bw_new를 통해 새 파일에 써준다.
            }
            while((line = br2.readLine())!=null){
                bw_new.write(line+"\r\n");
            }

            //리더 라이터 닫아줌
            br1.close();
            br2.close();
            bw_new.close();

            //새로 만든 파일을 읽어서 콘솔창에 출력해줌.
            BufferedReader br_new = new BufferedReader(new FileReader(f_new));
            while((line = br_new.readLine())!=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
