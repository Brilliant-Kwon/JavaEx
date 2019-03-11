package JavaStudy.Mar_11.YSH;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class Login extends JFrame{
	JPanel jp=new JPanel();
	JButton jb1=new JButton("확인");
	JButton jb2=new JButton("회원가입");
	JLabel la1=new JLabel("아이디:");
	JLabel la2=new JLabel("비밀번호:");
	JTextField jt1=new JTextField();
	JTextField jt2=new JTextField();
	ServerThread sth;
	ClientThread cth;
	Login(){
		setContentPane(jp);
		setTitle("채팅 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		jp.add(la1);
		jp.add(jt1);
		jp.add(la2);
		jp.add(jt2);
		jp.add(jb1);
		jp.add(jb2);
		jb2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("회원가입");
				Login f=new Login();
			}
		});
		jb1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JButton btn=(JButton) e.getSource();
				System.out.println("확인");
				System.out.println(jt1.getText());
				if(jt1.getText().equals("admin")) {
					sth=new ServerThread();
					sth.start();
					System.out.println(jt1.getText());
					System.out.println("서버시작");
//					server.setVisible(true);
				}else {
					cth=new ClientThread();
					cth.start();
					System.out.println(jt1.getText());
					System.out.println(jt1.getText()+"클라이언트 시작");
				}
			}
		});
		setSize(500,500);
		setVisible(true);
	}
	class ServerThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			new ServerEx();
		}
		
	}
	class ClientThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			new ClientEx(jt1.getText());
		}
		
	}
	public static void main(String[] args) {
		Login login=new Login();
	}
}

