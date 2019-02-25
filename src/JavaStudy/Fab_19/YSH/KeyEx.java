package JavaStudy.Fab_19.YSH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KeyEx extends JFrame{
	JPanel contentPane=new JPanel();
	KeyEx()
	{
		setTitle("~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		contentPane.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("-");
			}
			
		});
		setSize(300,200);		
		setVisible(true);
		contentPane.requestFocus();
	}
	public static void main(String[] args) {
		new KeyEx();
	}
}
