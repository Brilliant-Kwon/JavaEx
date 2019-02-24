package JavaStudy.Fab_19.EYR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShootingGame extends JFrame {
    int cnt;
    Thread bulletThread;

    Container con = null;

    ImageIcon starget = null;
    Image btarget = null;
    Image atarget = null;
    ImageIcon targetcon = null;
    JLabel target = null;

    ImageIcon sbullet = null;
    Image bbullet = null;
    Image abullet = null;
    ImageIcon bulletcon = null;
    JLabel bullet = null;

    ImageIcon slauncher = null;
    Image blauncher = null;
    Image alauncher = null;
    ImageIcon launchercon = null;
    JLabel launcher = null;

    public static void main(String[] args) {
        new ShootingGame();
    }

    public ShootingGame() {
        // 프레임 생성 위한 JFrame 상속
        // 키보드 이벤트 처리 위한 KeyListener 상속
        // 쓰레드 돌리기 위한 Runnable 상속
        setTitle("ShootingGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setBackground(Color.white);

        con = getContentPane();
        con.setLayout(null);

//        starget = new ImageIcon("C:\\Users\\yu__r\\Desktop\\엄유리\\Java File\\target.jpg");
        starget = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
        btarget = starget.getImage();
        atarget = btarget.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        targetcon = new ImageIcon(atarget);
        target = new JLabel(targetcon, SwingConstants.LEFT);
        target.setSize(100, 100);
        target.setLocation(0, 0);

        sbullet = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\fried.jpg");
        bbullet = sbullet.getImage();
        abullet = bbullet.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bulletcon = new ImageIcon(abullet);
        bullet = new JLabel(bulletcon, SwingConstants.LEFT);
        bullet.setSize(40, 40);
        bullet.setLocation(220, 500);

        slauncher = new ImageIcon("C:\\Users\\yu__r\\Desktop\\엄유리\\Java File\\launcher.jpg");
        blauncher = slauncher.getImage();
        alauncher = blauncher.getScaledInstance(500, 80, Image.SCALE_SMOOTH);
        launchercon = new ImageIcon(alauncher);
        launcher = new JLabel(launchercon, SwingConstants.LEFT);
        launcher.setSize(500, 80);
        launcher.setLocation(0, 400);

        con.add(target);
        con.add(bullet);
        con.add(launcher);

        Thread targetThread = new Thread(new targetRun());
        targetThread.start();
        System.out.println("타겟이 움직이기 시작.");

        addKeyListener(new KeyAdapter() {                   //엔터키 인식을 위한 키 리스터 지정
            @Override
            public void keyTyped(KeyEvent e) {//키보드 입력
                char keyChar = e.getKeyChar();          //키보드에 입력된 키 값이
                if (keyChar == '\n') {                  //엔터일 경우
                    System.out.println("엔터키 입력.");
                    bullet.setVisible(true);
                    bullet.setLocation(220, 500);

                    bulletThread = new Thread(new bulletRun());
                    bulletThread.start();
                }
            }
        });
    }

    class start implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            if (th.isAlive() == false) {
//                bullet.setVisible(true);
//                bullet.setLocation(220, 500);
//                th.start();
//
//                setTitle("슈팅게임");
//            }
        }
    }

    class targetRun implements Runnable {
        public void run() {
            while (true) {
                try {
                    target.setLocation(target.getX() + 5, target.getY());
                    Thread.sleep(200);


                } catch (InterruptedException e) {
                    System.err.println("Error:" + e.getMessage());
                }
            }
        }
    }

    class bulletRun implements Runnable {
        public void run() {
            while (true) {
                try {
                    bullet.setLocation(bullet.getX(), bullet.getY() - 10);
                    Thread.sleep(200);
                    if (bullet.getY() == -5) {
                        bullet.setVisible(false);
                        bulletThread.interrupt();
                    }
                } catch (InterruptedException e) {
                    System.err.println("Error:" + e.getMessage());
                }
            }
        }


    }

}

