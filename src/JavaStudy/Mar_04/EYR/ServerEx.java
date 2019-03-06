package JavaStudy.Mar_04.EYR;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
//		BufferedReader in = null;
//		BufferedReader stin = null;
//		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		
		try {
			// 서버 소켓 생성
			listener = new ServerSocket(9999);
			// 클라이언트로부터 연결 요청 대기
			System.out.println("<<연결을 기다립니다>>");
			socket = listener.accept();
			System.out.println("------연결됨------");


			// extends Thread대신 implements Runnable하면
			// setSocket에 오류남
			// start()에서도 오류남


//			Thread recThread = new Thread(new ReceiveThread());
//			recThread.setSocket(socket);
		
			// 이렇게하면 start()는 되는데 setsocket 때문에 작동이 안됨
			
			ReceiveThread recThread = new ReceiveThread();
			recThread.setSocket(socket);
			
			SendThread sendThread = new SendThread();
			sendThread.setSocket(socket);
			
			
			recThread.start();
			sendThread.start();
			
		}catch(IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
}
			
			
//			// 클라이언트로부터의 입력 스트림
//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			// 키보드로부터의 입력 스트림
//			stin = new BufferedReader(new InputStreamReader(System.in));
//			// 클라이언트로의 출력 스트림
//			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			String inputMessage;
//			while(true) {
//				// 클라이언트에서 한행의 문자열 읽음
//				inputMessage = in.readLine();
//				// 클라이언트가 "bye"를 보내면 연결 종료
//				if(inputMessage.equalsIgnoreCase("bye"))
//					break;
//				// 클라이언트가 보낸 메세지 화면에 출력
//				System.out.println("클라이언트>" + inputMessage + "\n");
//				// 키보드에서 한 행의 문자열 읽음
//				String outputMessage = stin.readLine();
//				// 키보드에서 읽은 문자열 전송
//				out.write("서버>" + outputMessage + "\n");
//				out.flush();
//			}
//		}catch(IOException e) {
//			System.err.println("Error:" + e.getMessage());
//		}finally {
//			try {
//				// 클라이언트와 통신용 소켓 닫기
//				socket.close();
//				// 서버 소켓 닫기
//				listener.close();
//			}catch(IOException e) {
//				System.err.println("Error: " + e.getMessage());
//			}
//		}
//
//	}
//
//}
