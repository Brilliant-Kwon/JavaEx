package JavaStudy.Fab_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class missileThread extends JFrame implements Runnable {
    Container container;
    static JLabel missile;
    int miss_y = 440;
//    boolean stop = false;

    public missileThread(JLabel misslabel, Container container) {
        this.container = container;
        this.missile = misslabel;
        this.missile.setSize(20, 20);
        this.missile.setLocation(390, 450);
        this.container.add(this.missile);
    }

    @Override
    public void run() {
        System.out.println("미사일 발사 시작");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            miss_y -= 10;
            missile.setLocation(390, miss_y);
            if (miss_y < -10) {
                break;
            }
        }
//        miss_y = 440;
//        missile.setLocation(390, miss_y);
        System.out.println("미사일 발사 끝");
    }
}

public class Threads extends JFrame implements Runnable {
    Container contentPane = getContentPane();

    JLabel textlabel = new JLabel();
    JLabel rectlabel = new JLabel("나는 탱크다.");
    JLabel missile = new JLabel();

    ImageIcon source = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
    Image before = source.getImage();
    Image after = before.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon chick = new ImageIcon(after);
    JLabel resizedlabel = new JLabel(chick, SwingConstants.LEFT);
    int x = 0;
    int y = 0;

    public Threads() {
        setTitle("사격 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textlabel.setFont(new Font("Consoles", Font.BOLD, 15));
        textlabel.setLocation(350, 130);
        textlabel.setSize(100, 20);

        //나는 탱크다
        rectlabel.setHorizontalAlignment(SwingConstants.CENTER);
        rectlabel.setSize(100, 50);
        rectlabel.setLocation(350, 462);
        rectlabel.setBackground(Color.GREEN);
        rectlabel.setOpaque(true);

        //미사일
        missile.setLocation(390, 450);
        missile.setBackground(Color.red);
        missile.setOpaque(true);

        //닭
        resizedlabel.setLocation(1, 0);
        resizedlabel.setSize(100, 100);

//        contentPane.add(missile);
        contentPane.add(textlabel);
        contentPane.add(rectlabel);
        contentPane.add(resizedlabel);

        contentPane.setBackground(Color.ORANGE);

//        Thread a = new Thread(new chickThread(resizedlabel));
//        a.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {//키보드 입력
                char keyChar = e.getKeyChar();
                if (keyChar == '\n') {
                    //미사일 - 스레드
                    Thread missThread = new Thread(new missileThread(missile, contentPane));
                    if (missThread.getState() == Thread.State.NEW) {
                        System.out.println("엔터키 입력받음.");
                    }
                    missThread.start();
                    for (int i = 0; i < 200000; i++) {
                        if (i % 200 == 0)
                            System.out.println("x : " + missile.getLocation().getX() + "y : " + missile.getLocation().getY());
                    }
                }
            }
        });
        //JFrame 설정
        setSize(800, 550);
        setResizable(false);
        setVisible(true);

    }

    int go = 1; // 닭 움직이는 방향 설정

//    private boolean hit() { // 겹쳤는지 판단 true => 맞음 / false => 안 맞음
////        System.out.println("hit:" + hit() + ", miss : " + missile.getLocation() + ", chick : " + resizedlabel.getLocation());
//
//    }

    //1 : 오른쪽 0 : 왼쪽
    @Override
    public void run() {
        while (true) {
            double miss_x = missile.getLocation().getX();
            double miss_y = missile.getLocation().getY();
            double chick_x = resizedlabel.getLocation().getX();
            double chick_y = resizedlabel.getLocation().getY();
            boolean hit = false;
            System.out.println("chick) x : " + chick_x + "y :" + chick_y);
            System.out.println("miss) x : " + miss_x + "y :" + miss_y);
            if ((miss_x >= chick_x && miss_x <= (chick_x + 100)) && (miss_x + 20) <= (chick_x + 100)) {
                if (miss_y >= chick_y && miss_y <= (chick_y + 100) && (miss_y + 20) <= (chick_y + 100)) {
                    hit = true;
                } else {
                    hit = false;
                }
            } else {
                hit = false;
            }
            //hit 함수 true 이면 제자리로 초기화 + sleep 3초?
            if (hit == true) {
                textlabel.setText("맞췄습니다.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x=0;
                y=0;
                textlabel.setText("");
                resizedlabel.setLocation(x, y);
            }

            if (resizedlabel.getLocation().equals(new Point(700, 0))) {
                go = 0;
            } else if (resizedlabel.getLocation().equals(new Point(0, 0))) {
                go = 1;
            }
            try {
                Thread.sleep(10); // 닭 움직이는 속도
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(resizedlabel.getLocation().toString());
            if (go == 1) {
                x += 5; //닭이 한번에 움직이는 좌표 값
                resizedlabel.setLocation(x, y);
            } else if (go == 0) {
                x -= 5;
                resizedlabel.setLocation(x, y);
            }


        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Threads());
        a.start();
    }

}
