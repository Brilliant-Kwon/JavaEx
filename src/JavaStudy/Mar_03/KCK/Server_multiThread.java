package JavaStudy.Mar_03.KCK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// TODO: 2019-03-03 채팅을 치던 받던 getChat에 출력되야 함.

public class Server_multiThread extends JFrame {

    char keyChar;

    ServerSocket serverSocket = null; // 서버 소켓
    Socket socket = null; // 클라이언트와 연결 소켓

    public Server_multiThread() {
        //GUI 부분
        Container con = getContentPane();
        setTitle("서버 채팅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        JLabel title = new JLabel("채팅 : 서버");
        title.setBackground(Color.ORANGE);
        title.setOpaque(true);
        con.add(title, BorderLayout.NORTH);

        JTextArea getChat = new JTextArea();
        JScrollPane Dialog = new JScrollPane(getChat);
        Dialog.setPreferredSize(new Dimension(300, 400));
        Dialog.setBackground(Color.ORANGE);
        Dialog.setOpaque(true);
        con.add(Dialog, BorderLayout.CENTER);

        JPanel input_panel = new JPanel();
        input_panel.setLayout(new BorderLayout());

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 100));

        JButton input_button = new JButton("전송");
        input_button.setBackground(Color.ORANGE);

        input_panel.add(input, BorderLayout.CENTER);
        input_panel.add(input_button, BorderLayout.EAST);

//        input.requestFocus();
        con.add(input_panel, BorderLayout.SOUTH);

        con.setSize(300, 500);
        con.requestFocus();
        setSize(300, 500);//창 크기 설정
        setLocation(100, 200);
        setVisible(true);//창 보이게 설정

//        //기능 부분
//        BufferedReader in = null; // 클라이언트로부터 입력
//        BufferedReader stin = null; // 키보드로부터 입력
//        BufferedWriter out = null; //클라이언트로 출력
//
//        boolean bye = false;

//        ArrayList<OutputStream> outputStreams = new ArrayList<>();
        ArrayList<Socket> socketList = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(9999);//서버 소켓 생성

            input.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
//                System.out.println("진입");
                    char key = e.getKeyChar();
                    keyChar = key;
                    if (keyChar == '\n') {
                        System.out.println("엔터키 입력");
                        Thread sender = null;
                        try {
                            sender = new Thread(new Server_Sender(con, serverSocket, socket, getChat, input));
                            sender.start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
//                getChat.append("키 입력:" + keyChar + key + "\n");
                }
            });

//            while (true) {//멀티 채팅용.......
            System.out.println("접속 대기중");
            socket = serverSocket.accept(); // 클라이언트 연결 요청 대기
//                outputStreams.add(socket.getOutputStream());// TODO: 2019-03-03 멀티 채팅
            //현재 시간 추가
            System.out.println(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라이언트 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.");
            getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라이언트 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.\n");
            getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌

            Thread receiver = new Thread(new Server_Receiver(serverSocket, socket, getChat, input));
            receiver.start();
//            }


//            getChat.append("채팅 종료\n");
//            getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
//            while (true) {
//                inputMessage = in.readLine();//클라이언트에서 한 행의 문자열 읽음
//                if (inputMessage.equalsIgnoreCase("bye")) {//"bye" 대소문자 관계없이 읽어오면 종료
//                    break;
//                }
//                System.out.println(inputMessage);//클라이언트가 보낸 메시지 -> 화면에 출력
//                String outputMessage = stin.readLine(); // 키보드에서 한 행 읽어옴
//                out.write("서버 > " + outputMessage + "\n"); // 키보드에서 읽은 문자열 전송
//                out.flush();// 플러쉬
//            }
        } catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            try {
                socket.close(); // 클라이언트와의 소켓 닫기
                serverSocket.close();// 서버 소켓 닫기
                getChat.append("서버소켓, 소켓 종료\n");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
            } catch (IOException e) {
                System.out.println("클라이언트와 채팅 중 오류가 발생하였습니다.");
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    class Server_Receiver extends JFrame implements Runnable {

        ServerSocket serverSocket = null; // 서버 소켓
        Socket socket = null; // 클라이언트와 연결 소켓
        JTextArea getChat = null;
        JTextField input = null;

        public Server_Receiver(ServerSocket serverSocket, Socket socket, JTextArea getChat, JTextField input) throws HeadlessException, IOException {
            this.serverSocket = serverSocket;
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
        }

        @Override
        public void run() {

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력 스트림
                String inputMessage; // 클라이언트에서 받아온 문자열 저장용
                while (true) {
                    inputMessage = in.readLine();//클라이언트에서 한 행의 문자열 읽음
                    if (inputMessage.equalsIgnoreCase("bye")) {//"bye" 대소문자 관계없이 읽어오면 종료
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라 : " + inputMessage + "\n");
                        getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라이언트 접속 종료\n");
                        System.out.println("클라이언트 접속 종료");
                        break;
                    }
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라 : " + inputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌

                }
            } catch (IOException e) {
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    class Server_Sender extends JFrame implements Runnable {
        Container con = null;
        ServerSocket serverSocket = null; // 서버 소켓
        Socket socket = null; // 클라이언트와 연결 소켓
        JTextArea getChat = null;
        JTextField input = null;
        String outputMessage;
//        ArrayList<OutputStream> outputStreams = null;
        // TODO: 2019-03-03 아웃풋 스트림을 분리하여 멀티 채팅을 나눈다.

//        Boolean sender_end = true;

        public Server_Sender(Container con, ServerSocket serverSocket, Socket socket, JTextArea getChat, JTextField input) throws HeadlessException, IOException {
            this.con = con;
            this.serverSocket = serverSocket;
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
        }

        @Override
        public void run() {
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림

//                if (keyChar == '\n') {
                outputMessage = input.getText();
                if (outputMessage.equalsIgnoreCase("bye")) {
                    out.write(outputMessage + "\n");
                    out.flush();
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 : " + outputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                    input.setText("");
//                            sender_end = false; // 반복문 탈출
                    System.out.println("접속 종료");
                } else {
                    out.write(outputMessage + "\n");
                    out.flush();
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 : " + outputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                    System.out.println(outputMessage);//클라이언트가 보낸 메시지 -> 화면에 출력
                    input.setText("");
                }
            } catch (
                    IOException e) {
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Server_multiThread();
    }
}
