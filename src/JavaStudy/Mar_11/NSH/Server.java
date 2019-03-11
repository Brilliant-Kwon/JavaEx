package JavaStudy.Mar_11.NSH;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Server extends JFrame{
	String id;
	String pw;
	String name;
	JTextField logid;
	JPasswordField logpw;
	JButton logb;
	JButton joinb;
	JTextArea ta;
	JTextField tf;
	JButton b;
	ServerSocket ss = null;
	Socket socket = null;
	List<Socket> list = new ArrayList<>();
	BufferedReader in = null;
	BufferedWriter out = null;
	String dbUser="bituser";
	String dbPass="bituser";
	static boolean islogin = false;
	static Server s = null;
	
	KakaoDaoImpl dao = new KakaoDaoImpl(dbUser, dbPass);
	static KakaoVo vo = null;
	Server(){	// 로그인 프레임
		setTitle("카카오톡 로그인");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(0,0);
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
		
		logid = new JTextField();
		logid.setBounds(100, 150, 200, 50);
		logpw = new JPasswordField();
		logpw.setBounds(100, 200, 200, 50);
		logb = new JButton("로그인");
		logb.setBounds(100, 250, 200, 50);
		joinb = new JButton("회원가입");
		joinb.setBounds(100, 300, 200, 50);
		
		
		logb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if (action == "로그인") {
					id = logid.getText();
					pw = logpw.getText();
					if (id.length()==0 | pw.length() == 0) {
						System.out.println("아이디/비밀번호를 입력해주세요");
					}else {
						vo = dao.login(id,pw);
						if(vo == null){
							System.out.println("아이디/비밀번호가 틀립니다.");
						}else {
							System.out.println(vo.getName());
							if (vo.getName().equals("관리자")) {
								dispose();
								System.out.println("로그인 성공!");
								System.out.println("아이디: "+vo.getId()+" 이름: "+vo.getName());
								islogin = true;
								
							}else {
								System.out.println("서버는 관리자만 접속할 수 있습니다.");
							}
						}
					}
				}
			}
			
			
		});
		
		joinb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if (action == "회원가입") {
					new Join();
				}
			}
			
			
		});
		P0.add(logo);
		P0.add(logid);
		P0.add(logpw);
		P0.add(logb);
		P0.add(joinb);
		c.add(P0);
		setVisible(true);
		
		
			
	}
	
	Server(String id){	// 채팅창 프레임
		this.id = id;
		setTitle("서버 채팅창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(0,0);
		
		Container c = getContentPane();
		c.setLayout(null);
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		P1.setBounds(0, 0, 384, 550);
		P1.setLayout(null);
		P2.setBounds(0, 550, 400, 150);
		P2.setLayout(null);
		
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane scr = new JScrollPane(ta);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scr.setBounds(0, 0, 383, 550);
		ta.setBackground(new Color(245,209,183));
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);
        ta.setFont(font);
        
		tf = new JTextField();
		tf.setBounds(0,0,300,110);
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {
					while(true) {
						try {
							String outputMessage = tf.getText();
							ta.append(id+"> "+outputMessage+"\n");
							for (int i=0; i<list.size(); i++) {
								out = new BufferedWriter(new OutputStreamWriter(list.get(i).getOutputStream()));
								out.write(vo.getName()+"> "+outputMessage+"\n");
								out.flush();
							}
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
		
		JButton b = new JButton("전송");
		b.setBackground(Color.YELLOW);
		b.setFont(new Font("돋움체",Font.BOLD,15));
		b.setBounds(300, 0, 84, 110);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if(action == "전송") {
					while(true) {
						try {
							String outputMessage = tf.getText();
							ta.append(id+"> "+outputMessage+"\n");
							for (int i=0; i<list.size(); i++) {
								out = new BufferedWriter(new OutputStreamWriter(list.get(i).getOutputStream()));
								out.write(vo.getName()+"> "+outputMessage+"\n");
								out.flush();
							}
							tf.setText("");
							break;
						}catch(IOException ee) {
							ee.printStackTrace();
						}
					}
				}
			}
			
			
		});
		
		
		P1.add(scr);
		P2.add(tf);
		P2.add(b);
		c.add(P1);
		c.add(P2);
		setVisible(true);
	}
	
	public void getClient() {	// 클라이언트가 접속하면 list에 추가해주고 다시 대기하는 메소드
		try {
			ss = new ServerSocket(9999);
			System.out.println("클라이언트 접속 대기중!");
			ta.append("클라이언트 대기중!\n");
			while(true) {
				System.out.println("무한루프 들어옴");
				socket = ss.accept();
				System.out.println("연결됨!");
				list.add(socket);
				ta.append("클라이언트가 접속하였습니다. "+socket.getInetAddress()+"\n");
				ta.append("접속자 수: "+list.size()+"\n");
				ta.append("접속 클라이언트: "+socket.getPort()+"\n");
				
				GetSend t = new GetSend(socket);
				t.start();
				ta.append("스레드 시작\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			list.remove(socket);
		}
		
	}
	class GetSend extends Thread{
		Socket socket;
		GetSend(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			while(true) {
				ta.append("GetSend run!\n");
				System.out.println("GetSend 시작");
				String line;
				String msg;
				try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				line = in.readLine();
				System.out.println("에게 받은메세지: "+line);
				msg = line+"\n";
				ta.append(msg);
				ta.setCaretPosition(ta.getDocument().getLength());
				
				for(int i=0; i<list.size(); i++) {
					out = new BufferedWriter(new OutputStreamWriter(list.get(i).getOutputStream()));
					out.write(msg);
					out.flush();
					ta.append("전송 완료!\n");
				}
				}catch(Exception e) {
					ta.append(socket.getPort()+"가 나갔습니다.\n");
					list.remove(socket);
					break;
					
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Server();
		System.out.println("연결?"+islogin);
		while(true) {
			System.out.println("무한루프 안");
			if (islogin) {
				s = new Server(vo.getId());
				System.out.println("채팅창을 띄웁니다");
				s.ta.append("아이디: "+vo.getId()+" 이름: "+vo.getName()+"\n");
				s.getClient();
				islogin = false;
			}else {
				continue;
			}
		}
	}
}
