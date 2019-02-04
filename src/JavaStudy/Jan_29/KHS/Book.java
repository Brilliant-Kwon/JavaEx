package JavaStudy.Jan_29.KHS;

import java.util.Scanner;

public class Book extends Product{
	public String ISBN;	//	ISBN번호
	public String author;	//	저자
	public String book_title;	//	책 제목
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void add() {
		super.add();
		System.out.print("책 제목>>");
		book_title = sc.nextLine();		
		System.out.print("저자>>");
		author = sc.nextLine();		
		System.out.print("ISBN>>");
		ISBN = sc.nextLine();	
		sc.close();
	}
	
	
}
