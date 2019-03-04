package JavaStudy.Mar_04.KCK.NSH;

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
import java.awt.*;
import javax.swing.*;

public class KakaoClient extends JFrame implements ActionListener, KeyListener{
	JTextField logid;
	JPasswordField logpw;
	static String id="";
	static String pw="";
	
	static JTextArea ta;
	static JTextField tf;
	JButton b;
	JButton login;

	static ServerSocket ss = null;
	static Socket socket = null;
	static BufferedReader in = null;	// 클라이언트로 부터 입력스트림
	static BufferedReader stin = null;	// 키보드로부터 입력스트림
	static BufferedWriter out = null;	// 클라이언트로 출력스트림
	KakaoClient(){
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
						KakaoClient kc = new KakaoClient(id);
						ta.append(id+"님이 서버에 접속하였습니다.\n");
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
	
	KakaoClient(String id){
		this.id = id;
		setTitle("카카오톡 대화창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		P1.setBounds(0, 0, 400, 550);
		P1.setBackground(new Color(0,180,200));
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
		new KakaoClient();
		try {
			socket = new Socket("localhost",9999);
			System.out.println("서버로 접속 성공");
			
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputMessage;
			while(true) {
				inputMessage = in.readLine();
				System.out.println(inputMessage);
				ta.append(inputMessage+"\n\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			
		}
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
			
		}
	
		
	}
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
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
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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
				KakaoClient kc = new KakaoClient(id);
				ta.append(id+"님이 서버에 접속하였습니다.\n");
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
