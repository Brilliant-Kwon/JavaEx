package Jan_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class kckClient {//클라이언트 클래스
    private static final String SERVER_IP = "192.168.1.12";//서버 ip주소
    private static final int SERVER_PORT = 5050;//서버 포트번호


    public static void main(String[] args) {//메인 시작

        Socket sk = new Socket();//소켓 생성
        try {
            sk.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));//서버소켓과 연결

            System.out.println("[클라이언트] 서버에 접속이 되었습니다.");//접속 메시지 출력
            String nick = null;//닉네임 저장을 위한 문자열 nick 선언

            while (true) {//무한 반복 루프 (닉네임 입력용)
                Scanner sc_nick = new Scanner(System.in);//닉네임 입력을 위한 스캐너 객체 생성
                System.out.print("[클라이언트] 닉네임을 입력하세요 : ");//시스템 문구 출력
                nick = sc_nick.nextLine();//스캐너로 입력받은 첫 줄을 읽어서 nick에 삽입

                if (!nick.isEmpty()) {//닉네임이 공백이 아닌 경우 닉네임 입력을 완료하고 루프를 탈출한다.
                    break;//탈출
                }
                System.out.println("[클라이언트] 닉네임을 한글자 이상 입력하세요.\n");//시스템 문구 출력
            }
            System.out.println("[클라이언트] \""+nick+"\" 님 환영합니다.");//시스템 문구 출력
            System.out.println("[클라이언트] 종료하려면 \"quit\"\n[클라이언트] 사칙연산 시 [숫자 + - * / 숫자] 형태로 공백없이 입력해주세요.\n[클라이언트] 현재는 연산자를 한번만 사용 가능합니다...(개발 중이에요)\n[클라이언트] 예시 : 1+1 (O) / 1   +   1(X:공백 포함 불가) / 1+2+3(X:연산자가 하나만 들어가야 함)\n[클라이언트] 즐거운 채팅 되세요\n========================================");//시스템 문구 출력

            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);//소켓을 통해 문자열을 넘겨주기 위해 PrintWriter 객체 pw 생성
            pw.println(nick);//닉네임을 먼저 넘겨준다. (println 메서드 사용)

            while (true) {//무한 루프 (소켓을 통해 메시지를 주고 받는 부분)
                Scanner sc = new Scanner(System.in);//메시지 전송을 위해 문자열을 입력받아야 하므로 스캐너 객체 생성
                System.out.print("["+nick+"] 입력 창 : ");//시스템 문구 출력
                String nextMsg = sc.nextLine();//클라이언트가 입력한 메시지를 저장하는 nextMsg 문자열 선언 및 입력한 문자열 저장
                if (nextMsg.equals("quit")) {//클라이언트가 quit를 입력하면 접속을 종료시켜주기 위해 if조건문을 통해 문자열 quit와 사용자의 메시지를 비교
                    System.out.println("[클라이언트] 접속을 종료합니다. 감사합니다 ^_^");//시스템 문구 출력
                    pw.close();//메시지 전송이 끝났으므로 PrintWriter를 닫아준다.
                    sk.close();//종료하였으므로 소켓을 닫아준다.
                    break;//무한루프 탈출
                }
                pw.println(nextMsg);//클라이언트의 메시지를 PrintWriter객체 pw를 이용하여 서버에 넘겨준다.
                BufferedReader rd = new BufferedReader(new InputStreamReader(sk.getInputStream()));//서버에서 메시지를 받아오기 위해 BufferedReader 객체 rd를 생성해주다.
                String serverMsg = rd.readLine();//서버가 보내온 메시지를 저장하는 serverMsg 문자열 선언 및 받아온 문자열 저장
                if (serverMsg.length() > 14 && serverMsg.substring(0, 14).equals("[서버] [사칙연산 답변]")) {//사칙연산의 답변을 받아올 경우 14글자 이상이고 앞부분이 일정하므로 조건문을 통해 걸러준다.
                    System.out.println(serverMsg);//사칙연산 결과물을 출력해준다.
                    serverMsg = rd.readLine();//다시 다음 서버가 직접 입력한 메시지를 받아오기 위해 serverMsg문자열에 다음 메시지를 새로 덮어씌운다.
                    System.out.println("[서버] 메시지 : " + serverMsg);//콘솔화면에 출력해준다.
                } else {//사칙연산의 답변이 아닐 경우
                    System.out.println("[서버] 메시지 : " + serverMsg);//서버의 메시지를 그대로 콘솔화면에 출력해준다.
                }
            }//무한루프 끝부분
            pw.close();//메시지 전송이 끝났으므로 PrintWriter를 닫아준다.

            //이하 catch문을 통해 예외처리를 해준다.
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("접속 실패, UnknownHostException");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("접속 실패, IOException");
        } finally {//마지막으로 소켓을 닫는 작업
            try {
                if (sk != null && !sk.isClosed()) {
                    sk.close();//소켓안에 든게 없고 소켓이 중간에 닫히지 않았다면 직접 소켓을 닫아준다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
