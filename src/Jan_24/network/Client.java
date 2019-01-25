package Jan_24.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            //소켓 생성
            socket = new Socket();
            System.out.println("<클라이언트 시작>");
            System.out.println("[CLIENT] 연결을 요청");

            //서버 정보 소켓으로 연결 시도
//            InetSocketAddress server = new InetSocketAddress("192.168.1.50", 10000);
            InetSocketAddress server = new InetSocketAddress("192.168.1.50", 10000);
            socket.connect(server);
            System.out.println("[서버에 연결되었습니다.]");

            //서버로 메시지 전송
            OutputStream os = socket.getOutputStream();
            Writer osw = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            //서버로부터 응답을 받아서 출력
            InputStream is = socket.getInputStream();
            Reader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            //키보드 입력
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                //메시지 키보드 입력
                String message = keyReader.readLine();

                if(message.equals("/q")){
                    System.out.println("접속을 종료합니다.");
                    break;
                }
                bw.write(message);
                bw.newLine();
                bw.flush();
                System.out.println("[메시지 전송] " + message);

                String recvMsg = br.readLine();
                System.out.println("수신 메시지 : " + recvMsg);


            }

            bw.close();
            br.close();

            //정보 소켓으로 데이터 송수신

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
