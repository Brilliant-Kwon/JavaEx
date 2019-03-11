package JavaStudy.Mar_11.YSH;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;



public class Form extends JFrame{
	JPanel jp=new JPanel();
	JButton jb1=new JButton("확인");
	JButton jb2=new JButton("취소");
	JLabel la1=new JLabel("아이디:");
	JLabel la2=new JLabel("이름:");
	JLabel la3=new JLabel("비밀번호:");
	JLabel la4=new JLabel("이메일:");
	JTextField jt1=new JTextField();
	JTextField jt2=new JTextField();
	JTextField jt3=new JTextField();
	JTextField jt4=new JTextField();
	Form(){
		setContentPane(jp);
		setTitle("회원가입창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setLayout(new GridLayout(5,2));
		jp.add(la1);
		jp.add(jt1); //아이디 
		jp.add(la2);
		jp.add(jt2); //이름 
		jp.add(la3);
		jp.add(jt3); //비밀번호 
		jp.add(la4);
		jp.add(jt4);
		jp.add(jb1);
		jp.add(jb2);
		jb1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				System.out.println("확인");
				System.out.println(jt1.getText()+ jt2.getText()+ jt3.getText());
				insertUsers(jt1.getText(), jt2.getText(), jt3.getText());
				
			}
		});
		setSize(500,500);
		setVisible(true);
	}
	static void insertUsers(String id,String name, String password) {
		UserDAO dao=new UserDAOImpl();
		UserVo userVo=new UserVo(id, name, password);
		
		boolean success = dao.insert(userVo);
		
		if(success) {
			System.out.printf("%s를 추가했습니다.%n",userVo.getName());
		}else 
			
			System.out.printf("%s를 추가하지 못했습니다.%n",userVo.getName());
	}
	public static void main(String[] args) {
		new Form();
	}
}