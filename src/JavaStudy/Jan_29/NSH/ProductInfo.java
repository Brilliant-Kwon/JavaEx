package JavaStudy.Jan_29.NSH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInfo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Product> prolist = new ArrayList<Product>();
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (cnt < 10) {
            System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3>>>");
            int a = sc.nextInt();
            if (a == 1) {
                System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3>>>");
                int b = sc.nextInt();
                if (b == 1) {
                    System.out.print("상품 설명>>");
                    String s1 = sc.next();
                    System.out.print("생산자>>");
                    String s2 = sc.next();
                    System.out.print("가격>>");
                    int price = sc.nextInt();
                    System.out.print("ISBN>>");
                    String s3 = sc.next();
                    System.out.print("저자>>");
                    String s4 = sc.next();
                    System.out.print("책 제목>>");
                    String s5 = sc.next();

                    Product product = new Book("0", s1, s2, price, s3, s4, s5);
                    prolist.add(product);
                } else if (b == 2) {
                    System.out.print("상품 설명>>");
                    String s1 = sc.next();
                    System.out.print("생산자>>");
                    String s2 = sc.next();
                    System.out.print("가격>>");
                    int price = sc.nextInt();
                    System.out.print("앨범 제목>>");
                    String s3 = sc.next();
                    System.out.print("가수>>");
                    String s4 = sc.next();

                    Product product = new CompactDisc("1", s1, s2, price, s3, s4);
                    prolist.add(product);
                } else if (b == 3) {
                    System.out.print("상품 설명>>");
                    String s1 = sc.next();
                    System.out.print("생산자>>");
                    String s2 = sc.next();
                    System.out.print("가격>>");
                    int price = sc.nextInt();
                    System.out.print("ISBN>>");
                    String s3 = sc.next();
                    System.out.print("저자>>");
                    String s4 = sc.next();
                    System.out.print("책 제목>>");
                    String s5 = sc.next();
                    System.out.print("언어>>");
                    String s6 = sc.next();

                    Product product = new ConversationBook("2", s1, s2, price, s3, s4, s5, s6);
                    prolist.add(product);
                } else {
                    System.out.println("다시 입력하세요.");
                }

            } else if (a == 2) {
                for (int i = 0; i < prolist.size(); i++) {
                    prolist.get(i).showInfo();
                }

            } else if (a == 3) {
                break;
            } else {
                System.out.println("다시 입력해주세요");
            }
            cnt++;
        }
        sc.close();


    }

}
