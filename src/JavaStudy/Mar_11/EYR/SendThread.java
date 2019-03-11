package JavaStudy.Mar_11.EYR;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendThread extends JFrame implements Runnable{
	BufferedReader in = null;
	BufferedReader stin = null;
	BufferedWriter out = null;
	Socket socket;

	Container con = null;
	JTextField tf = null;
	JTextArea ta  = null;
	JButton bt  = null;
	JScrollPane sp = null;



	public SendThread(Socket socket) throws HeadlessException {
		super();
		this.socket = socket;
	}


	public SendThread(Socket socket, Container con, JTextField tf, JTextArea ta, JButton bt, JScrollPane sp)
			throws HeadlessException {
		super();
		this.socket = socket;
		this.con = con;
		this.tf = tf;
		this.ta = ta;
		this.bt = bt;
		this.sp = sp;
	}


	//run안에서 무한반복 없애주고
	//String message = tf.getText();
	//message를 out.write로 상대방에게 넘겨준다.


	@Override
	public void run() {
		try {
			if(socket!=null) {
				System.out.println("소켓 연결됨");
			}
//			System.out.println("샌더 시작");
			// 클라이언트로부터의 입력 스트림
			//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//			// 키보드로부터의 입력 스트림
//			stin = new BufferedReader(new InputStreamReader(System.in));
			//			// 클라이언트로의 출력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//			String inputMessage;

			//				// 클라이언트에서 한행의 문자열 읽음
			//				inputMessage = in.readLine();
			//				// 클라이언트가 "bye"를 보내면 연결 종료
			//				if(inputMessage.equalsIgnoreCase("bye"))
			//					break;
			//				// 클라이언트가 보낸 메세지 화면에 출력
			//				System.out.println("클라이언트>" + inputMessage + "\n");
			//				// 키보드에서 한 행의 문자열 읽음
//			String outputMessage = stin.readLine();

			String message = tf.getText();
//			System.out.println("샌더 tf : "+tf.getText());
			ta.append(message+
					"\n");
			//				// 키보드에서 읽은 문자열 전송
			out.write(">" + message + "\n");
			out.flush();
			sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum());
			tf.setText("");

		}catch(IOException e) {
			System.err.println("Error:" + e.getMessage());
		}


		

	}

}
