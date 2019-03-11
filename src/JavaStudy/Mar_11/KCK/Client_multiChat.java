package JavaStudy.Mar_11.KCK;

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

    private static Client_multiChat client = null;

    private String nickname = null;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    Socket socket = null;

    public Client_multiChat() {
        if (client == null)
            client = this;
        Container con = getContentPane();
        con.setLayout(null);
        setTitle("클라이언트 채팅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가 끝나도록 설정

        con.add(new Login_window(), 0);

        //크기 및 위치 관련
        con.setSize(300, 500);
        setSize(300, 500);//창 크기 설정
        setLocation(400, 200);
        setVisible(true);//창 보이게 설정

    }

    public static Client_multiChat getClient() {
        if (client == null)
            client = new Client_multiChat();
        return client;
    }


    class Login_window extends JPanel {
        public Login_window() {
            setLayout(null);
            JLabel title = new JLabel("로그인");
            title.setBackground(Color.GREEN);
            title.setOpaque(true);
            title.setSize(300, 100);
            title.setLocation(0, 0);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            add(title);

            JLabel label_id = new JLabel("아이디");
            label_id.setSize(100, 50);
            label_id.setLocation(20, 100);
            add(label_id);

            JTextField input_id = new JTextField();
            input_id.setSize(180, 50);
            input_id.setLocation(80, 100);
            add(input_id);

            JLabel label_pw = new JLabel("비밀번호");
            label_pw.setSize(100, 50);
            label_pw.setLocation(20, 150);
            add(label_pw);

            JTextField input_pw = new JTextField();
            input_pw.setSize(180, 50);
            input_pw.setLocation(80, 150);
            add(input_pw);

            JButton button = new JButton("로그인");
            button.setSize(100, 50);
            button.setLocation(30, 220);
            add(button);

            JButton signbutton = new JButton("회원가입");
            signbutton.setSize(100, 50);
            signbutton.setLocation(160, 220);
            add(signbutton);

            setBackground(Color.GREEN);
            setSize(300, 500);//판넬 크기 설정
            setLocation(0, 0);

            Client_multiChat.getClient().repaint();
            Client_multiChat.getClient().setSize(301, 500);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (input_id.getText() != null && input_pw.getText() != null) {
                        Chat_Dao dao = new Chat_Dao_Impl("bituser", "bituser");
                        System.out.println("id : " + input_id.getText() + "\n" + "pw : " + input_pw.getText() + "\n");
                        String nickname = dao.match(input_id.getText(), input_pw.getText());
                        System.out.println("닉네임 : " + nickname);
                        if (nickname != null) {
                            Client_multiChat.getClient().setNickname(nickname);
                            Client_multiChat.getClient().getContentPane().remove(0);
                            Client_multiChat.getClient().getContentPane().add(new Chat_window(), 0);

                            System.out.println("셋팅된 닉네임 : " + Client_multiChat.getClient().getNickname());
                        } else {
                            title.setText("로그인 실패");
                        }
                    } else {
                        title.setText("모두 입력해주세요.");
                    }
                }
            });

            input_pw.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char key = e.getKeyChar();
                    if (key == '\n') {
                        System.out.println("엔터키 입력");

                        if (input_id.getText() != "" && input_pw.getText() != "") {
                            Chat_Dao dao = new Chat_Dao_Impl("bituser", "bituser");
                            System.out.println("id : " + input_id.getText() + "\n" + "pw : " + input_pw.getText() + "\n");
                            String nickname = dao.match(input_id.getText(), input_pw.getText());
                            System.out.println("닉네임 : " + nickname);
                            if (nickname != null) {
                                Client_multiChat.getClient().setNickname(nickname);
                                Client_multiChat.getClient().getContentPane().remove(0);
                                Client_multiChat.getClient().getContentPane().add(new Chat_window(), 0);

                                System.out.println("셋팅된 닉네임 : " + Client_multiChat.getClient().getNickname());
                            } else {
                                title.setText("로그인 실패");
                            }
                        } else {
                            title.setText("모두 입력해주세요.");
                        }
                    }
                }
            });

            signbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Client_multiChat.getClient().getContentPane().remove(0);
                    Client_multiChat.getClient().getContentPane().add(new Sign_window(), 0);
                }
            });
        }
    }

    class Sign_window extends JPanel {
        public Sign_window() {
            System.out.println("회원가입 창 시작");
            setLayout(null);
            JLabel title = new JLabel("회원 가입");
            title.setBackground(Color.yellow);
            title.setOpaque(true);
            title.setSize(300, 100);
            title.setLocation(0, 0);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            add(title);

            JLabel label_id = new JLabel("아이디");
            label_id.setSize(100, 50);
            label_id.setLocation(20, 100);
            add(label_id);

            JTextField input_id = new JTextField();
            input_id.setSize(160, 50);
            input_id.setLocation(110, 100);
            add(input_id);

            JLabel label_pw = new JLabel("비밀번호");
            label_pw.setSize(100, 50);
            label_pw.setLocation(20, 150);
            add(label_pw);

            JTextField input_pw = new JTextField();
            input_pw.setSize(160, 50);
            input_pw.setLocation(110, 150);
            add(input_pw);

            JLabel label_nick = new JLabel("닉네임");
            label_nick.setSize(100, 50);
            label_nick.setLocation(20, 200);
            add(label_nick);

            JTextField input_nick = new JTextField();
            input_nick.setSize(160, 50);
            input_nick.setLocation(110, 200);
            add(input_nick);

            JButton signbutton = new JButton("회원가입");
            signbutton.setSize(100, 50);
            signbutton.setSize(100, 50);
            signbutton.setLocation(100, 270);
            add(signbutton);

            setBackground(Color.yellow);
            setSize(300, 500);//판넬 크기 설정
            setLocation(0, 0);
            Client_multiChat.getClient().repaint();
            Client_multiChat.getClient().setSize(301, 501);

            signbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (input_id.getText() != ""
                            && input_pw.getText() != ""
                            && input_nick.getText() != "") {
                        Chat_Dao dao = new Chat_Dao_Impl("bituser", "bituser");
                        System.out.println("id : " + input_id.getText() + "\n" + "pw : " + input_pw.getText() + "\n" + "nickname : " + input_nick.getText() + "\n");
                        boolean success = dao.insert(new Chat_Vo(input_id.getText(), input_pw.getText(), input_nick.getText()));

                        if (success) {
                            System.out.println("회원가입 성공");
                            Client_multiChat.getClient().getContentPane().remove(0);
                            Client_multiChat.getClient().getContentPane().add(new Login_window(), 0);


                        } else {
                            System.out.println("회원가입 실패");
                            title.setText("회원가입 실패");
                        }
                    } else {
                        title.setText("모두 입력해주세요.");
                    }
                }
            });
        }
    }


    class Chat_window extends JPanel {
        public Chat_window() {
            System.out.println("채팅 창 시작");
            String nickname = Client_multiChat.getClient().getNickname();
            setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

            //상단바
            String titleText = "클라이언트 [" + nickname + "]";
            JLabel title = new JLabel(titleText);
            title.setBackground(Color.GREEN);
            title.setOpaque(true);
            add(title, BorderLayout.NORTH);

            //내용창
            JTextArea getChat = new JTextArea();
            JScrollPane Dialog = new JScrollPane(getChat);
            Dialog.setPreferredSize(new Dimension(300, 400));
            Dialog.setBackground(Color.ORANGE);
            Dialog.setOpaque(true);
            add(Dialog, BorderLayout.CENTER);

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

            add(input_panel, BorderLayout.SOUTH);

            setSize(300, 500);//판넬 크기 설정
            setLocation(0, 0);
            Client_multiChat.getClient().repaint();
            Client_multiChat.getClient().setSize(310, 530);
            try {
                socket = new Socket("localhost", 9999); // 소켓 생성
                System.out.println("소켓 생성");
//                System.out.println("서버 [" + socket.getInetAddress().getHostAddress() + "] 와 연결되었습니다.");
                System.out.println(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.");
                getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "서버 [" + socket.getInetAddress().getHostAddress() + "] 연결 됨.\n");
                System.out.println("채팅창 어팬드");
                getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                System.out.println("스크롤 초기화");

                Thread receiver = new Thread(new Client_Receiver(socket, getChat, input));
                System.out.println("리시버 쓰레드 생성");

                input.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (!input.getText().equals("")) {
                            char key = e.getKeyChar();
                            if (key == '\n') {
                                System.out.println("엔터키 입력");
                                Thread sender = new Thread(new Client_Sender(socket, getChat, input, nickname));
                                sender.start();
                            } else {
                                System.out.println("입력창이 공백임");
                            }
                        }
                    }
                });

                System.out.println("엔터키 리스너 생성");

                input_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("버튼 클릭");
                        if (input.getText() != "") {
                            Thread sender = new Thread(new Client_Sender(socket, getChat, input, nickname));
                            sender.start();
                        } else {
                            System.out.println("입력창이 공백임");
                        }
                    }
                });

                System.out.println("버튼 클릭 리스너 생성");

                receiver.start();
                System.out.println("리시버 시작");

            } catch (UnknownHostException e) {
                System.out.println("ERROR : " + e.getMessage());
            } catch (IOException e) {
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
        BufferedWriter out = null;


        public Client_Receiver(Socket socket, JTextArea getChat, JTextField input) throws HeadlessException {
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
        }

        @Override
        public void run() {
            try {
                System.out.println("리시버 스레드 들어옴");

                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write(nickname + ":님이 접속하셨습니다.\n");
                out.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력 스트림
                String inputMessage; // 서버에서 받아온 문자열 저장용

                System.out.println("버퍼리더 생성");

                while (true) {
                    System.out.println("리시버 무한반복 진입, 메시지를 기다립니다.");
                    inputMessage = in.readLine();
                    if (inputMessage.equalsIgnoreCase("bye") && !inputMessage.equalsIgnoreCase("")) {//"bye" 대소문자 관계없이 읽어오면 종료
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + inputMessage + "\n");
                        getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                        getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "클라이언트 접속 종료\n");
                        System.out.println("클라이언트 [" + Client_multiChat.getClient().getNickname() + "] 접속 종료");
                        break;
                    }
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + inputMessage + "\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                    System.out.println("리시버 어팬드");
                }
            } catch (IOException e) {
                System.out.println("ERROR : " + e.getMessage());
            } finally {
                try {
                    // TODO: 2019-03-10 강제 종료 시 어떻게 닉네임을 넘길 것인가
                    System.out.println("finally 진입");
                    out.write(Client_multiChat.getClient().getNickname() + " : 종료하였습니다.");
                    out.flush();
                    System.out.println("finally 메시지 전송");

                    if (!socket.isClosed())
                        socket.close();//클라이언트 소켓 닫기
                    getChat.append("소켓 종료\n");
                    getChat.setCaretPosition(getChat.getDocument().getLength()); //스크롤 맨 아래로 해줌
                } catch (IOException e) {
                    System.out.println("서버와의 채팅 중 오류가 발생하였습니다.");
                    System.out.println("ERROR : " + e.getMessage());
                }
            }
        }
    }

    class Client_Sender extends JPanel implements Runnable {

        Socket socket = null; // 클라이언트와 연결 소켓
        JTextArea getChat = null;
        JTextField input = null;
        String nickname = null;

        String outputMessage;

        public Client_Sender(Socket socket, JTextArea getChat, JTextField input, String nickname) throws HeadlessException {
            this.socket = socket;
            this.getChat = getChat;
            this.input = input;
            this.nickname = nickname;
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
                    getChat.append(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()) + "소켓 종료+\n");
                    if (!socket.isClosed())
                        socket.close();
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
