package Jan_24.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //서버 소켓 생성
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            InetSocketAddress localhost = new InetSocketAddress("192.168.1.50",10000);
            serverSocket.bind(localhost);
            System.out.println("<서버 시작>");
            System.out.println("[연결을 기다립니다.]");

            //연결을 기다려 봅니다.
            while (true) {
                Socket socket = serverSocket.accept();
                Thread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        try {
//            serverSocket = new ServerSocket();
//            //주소, 포트 연결
//            InetSocketAddress localhost = new InetSocketAddress("192.168.1.50",10000);
//            serverSocket.bind(localhost);
//
//            System.out.println("<서버 시작>");
//            System.out.println("[연결을 기다립니다.]");
//            //연결 대기
//            Socket socket = serverSocket.accept();
//            //연결 완료 -> 통신 소켓 생성
//
//            //클라이언트 정보 확인
//            InetSocketAddress client = (InetSocketAddress)socket.getRemoteSocketAddress();
//            System.out.println("[SERVER] 클라이언트가 접속");
//            System.out.printf("[SERVER] 클라이언트 IP : %s, 포트 : %d\n",client.getAddress(),client.getPort());
//            //통신 소켓 이용 데이터 송수신
//            //클라이언트 메시지 수신
//            InputStream is = socket.getInputStream();
//            Reader isr = new InputStreamReader(is, "UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//
//            OutputStream os = socket.getOutputStream();
//            Writer osw = new OutputStreamWriter(os, "UTF-8");
//            BufferedWriter bw = new BufferedWriter(osw);
//
//            while(true) {
//                String message = br.readLine();
//
//                if(message == null){
//                    System.out.println("[클라이언트 접속 종료]");
//                    break;
//                }
//                System.out.println("[메시지 수신] " + message);
//
//                //클라이언트로 응답을 보내줍니다.
//                bw.write("ECHO BACK -> " + message);
//                System.out.println("[SERVER] 메시지 에코백 : "+message);
//                bw.newLine();
//                bw.flush();
//
//            }
//
//            br.close();
//            bw.close();
//
//            System.out.println("<서버 종료>");
//
//        } catch (IOException e) {
//            System.out.println("IOException : " + e.getMessage());
//        } finally {
//            try {
//                serverSocket.close();
//            } catch (IOException e) {
//                System.out.println("서버 소켓 닫을 수 없음.");
//            }
//        }
    }
}
