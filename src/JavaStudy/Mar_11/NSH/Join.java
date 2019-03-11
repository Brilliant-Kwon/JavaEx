package JavaStudy.Mar_11.NSH;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Join extends JFrame{	
	
	JLabel namel;
	JLabel idl;
	JLabel pwl;
	JTextField namet;
	JTextField idt;
	JPasswordField pwt;
	JButton checkDupl;
	JButton join;
	String dbUser="bituser";
	String dbPass="bituser";
	boolean uniq=false;
	KakaoDaoImpl dao = new KakaoDaoImpl(dbUser, dbPass);
	
	Join(){	// 회원가입 프레임
		setTitle("회원가입 창");
		setSize(380,280);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		
		Container c = getContentPane();
		c.setBackground(new Color(255,225,30));
		
		namel = new JLabel("이름");
		namel.setSize(60, 30);
		namel.setLocation(30, 30);
		namet = new JTextField();
		namet.setBounds(100, 30, 100, 30);
		
		idl = new JLabel("아이디");
		idl.setSize(60, 30);
		idl.setLocation(30, 70);
		idt = new JTextField();
		idt.setBounds(100, 70, 100, 30);
		
		pwl = new JLabel("비밀번호");
		pwl.setSize(60, 30);
		pwl.setLocation(30, 110);
		pwt = new JPasswordField();
		pwt.setBounds(100, 110, 100, 30);
		
		checkDupl = new JButton("중복확인");
		checkDupl.setBounds(230, 70, 90, 30);
		checkDupl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if (action == "중복확인") {
					String id = idt.getText();
					uniq = dao.check(id);
					if(uniq) {
						System.out.println("사용가능");
					}else {
						System.out.println("사용중");
					}
				}
			}
			
			
		});
		
		join = new JButton("가입하기");
		join.setBounds(100, 180, 90, 30);
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if (action == "가입하기") {
					String name = namet.getText();
					String id = idt.getText();
					String pw = pwt.getText();
					if(uniq) {
						KakaoVo vo = new KakaoVo(id,name,pw);
						boolean success = dao.insert(vo);
						if(success) {
							System.out.println("회원가입 완료");
							dispose();
						}else {
							System.out.println("회원가입 실패..");
						}
					}else {
						System.out.println("아이디 중복확인을 해주세요");
					}
					
				}
			}
			
			
		});
		
		
		c.add(namel);
		c.add(idl);
		c.add(pwl);
		c.add(namet);
		c.add(idt);
		c.add(pwt);
		c.add(checkDupl);
		c.add(join);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Join();
	}
}
