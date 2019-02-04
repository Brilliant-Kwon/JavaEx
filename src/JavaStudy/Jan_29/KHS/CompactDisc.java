package JavaStudy.Jan_29.KHS;

import java.util.Scanner;

public class CompactDisc extends Product{
	public String album_title;	//	앨범 제목
	public String singer;	//	가수 이름
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void add() {
		super.add();	
		System.out.print("앨범 제목");
		album_title = sc.nextLine();
		singer = sc.nextLine();
		sc.close();
	}
	
	
}
