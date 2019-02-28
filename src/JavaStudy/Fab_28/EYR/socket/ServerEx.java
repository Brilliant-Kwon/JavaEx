package JavaStudy.Fab_28.EYR.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedReader stin = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		
		try {
			// 서버 소켓 생성
			listener = new ServerSocket(9999);
			// 클라이언트로부터 연결 요청 대기
			socket = listener.accept();
			System.out.println("연결됨");
			// 클라이언트로부터의 입력 스트림
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 키보드로부터의 입력 스트림
			stin = new BufferedReader(new InputStreamReader(System.in));
			// 클라이언트로의 출력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String inputMessage;
			while(true) {
				// 클라이언트에서 한행의 문자열 읽음
				inputMessage = in.readLine();
				// 클라이언트가 "bye"를 보내면 연결 종료
				if(inputMessage.equalsIgnoreCase("bye"))
					break;
				// 클라이언트가 보낸 메세지 화면에 출력
				System.out.println(inputMessage);
				// 키보드에서 한 행의 문자열 읽음
				String outputMessage = stin.readLine();
				// 키보드에서 읽은 문자열 전송
				out.write("서버>" + outputMessage + "\n");
				out.flush();
			}
		}catch(IOException e) {
			System.err.println("Error:" + e.getMessage());
		}finally {
			try {
				// 클라이언트와 통신용 소켓 닫기
				socket.close();
				// 서버 소켓 닫기
				listener.close();
			}catch(IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

	}

}
