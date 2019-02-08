package JavaStudy.Jan_31.NSH;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ݺ��� ��� ������ �����մϴ�.");
//		String[] strArray = new String[5];
//		strArray[0] = "orchard";
//		strArray[1] = "expositor";
//		strArray[2] = "JavaStudy";
//		strArray[3] = "Python";
//		strArray[4] = "eclipse";
//		Random rd = new Random();
//		
//		for (int i=0; i<strArray.length; i++) {
//			int a = rd.nextInt(strArray[i].length());
//			int b = rd.nextInt(strArray[i].length());
//			
//		}
		
		
		String s = "Melon";
		String tmp = s;
		Random rd = new Random();
		
		int a = rd.nextInt(s.length());
		int b = rd.nextInt(s.length());
		while(a==b) {
			b = rd.nextInt(s.length());
		}
		
		for (int i=0; i < s.length(); i++) {
			if (i==a | i==b) {
				System.out.print("_");
			}else {
				System.out.print(s.charAt(i));
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		String stop = null;
		
		while(true) {
	
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">>");
		String ans = sc.next();
		char ch = ans.charAt(0);
		
		if (ch==s.charAt(a)) {
			System.out.println("�¾ҽ��ϴ�.");
			if (cnt1 == 1) {
				System.out.println("�����Դϴ�!\n"+s);
				System.out.println("Next(y/n?)");
				stop = sc.next();
				if (stop.equals("n")) {
					break;
				}else {
					a = rd.nextInt(s.length());
					b = rd.nextInt(s.length());
					while(a==b) {
						b = rd.nextInt(s.length());
					}
					cnt1 = 0;
					cnt2 = 0;
					for (int i=0; i < s.length(); i++) {
						if (i==a | i==b) {
							System.out.print("_");
						}else {
							System.out.print(s.charAt(i));
						}
					}
					continue;
				}
				
			}
			cnt1++;
			for (int i=0; i < s.length(); i++) {
				if (i==b) {
					System.out.print("_");
				}else {
					System.out.print(s.charAt(i));
					
				}
			}
		
		}else if
			(ch==s.charAt(b)){
				System.out.println("�¾ҽ��ϴ�.");
				if (cnt1 == 1) {
					System.out.println("�����Դϴ�!\n"+s);
					System.out.println("Next(y/n?)");
					stop = sc.next();
					if (stop.equals("n")) {
						break;
					}else {
						a = rd.nextInt(s.length());
						b = rd.nextInt(s.length());
						while(a==b) {
							b = rd.nextInt(s.length());
						}
						cnt1 = 0;
						cnt2 = 0;
						for (int i=0; i < s.length(); i++) {
							if (i==a | i==b) {
								System.out.print("_");
							}else {
								System.out.print(s.charAt(i));
							}
						}
						continue;
					}
					
				}
				cnt1++;
				for (int i=0; i < s.length(); i++) {
					if (i==a) {
						System.out.print("_");
					}else {
						System.out.print(s.charAt(i));
					}
				}
		}
			else {
			System.out.println("Ʋ�Ƚ��ϴ�.");
			cnt2++;
			if (cnt2 == 5) {
				System.out.println("5�� Ʋ�Ƚ��ϴ�.\n"+s);
				System.out.println("Next(y/n?)");
				stop = sc.next();
				if (stop.equals("n")) {
					break;
				}else {
					a = rd.nextInt(s.length());
					b = rd.nextInt(s.length());
					while(a==b) {
						b = rd.nextInt(s.length());
					}
					cnt1 = 0;
					cnt2 = 0;
					for (int i=0; i < s.length(); i++) {
						if (i==a | i==b) {
							System.out.print("_");
						}else {
							System.out.print(s.charAt(i));
						}
					}
					continue;
				}
				
			}
			for (int i=0; i < s.length(); i++) {
				if (i==a | i==b) {
					System.out.print("_");
				}else {
					System.out.print(s.charAt(i));
				}
			}
		}
		
	}

}
}

