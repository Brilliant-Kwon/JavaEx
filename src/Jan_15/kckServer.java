package Jan_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class kckServer {//서버 클래스
    public static void main(String[] args) {
        final int port = 5050;    //포트번호 설정
        ServerSocket ssk = null; //서버소켓 ssk 선언

        try {
            ssk = new ServerSocket(port);//서버 소켓 ssk 에 포트번호를 포함한 객체를 생성

            //호스트 주소를 문자열로 받아옴 (미사용 부분)
//            String localHostAddress = InetAddress.getLocalHost().getHostAddress();

            System.out.println("[서버] 클라이언트의 접속 대기중......");//시스템 문구 출력
            //무한 반복-소켓서버 종료 시 까지
            while (true) {
                Socket scok = ssk.accept();//접속 요청시까지 대기하는 소켓 생성 (클라이언트와 직접 연결되는 소켓)

                //요청이 오면
                System.out.println("[서버] 사용자가 접속했습니다.");//시스템 문구 출력
                //클라이언트 ip주소 반환하여 출력
                System.out.println("[서버] 클라이언트 ip : " + scok.getInetAddress().getHostAddress());//클라이언트 ip를 받아와 출력
                int remoteHostPort = scok.getPort();//클라이언트의 포트 번호를 int형 변수에 저장
                System.out.println("[서버] 클라이언트 port : " + remoteHostPort);//위에서 저장한 클라이언트 포트 번호를 출력

                //수신 메시지부분
                BufferedReader reader = new BufferedReader(new InputStreamReader(scok.getInputStream()));//클라이언트에서 보낸 메시지를 읽어오기 위해 BufferedReader 객체 reader를 생성
                String nick = reader.readLine();//가장 먼저 닉네임을 클라이언트에서 보내게 했기 때문에, 닉네임용 문자열 nick을 선언하여 닉네임 저장.
                while (true) {//무한 루프 (클라이언트와 메시지를 주고 받기 위한 부분)
                    String msg = reader.readLine();//msg문자열을 선언하고 클라이언트가 보낸 메시지를 읽어와 문자열을 저장한다.
                    if (msg == null) {//읽어온 메시지가 없을 경우
                        System.out.println("[서버] [" + nick + "] 님의 메시지가 없어 접속이 종료되었습니다.");//시스템 문구 출력
                        break;//무한루프 탈출
                    }
                    System.out.println("[" + nick + "] 메시지 : " + msg);//메시지를 콘솔창에 출력해준다.

                    PrintWriter pw = new PrintWriter(scok.getOutputStream(), true);//클라이언트에게 메시지를 보내기 위해 PrintWriter 객체 pw를 생성

                    for (int i = 0; i < msg.length(); i++) {//사칙연산인지 메시지인지 확인/ 계산/ 출력/ 전송하기 위해 메시지를 처음 인덱스부터 끝 인덱스까지 char단위로 문자 하나씩 읽기 위해서 반복문 사용
                        switch (msg.charAt(i)) {//해당 인덱스의 문자를 스위치 문을 통하여 연산자 + - * / 인지 일반 문자인지 색출해냄
                            //연산자가 하나라도 들어가 있으면 해당 메시지 전체는 사칙연산으로 취급함
                            case '+'://더하기인 경우
                                String str1 = msg.substring(0, i);//0번째부터 i번째 앞까지 문자열을 잘라준다.(i번째가 연산자)
                                String str2 = msg.substring(i + 1);//i+1번째부터 마지막까지 문자열을 잘라준다.
                                int num1 = Integer.parseInt(str1);//잘라운 str1문자열을 숫자로 취급하기 위하여 int형으로 변환해주기 위해 Integer.parseInt를 사용하여 변환해 num1에 저장해 주었다.
                                int num2 = Integer.parseInt(str2);//이하 동문
                                int result1 = num1 + num2;//연산 결과를 int형 변수 result1에 저장해주었다.
                                System.out.println("[서버] [사칙연산 답변] : " + num1 + " + " + num2 + " = " + result1);//콘솔창에 출력
                                pw.println("[서버] [사칙연산 답변] : " + num1 + " + " + num2 + " = " + result1);//클라이언트에게 메시지 형태로 전송 (PrintWriter객체 pw를 사용)
                                break;//switch문 탈출
                            case '-'://빼기인 경우
                                String str3 = msg.substring(0, i);
                                String str4 = msg.substring(i + 1);
                                int num3 = Integer.parseInt(str3);
                                int num4 = Integer.parseInt(str4);
                                int result2 = num3 - num4;
                                System.out.println("[서버] [사칙연산 답변] : " + num3 + " - " + num4 + " = " + result2);
                                pw.println("[서버] [사칙연산 답변] : " + num3 + " - " + num4 + " = " + result2);
                                break;
                            case '*'://곱하기인 경우
                                String str5 = msg.substring(0, i);
                                String str6 = msg.substring(i + 1);
                                int num5 = Integer.parseInt(str5);
                                int num6 = Integer.parseInt(str6);
                                int result3 = num5 * num6;
                                System.out.println("[서버] [사칙연산 답변] : " + num5 + " * " + num6 + " = " + result3);
                                pw.println("[서버] [사칙연산 답변] : " + num5 + " * " + num6 + " = " + result3);
                                break;
                            case '/'://나누기인 경우
                                String str7 = msg.substring(0, i);
                                String str8 = msg.substring(i + 1);
                                int num7 = Integer.parseInt(str7);
                                int num8 = Integer.parseInt(str8);
                                int result4 = num7 / num8;
                                System.out.println("[서버] [사칙연산 답변] : " + num7 + " / " + num8 + " = " + result4);
                                pw.println("[서버] [사칙연산 답변] : " + num7 + " / " + num8 + " = " + result4);
                                break;
                        }

                    }

                    System.out.print("[서버] 답변 입력 : ");//시스템 문구 출력
                    Scanner sc = new Scanner(System.in);//클라이언트에게 보낼 문자열을 콘솔창에서 입력받기 위해 Scanner 객체 sc 생성
                    String nextMsg = sc.nextLine();//입력한 문자열을 줄단위로 읽어와 nextMsg 문자열을 생성하고 저장해준다.
                    if (nextMsg.equals("quit")) {//클라이언트의 접속을 강제로 끊고 시을 경우 quit를 입력해준다.
                        break;//무한루프 종료
                    }
                    pw.println(nextMsg);//입력한 문자열을 클라이언트에게 전송해준다.
                }

                System.out.println("[서버] [" + nick + "] 님의 접속이 종료되었습니다.");//시스템 문구 출력
                reader.close();//BufferdReader객체 reader를 닫아준다.
                scok.close();//해당 소켓 닫아줌
            }
        } catch (IOException e) {
            // TODO 자동 생성된 catch 블록
            e.printStackTrace();
        } finally {//마지막으로 소켓 닫아주는 작업
            try {
                if (ssk != null && !ssk.isClosed()) {
                    ssk.close();//서버 소켓안에 든게 없고 소켓이 중간에 닫히지 않았다면 직접 서버 소켓을 닫아준다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
