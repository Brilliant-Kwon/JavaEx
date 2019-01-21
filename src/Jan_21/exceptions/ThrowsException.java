package Jan_21.exceptions;

import java.io.IOException;

public class ThrowsException {
    public void executeException() throws IOException {
        System.out.println("강제 예외 발생");
        //강제로 IOException을 발생시켜 외부로 넘겨주기
        throw new IOException("강제 예외");
    }
    public void executeRuntimeException(){
        System.out.println("런타임 예외");
        throw new RuntimeException("RuntimeException" );
    }
}
