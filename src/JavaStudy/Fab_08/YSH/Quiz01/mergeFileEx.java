package JavaStudy.Fab_08_Calculator.YSH.Quiz01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class mergeFileEx {
	
	
	public static void main(String[] args) {
		try {
			String line;
			String line2;
			ArrayList<String> arr=new ArrayList<>();
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\YSH\\t1.txt"));
			BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\YSH\\t2.txt"));
			//t1.txt 파일 읽어들이기위해 Input 스트림열기  
			
			File file=new File("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_08\\YSH\\t3.txt"); //새로운파일 생성
			//t3 텍스트 파일로의 출력을 위해서 DataOutputStream을 연결
			OutputStream fos=new FileOutputStream(file);
			DataOutputStream dos=new DataOutputStream(fos);
			
			while((line=in.readLine())!=null) {  //첫번째 파일에서 가져온 문자열 arr에 저장 
				arr.add(line);
			}
			while((line2=in2.readLine())!=null) { //두번째 파일에서 가져온 문자열 arr에 저장 
				arr.add(line2);
			}
			for(int i=0;i<arr.size();i++) {
				dos.writeUTF(arr.get(i));
				System.out.println("세번째 파일에"+(i+1)+"번째줄 문자열 들어간다~");
			}
			
			in.close();
			in2.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다:"+e.getMessage());
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("입출력 오류:"+e.getMessage());
		}
	}
}
