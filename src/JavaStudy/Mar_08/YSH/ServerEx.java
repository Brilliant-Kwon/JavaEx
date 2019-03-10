package JavaStudy.Mar_08.YSH;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//멀티접속 (o)
//클라이언트들이 보낸 메세지들 서버에서 보여주기(o)
//서버에서 클라이언트들에게 메세지들 뿌려주기(x)->서버에서 보내면 한쪽으로만 출력이되고있는중
//회원가입(x)
//로그인(x)
//로그인한아이디로 채팅(x)

public class ServerEx extends JFrame {
   JPanel jp=new JPanel();
   BufferedReader in=null;
   BufferedWriter out=null;
   ServerSocket listener=null;
   Socket socket=null;
   JTextField tf=new JTextField(61);
   JTextArea sp=new JTextArea(17,61);
   JScrollPane js=new JScrollPane(sp);
   String outputMessage;
   String inputMessage;
   SenderThread sth;
   ReceiverThread rth;
   ArrayList<Socket> clientsSockets= new ArrayList<>(); // 소켓들 생성될때마다  소켓들을 넣어주는 ArrayList 
   ArrayList<BufferedWriter> outM=new ArrayList<>();
   ArrayList<String> inM=new ArrayList<>();
//   ArrayList<BufferedWriter> out = new ArrayList<>();//각 클라이언트들로 뿌려주기위한 BuffferedWriter형 out만들기 
   int num=0;
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
		   while(true) {
//			   socket=listener.accept();//클라이언트로부터 연결 요청 대기 
			   clientsSockets.add(listener.accept());   
			   System.out.println("["+clientsSockets.get(num).getInetAddress()+"]"+num+"번째 클라이언트가"+"["+clientsSockets.get(num).getPort()+"]"+"로 연결됨");
			   sp.append("["+clientsSockets.get(num).getInetAddress()+"]"+num+"번째클라이언트가"+"["+clientsSockets.get(num).getPort()+"]"+"로 연결됨\n");
			   sth=new SenderThread(clientsSockets.get(num)); //각클라이언트들로의 센더 스레드 
			   rth=new ReceiverThread(clientsSockets.get(num));//각클라이언트들로부터 받는 리시버 스레드 
			   rth.start();
			   sth.start();
			   num++;
		   }
		   
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }//서버소켓생성
   }
   class SendAllMessage{
	   ArrayList<Socket> clientsSockets;
	   SendAllMessage(ArrayList<Socket> clientsSockets){
		   this.clientsSockets=clientsSockets;
	   }
	   public void sendMessage(){
		   for(int i =0 ; i<clientsSockets.size();i++) {
			   
		   }
	   }
	   
   }
   class SenderThread extends Thread{
	   Socket socket;
	   SenderThread(Socket socket){
		   this.socket=socket;
	   }
	   @Override
	   public void run() {
		   System.out.println("센더스레드");
		   // TODO Auto-generated method stub
		   try { 
			   
				   out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//클라이언트로의 출력스트림
				   outM.add(out);
			    			 
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
	   Socket socket;
	   ReceiverThread(Socket socket){
		   this.socket=socket;
	   }
	   @Override
	   public void run() {
		   System.out.println("리시버스레드");
		   // TODO Auto-generated method stub
//		   String inputMessage;
		   try {
			    while(true) {
			    	
			    	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			    	//클라이언트로부터 입력스트림
			    	inputMessage=in.readLine();   //문자열 읽으면 모든 클라이언트들에게 뿌려주기 
			    	//클라이언트에서 한행의 문자열 읽음 
			    	sp.append(inputMessage+"\n");//서버 채팅방에 붙이기 
			    	sp.setCaretPosition(sp.getDocument().getLength());  // 맨아래로 스크롤한다.

			    	for(int i=0;i<clientsSockets.size();i++) {
			    			
			    			outM.get(i).write(inputMessage+"\n");
				    		//						   System.out.println(outputMessage);
				    		outM.get(i).flush();
	
				    		System.out.println(inputMessage);
			    	}
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
			   sp.setCaretPosition(sp.getDocument().getLength());  // 맨아래로 스크롤한다.

			   try {
				   for(int i=0;i<clientsSockets.size();i++) {
					   outM.get(i).write("["+s+"]"+"["+listener.getInetAddress()+"]"+"서버>"+outputMessage);
//					   System.out.println(outputMessage);
					   outM.get(i).flush();
					   System.out.println(outputMessage);
				   }
			   } catch (IOException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
			   }
			   tf.setText("");
			   outputMessage="";
			   
		   }
	   }
   }
   public static void main(String[] args) {      
    new ServerEx();
   }
}