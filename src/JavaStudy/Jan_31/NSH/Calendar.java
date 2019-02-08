package JavaStudy.Jan_31.NSH;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("��, ���� �Է��ϼ���>>");
	String s = sc.nextLine();
	String[] sa = s.split(" ");
	int year = Integer.parseInt(sa[0]);
	int month = Integer.parseInt(sa[1]);
	int total = (year-1)*365 + ((year-1)/4 - (year-1)/100 + (year-1)/400);
	int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	for (int a=0; a<month-1; a++) {
		total += m[a];
	}
	System.out.println("---------------------------------------------------");
	System.out.println("year: "+ year + "\tmonth: " + month);
	System.out.println("���ۿ���: "+(total+1)%7);
	System.out.println("Sun"+"\t"+"Mon"+"\t"+"Tue"+"\t"+"wed"+"\t"+"Thu"+"\t"+"Fri"+"\t"+"Sat");
	int start = (total+1)%7;
	switch (start) {
	case 0:
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 1:
		System.out.print("\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 2:
		System.out.print("\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 3:
		System.out.print("\t\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 4:
		System.out.print("\t\t\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 5:
		System.out.print("\t\t\t\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 6:
		System.out.print("\t\t\t\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
	case 7:
		System.out.print("\t\t\t\t\t\t");
		
		for (int i=1; i<=m[month-1]; i++) {
			System.out.print(i+"\t");
			if ((start+i)%7 == 0) {
			System.out.println();
		}
		}
		System.out.println();
		break;
		
	}
	System.out.println("---------------------------------------------------");
	
}
}