package Jan_24.phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class phoneManage {      //기능 메서드들을 담고 있는 클래스

    public static void List(String file) {              //리스트 호출 함수 정의
        List<phone> lst = new ArrayList<>();            //phone 객체 형태의 ArrayList lst 선언 및 리스트 객체 생성

        Reader reader = null;                           //Reader 선언 및 초기화
        try {
            reader = new FileReader(file);              //reader에 FileReader객체 생성 및 파일 경로 인자로 넣어줌.
            BufferedReader br = new BufferedReader(reader);     //BufferedReader br 선언 및 객체 생성, reader를 인자로 넣어줌

            String line;    //br을 통해 읽어온 한 줄을 저장할 문자열 line 선언

            int listIndex = 1;      //int형 변수 listIndex -> 전화번호 리스트 출력 시 앞에 붙혀줄 번호.
            System.out.println("<1.리스트>");
            while ((line = br.readLine()) != null) {        //txt 파일을 줄단위로 읽어와 안에 내용이 있으면 반복
                System.out.print(listIndex++ + ". ");       //전화번호 리스트 앞에 붙을 번호 출력 ex) 1. xxx 1234 1234
                StringTokenizer st = new StringTokenizer(line, ",");        //StringTokenizer st를 선언 및 객체 생성 (읽어온 줄을 ','를 기준으로 등분주면서 토큰 생성)
                String[] str = new String[]{"", "", ""};    //st를 통해 잘라준 토큰들을 저장할 임시 배열 str[3] 선언 및 초기화
                for (int i = 0; i < 3; i++) {               //안에 들어갈 값이 총 3개이므로 3번 반복해준다.
                    String token = st.nextToken();          //문자열 token을 선언하여 다음 토큰을 담아준다.
                    str[i] = token;                         //str배열에 token을 0부터 2 인덱스까지 담아준다.
                    System.out.print(token + " ");          //토큰을 출력함으로써 리스트에 이름, 휴대전화, 집전화 순으로 출력이 된다. ***
                }
                System.out.println();                       //한줄 띄워준다.

                lst.add(new phone(str[0], str[1], str[2]));     //lst에 str의 문자열들을 phone 객체 생성자 속 인자로 넣어주며 객체 생성과 동시에 lst삽입
            }
            br.close();         //br을 닫아준다.
            //ArrayList 내용 확인 임시 출력부분
//            for (int i = 0; i < lst.size(); i++) {
//                System.out.println(i + " : " + lst.get(i).toString());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Add(String file) {           //전화번호 추가 메서드
        List<phone> lst = new ArrayList<>();

        //리스트 출력과 똑같은 방식으로 읽어 와 lst에 담아주되, 다른점은 리스트를 출력하지 않는다.
        Reader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;

//            int listIndex = 1;
            while ((line = br.readLine()) != null) {
//                System.out.print(listIndex + ". ");
                StringTokenizer st = new StringTokenizer(line, ",");
                String[] str = new String[]{"", "", ""};
                for (int i = 0; i < 3; i++) {
                    String token = st.nextToken();
                    str[i] = token;
                }
//                System.out.println(listIndex++ + "번 리스트에 저장");    //ArrayList 저장 확인 문구

                lst.add(new phone(str[0], str[1], str[2]));
            }
//            System.out.println("총 " + lst.size() + "개 저장.");          //ArrayList 길이 확인 문구

            //전화번호 추가 부분 시작
            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);     //BufferedWriter 선언 및 객체 생성
            PrintWriter pr = new PrintWriter(bw,true);
            pr.write("??");

            //기존의 정보를 다시 써줘야함. (BufferdWriter를 이용한 쓰기 기능은 파일의 내용을 처음부터 다시 써야하므로)
            for (int i = 0; i < lst.size(); i++) {              //lst의 크기만큼 반복
                bw.write(lst.get(i).getName());                 //이름, 휴대전화, 집전화를 각각 write메서드를 통해 txt파일에 써주고, 구분자 ','도 같이 써준다.
                bw.write(",");
                bw.write(lst.get(i).getHp());
                bw.write(",");
                bw.write(lst.get(i).getCompany());
                bw.write("\r\n");                           //마지막엔 한줄 띄워준다.
                bw.flush();
            }

            Scanner sc = new Scanner(System.in);                       //스캐너 선언

            System.out.print("<2.등록>\n>이름 : ");
            bw.write(sc.nextLine());                                    //한줄씩 받아서 써주고
            bw.write(",");                                          //구분자를 써준다.
            System.out.print(">휴대 전화 : ");
            bw.write(sc.nextLine());
            bw.write(",");
            System.out.print(">집 전화 : ");
            bw.write(sc.nextLine());
            bw.write("\r\n");                                       //마지막엔 한줄 띄워준다.

            bw.flush();
            bw.close(); //bw닫아준다.


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(String file) {                //전화번호 삭제 메서드
        //추가 메서드와 같으나 삭제할 번호를 받아서 기존 전화번호를 다시 쓰는 반복문 내부에
        // if를 통해 해당 번호의 전화번호를 제외하고 다시 쓰게하면 된다.
        List<phone> lst = new ArrayList<>();

        Reader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;

            int listIndex = 1;
            while ((line = br.readLine()) != null) {
                System.out.print(listIndex + ". ");
                StringTokenizer st = new StringTokenizer(line, ",");
                String[] str = new String[]{"", "", ""};
                for (int i = 0; i < 3; i++) {
                    String token = st.nextToken();
                    str[i] = token;
                }
//                System.out.println(listIndex++ + "번 리스트에 저장");

                lst.add(new phone(str[0], str[1], str[2]));
            }
//            System.out.println("총 " + lst.size() + "개 저장.");

            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);

            Scanner sc = new Scanner(System.in);
            System.out.print("<3.삭제>\n>번호 : ");
            int delNum = sc.nextInt();                  //삭제할 번호를 받아줌

            for (int i = 0; i < lst.size(); i++) {
                if (i != (delNum - 1)) {                //삭제할 번호(-1을 해줘야 함)를 제외한 나머지 정보를 다시 써준다.
                    bw.write(lst.get(i).getName());
                    bw.write(",");
                    bw.write(lst.get(i).getHp());
                    bw.write(",");
                    bw.write(lst.get(i).getCompany());
                    bw.write("\r\n");
                    bw.flush();
                }
            }

            System.out.println("[" + delNum + " 번이 삭제되었습니다.]");

            bw.flush();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Search(String file) {            //검색 메서드
        //리스트 출력 메서드와 동일하나 기존 정보들을 출력하지 않고 그 부분에 조건문을 삽입,
        // String을 하나 입력받아서 해당 String을 contain하면 조건 만족으로 그 line을 출력할 수 있게 한다.
        List<phone> lst = new ArrayList<>();

        Reader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;

            Scanner sc = new Scanner(System.in);
            System.out.print("<4.검색>\n>검색할 이름 : ");
            String srcString = sc.nextLine();           //찾을 String 입력받음

            int listIndex = 1;
            while ((line = br.readLine()) != null) {
                if (line.contains(srcString))           //line이 srcString을 포함하고있으면
                    System.out.print(listIndex + ". ");     //번호 출력
                listIndex++;                            //번호는 유지해야하므로 계속 증가를 위해 따로 빼줬다.
                StringTokenizer st = new StringTokenizer(line, ",");
                String[] str = new String[]{"", "", ""};
                for (int i = 0; i < 3; i++) {
                    String token = st.nextToken();
                    str[i] = token;
                    if (line.contains(srcString))           //line이 srcString을 포함하고있으면
                        System.out.print(token + " ");      //해당 정보들 출력(이름, 휴대전화, 집전화)
                }
                if (line.contains(srcString))               //line이 srcString을 포함하고있으면
                    System.out.println();                   //한줄 띄워줘야함 (해당하는 정보가 하나가 아닐 수도 있으므로)

                lst.add(new phone(str[0], str[1], str[2]));
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
