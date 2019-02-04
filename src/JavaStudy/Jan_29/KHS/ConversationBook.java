package JavaStudy.Jan_29.KHS;

import java.util.Scanner;

public class ConversationBook extends Book{
	public String language;	//	회화책에서 다루는 언어명 정보
	Scanner sc = new Scanner(System.in);

	@Override
	public void add() {
		super.add();	
		System.out.print("언어>>");
		language = sc.nextLine();
		sc.close();
	}
	
	
}
