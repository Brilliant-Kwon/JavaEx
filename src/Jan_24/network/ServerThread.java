package Jan_24.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
    //필드
    private Socket socket;

    //생성자
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //클라이언트 정보 확인
            InetSocketAddress client = (InetSocketAddress)socket.getRemoteSocketAddress();
            System.out.println("[SERVER] 클라이언트가 접속");
            System.out.printf("[SERVER] 클라이언트 IP : %s, 포트 : %d\n",client.getAddress(),client.getPort());
            //통신 소켓 이용 데이터 송수신
            //클라이언트 메시지 수신
            InputStream is = socket.getInputStream();
            Reader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            Writer osw = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            while(true) {
                String message = br.readLine();

                if(message == null){
                    System.out.println("[클라이언트 접속 종료]");
                    break;
                }
                System.out.println("[메시지 수신] " + message);

                //클라이언트로 응답을 보내줍니다.
                bw.write("ECHO BACK -> " + message);
                System.out.println("[SERVER] 메시지 에코백 : "+message);
                bw.newLine();
                bw.flush();

            }

            br.close();
            bw.close();

            System.out.println("<서버 종료>");

        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        } finally {

        }
    }
}
