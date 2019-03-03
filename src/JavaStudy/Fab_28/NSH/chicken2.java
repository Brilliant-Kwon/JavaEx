package JavaStudy.Fab_28.NSH;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class chicken2 extends JFrame implements KeyListener{
	/*
	 * 미사일 발사 게임.
	 * enter키를 입력받아 총알을 발사
	 * 닭, 미사일은 20ms당 5픽셀 움직임
	 * 닭이 오른쪽을 벗어나면 다시 왼쪽에서 시작
	 * 명중 or 실패해야 다음 발사 가능
	 * 
	 * 
	 * 해야할 일
	 * 1. Frame 생성하여 발사대, 미사일, 치킨 label 부착
	 * 2. 미사일, 치킨 쓰레드 생성하여 run하면 움직여줌
	 * 3. Key event를 발생하여 enter입력시 미사일, 치킨이 움직이게 함 (enter누르면 run 실행하게?)
	 * 4. 미사일, 치킨의 좌표가 겹친다면 명중하였습니다 띄우고 종료
	 * 5. 미사일이 치킨을 맞추지 못하고 화면 끝까지 가면 실패하고 종료
	 * 6. 종료해야 다음 발사할 수 있게
	 *  
	 * 
	 */
	ImageIcon image1 = new ImageIcon("D:\\javastudy\\chicken.png");
	JLabel chi = new JLabel(image1);
	int x=0;	// 치킨 x좌표
	JLabel mi = new JLabel();
	int mi_x = 195;
	int mi_y = 410;	//	미사일의 x,y좌표 초기값
	boolean failed = false;
	boolean hit = false;
	boolean miReady = true;	//	미사일이 날아가고 있을 때는 쏘지 못하게 미사일 준비 플래그
	
	
	chicken2(){	// frame 생성자로 frame 생성
		
		setTitle("미사일 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		Dimension fSize = getSize();
		System.out.println(fSize);
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(sSize);
		setLocation((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2 );
//		setLocationRelativeTo(null);	//이거 해주면 위에 과정없이 바로 가운데 정렬해줌
		setResizable(false);	//	사이즈 변경 불가
		setVisible(true);
		
		// 배경색 오렌지색으로 지정하고 배치관리자는 null로 설정 (Label들을 setLocation으로 직접 지정해줌)
		Container c = getContentPane();
		c.setBackground(Color.ORANGE);
		c.setLayout(null);
		
		// 발사대 Label 설정
		JLabel L1 = new JLabel("발사대");
		L1.setBackground(Color.BLACK);
		L1.setForeground(Color.WHITE);
		L1.setOpaque(true);	//	label 불투명도
		L1.setSize(40,40);
		L1.setLocation(180,420);
		c.add(L1);
		
		// 미사일 Label 설정
		mi.setBackground(Color.RED);
		mi.setOpaque(true);
		mi.setSize(10,10);
		mi.setLocation(mi_x, mi_y);
		mi.addKeyListener(this);
		c.add(mi);
		
		// 치킨 Label 설정
		chi.setOpaque(true);
		chi.setSize(50,50);
		chi.setLocation(0,0);
		c.add(chi);
		
		// 치킨 쓰레드 객체 생성하고 실행
		chickenThread chith = new chickenThread(chi);
		Thread chithTh=new Thread(chith);
		chithTh.start();	//	실행하자마자 치킨은 바로 움직임
		
		addKeyListener(this);	// ★★★ 이벤트리스너 부착을 어디다 해야하는지????????
		
	}
	
	class misileThread implements Runnable{	//	미사일 쓰레드
//		JLabel mii;		// ★★★여기에 있는 mii와 위의 mi의 관계???? -> 생성자 만들기 위해서?
//
//		misileThread(JLabel mi){
//			this.mii=mi;
//		}
		
		@Override
		public void run() {
				while(true) {
						mi.setLocation(mi_x, mi_y);
						mi_y -= 10;
						if (mi_y < 0) {
							System.out.println("미사일 위치: "+mi_y);
							mi.setLocation(mi_x, mi_y);
							failed = true;	//	미사일의 y좌표가 0보다 작아지면 실패!
							mi_x = 195;
							mi_y = 410;		// ★★★이것보다 쉬운 방법 있는지???
							miReady = true;	// 다시 미사일 초기좌표 설정해주고 미사일 준비완료
							break;
						}
						if (0 <= mi_y & mi_y <= 40) {
							if (x <= mi_x & mi_x <= x+50) {
								hit = true;	// 치킨안에 좌표가 들어가면 명중!
								mi_x = 195;
								mi_y = 410;
								miReady = true;	// 미사일 초기좌표 설정해주고 마시일 준비완료
								break;
							}
						}
						System.out.println("미사일 위치: "+mi_y);
						
						try {
							Thread.sleep(30);
						}catch (Exception e) {}
				}
			}
		
	}
	class chickenThread implements Runnable{
		JLabel chi;
		chickenThread(JLabel chi){
			this.chi=chi;
		}
		@Override
		public void run() {

			while(true) {
				chi.setLocation(x, chi.getY());
				x+=5;
				if (x>400) {
					x = 0;
					chi.setText("");
				}
				if (hit) {
					chi.setText("명중!!!");
					x = 0;
					break;
				}else if(failed) {
					chi.setText("ㅋㅋㅋ");
				}
				try {
					Thread.sleep(100);
				}catch(Exception e) {}

			}
		}

	}

	
	public static void main(String[] args) {
		new chicken2();
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10 & miReady) {	// 입력받은 키가 enter이고 미사일이 준비됐을 때 실행
			System.out.println("발사!");
			misileThread mith = new misileThread();
			Thread mithTh=new Thread(mith);
			chickenThread chith = new chickenThread(chi);
			Thread chithTh=new Thread(chith);
			if (miReady) {
				mithTh.start();
				miReady = false;
			}
			if (hit) {	
				chithTh.start();
				hit = false;
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
