package JavaStudy.Jan_29.YSH;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
//		Scanner sc=new Scanner(System.in);
		int bookChoice;
		int num;  // 초기메뉴선택 
		int id;      //상품ID
		String proInfo; //상품설명 
		String producer;//생산자
		int price;//가격 
		int isbn;//isbn
		String writer;//저자
		String proName;//상품이름 
		String bookName;//책이름 
		String language;//영어
		String singerName; //가수이름 
		String albumName;
		Product p[]=new Product[10];
		int idNumber=0;
//		ArrayList<Product> arr=new ArrayList();
		for(;;) {
			Scanner sc=new Scanner(System.in);
			System.out.println("상품추가<1>, 모든상품조회<2>, 끝내기<3>  >>>>>");
			num=sc.nextInt();
			if(num==1) {
				Scanner sc1=new Scanner(System.in);
				Scanner sc11=new Scanner(System.in);
				System.out.println("상품 종류 책 <1>, 음악 CD<2>, 회화책<3> >>>>>");
				bookChoice=sc11.nextInt();
				
				if(bookChoice==1) { //책 
					//	int sik, String info, String producer, int price,int isbn,String writer,String bookName
//					System.out.print("상품 ID>>");
//					id=sc1.nextInt();
					id=idNumber;
					System.out.print("상품 설명>>");
					proInfo=sc1.nextLine();
					System.out.print("생산자>>");
					producer=sc1.nextLine();
					System.out.print("가격>>");
					price=sc1.nextInt();
					System.out.print("ISBN>>");
					isbn=sc1.nextInt();
					sc1.nextLine();
					System.out.print("저자>>");
					writer=sc1.nextLine();
					
					System.out.print("책 제목>>");
					bookName=sc1.nextLine();
					p[id]=new Book(id,proInfo,producer,price,isbn,writer,bookName);
					idNumber++;
				}else if(bookChoice==2) { //음악CD
					//(int id, String info, String producer, int price,String albumName,String singerName
//					System.out.print("상품 ID>>");
//					id=sc1.nextInt();
					id=idNumber;
					System.out.print("상품 설명>>");
					proInfo=sc1.nextLine();
					System.out.print("생산자>>");
					producer=sc1.nextLine();
					System.out.print("가격>>");
					price=sc1.nextInt();
					sc1.nextLine();
					System.out.print("앨범>>");
					albumName=sc1.nextLine();
					
					System.out.print("가수>>");
					singerName=sc1.nextLine();
//					Product cpDisc=new CompactDisc(id,proInfo,producer,price,albumName,singerName);
					p[id]=new CompactDisc(id,proInfo,producer,price,albumName,singerName);
					idNumber++;
				}else if(bookChoice==3) { //회화책  int sik, String info, String producer, 
					//				int price, int isbn, String writer,String bookName,String language
//					System.out.println("상품 ID>>");
//					id=sc1.nextInt();
					id=idNumber;
					System.out.print("상품 설명>>");
					proInfo=sc1.nextLine();
					System.out.print("생산자>>");
					producer=sc1.nextLine();
					System.out.print("가격>>");
					price=sc1.nextInt();
					sc1.nextLine();
					System.out.print("책 제목>>");
					bookName=sc1.nextLine();
					System.out.print("저자>>");
					writer=sc1.nextLine();
					sc1.nextLine();
					System.out.print("언어>>");
					language=sc1.nextLine();
					System.out.print("ISBN>>");
					isbn=sc1.nextInt();
//					Product converB=new ConversationBook(id,proInfo,producer,price,isbn,writer,language,bookName);
					p[id]=new ConversationBook(id,proInfo,producer,price,isbn,writer,language,bookName);
					id++;
				}else {
					System.out.println("다시 입력하시오.");
					//				continue;
				}
				System.out.println();

			}else if(num==2) {
				try {
					if(p.length!=0) {
						for(int i=0;i<p.length;i++) {
							p[i].showInfo();
							System.out.println();
						}
					}else
						System.out.println("책이 없습니다.");
				}catch (NullPointerException e) {
					// TODO: handle exception
					continue;
				}
				
			}else if(num==3) {
				break;
			}else {
				System.out.println("다시 입력하시오.");
				//			continue;
			}
		}

	}

}
