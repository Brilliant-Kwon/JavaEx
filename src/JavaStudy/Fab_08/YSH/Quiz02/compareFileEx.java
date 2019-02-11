package JavaStudy.Fab_08.YSH.Quiz02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class compareFileEx {
	
	public static void main(String[] args) {
	try {	
		boolean equ=true;
		//t1.txt 파일 읽어들이기위해 Input 스트림열기  
		FileInputStream fin=new FileInputStream("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\YSH\\t1.txt");
		FileInputStream fin2=new FileInputStream("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\YSH\\t2.txt");
		
		int byte1,byte2;
		
		while((byte1=fin.read())!=-1) {
			byte2=fin2.read();
			if(byte1!=byte2) {
//				System.out.println("두파일은다릅니다.");
				equ=false;
				System.out.println(byte1 +"  "+byte2);
				break;
			}
			else
				System.out.print(byte1 +"  "+byte2);
			System.out.println();
		}
		if(equ==true) {
			System.out.println("두파일은 같습니다.");
		}else
			System.out.println("두파일은 다릅니다.");
		
		
		
		fin.close();
		fin2.close();
	}catch (FileNotFoundException e) {
		System.out.println("파일없음");
	}catch(IOException e) {
		System.out.println("IOException:"+e.getMessage());
	}
}
}
