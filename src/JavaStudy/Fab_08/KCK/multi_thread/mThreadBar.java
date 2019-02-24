package JavaStudy.Fab_08_Calculator.KCK.multi_thread;

import java.util.Scanner;

class runnerThreadBar implements Runnable {//달리기 주자 쓰레드
    private int number;//주자의 번호

    public runnerThreadBar(int number) {//생성자
        this.number = number;
    }
//
//    public int getNumber() {
//        return number;
//    }

    @Override
    public void run() {
        System.out.println("[ " + number + " 번 주자] 출발");
        int ran = (int) Math.round(Math.random() * 4 + 1); // 달리기 속도를 랜덤하게 해주기 위해 ran에 정수값 1~5 삽입
        for (int i = 1; i <= 10; i++) { //각 쓰레드는 10번 반복한다.
            try {
                Thread.sleep(ran * 200); // 0.2초 * ran 의 속도로 쓰레드를 작동시킴.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("[ " + number + " 번 주자] "); //10미터씩 달리고 있는 것 처럼 출력함.
            for (int k = 0; k < i; k++) {
                if (k % 2 == 0)
                    System.out.print("▷");
                else
                    System.out.print("▶");

                if (k == (i - 1))
                    System.out.println();
            }
        }
        System.out.println("[ " + number + " 번 주자] 결승선 통과!!");


    }
}

public class mThreadBar {//main 쓰레드

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("BIT 배 100미터 달리기 결승 중계");
        System.out.println("=================================");
        System.out.print("1등을 예측하세요 (1~4) : ");
        Scanner sc = new Scanner(System.in);
        int select;
        while (true) {
            select = sc.nextInt();

            if (select >= 1 && select <= 4) {
                break;
            } else {
                System.out.println("1~4 사이의 숫자를 입력하셔야 합니다.\n재입력 (1~4) : ");
            }
        }

        int[] result = {0, 0, 0, 0}; // 최종 순위 저장할 배열 4칸짜리 선언

        Boolean goal_a = false; // result에 a가 들어갔으면 true 안 들어갔으면 false
        Boolean goal_b = false;
        Boolean goal_c = false;
        Boolean goal_d = false;

        Thread a = new Thread(new runnerThreadBar(1));     //주자 1역할을 하는 쓰레드 a ~ 4역할을 하는 쓰레드 d
        Thread b = new Thread(new runnerThreadBar(2));
        Thread c = new Thread(new runnerThreadBar(3));
        Thread d = new Thread(new runnerThreadBar(4));

        a.start();      //쓰레드 시작
        b.start();
        c.start();
        d.start();

        //메인쓰레드가 하는일
        while (true) {
            // a쓰레드가 결승선을 통과해서 종료된 상태 & 순위결과 배열에 기록이 안되어있으면(goal_a = false)
            // for문을 통해 결과 배열을 돌아서 순위를 순차적으로 기록해준다.
            // 기본값이 0이므로 0인 인덱스부터 순서대로 기록
            if (a.getState() == Thread.State.TERMINATED && goal_a == false) {
                for (int i = 0; i < 4; i++) {
                    if (result[i] == 0) {
                        result[i] = 1;
                        goal_a = true;
                        break;
                    }
                }
            }

            if (b.getState() == Thread.State.TERMINATED && goal_b == false) {
                for (int i = 0; i < 4; i++) {
                    if (result[i] == 0) {
                        result[i] = 2;
                        goal_b = true;
                        break;
                    }
                }
            }

            if (c.getState() == Thread.State.TERMINATED && goal_c == false) {
                for (int i = 0; i < 4; i++) {
                    if (result[i] == 0) {
                        result[i] = 3;
                        goal_c = true;
                        break;
                    }
                }
            }

            if (d.getState() == Thread.State.TERMINATED && goal_d == false) {
                for (int i = 0; i < 4; i++) {
                    if (result[i] == 0) {
                        result[i] = 4;
                        goal_d = true;
                        break;
                    }
                }
            }

            if (a.getState() == Thread.State.TERMINATED &&      //쓰레드 4개가 모두 끝났으면 무한 루프 탈출
                    b.getState() == Thread.State.TERMINATED &&
                    c.getState() == Thread.State.TERMINATED &&
                    d.getState() == Thread.State.TERMINATED &&
                    result[3] != 0) {
                break;
            }


        }

        System.out.println("경기 종료.\n결과 발표!\n");

        for (int i = 0; i < 4; i++) {
            System.out.println(i + 1 + "등 : " + result[i]);
        }

        if (result[0] == select)
            System.out.println("1등을 맞히셨군요.\n로또사러 가세요.^^");
        else
            System.out.println("예측에 실패하셨습니다.\n아쉽지만 도박에는 소질이 없어 보이시네요 ^_^.. ");


    }
}
