package JavaStudy.Jan_29.KHS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
	public int num;	//	각 상품의 고유한 식별자
	public String content;	//	상품 설명
	public String producer;	//	생산자
	public int price;	//	가격 정보
	
	Scanner sc = new Scanner(System.in);
		
	public void add() {
		num = 0;
		System.out.print("상품 설명>>");
		content = sc.nextLine();
		System.out.print("생산자>>");
		producer = sc.nextLine();
		try{
			System.out.print("가격>>");
			price = sc.nextInt();
			num++;
		}
		catch(InputMismatchException e)
		{
			e.getMessage();
		}
	}
	
	public void list() {
		System.out.print("상품 ID>>");
		num = sc.nextInt();
		
		
	}
}

