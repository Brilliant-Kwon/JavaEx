package JavaStudy.Fab_28.YSH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EnterShooting extends JFrame {
    ImageIcon imageMe = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\airplane2.png");
    ImageIcon imageMisile = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\misile2.png");
    ImageIcon imageMon = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\monster2.png");

    JLabel na = new JLabel(imageMe);
    JLabel misile = new JLabel(imageMisile);
    JLabel monster = new JLabel(imageMon);
    JPanel contentPane = new JPanel();
    ThreadByMonster runMon = new ThreadByMonster();
    ThreadByMisile runMi = new ThreadByMisile(misile, monster);
    Thread tm = new Thread(runMon);

    //   Thread tmi=new Thread(runMi);
    ////////////해당레이블에이미지 연결
    public EnterShooting() {
        setTitle("엔터슈팅");
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        contentPane.addKeyListener(new MyKeyListener());
        contentPane.add(na);
        contentPane.add(monster);
        contentPane.add(misile);
        na.setSize(50, 50);
        monster.setSize(70, 70);
        misile.setSize(20, 50);
        na.setLocation(200, 400);
        misile.setLocation(215, 350);

        tm.start();

        setSize(500, 500);
        setVisible(true);
        contentPane.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            Thread tmi = new Thread(runMi);
            if (keyCode == 10) {
                System.out.println("엔터");
                tmi.start();
                System.out.println("미사일 스레드 시작");
                System.out.println(misile.getX() + "," + misile.getY());

            }
        }
    }

    class ThreadByMonster extends JFrame implements Runnable {
        boolean flag = true;

        @Override
        public void run() {
            // TODO Auto-generated method stub
            int n = 0;
            while (true) { //x 좌표값이 0~420까지 몬스터가 왔다갔다 하게 만들었음.
                System.out.println("몬스터:" + monster.getX() + "," + monster.getY());
                if (flag == true && (monster.isVisible() == true)) //(좌표가(0,0)일때의 조건이랑 미사일이랑 안맞았을때
                {
                    if (monster.isVisible() == false) { /// 몬스터가 미사일이랑 맞았을때 visible 값을 false로 줬음 ,오른쪽으로가는도중에 미사일맞았을때
                        n = 0;
                        monster.setLocation(0, 0); //
                        try {
                            Thread.sleep(500);
//                       monster.setVisible(true);
                        } catch (InterruptedException e) {
                            // TODO: handle exception
                            return;
                        }
                    }
                    monster.setLocation(n, monster.getY());
                    n += 10;   //=>진행방향 오른쪽
                    if (n == 420) {
                        flag = false;
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        return;
                    }
                } else if (flag == false && (monster.isVisible() == true))  //왼쪽으로 가는
                {
                    if (monster.isVisible() == false) { //왼쪽으로 가다가 몬스터가미사일이랑 맞았을때
                        //다시원위치에서 (0,0)에서 오른쪽으로 가야하기때문에
                        n = 0;
                        monster.setLocation(0, 0);  //미사일 쓰레드에서는 단순히 몬스터의 visible의 true false 만 구분해주었다.

                    }
                    System.out.println(flag);
                    if (flag == false) {     //위에서도 false 인걸 확인했지만 이조건을 안넣어주면 왼쪽으로 진행하다가 미사일맞았을때 0,0위치로 옮겨진뒤 계속해서 왼쪽으로간다.
                        monster.setLocation(n, monster.getY());
                        n -= 10;  //<==진행방향이 왼쪽
                    }

                    if (n == 0) {  //다시 좌표가 (0,0이 되었을때)->여기서 flag값 바뀌고 몬스터는 다시 오른쪽으로 진행
                        flag = true;
                    }
                    //               System.out.println(n);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        return;
                    }


                } else {
                    System.out.println("맞았다.");
                    flag = true;
                    monster.setLocation(0, 0);
                    n = 0;
                    monster.setVisible(true);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new EnterShooting();
    }
}