package JavaStudy.Mar_11.NSH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame{
	static String id;
	String pw;
	String name;
	JTextField logid;
	JPasswordField logpw;
	JButton logb;
	JButton joinb;
	JTextArea ta;
	JTextField tf;
	JButton b;
	Socket socket = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	String dbUser="bituser";
	String dbPass="bituser";
	KakaoDaoImpl dao = new KakaoDaoImpl(dbUser, dbPass);
	static KakaoVo vo;
	static boolean isconnect = false;
	static Client cc = null;
	
	
	Client(){	// 로그인 프레임
		setTitle("카카오톡 로그인");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(400,0);
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
						vo = dao.login(id, pw);
						if (vo != null) {
							dispose();
							System.out.println("접속 성공!");
							cc = new Client(vo.getId());
							cc.connectServer();
						}else {
							System.out.println("아이디/비밀번호가 틀립니다");
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
	
	Client(String id){	// 채팅창 프레임
		this.id = id;
		setTitle("클라이언트 채팅창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(400,0);
		
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {
					while(true) {
						try {
							String outputMessage = tf.getText();
							out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
							out.write(vo.getName()+"> "+outputMessage+"\n");
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
				// TODO Auto-generated method stub
				
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
							out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
							out.write(vo.getName()+"> "+outputMessage+"\n");
							out.flush();
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
	
	class Receive extends Thread{
		Socket socket;
		Receive(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			ta.append("run합니다~\n");
			try {
				while(true) {
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String inputMessage;
					inputMessage = in.readLine();
					System.out.println(inputMessage);
					ta.append(inputMessage+"\n");
					ta.setCaretPosition(ta.getDocument().getLength());
					
				}
			}catch(IOException e) {
				ta.append("서버가 종료되었습니다.\n");
				System.exit(0);
			}finally {
				try {
					socket.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void connectServer() {
		try {
			socket = new Socket("localhost",9999);
			System.out.println("서버로 접속 성공");
			ta.append("서버에 접속하였습니다. IP:"+socket.getInetAddress()+"\n");
			ta.append("이름: "+vo.getName()+"\n");
			Receive r = new Receive(socket);
			r.start();
			
			
		}catch(IOException e) {
//			e.printStackTrace();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cc = new Client();
	}

}
