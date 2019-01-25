package Jan_24.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class inetAddressEx {
    public static void main(String[] args) {
        printServerIP("www.naver.com");
        printServerIP("www.google.com");
    }

    private static void printServerIP(String hostName){

        try {
            //내 ip 주소 확인
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Local IP : "+localhost.getHostAddress());

            //서버 IP를 확인
            InetAddress[] adrs = InetAddress.getAllByName(hostName);
            for (InetAddress remote : adrs) {
                System.out.printf("host : %s -> %s\n",hostName,remote.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("해당 호스트 없음 : "+e.getMessage());
        }


    }
}
