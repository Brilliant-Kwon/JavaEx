package JavaStudy.Jan_29.Jan_29.product;

import java.util.Scanner;

public class ProductInfo {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("비트서적에 오신 것을 환영합니다.");
        System.out.println("=====================================");

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        int id = 0;
        while (true) {
            System.out.println("메뉴를 고르세요.\n1.상품추가 / 2.전체 상품 조회 / 3.끝내기");
            System.out.print(">>>> ");
            int userChoose = sc.nextInt();
            System.out.println("=====================================");

            switch (userChoose) {
                case 1:
                    products[id] = addProduct(id + 1);
                    id++;
                    break;

                case 2:
                    for (int i = 0; i < 10; i++)
                        if (products[i] != null)
                            products[i].showInfo();
                    break;

                case 3:
                    System.out.println("비트서적을 이용해 주셔서 감사합니다.");
                    break;

                default:
                    System.out.println("잘못 입력하셨어요 다시 입력하세요.");
                    break;
            }

            if (userChoose == 3) {
                break;
            }
        }

    }

    public static Product addProduct(int id) {
        Scanner sc = new Scanner(System.in);
        String introduce;
        String made;
        int price;
        int ISBN;
        String writer;
        String title;
        String albumTitle;
        String singer;
        String language;

        while (true) {
            System.out.println("상품 종류를 고르세요.\n1.책 / 2.음악CD / 3.회화책");
            System.out.print(">>>> ");
            int userChoose = sc.nextInt();
            sc.nextLine();//nextInt 다음 오류 방지용

            switch (userChoose) {
                case 1:
                    //int identifier, String introduce, String made, int price, int ISBN,
                    // String writer, String title
                    System.out.print("책 설명 : ");
                    introduce = sc.nextLine();
                    System.out.print("책 생산자 : ");
                    made = sc.nextLine();
                    System.out.print("책 가격 : ");
                    price = sc.nextInt();
                    System.out.print("책 ISBN : ");
                    ISBN = sc.nextInt();
                    sc.nextLine();//nextInt 다음 오류 방지용
                    System.out.print("책 저자 : ");
                    writer = sc.nextLine();
                    System.out.print("책 제목 : ");
                    title = sc.nextLine();
                    System.out.println("=====================================");
                    return new Book(id, introduce, made, price, ISBN, writer, title);
                case 2:
                    //int identifier, String introduce, String made, int price,
                    //String albumTitle, String singer
                    System.out.print("앨범 설명 : ");
                    introduce = sc.nextLine();
                    System.out.print("앨범 생산자 : ");
                    made = sc.nextLine();
                    System.out.print("앨범 가격 : ");
                    price = sc.nextInt();
                    sc.nextLine();//nextInt 다음 오류 방지용
                    System.out.print("앨범 제목 : ");
                    albumTitle = sc.nextLine();
                    System.out.print("앨범 가수 : ");
                    singer = sc.nextLine();
                    System.out.println("=====================================");
                    return new CompactDisc(id, introduce, made, price, albumTitle, singer);
                case 3:
                    //int identifier, String introduce, String made, int price,
                    //int ISBN, String writer, String title, String language
                    System.out.print("책 설명 : ");
                    introduce = sc.nextLine();
                    System.out.print("책 생산자 : ");
                    made = sc.nextLine();
                    System.out.print("책 가격 : ");
                    price = sc.nextInt();
                    System.out.print("책 ISBN : ");
                    ISBN = sc.nextInt();
                    sc.nextLine();//nextInt 다음 오류 방지용
                    System.out.print("책 저자 : ");
                    writer = sc.nextLine();
                    System.out.print("책 제목 : ");
                    title = sc.nextLine();
                    System.out.print("책 언어 : ");
                    language = sc.nextLine();
                    System.out.println("=====================================");
                    return new ConversationBook(id, introduce, made, price, ISBN, writer, title, language);
                default:
                    System.out.println("잘못 입력하셨어요 다시 입력하세요.");
                    break;
            }
            if (userChoose > 3 && userChoose < 1)
                continue;
            else {
                return null;
            }
        }
    }
}
