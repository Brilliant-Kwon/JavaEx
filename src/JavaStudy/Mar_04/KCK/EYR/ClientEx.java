package JavaStudy.Mar_04.KCK.EYR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx {

	public static void main(String[] args) {

		Socket socket = null;
		try {
			// 클라이언트 소켓 생성
			socket = new Socket("localhost", 9999);
			System.out.println("------연결됨------");

			ReceiveThread recThread = new ReceiveThread();
			recThread.setSocket(socket);
			
			SendThread sendThread = new SendThread();
			sendThread.setSocket(socket);
			
			recThread.start();
			sendThread.start();

		}catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
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
