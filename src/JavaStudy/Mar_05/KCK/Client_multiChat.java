package JavaStudy.Mar_05.KCK;

import JavaStudy.Mar_05.KCK.dao.Chat_Dao;
import JavaStudy.Mar_05.KCK.dao.Chat_Dao_Impl;
import JavaStudy.Mar_05.KCK.vo.Chat_Vo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client_multiChat extends JFrame {

    char keyChar;

    String nickname = null;

    Socket socket = null;

    static class Login_window extends JFrame {
        public Login_window() throws HeadlessException {
            Container con = getContentPane();
            setTitle("클라이언트 닉네임 설정");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLayout(null);
            JLabel title = new JLabel("로그인");
            title.setBackground(Color.GREEN);
            title.setOpaque(true);
            title.setSize(300, 100);
            title.setLocation(0, 0);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            con.add(title);

            JTextField input_id = new JTextField();
            input_id.setSize(150, 50);
            input_id.setLocation(30, 100);
            con.add(input_id);

            JTextField input_pw = new JTextField();
            input_pw.setSize(150, 50);
            input_pw.setLocation(30, 150);
            con.add(input_pw);

            JButton button = new JButton("로그인");
            button.setSize(70, 100);
            button.setLocation(190, 100);
            con.add(button);



            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Chat_Dao dao = new Chat_Dao_Impl("bituser", "bituser");
                    System.out.println("id : " + input_id.getText() + "\n" + "pw : " + input_pw.getText() + "\n");
                    String nickname = dao.match(input_id.getText(), input_pw.getText());
                    System.out.println("닉네임 : " + nickname);
                    if (nickname != null) {
                        Client_multiChat start = new Client_multiChat();
                        start.nickname = nickname;
                    } else {
                        title.setText("로그인 실패");
                    }

                }
            });

            JPanel input_panel = new JPanel();
            input_panel.setLayout(new BorderLayout());

            JButton signbutton = new JButton("회원가입");
            signbutton.setSize(100, 50);
            signbutton.setSize(100, 50);
            signbutton.setLocation(100, 220);
            con.add(signbutton);

            con.setBackground(Color.GREEN);
            con.setSize(300, 500);
            setSize(300, 500);//창 크기 설정
            setLocation(400, 200);
            setVisible(true);//창 보이게 설정
            //
        }
    }

    public Client_multiChat() {
        //GUI 부분
        Container con = getContentPane();
        setTitle("클라이언트 채팅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가j 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        //상단바
        JLabel title = new JLabel("채팅 : 클라이언트");
        title.setBackground(Color.GREEN);
        title.setOpaque(true);
        con.add(title, BorderLayout.NORTH);

        //내용창
        JTextArea getChat = new JTextArea();
        JScrollPane Dialog = new JScrollPane(getChat);
        Dialog.setPreferredSize(new Dimension(300, 400));
        Dialog.setBackground(Color.ORANGE);
        Dialog.setOpaque(true);
        con.add(Dialog, BorderLayout.CENTER);

        //입력창
        JPanel input_panel = new JPanel();
        input_panel.setLayout(new BorderLayout());

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 100));
        input.requestFocus();

        JButton input_button = new JButton("전송");
        input_button.setBackground(Color.GREEN);

        input_panel.add(input, BorderLayout.CENTER);
        input_panel.add(input_button, BorderLayout.EAST);

        con.add(input_panel, BorderLayout.SOUTH);

        //크기 및 위치 관련
        con.setSize(300, 500);
        setSize(300, 500);//창 크기 설정
        setLocation(400, 200);
        setVisible(true);//창 보이게 설정

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

                input_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
//        new Client_multiChat();
        new Login_window();
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
