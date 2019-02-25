package JavaStudy.Fab_19.NSH;

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

public class chicken extends JFrame implements KeyListener{
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
	int mi_x = 195;
	int mi_y = 410;	//	미사일의 x,y좌표 초기값
	JLabel mi = new JLabel();
	int x=0;	// 치킨 x좌표
	boolean failed = false;
	boolean hit = false;
	boolean miReady = true;
	
	
	chicken(){	// frame 생성자로 frame 생성
		
		setTitle("미사일 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		Dimension fSize = getSize();
		System.out.println(fSize);
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(sSize);
		setLocation((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2 );
//		setLocationRelativeTo(null);	//이거 해주면 위에 과정없이 바로 가운데 정렬해줌
		setResizable(false);
		setVisible(true);
		
		// 배경색 오렌지색으로 지정하고 배치관리자는 null로 설정 (Label들을 setLocation으로 직접 지정해줌)
		Container c = getContentPane();
		c.setBackground(Color.ORANGE);
		c.setLayout(null);
		
		// 발사대 Label 설정
		JLabel L1 = new JLabel("발사대");
		L1.setBackground(Color.BLACK);
		L1.setForeground(Color.WHITE);
		L1.setOpaque(true);
		L1.setSize(40,40);
		L1.setLocation(180,420);
		c.add(L1);
		
		// 미사일 Label 설정
//		JLabel mi = new JLabel();
		mi.setBackground(Color.RED);
		mi.setOpaque(true);
//		int mi_x = 195;
//		int mi_y = 410;	//	미사일의 x,y좌표 초기값
		mi.setSize(10,10);
		mi.setLocation(mi_x, mi_y);
		c.add(mi);
		
		// 치킨 Label 설정
		
		chi.setOpaque(true);
		chi.setSize(50,50);
		chi.setLocation(0,0);
		c.add(chi);
		misileThread mith = new misileThread(mi);
		chickenThread chith = new chickenThread(chi);
		Thread mithTh=new Thread(mith);
		Thread chithTh=new Thread(chith);
		
	
//		mithTh.start();
		chithTh.start();
		
		this.addKeyListener(this);
		setFocusable(true);
		
	}
	
	class misileThread implements Runnable{
		JLabel mi;
		
		misileThread(JLabel mi){
			this.mi=mi;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			mi_x = 195;
			mi_y = 410;
				while(true) {
						mi.setLocation(mi_x, mi_y);
						mi_y -= 10;
						if (mi_y < 0) {
							System.out.println("미사일 위치: "+mi_y);
							mi.setLocation(mi_x, mi_y);
							failed = true;
							mi_x = 195;
							mi_y = 410;
							miReady = true;
							break;
						}
						if (0 <= mi_y & mi_y <= 40) {
							if (x <= mi_x & mi_x <= x+50) {
								hit = true;
								mi_x = 195;
								mi_y = 410;
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
//		int x=0;
		chickenThread(JLabel chi){
			this.chi=chi;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		new chicken();
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			System.out.println("발사!");
			misileThread mith = new misileThread(mi);
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
