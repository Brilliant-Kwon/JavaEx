package JavaStudy.Mar_04.KCK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Client_multiChat extends JFrame {

    char keyChar;

    String nickname = null;

    Socket socket = null;

    public Client_multiChat() {
        //GUI 부분
        Container con = getContentPane();
        setTitle("클라이언트 채팅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가j 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        JLabel title = new JLabel("채팅 : 클라이언트");
        title.setBackground(Color.GREEN);
        title.setOpaque(true);
        con.add(title, BorderLayout.NORTH);

        JTextArea getChat = new JTextArea();
        JScrollPane Dialog = new JScrollPane(getChat);
        Dialog.setBackground(Color.ORANGE);
        Dialog.setOpaque(true);
        con.add(Dialog, BorderLayout.CENTER);

        JTextField input = new JTextField();
//        input.requestFocus();
        con.add(input, BorderLayout.SOUTH);

        con.setSize(300, 500);
        con.requestFocus();
        setSize(300, 500);//창 크기 설정
        setLocation(400, 200);
        setVisible(true);//창 보이게 설정

        //기능 부분
        BufferedReader in = null;
        BufferedReader stin = null;
        BufferedWriter out = null;

        boolean connected = false;

        try {
            socket = new Socket("localhost", 9999); // 소켓 생성
            if (socket.isConnected()) {
//                System.out.println("서버 [" + socket.getInetAddress().getHostAddress() + "] 와 연결되었습니다.");
                System.out.println(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.");
                getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.\n");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌

                getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "닉네임 입력을 입력하세요 : ");

                Thread receiver = new Thread(new Client_Receiver(socket, getChat, input));

                input.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
//                System.out.println("진입");
                        char key = e.getKeyChar();
                        keyChar = key;
                        if (keyChar == '\n') {
                            if (nickname == null) {
                                System.out.println("닉네임 엔터키 입력");
                                nickname = input.getText();
                                System.out.println("닉네임 : " + nickname);
                                getChat.append(nickname + "\n");
                                title.setText(title.getText() + " [" + nickname + "]");
                                input.setText("");
                            } else {
                                System.out.println("엔터키 입력");
                                Thread sender = null;

                                sender = new Thread(new Client_Sender(con, socket, getChat, input));
                                sender.start();
                            }
                        }
//                getChat.append("키 입력:" + keyChar + key + "\n");
                    }
                });

                receiver.start();

                while (receiver.isAlive()) {//소켓이 닫히지 않게 유지

                }

                getChat.append("채팅 종료\n");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
            } else {
                System.out.println("연결 실패");
                getChat.append("연결 실패\n");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
            }

        } catch (UnknownHostException e) {
            System.out.println("ERROR : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR : " + e.getMessage());
        } finally {
            try {
                socket.close();//클라이언트 소켓 닫기
                getChat.append("소켓 종료\n");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
            } catch (IOException e) {
                System.out.println("서버와의 채팅 중 오류가 발생하였습니다.");
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Client_multiChat();
    }

    class Client_Receiver extends JFrame implements Runnable {

        Socket socket = null; // 서버와 연결 소켓
        JTextArea getChat = null;
        JTextField input = null;

        public Client_Receiver(Socket socket, JTextArea getChat, JTextField input) throws HeadlessException {
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
        }

        @Override
        public void run() {
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력 스트림
                String inputMessage; // 서버에서 받아온 문자열 저장용
                while (true) {
                    inputMessage = in.readLine();
                    if (inputMessage.equalsIgnoreCase("bye")) {//"bye" 대소문자 관계없이 읽어오면 종료
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + inputMessage + "\n");
                        getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라이언트 접속 종료\n");
                        System.out.println("서버 접속 종료");
                        break;
                    }
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + inputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌


                }
            } catch (IOException e) {
                System.out.println("ERROR : " + e.getMessage());
            }

        }
    }

    class Client_Sender extends JFrame implements Runnable {

        Container con = null;
        Socket socket = null; // 클라이언트와 연결 소켓
        JTextArea getChat = null;
        JTextField input = null;
        String outputMessage;

        public Client_Sender(Container con, Socket socket, JTextArea getChat, JTextField input) throws HeadlessException {
            this.con = con;
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
        }

        @Override
        public void run() {
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력 스트림
                outputMessage = input.getText();

                if (outputMessage.equalsIgnoreCase("bye")) {
                    out.write(nickname + " : " + outputMessage + "\n");
                    out.flush();
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + nickname + " : " + outputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                    input.setText("");
                    System.out.println("접속 종료");
                } else {
                    out.write(nickname + " : " + outputMessage + "\n");
                    out.flush();
//                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라 : " + outputMessage + "\n");
//                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                    System.out.println(outputMessage);//클라이언트가 보낸 메시지 -> 화면에 출력
                    input.setText("");
                }

            } catch (IOException e) {
                System.out.println("ERROR : " + e.getMessage());
            }

        }
    }

}
