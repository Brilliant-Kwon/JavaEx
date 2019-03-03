package JavaStudy.Mar_03.KCK;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_multiThread extends JFrame {
    public Server_multiThread() {
        //GUI 부분
        Container con = getContentPane();
        setTitle("서버 GUI 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        JLabel title = new JLabel("채팅 : 서버");
        title.setBackground(Color.ORANGE);
        title.setOpaque(true);
        con.add(title, BorderLayout.NORTH);

        JTextArea getChat = new JTextArea();
        JScrollPane Dialog = new JScrollPane(getChat);
        Dialog.setBackground(Color.ORANGE);
        Dialog.setOpaque(true);
        con.add(Dialog, BorderLayout.CENTER);

        //기능 부분
        BufferedReader in = null; // 클라이언트로부터 입력
        BufferedReader stin = null; // 키보드로부터 입력
        BufferedWriter out = null; //클라이언트로 출력

        ServerSocket serverSocket = null; // 서버 소켓
        Socket socket = null; // 클라이언트와 연결 소켓

        try {
            serverSocket = new ServerSocket(9999);//서버 소켓 생성
            socket = serverSocket.accept(); // 클라이언트 연결 요청 대기
            System.out.println("클라이언트 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력 스트림
            stin = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
            String inputMessage; // 클라이언트에서 받아온 문자열 저장용
            while (true) {
                inputMessage = in.readLine();//클라이언트에서 한 행의 문자열 읽음
                if (inputMessage.equalsIgnoreCase("bye")) {//"bye" 대소문자 관계없이 읽어오면 종료
                    break;
                }
                System.out.println(inputMessage);//클라이언트가 보낸 메시지 -> 화면에 출력
                String outputMessage = stin.readLine(); // 키보드에서 한 행 읽어옴
                out.write("서버 > " + outputMessage + "\n"); // 키보드에서 읽은 문자열 전송
                out.flush();// 플러쉬
            }
        } catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            try {
                socket.close(); // 클라이언트와의 소켓 닫기
                serverSocket.close();// 서버 소켓 닫기
            } catch (IOException e) {
                System.out.println("클라이언트와 채팅 중 오류가 발생하였습니다.");
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    class Server_Receiver extends JFrame implements Runnable {

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        
    }
}
