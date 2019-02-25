package JavaStudy.Fab_19.EYR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ShootingGame1 extends JFrame {
    int cnt;
    Thread th;

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

    ImageIcon scrash = null;
    Image bcrash = null;
    Image acrash = null;
    ImageIcon crashcon = null;
    JLabel crash = null;

    public static void main(String[] args) {
        new ShootingGame1();
    }

    public ShootingGame1() {

        setTitle("ShootingGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setBackground(Color.white);

        con = getContentPane();
        con.setLayout(null);

        starget = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
        btarget = starget.getImage();
        atarget = btarget.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        targetcon = new ImageIcon(atarget);
        target = new JLabel(targetcon, SwingConstants.LEFT);
        target.setSize(100, 100);
        target.setLocation(0, 0);

        sbullet = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
        bbullet = sbullet.getImage();
        abullet = bbullet.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bulletcon = new ImageIcon(abullet);
        bullet = new JLabel(bulletcon, SwingConstants.LEFT);
        bullet.setSize(40, 40);
        bullet.setLocation(220, 400);

        slauncher = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
        blauncher = slauncher.getImage();
        alauncher = blauncher.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        launchercon = new ImageIcon(alauncher);
        launcher = new JLabel(launchercon, SwingConstants.LEFT);
        launcher.setSize(100, 100);
        launcher.setLocation(200, 400);

        scrash = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
        bcrash = scrash.getImage();
        acrash = bcrash.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        crashcon = new ImageIcon(acrash);
        crash = new JLabel(crashcon, SwingConstants.LEFT);
        bullet.setSize(100, 100);
        bullet.setLocation(220, 500);


        con.add(target);
        con.add(bullet);
        con.add(launcher);
//        con.add(crash);

        Thread targetrun = new Thread(new TargetThread());
        targetrun.start();


//    class start implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (th.isAlive() == false) {
//                bullet.setVisible(true);
//                bullet.setLocation(220, 500);
//                th.start();
//            }
//        }
//    }
//    	bullet.addKeyListener(new KeyListener() {
//        BulletThread bulletThread = null;
//        @Override
//        public void keyTyped(KeyEvent ke) {
//        }
//
//        @Override
//        public void keyPressed(KeyEvent ke) {
//            if(ke.getKeyChar()==KeyEvent.VK_ENTER){
//                //스레드가 죽어있는 상태인지 확인
//                if(bulletThread==null || !bulletThread.isAlive()){
//                    //sound.play();
//                    //총알로 타겟을 맞췄는지 확인하기 위해 2개의 레이블과 타겟스레드를 넘겨준다.
//                    bulletThread = new BulletThread(bullet,target,targetThread);
//                    bulletThread.start();
//                }
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent ke) {
//        }
//        
//    });
//}


    }


    class TargetThread implements Runnable {
        public void run() {
//            int x;
//            int y;
            while (true) {
                try {
                    target.setLocation(target.getX() + 5, target.getY());
                    Thread.sleep(20);
                    if (target.getX() > 500) {
                        target.setLocation(target.getX() - 5, target.getY());
                        Thread.sleep(20);
                    } else {
                        target.setLocation(target.getX() + 5, target.getY());
                    }

//                    x = target.getX();
//                    y = target.getY();

                    if ((target.getX() <= bullet.getX()) && (bullet.getX() <= target.getX() + 100)
                            && (target.getY() <= bullet.getY()) && (bullet.getY() <= target.getY() + 100)) {
                        target.setVisible(false);
                        con.add(crash);
                        crash.setLocation(target.getX(), target.getY());

                    }


                } catch (InterruptedException e) {
                    System.err.println("Error:" + e.getMessage());
                }
            }
        }
    }

    class BulletThread implements Runnable {
        public void run() {

            while (true) {
                try {
                    bullet.setLocation(bullet.getX(), bullet.getY() - 10);
                    Thread.sleep(200);
                    if (bullet.getY() == -5) {
                        bullet.setVisible(false);
                        th.interrupt();
                    }
                } catch (InterruptedException e) {
                    System.err.println("Error:" + e.getMessage());
                }
            }
        }


    }

}
