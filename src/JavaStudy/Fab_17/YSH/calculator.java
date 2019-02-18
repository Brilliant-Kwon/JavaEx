package JavaStudy.Fab_17.YSH;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 *   계산기 만들기   + , - , x, /    사칙연산되고  c 로 취소 ce 직전 취소  = 결과값계산버튼 (해결)
 *   마우스리스너랑, 키보드 리스너로 입력값받아서 계산하기 (키보드입력하면 너무 길어져서 마우스만해결)
 *   숫자 입력전에 숫자이외의 버튼입력시에 아무 반응 없게 하기(해결) 
 *   0으로 나눌수 없다.(해결)
 *   연산자가 연속으로 두번 나올 수 없다.(해결) 
 *   ->=으로 계산마치고나서 한번더 =누르면 에러
 *   = 으로 결과값 출력후에 연산자를 입력하면 해당 수에 이어서 계산을 진행한다.
 *   = 으로 결과값 출력후에 연산자가아닌 숫자를 입력하면 버퍼랑 temp초기화해주고 새로 계산시작한다.
 */

public class calculator extends JFrame{
	String operator="";
	int temp=0;
	boolean flag=false; // 0일때 연산자먼저안나오게하는 플래그 
	boolean flag2=false; // 연산자 두번연속 못나오게하는 플래그 
	Dimension dim=new Dimension(500,800);
	JPanel cp = new JPanel();
	JPanel jp1 = new JPanel();//화면에 보여주는 패널
	JPanel jp2 = new JPanel();//버튼 보여주는 패널 
	JLabel la1 = new JLabel("0");  // 사용자 입력받는 키 넣어줄 곳  
	StringBuffer sb=new StringBuffer("");
	StringBuffer sbNum=new StringBuffer(""); // 숫자만 받는 sb 
	StringBuffer sbEqual=new StringBuffer();// 이퀄임시저장변수  
	JButton btn[] = new JButton[16];
	calculator(){
		cp.setSize(dim);
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(cp);
		la1.setSize(500,300);
		la1.setVisible(true);
		la1.setFont(new Font("Serif",Font.BOLD,30));
		
		jp2.setLayout(new GridLayout(4,4,3,3)); //버튼 레이아웃하는 부분 
		cp.setLayout(new BorderLayout()); // 두개의 패널 레이아웃하는부분 
		cp.add(jp1,BorderLayout.NORTH);
		cp.add(jp2,BorderLayout.CENTER);
		
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.BLACK);
		jp1.setLayout(new BorderLayout());
		jp1.add(la1,BorderLayout.EAST);
		for(int i=0;i<9;i++) {
			btn[i]=new JButton(Integer.toString(i));
			jp2.add(btn[i]);
			btn[i].setBackground(Color.BLUE);
			btn[i].setFont(new Font("Serif",Font.BOLD,30));
			btn[i].setForeground(Color.white);
			btn[i].addMouseListener(new MyMouseListener());
		}
		btn[9]=new JButton("+");
		btn[9].addMouseListener(new MyMouseListener());
		btn[9].setBackground(Color.GRAY);
		btn[9].setFont(new Font("Serif",Font.BOLD,30));
		btn[10]=new JButton("-");
		btn[10].addMouseListener(new MyMouseListener());
		btn[10].setBackground(Color.GRAY);
		btn[10].setFont(new Font("Serif",Font.BOLD,30));
		btn[11]=new JButton("*");
		btn[11].addMouseListener(new MyMouseListener());
		btn[11].setBackground(Color.GRAY);
		btn[11].setFont(new Font("Serif",Font.BOLD,30));
		btn[12]=new JButton("/");
		btn[12].addMouseListener(new MyMouseListener());
		btn[12].setBackground(Color.GRAY);
		btn[12].setFont(new Font("Serif",Font.BOLD,30));
		btn[13]=new JButton("c");
		btn[13].addMouseListener(new MyMouseListener());
		btn[13].setBackground(Color.GRAY);
		btn[13].setFont(new Font("Serif",Font.BOLD,30));
		btn[14]=new JButton("ce");
		btn[14].addMouseListener(new MyMouseListener());
		btn[14].setBackground(Color.GRAY);
		btn[14].setFont(new Font("Serif",Font.BOLD,30));
		btn[15]=new JButton("=");
		btn[15].addMouseListener(new MyMouseListener());
		btn[15].setBackground(Color.GRAY);
		btn[15].setFont(new Font("Serif",Font.BOLD,30));
		for(int i=9;i<16;i++) {
			jp2.add(btn[i]);
		}
		setSize(500,300);
		setVisible(true);
	}
	class MyMouseListener extends KeyAdapter implements MouseListener{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
		}
		@Override
		public void mouseClicked(MouseEvent e) {

			// TODO Auto-generated method stub
		}
		@Override
		public void mousePressed(MouseEvent e) {   // "="누르면 연산성공해야함 .숫자버퍼 길이가더클때  = 누르면계산 = 입력전 인덱스의값이 기호면 완성되지않은수식이라고출력

			// TODO Auto-generated method stub           수식 두번이상 연달아입력못하게 하기

			JButton b=(JButton)e.getSource();   //눌린버튼이 뭔지 확인해주는 코드 

			for(int i=0;i<16;i++) {   //버튼클릭했을때 해당 버튼 찾아서 색깔 바꾸기위한 반복문 

				if(btn[i].getText().equals(b.getText())) {

					btn[i].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton b=(JButton)e.getSource();
			
			switch(b.getText()) {
			case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
				//입력버튼이 숫자일경우
				if(sbEqual.length()!=0) { // 숫자를입력하기전 연산을한번했었고 그상태에서 숫자를  바로누른다면 연산새로시작이니까  버퍼세개다비워주기  
					sb.delete(0, sb.length());
					sbNum.delete(0, sbNum.length());
					sbEqual.delete(0, sbEqual.length());
				}
				flag=true; //숫자입력받을경우 true로해줌 (처음부터 번호이외의 다른것 눌림방지)
				flag2=true; // 숫자입력받고 나서 연산자입력받을수있게함
				
				sb.append(b.getText());  //화면에 보여주는 스트링 버퍼   
				la1.setText(sb.toString());//화면에 보여주기
				sbNum.append(sb.charAt(sb.length()-1)); // 숫자만넣는 스트링버퍼 sbNum에 넣어주기  (마지막으로입력받는 숫자만 붙여준다. 안그렴1 12 112123이렇게된다.
				System.out.println("sb:"+sb);
				System.out.println("sbNum:"+sbNum);
				System.out.println("operator:"+operator);
				System.out.println("temp:"+temp);
				System.out.println("sbEqual:"+sbEqual);
				b.setBackground(Color.BLUE);
				
				break;
			case "+":
				if((flag==true)&&(sb.length()!=0)&&(sb.charAt(sb.length()-1)!='+')&&(sb.charAt(sb.length()-1)!='-')
						&&(sb.charAt(sb.length()-1)!='*')&&(sb.charAt(sb.length()-1)!='/')&&(sb.charAt(sb.length()-1)!='=')) { //피연산자값이 미리 입력이되지않으면 label 이 바뀌지않음 .
					temp=temp+Integer.parseInt(sbNum.toString()); //+누르는 순간 연산자전에 입력했던 숫자들 temp에 더해준다.
					sbEqual.delete(0, sbEqual.length()); // 한번의 연산이끝나고 또한번연산을할수있게  sbEqual를 비워줘야 두번째연산시에 연산자뒤에 숫자입력시 연산이안되는것을 해결해준다.
					b.setBackground(Color.GRAY);
					sb.append(b.getText()); //sb에 입력버튼 보여주기 
					la1.setText(sb.toString()); //화면에보여주기 
					operator="+";
					System.out.println("sb:"+sb);
					System.out.println("sbNum:"+sbNum);
					System.out.println("operator:"+operator);
					System.out.println("temp:"+temp);
					System.out.println("sbEqual:"+sbEqual);
					sbNum=sbNum.delete(0,sbNum.length());
					operator="";
//					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}

			case "-":
				if((flag==true)&&(sb.length()!=0)&&(sb.charAt(sb.length()-1)!='+')&&(sb.charAt(sb.length()-1)!='-')
						&&(sb.charAt(sb.length()-1)!='*')&&(sb.charAt(sb.length()-1)!='/')&&(sb.charAt(sb.length()-1)!='=')) {
					temp=temp-(-Integer.parseInt(sbNum.toString()));
					sbEqual.delete(0, sbEqual.length());
					b.setBackground(Color.GRAY);
					sb.append(b.getText());
					la1.setText(sb.toString());
					operator="-";
					System.out.println("sb:"+sb);
					System.out.println("sbNum:"+sbNum);
					System.out.println("operator:"+operator);
					System.out.println("temp:"+temp);
					System.out.println("sbEqual:"+sbEqual);
					sbNum=sbNum.delete(0,sbNum.length());
					operator="";
					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
				
			case "*":
				if((flag==true)&&(sb.length()!=0)&&(sb.length()!=0)&&(sb.charAt(sb.length()-1)!='+')&&(sb.charAt(sb.length()-1)!='-')
						&&(sb.charAt(sb.length()-1)!='*')&&(sb.charAt(sb.length()-1)!='/')&&(sb.charAt(sb.length()-1)!='=')) {
					temp=1*Integer.parseInt(sbNum.toString());
					sbEqual.delete(0, sbEqual.length());
					b.setBackground(Color.GRAY);
					sb.append(b.getText());
					operator="*";
					la1.setText(sb.toString());
					System.out.println("sb:"+sb);
					System.out.println("sbNum:"+sbNum);
					System.out.println("operator:"+operator);
					System.out.println("temp:"+temp);
					System.out.println("sbEqual:"+sbEqual);
					sbNum=sbNum.delete(0,sbNum.length());
					operator="";
//					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
				
			case "/":
				if((flag==true)&&(sb.length()!=0)&&(sb.length()!=0)&&(sb.charAt(sb.length()-1)!='+')&&(sb.charAt(sb.length()-1)!='-')
						&&(sb.charAt(sb.length()-1)!='*')&&(sb.charAt(sb.length()-1)!='/')&&(sb.charAt(sb.length()-1)!='=')) {
					temp=Integer.parseInt(sbNum.toString());
					sbEqual.delete(0, sbEqual.length());
					b.setBackground(Color.GRAY);
					sb.append(b.getText());
					operator="/";
					la1.setText(sb.toString());
					System.out.println("sb:"+sb);
					System.out.println("sbNum:"+sbNum);
					System.out.println("operator:"+operator);
					System.out.println("temp:"+temp);
					System.out.println("sbEqual:"+sbEqual);
					sbNum=sbNum.delete(0,sbNum.length());
					operator="";
//					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
					
			case "c": //스트링버퍼에있는 요소들다 지우고 0보여주기 
				if((flag==true)&&(flag2==true)) {
					b.setBackground(Color.GRAY);
					System.out.println("지우기전:"+sb);
					sb=sb.delete(0,sb.length());
					sbNum=sbNum.delete(0, sbNum.length());
					temp=0;
					la1.setText("0");
					flag=false; //다지우고나면 다시 처음부터 시작이기때문에 역시나 번호먼저 눌러주기위해 false 값으로 변경 
//					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					System.out.println("지우고난후:"+sb);
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
				
			case "ce"://직전삭제
				if((flag==true)&&(flag2==true)) {
					b.setBackground(Color.GRAY);
					System.out.println(sb);
					sb=sb.delete(sb.length()-1,sb.length());
					
					if(sb.length()==0) {
						temp=0;
						sbNum=sbNum.delete(0, sbNum.length());
						la1.setText("0");
						flag=false;//마찬가지로 ce로 한개씩지우더라고 다지우면 처음부터시작이라 false값으로변경 
					}else 
						la1.setText(sb.toString());
					
					System.out.println(sb);
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
				
			case "=": 
//				flag=true;// = 누르면 결과값보여주고 처음부터시작이라도 해당결과값을 가진상태로 연산을 이어가기때문에 
//				플래그값을 false로바꾸지않고 그대로 뒀다.
				if((flag==true)&&(sb.length()!=0)&&(sb.charAt(sb.length()-1)!='+')
						&&(sb.charAt(sb.length()-1)!='-')&&(sb.charAt(sb.length()-1)!='*')
						&&(sb.charAt(sb.length()-1)!='/')&&(sb.charAt(sb.length()-1)!='=')
						&&(sb.toString().equals(sbNum.toString())!=true)) { //sb랑 sbNum이달라야 =이눌러진다~~
					//연산한번한상태에서는 sb랑 sbNum이 같기때문 ~~~
					//처음에 연산자가 안눌리기위한조건과 연산자들입력이후에 바로 =이 못입력하도록 하기위한 조건들 
					if(sb.charAt((sb.length()-sbNum.length())-1)=='+') {//피연산자 앞의 연산자가 + 일때
						temp=temp+Integer.parseInt(sbNum.toString());
					}
					if(sb.charAt((sb.length()-sbNum.length())-1)=='-') {//피연산자 앞의 연산자가 - 일때
						temp=temp-Integer.parseInt(sbNum.toString());
					}
					if(sb.charAt((sb.length()-sbNum.length())-1)=='*') {//피연산자 앞의 연산자가 * 일때
						temp=temp*Integer.parseInt(sbNum.toString());
					}
					if(sb.charAt((sb.length()-sbNum.length())-1)=='/') {//피연산자 앞의 연산자가 / 일때
						if(Integer.parseInt(sbNum.toString())!=0) {  //연산자우측에오는 수가 0이면 못나누고 다시입력하게 만듬.
							temp=temp/Integer.parseInt(sbNum.toString());
						}
						else {
							b.setBackground(Color.GRAY);
							la1.setText("0으로는 나눌 수 없습니다.다시하세요.");
							sb=sb.delete(0,sb.length());
							sbNum=sbNum.delete(0, sbNum.length());
							temp=0;
							break;
						}
					}
					sbEqual.append("="); // 이퀄버튼눌렸을때 sbEqual 버퍼에 = 넣어준다.
					b.setBackground(Color.GRAY);
					System.out.println(sb.length());
					sb=sb.delete(0,sb.length());  //연산후 sb 버퍼 비워주기 
					sb.append(temp);  //위에서 연산한 값을 sb에 넣어주고 
					la1.setText(Integer.toString(temp));//연산결과를sb로 출력 
					
					sbNum=sbNum.delete(0, sbNum.length()); //연산후 sbNum에있는 버퍼비워주기  
					sbNum.append(temp); //sbNum에는 예를 들어 1+2= 이후에 3의결과값을 저장해놓았음
					temp=0; //temp초기화 
					System.out.println("sb:"+sb);   //              12+12를 했을때  sb:12
					System.out.println("sbNum:"+sbNum); //          sbNum:12
					System.out.println("operator:"+operator); //    operator:없음
					System.out.println("temp:"+temp);//				temp:0
					System.out.println("sbEqual:"+sbEqual);
//					flag2=false;// 바로연산자또 입력못하게 플래그 2값만 false로바꿔줌 
					break;
				}else {//flag 가 false임 숫자가 먼저 눌리지않았기때문에 바로 스위치 탈출 
					b.setBackground(Color.GRAY);
					break;
				}
				

			}

		}
		@Override
		public void mouseEntered(MouseEvent e) {

			// TODO Auto-generated method stub
		}
		@Override

		public void mouseExited(MouseEvent e) {

			// TODO Auto-generated method stub
		}
	}
}