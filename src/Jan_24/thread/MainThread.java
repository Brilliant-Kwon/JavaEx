package Jan_24.thread;

//Thread 클래스 상속을 통한 Thread 생성
class DigitThread extends Thread {

    //쓰레드에서 실행할 로직 코드 작성
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("[DigitThread] " + i);

            //쓰레드 지연
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

//Runnable 인터페이스 구현을 통한 Thread
class AlphabetRunnable implements Runnable{
    @Override
    public void run() {
        //쓰레드 로직
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.println("[Alphabet Thread] " + ch);

            //메인 쓰레드 속도 지연
            try {
                Thread.sleep(300); //0.3sec
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class MainThread {
    public static void main(String[] args) {

        //멀티쓰레드
        Thread dThread = new DigitThread(); //NEW
        Thread aThread = new Thread(new AlphabetRunnable());
        Thread anomThread = new Thread(new Runnable() {//익명클래스 - Run 메서드를 직접 즉석에서 정의하여 사용 가능하다.
            //재사용할 필요가 없는 인터페이스를 직접 구현한다.
            @Override
            public void run() {
                int total = 0 ;
                for(int i = 1  ; i<100;i++){
                    total += i ;
                    System.out.println("[ANOMTHREAD] "+total);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        anomThread.start();

        //중요한 작업에 우선순위를 부여하고자 할 때 : setPriority
        //보통 기본값 5정도 설정되어 있음.
        dThread.setPriority(Thread.MAX_PRIORITY);
        dThread.setPriority(Thread.MIN_PRIORITY);

        dThread.start();                    //Running
        aThread.start();

        //Working Threads 제어를 위해
        //Working 쓰레드의 흐름을 MainThread 흐름에 합류
        try {
            dThread.join();
            aThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("[Main Thread] 종료");

    }
}
