package JavaStudy.Mar_08.NSH;
import java.awt.BorderLayout;
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

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestServer extends JFrame{
	
	JTextArea ta;
	JTextField tf;
	ServerSocket ss = null;
	Socket socket = null;
	List<Socket> list = new ArrayList<>();
	BufferedReader in = null;
	BufferedWriter out = null;
			
	TestServer(){
		setTitle("서버 채팅창");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
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
					ta.append(tf.getText()+"\n");
					tf.setText("");
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
	
	public void getClient() {	// 클라이언트가 접속하면 list에 추가해주고 다시 대기하는 메소드
		try {
			ss = new ServerSocket(9999);
			System.out.println("클라이언트 접속 대기중!");
			while(true) {
				socket = ss.accept();
				System.out.println("연결됨!");
				list.add(socket);
				ta.append("클라이언트가 접속하였습니다."+socket.getInetAddress()+"\n");
				ta.append("접속자 수: "+list.size()+"\n");
				ta.append("접속 클라이언트: "+socket.getPort()+"\n");
				
				GetSend t = new GetSend(socket);
				t.start();
				ta.append("스레드 시작ㅋㅋ\n");
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
				String line;
				String msg;
				try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				line = in.readLine();
				msg = socket.getPort()+"> "+line+"\n";
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
		TestServer ts = new TestServer();
		ts.getClient();
	}

}
