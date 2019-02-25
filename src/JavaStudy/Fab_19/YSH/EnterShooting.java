package JavaStudy.Fab_19.YSH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnterShooting extends JFrame{
	ImageIcon imageMe=new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\airplane2.png");
	ImageIcon imageMisile=new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\misile2.png");
	ImageIcon imageMon=new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\YSH\\monster2.png");
	JLabel na=new JLabel(imageMe);
	JLabel misile=new JLabel(imageMisile);
	JLabel monster=new JLabel(imageMon);
	JPanel contentPane=new JPanel();
	ThreadByMonster runMon=new ThreadByMonster(monster,misile);
	ThreadByMisile runMi=new ThreadByMisile(misile,monster);
	Thread tm=new Thread(runMon);
	//	Thread tmi=new Thread(runMi);
	////////////해당레이블에이미지 연결 
	public EnterShooting(){
		setTitle("엔터슈팅");
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(na);
		contentPane.add(monster);
		contentPane.add(misile);
		na.setSize(50,50);
		monster.setSize(70,70);
		misile.setSize(20,50);
		na.setLocation(200,400);
		misile.setLocation(215,350);

		tm.start();

		setSize(500,500);
		setVisible(true);
		contentPane.requestFocus();
	}
	class MyKeyListener extends KeyAdapter{
		 public void keyPressed(KeyEvent e) {
			int keyCode=e.getKeyCode();
			Thread tmi=new Thread(runMi);
			Thread.State s=tmi.getState();
			if(keyCode==10) {
					tmi.start();
					System.out.println("미사일 스레드 시작");
		
			}
		}
	}
	
	public static void main(String[] args) {
		new EnterShooting();
	}
}
