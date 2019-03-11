package JavaStudy.Mar_11.YSH;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientEx extends JFrame {
   String name;
   JPanel jp=new JPanel();
   BufferedReader in =null;
   BufferedReader stin=null;
   BufferedWriter out=null;
   Socket socket=null;
   JTextField tf=new JTextField(61);
   JTextArea sp=new JTextArea(17,61);
   JScrollPane js=new JScrollPane(sp);
   String outputMessage;
   SenderThread sth=new SenderThread();
   ReceiverThread rth=new ReceiverThread();
   ClientEx(String name){
	   this.name=name;
	   setTitle(name+" 클라이언트 채팅 방");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setContentPane(jp);
	   jp.setLayout(new FlowLayout());
//	   jp.add(sp);
	   jp.add(js);
	   jp.add(tf);
	   tf.addKeyListener(new MyKeyListener());
	   setSize(700,400);
	   setLocation(700,0);
	   setVisible(true);
	   tf.requestFocus();
	   try {
		   socket = new Socket("localhost",9999);
		   sp.append(name+" 클라이언트>서버에 접속했습니다.\n");
	   } catch (UnknownHostException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }//클라이언트 소켓생성
	   sth.start();
	   rth.start();
   }
   class SenderThread extends Thread{
	   @Override
	   public void run() {
		   try { 
			   out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			   //서버로의 출력스트림
		   }catch (Exception e) {
			   // TODO: handle exception
			   try {
				socket.close();
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
		   try {
			   in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			   //서버로부터의 입력스트림
			   while(true) {
				   String inputMessage = in.readLine();
				   //서버에서 한행의 문자열 읽음 
				   sp.append(inputMessage+"\n");
				   sp.setCaretPosition(sp.getDocument().getLength());  // 맨아래로 스크롤한다.

				   System.out.println(inputMessage);
				   //서버가 보낸 메시지 화면에 출력
			   }
		   }catch (Exception e) {
			   // TODO: handle exception
			   sp.append("서버가 꺼졌습니다.\n");
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
			   sp.setCaretPosition(sp.getDocument().getLength());  // 맨아래로 스크롤한다.

			   try {
				   out.write("["+s+"]"+"["+socket.getInetAddress()+"]"+name+" 클라이언트>"+outputMessage);
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
//   public static void main(String[] args) {
//	   new ClientEx();
//   }
}