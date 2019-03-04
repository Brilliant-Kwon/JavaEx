package JavaStudy.Mar_04.KCK.YSH;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ServerEx extends JFrame {
   JPanel jp=new JPanel();
   BufferedReader in=null;
   BufferedReader stin=null;
   BufferedWriter out=null;
   ServerSocket listener=null;
   Socket socket=null;
   JTextField tf=new JTextField(61);
   JTextArea sp=new JTextArea(17,61);
   JScrollPane js=new JScrollPane(sp);
   String outputMessage;
   SenderThread sth=new SenderThread();
   ReceiverThread rth=new ReceiverThread();
   ServerEx(){
	   System.out.println("서버실행");
	   sp.append("서버실행\n");
	   setTitle("서버 채팅 방");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setContentPane(jp);
	   jp.setLayout(new FlowLayout());
//	   jp.add(sp);
	   jp.add(js);
	   jp.add(tf);
	   tf.addKeyListener(new MyKeyListener());
	   setSize(700,400);
	   setVisible(true);   
	   tf.requestFocus();
	   try {
		   listener = new ServerSocket(9999);
		   socket=listener.accept();//클라이언트로부터 연결 요청 대기 
		   System.out.println("["+socket.getInetAddress()+"]"+"클라이언트가"+"["+socket.getPort()+"]"+"로 연결됨");
		   sp.append("["+socket.getInetAddress()+"]"+"클라이언트가"+"["+socket.getPort()+"]"+"로 연결됨\n");
		   rth.start();
		   sth.start();
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }//서버소켓생성
   }
   class SenderThread extends Thread{
	   @Override
	   public void run() {
		   System.out.println("센더스레드");
		   // TODO Auto-generated method stub
		   try { 
			   out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//클라이언트로의 출력스트림 			   

		   } catch (IOException e) {
			   try {
					socket.close();
					listener.close();
				   } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				   }
		   }
	   }
   }
   class ReceiverThread extends Thread{
	   @Override
	   public void run() {
		   // TODO Auto-generated method stub
		   String inputMessage;
		   try {
			   in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			   //클라이언트로부터 입력스트림 
			   while(true) {
				   inputMessage=in.readLine();
				   //클라이언트에서 한행의 문자열 읽음 
				   if(inputMessage.equalsIgnoreCase("bye"))
					   //클라이언트가 bye를 보내면 연결종료 
					   break;
				   sp.append(inputMessage+"\n");
				   System.out.println(inputMessage);
				   //클라이언트가 보낸 메시지 화면에 출력 
				   //키보드에서 한행의 문자열 읽음   
			   }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
//			   e.printStackTrace();
			   sp.append("클라이언트가 나갔습니다.\n");
		   }
	   }   

   }
   class MyKeyListener extends KeyAdapter{
	   public void keyPressed(KeyEvent e) {
		   int keyCode=e.getKeyCode();
		   if(keyCode==10) {
			   Calendar cal = Calendar.getInstance( );
			   String s = String.format("%04d-%02d-%02d %02d:%02d:%02d",
			                                 cal.get(Calendar.YEAR),
			                                 (cal.get(Calendar.MONTH) + 1),
			                                 cal.get(Calendar.DAY_OF_MONTH),
			                                 cal.get(Calendar.HOUR_OF_DAY),
			                                 cal.get(Calendar.MINUTE),
			                                 cal.get(Calendar.SECOND)
			                             );

			   outputMessage=tf.getText()+"\n";
			   sp.append("["+s+"]"+"["+listener.getInetAddress()+"]"+"서버>"+outputMessage);
			   js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
			   try {
				   out.write("["+s+"]"+"["+listener.getInetAddress()+"]"+"서버>"+outputMessage);
//				   System.out.println(outputMessage);
				   out.flush();
			   } catch (IOException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
			   }
			   tf.setText("");
			   outputMessage="";
			   System.out.println(outputMessage);
		   }
	   }
   }
   public static void main(String[] args) {      
    new ServerEx();
   }
}