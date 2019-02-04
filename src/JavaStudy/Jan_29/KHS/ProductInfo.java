package JavaStudy.Jan_29.KHS;

import java.util.Scanner;

public class ProductInfo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1; // 추가, 조회, 끝내기 번호
		int num2; // 상품 종류 번호
		System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3>>>");
		num1 = sc.nextInt();
		while (num1 != 3) {
			if (num1 == 1) {
				System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3>>>");
				num2 = sc.nextInt();
				Product book = new Book();
				Product compactDisc = new CompactDisc();
				Product converSation = new ConversationBook();
				switch (num2) {
				case 1:
					book.add();
					break;
				case 2:
					compactDisc.add();
					break;
				case 3:
					converSation.add();
					break;
				default:
					System.out.print("잘못 입력하였습니다."); break;
				}
			} else if (num1 == 2) {
				Product product = new Product();
				product.list();
			} else if (num1 == 3) {
				System.exit(0);
			} else {
				System.out.print("잘못 입력하였습니다.");
			}
//			sc.close();
		}
	}
}