package JavaStudy.Fab_17.NSH;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCal extends JFrame implements ActionListener{
	JTextField T1;
	JButton Button[] = new JButton[16];
	JPanel P1,P2;
	int num,temp,result;
	String oper, next = "";
	
	MyCal(){
		setTitle("My Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		T1 = new JTextField("",15);
		P1 = new JPanel();
		P2 = new JPanel();
		
		P1.setLayout(new BorderLayout());
		P2.setLayout(new GridLayout(4,4,10,10));
		
		P1.add(T1);
		String btnVal[] = {"7","8","9","+","4","5","6","-","1","2","3","*","C","0","=","/"};
		for (int i=0; i<=15; i++) {
			Button[i] = new JButton(btnVal[i]);
			P2.add(Button[i]);
			Button[i].addActionListener(this);
		}
		
		add("North",P1);
		add("South",P2);
		
		setSize(300,400);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		
		if(input.equals("+")) {
			num = temp;
			oper = "+";
			next = "";
		}else if(input.equals("-")) {
			num = temp;
			oper = "-";
			next = "";
		}else if(input.equals("*")) {
			num = temp;
			oper = "*";
			next = "";
		}else if(input.equals("/")) {
			num = temp;
			oper = "/";
			next = "";
		}else if(input.equals("C")) {
			next = "";
			temp = 0;
			num = 0;
			T1.setText("0");
		}else if(input.equals("=")){
			if (oper.equals("+")) {
				result = num+temp;
				temp = result;
				T1.setText(String.valueOf(result));
			}else if (oper.equals("-")) {
				result = num-temp;
				temp = result;
				T1.setText(String.valueOf(result));
			}else if (oper.equals("*")) {
				result = num*temp;
				temp = result;
				T1.setText(String.valueOf(result));
			}else if (oper.equals("/")) {
				result = num/temp;
				temp = result;
				T1.setText(String.valueOf(result));
			}
			
		}else {
			next += e.getActionCommand();
			T1.setText(next);
			temp = Integer.parseInt(next);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new MyCal();
	}
}
