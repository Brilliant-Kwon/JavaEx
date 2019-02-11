package JavaStudy.Fab_08.YSH.multhEx;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
class TimerThread extends Thread{
	JLabel timerLabel;
	Container contentPane;
	public TimerThread(JLabel timerLabel,Container contentPane) {
		this.timerLabel=timerLabel;
		this.contentPane=contentPane;
	}
	public void run() {
		int x;
		int y;
		timerLabel.setSize(80,30);
		contentPane.add(timerLabel);
		while(true) {
			x=((int)(Math.random()*contentPane.getWidth()));
			y=((int)(Math.random()*contentPane.getWidth()));
			
			if((x<300)&&(x>200)&&(y<300)&&(y<200)) {
				timerLabel.setLocation(x, y);
				timerLabel.setText("finish");
				break;
			}else {
				timerLabel.setLocation(x, y);
				timerLabel.setText(timerLabel.getX()+","+timerLabel.getY());
			}
				
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
			
		}
	}
}
public class ThreadTimerEx extends JFrame{
	public ThreadTimerEx() {
		setTitle("ThreadTimerEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(null);
		
		JLabel timerLabel=new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,30));
		JLabel timerLabel2=new JLabel();
		timerLabel2.setFont(new Font("Gothic",Font.ITALIC,30));
		
		setSize(500,500);
		setVisible(true);
		TimerThread th=new TimerThread(timerLabel,c);
		TimerThread th2=new TimerThread(timerLabel2,c);
		th.start();
		th2.start();
	}
	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}
