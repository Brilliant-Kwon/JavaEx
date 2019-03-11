package JavaStudy.Mar_11.EYR;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientEx extends JFrame{

	Container con = null;
	JTextField tf = new JTextField();
	JTextArea ta = new JTextArea();
	JButton bt = new JButton();
	JScrollPane sp = null;
	Socket socket;


	public static void main(String[] args) {
		new ClientEx();
	}

	public ClientEx() {

		setTitle("클라이언트 채팅창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = getContentPane();
		setSize(300,440);
		con.setSize(300,440);

		con.setBackground(Color.white);
		setVisible(true);

		setLayout(null);

		sp = new JScrollPane(ta);
		sp.setSize(265,300);
		sp.setLocation(10,10);

		tf.setSize(200,70);
		tf.setLocation(10,320);

		bt = new JButton("전송");
		bt.setSize(60,40);
		bt.setLocation(215,335);

		//		con.add(ta);
		con.add(tf);
		con.add(bt);
		con.add(sp);

		//		
		//tf에 엔터키 입력받는 리스너 붙혀주고 
		//엔터키를 누를때마다
		//Thread sendThread = new Thread(new SendThread(socket, con, tf, ta ,bt, sp));
		//sendThread.start();


		try {
			// 클라이언트 소켓 생성
			socket = new Socket("localhost", 9999);
			ta.append(" -------------------------연결됨-------------------------"+"\n");

			Thread recThread = new Thread(new ReceiveThread(socket, con, tf, ta ,bt, sp));
			//			Thread sendThread = new Thread(new SendThread(socket, con, tf, ta ,bt, sp));

			recThread.start();
			//			sendThread.start();

		}catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}


		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bt){//전송버튼 눌렀을 경우
					//메세지 입력없이 전송버튼만 눌렀을 경우
					if(tf.getText().equals("")){
						return;
					}

					Thread sendThread = new Thread(new SendThread(socket, con, tf, ta ,bt, sp));
					sendThread.start();
//					tf.requestFocus();

				}

			}

		});

		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {


			}

			@Override
			public void keyReleased(KeyEvent ke) {
				if(ke.getKeyChar()==KeyEvent.VK_ENTER) {
					if(tf.getText().equals("")){
						return;
					}else {
						//					System.out.println("엔터");
						//					System.out.println("메인 tf : "+tf.getText());
						Thread sendThread = new Thread(new SendThread(socket, con, tf, ta ,bt, sp));
						sendThread.start();
//						tf.setText("");

//						tf.requestFocus();
					}

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
//		tf.addFocusListener(new FocusAdapter() {
//			public void focusGained(FocusEvent e) {
//				tf.setText("");
//			}
//
//
//		});
	}
}
//			// 서버로부터의 입력 스트림
//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			// 키보드로부터의 입력 스트림
//			stin = new BufferedReader(new InputStreamReader(System.in));
//			// 서버로의 출력 스트림
//			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			
//			String outputMessage;
//			while(true) {
//				// 키보드에서 한 행의 문자열 읽음
//				outputMessage = stin.readLine();
//				// "bye"가 입력되면 메세지 전송 후 연결 종료
//				if(outputMessage.equalsIgnoreCase("bye")) {
//					out.write(outputMessage);
//					out.flush();
//					break;
//				}
//				// 키보드에서 읽은 문자열 전송
//				out.write("클라이언트>" + outputMessage + "\n");
//				out.flush();
//				// 서버에서 한 행의 문자열 읽음
//				String inputMessage = in.readLine();
//				// 서버가 보낸 메세지 화면에 출력
//				System.out.println("서버>" + inputMessage + "\n");
//			}
//		}catch(IOException e) {
//			System.err.println("Error: " + e.getMessage());
//		}finally {
//			try {
//				// 클라이언트 소켓 닫기 
//				socket.close();
//			}catch(IOException e) {
//				System.err.println("Error: " + e.getMessage());
//			}
//		}
//
//	}
//
//}
