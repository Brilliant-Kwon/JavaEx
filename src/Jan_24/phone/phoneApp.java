package Jan_24.phone;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class phoneApp {     //메인문을 담고 있는 실행용 클래스
    //파일 경로 저장
    private static String dirName = "C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\Jan_24\\phone\\";
    private static String fileName = dirName + "phone.txt";

    public static void main(String[] args) {
        //파일 유무 확인 및 생성
        exist();

        //메뉴창 출력
        System.out.println("*****************************************");
        System.out.println("*\t\t\t전화번호 관리 프로그램\t\t\t*");
        System.out.println("*****************************************");

        //기능 부분
        while (true) {//반복되야함
            System.out.println("\n1.리스트 2.등록 3.삭제 4.검색 5.종료");
            System.out.println("-----------------------------------------");

            Scanner sc = new Scanner(System.in);    //스캐너 선언
            System.out.print(">메뉴번호 : ");
            int menu = sc.nextInt();                //스캐너를 통해 메뉴 번호 int형 변수 입력 받음
            switch (menu) {                         //switch를 통해 메뉴 번호 판별
                case 1:                             //1번일 경우
                    phoneManage.List(fileName);     //리스트 출력 함수 호출 (파일경로 인자로 보내줌)
                    break;
                case 2:
                    phoneManage.Add(fileName);      //전화번호 추가 함수 호출
                    break;
                case 3:
                    phoneManage.Delete(fileName);   //전화번호 삭제 함수 호출
                    break;
                case 4:
                    phoneManage.Search(fileName);   //검색 함수 호출
                    break;
                case 5:                             //종료
                    System.out.println("*****************************************");
                    System.out.println("*\t\t\t\t감사합니다.\t\t\t\t*");
                    System.out.println("*****************************************");
                    break;
                default:                            //이외의 번호를 입력 시 문구와 함께 다시 반복문 처음으로
                    System.out.println("잘못된 번호를 입력하셨습니다.");
                    break;
            }
            if(menu==5) {                           //5번을 입력받았을 때 무한 루프 탈출 - > 메인문 종료 -> 프로그램 종료
                break;
            }
        }
    }

    public static void exist(){//파일 존재 확인
        File txt = new File(fileName);
//        System.out.println(fileName + "exist? : " + txt.exists());    //  임시출력

        if (!txt.exists()) {//파일이 존재하지 않으면 생성해줌
            try {
                txt.createNewFile();//해당 파일 객체의 생성 메서드
            } catch (IOException e) {
                System.out.println("파일 생성 오류 : " + e.getMessage());
            }
            System.out.println("파일 생성 완료 : " + fileName);
        }
    }

}
