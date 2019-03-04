package JavaStudy.Mar_04.KCK.NSH;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class KakaoServer extends JFrame implements ActionListener, KeyListener{
	/*
	 * <서버와 클라이언트 채팅 프로그램> 
	 * 스레드를 이용하여 순서에 상관없이 메세지 송수신
	 * GUI를 만들어 전송할 메세지와 전송받은 메세지를 구분
	 * 자신과 상대방의 메세지 모두 출력
	 * 어느 한쪽이 접속을 끊으면 프로그램 종료
	 * 
	 * 1. GUI 먼저 구현
	 * - 맨 처음 아이디, 패스워드를 입력받는 창
	 * 확인 누르면 아이디로 접속하면 채팅창으로 연결
	 * 
	 * - 밑에는 입력창 textfield, 오른쪽에는 내가 보낸 메세지, 왼쪽에는 상대방의 메세지를 받을 Label, 전송버튼 Button
	 * 가능하면 메세지창 옆에 시간을 표시할 Label
	 * 가능하면 프로필 사진과 상대방의 이름
	 * 
	 * 2. 메인서버, 메인클라이언트 생성
	 * 
	 * 3. 서버쓰레드, 클라이언트 쓰레드를 생성하여
	 * run메소드를 오버라이드해서 입출력
	 * 키보드 enter를 누르거나 마우스로 전송버튼 클릭하면 전송
	 * 
	 * 4. 어느 한 쪽이 접속을 종료하면 프로그램 종료
	 * 
	 * 
	 */
	
	JTextField logid;
	JPasswordField logpw;
	static String id="";
	static String pw="";
	JButton login;
	
	static JTextArea ta;
	static JTextField tf;
	JButton b;

	static ServerSocket ss = null;
	static Socket socket = null;
	static List<Socket> list = new ArrayList<>();
	
	static BufferedReader in = null;	// 클라이언트로 부터 입력스트림
	static BufferedReader stin = null;	// 키보드로부터 입력스트림
	static BufferedWriter out = null;	// 클라이언트로 출력스트림
	
	KakaoServer(){
		setTitle("카카오톡 로그인");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setBackground(new Color(255,225,30));
		c.setLayout(null);
		
		JPanel P0;
		JLabel logo;
		ImageIcon image1 = new ImageIcon("D:\\javastudy\\kakao.png");
		
		P0 = new JPanel();
		P0.setBounds(0, 200, 400, 350);
		P0.setLocation(0, 100);
		P0.setLayout(null);
		P0.setBackground(new Color(255,225,30));
		
		logo = new JLabel(image1);
		logo.setBounds(138, 0, 122, 122);
		
		logid = new JTextField("",15);
		logid.setBounds(100, 150, 200, 50);
		
		logpw = new JPasswordField("",15);
		logpw.setBounds(100, 200, 200, 50);
		
		login = new JButton("로그인");
		login.setBounds(100, 250, 200, 50);
		login.addActionListener(this);
		login.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (login == (JButton)e.getSource()) {
					id = logid.getText();
					pw = logpw.getText();
					System.out.println("아이디:"+ id +" 패스워드:"+pw);
					if (id.length()>0 && pw.length()>0) {
						System.out.println("로그인 성공!");
						dispose();	// setVisible(false)로 해도됨.
						KakaoServer ks = new KakaoServer(id);
						ta.append(id+"님이 서버를 생성하였습니다.\n");
					}else {
						System.out.println("아이디/비밀번호를 입력해주세요");
					}
			}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		P0.add(logo);
		P0.add(logid);
		P0.add(login);
		P0.add(logpw);
		c.add(P0);
		setVisible(true);
		
	}
	
	KakaoServer(String id){
		this.id = id;
		setTitle("카카오톡 대화창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		P1.setBounds(0, 0, 384, 550);
		P1.setLayout(null);
		P2.setBounds(0, 550, 400, 150);
		P2.setLayout(null);
		
		
		ta = new JTextArea(25,50);
		ta.setEditable(false);
		JScrollPane scr = new JScrollPane(ta);
		ta.setLineWrap(false);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scr.setBounds(0, 0, 383, 550);
		ta.setBackground(new Color(245,209,183));
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);
        ta.setFont(font);

		
		tf = new JTextField(50);
		tf.setBounds(0,0,300,110);
		tf.addKeyListener(this);
		
		b = new JButton("전송");
		b.setBackground(Color.YELLOW);
		b.setFont(new Font("돋움체",Font.BOLD,15));
		b.setBounds(300, 0, 84, 110);
		b.addActionListener(this);
		b.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(b == (JButton)e.getSource()) {
					while(true) {
						try {
							String outputMessage = tf.getText();
							out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
							out.write(id+"> "+outputMessage+"\n");
							ta.append(outputMessage+"\n\n");
							ta.setCaretPosition(ta.getDocument().getLength());
							out.flush();
							tf.setText("");
							break;
						}catch(IOException ee) {
							ee.printStackTrace();
						}
				}
			}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		
		P1.add(scr);
		P2.add(tf);
		P2.add(b);
		
		c.add(P1);
		c.add(P2);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new KakaoServer();
		try {
			ss = new ServerSocket(9999);
			System.out.println("클라이언트 접속 대기중!");
			while(true) {
				socket = ss.accept();
			
			System.out.println("연결됨!");
			
			String inputMessage;
			while(true) {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
				inputMessage = in.readLine();
				System.out.println(inputMessage);
				ta.append(inputMessage+"\n\n");
				ta.setCaretPosition(ta.getDocument().getLength());
					
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				out.write(id+"> "+inputMessage+"\n");
			}
			}
		}catch (IOException e) {
			System.out.println("연결 실패!");
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 10){	
			while(true) {
				try {
					String outputMessage = tf.getText();
					out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					out.write(id+"> "+outputMessage+"\n");
					ta.append(outputMessage+"\n\n");
					ta.setCaretPosition(ta.getDocument().getLength());
					out.flush();
					tf.setText("");
					break;
				}catch(IOException ee) {
					ee.printStackTrace();
				}
			}
	}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if (input == "로그인") {
			id = logid.getText();
			pw = logpw.getText();
			System.out.println("아이디:"+ id +" 패스워드:"+pw);
			if (id.length()>0 && pw.length()>0) {
				System.out.println("로그인 성공!");
				dispose();	// setVisible(false)로 해도됨.
				KakaoServer ks = new KakaoServer(id);
				ta.append(id+"님이 서버를 생성하였습니다.\n");
			}else {
				System.out.println("아이디/비밀번호를 입력해주세요");
			}
		}else if (input == "전송") {
			while(true) {
				try {
					String outputMessage = tf.getText();
					out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					out.write(id+"> "+outputMessage+"\n");
					ta.append(outputMessage+"\n\n");
					ta.setCaretPosition(ta.getDocument().getLength());
					out.flush();
					tf.setText("");
					break;
				}catch(IOException ee) {
					ee.printStackTrace();
				}
		}
			
			
			
		}
		
	}
}
