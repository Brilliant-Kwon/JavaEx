package JavaStudy.Jan_31.NSH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {
	static List<Phone> plist = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		System.out.println("��ȭ��ȣ ���� ���α׷��� �����մϴ�. ���Ϸ� �������� �ʽ��ϴ�.");
		System.out.println("---------------------------------");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.print("����:0, ����:1, ã��:2, ��ü����:3, ����:4>>");
		int a = sc.nextInt();
		if (a==4) {
			System.out.println("���α׷��� �����մϴ�...");
			break;
		}
		switch (a) {
		case 0:
			add();
			break;
		case 1:
			delete();
			break;
		case 2:
			search();
			break;
		case 3:
			showInfo();
			break;
		default:
			System.out.println("�ٽ� �Է����ּ���.");
			
			
		}
		}
	}
	
	public static void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸�>>");
		String s1 = scanner.nextLine();
		System.out.print("�ּ�>>");
		String s2 = scanner.nextLine();
		System.out.print("��ȭ��ȣ>>");
		String s3 = scanner.nextLine();
		Phone phone = new Phone(s1,s2,s3);
		plist.add(phone);		
		}
	
	public static void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸�>>");
		String s1 = scanner.nextLine();
		for (int i=0; i < plist.size(); i++) {
			if (plist.get(i).getName().equals(s1)) {
				plist.remove(i);
				System.out.println(s1+"�� �����Ǿ����ϴ�.");
			}
		}
	}
	
	public static void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸�>>");
		String s1 = scanner.nextLine();
		for (int i=0; i < plist.size(); i++) {
			if (plist.get(i).getName().contains(s1)){
				System.out.println(plist.get(i).getName()+" "+plist.get(i).getAddress()
						+" "+plist.get(i).getPhonenumber());
				
			}
		}
		
	}
	
	public static void showInfo() {
		for (int i=0; i<plist.size(); i++) {
			System.out.println(plist.get(i).getName()+" "+plist.get(i).getAddress()
					+" "+plist.get(i).getPhonenumber());
		}
	}
	

}
