package JavaStudy.Fab_08.KCK.Quiz04_05;

import java.io.*;
import java.util.Scanner;

public class quiz05 {
    //가져올 파일이 있는 경로명 dir 문자열에 저장
    static String dir = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\KCK\\Quiz04_05\\";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //파일이름 입력받음
        System.out.println("파일 이름 두개 입력할 것");
        System.out.print("첫번째 파일 이름 : ");
        String f1 = dir + sc.nextLine();//
        System.out.print("두번째 파일 이름 : ");
        String f2 = dir + sc.nextLine();

        try {
            //메인 스트림
            InputStream bis1 = new FileInputStream(f1);
            InputStream bis2 = new FileInputStream(f2);

            //보조 스트림 연결 - 파일 복사 속도 업
            BufferedInputStream buffIs1 = new BufferedInputStream(bis1);
            BufferedInputStream buffIs2 = new BufferedInputStream(bis2);

            int size1 = 0;//읽어온 바이트형태의 데이터 임시 저장용 변수
            int size2 = 0;

            Boolean result = true;//파일이 같은지 다른지 비교용 불린 변수


            //두 파일 모두 읽어온 바이트가 없을 때 까지 반복
            //buffIs1.read() - 스트림을 통해 바이트 씩 데이터를 읽어오는데,
            //데이터가 있으면 int형으로 데이터를 리턴해줌.
            //그 데이터를 size1에 저장한다.
            while ((size1 = buffIs1.read()) != -1 && (size2 = buffIs2.read()) != -1) {
                if (size1 != size2) {
                    result = false;//읽어온 바이트가 다르면 결과에 false 저장
                    break;//이후 더 이상 비교할 필요가 없으니 탈출
                }
            }

            if (result == true) {
                System.out.println("두 파일이 같습니다.");
            } else {
                System.out.println("두 파일이 다릅니다.");
            }


        } catch (FileNotFoundException e) {
            System.out.println("해당 파일이 없습니다 : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error : " + e.getMessage());
        }

    }
}
