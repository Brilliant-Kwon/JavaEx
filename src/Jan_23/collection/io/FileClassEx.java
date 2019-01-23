package Jan_23.collection.io;

import java.io.File;
import java.io.IOException;

//File 클래스 연습
public class FileClassEx {

    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\";

    public static void main(String[] args) {
        //파일 객체 생성
        File root = new File(dirName);
        //디렉토리가 존재하는 지 확인
        System.out.println(dirName + " exist? : " + root.exists());

        //디렉터리가 없으면 만들어 줄 것
        if (!root.exists()) {
            root.mkdirs();
        }
        System.out.println(dirName + " exist? : " + root.exists());
        //파일 정보를 출력
        printFileInfo(root);

        //파일을 만들어 봅시다.
        File file = new File(dirName + "address.txt");
        if (!file.exists()) {//파일이 존재하지 않으면
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("파일 생성 오류");
            }
        }
        printFileInfo(root);//확인

        //파일을 지워 봅시다.
        file.delete();
        printFileInfo(root);
    }

    private static void printFileInfo(File f) {
        System.out.println("--------------------");

        //이 파일이 디렉터리인지 확인
        if (f.isDirectory()) {//디렉터리이면
            //디렉터리와 내부 파일 목록 출력
            System.out.println("Directory : " + f.getName());
            //내부 파일 목록
            File[] files = f.listFiles(); // 배열 형태의 파일 객체 files
            //파일 목록 출력
            for (File file : files) {
                System.out.print(file.isDirectory() ? "d" : "f");//디렉터리이면 d 파일이면 f 출력
                System.out.println("\t" + file.getName());
            }

        } else {//디렉터리가 아닌 파일이면
            //파일 정보를 출력
            System.out.println("f\t" + f.getName());
        }
    }
}
