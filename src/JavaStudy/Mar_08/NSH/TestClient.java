package JavaStudy.Mar_08.NSH;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestClient extends JFrame{

	JTextArea ta;
	JTextField tf;
	Socket socket = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	
	TestClient(){
		setTitle("클라이언트 채팅창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(400,0);
		
		ta = new JTextArea();
		ta.setEditable(false);
		
		setLayout(new BorderLayout());
		tf = new JTextField();
		tf.setSize(400, 100);
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
								out.write(outputMessage+"\n");
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
		add("Center",ta);
		add("South",tf);
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
				e.printStackTrace();
			}finally {
				try {
//					socket.close();
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
			Receive r = new Receive(socket);
			r.start();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClient tc = new TestClient();
		tc.connectServer();
	}

}



