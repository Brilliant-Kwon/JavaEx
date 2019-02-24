package JavaStudy.Fab_08_Calculator.YSH.multhEx;
import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable{
	JLabel timerLabel;
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel=timerLabel;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n)+timerLabel.getLocation());
			n++;
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
		}
	}
}
public class RunnableTimerEx extends JFrame{
	public RunnableTimerEx() {
		setTitle("RunnableTimer Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel=new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th=new Thread(runnable);
		c.add(timerLabel);
		setSize(200,200);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new RunnableTimerEx();
	}
}
