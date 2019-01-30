package JavaStudy.Jan_29.product;

public class Book extends Product {
    private int ISBN;
    private String writer;
    private String bookTitle;

    public Book(int identifier, String introduce, String made, int price, int ISBN, String writer, String title) {
        super(identifier, introduce, made, price);
        this.ISBN = ISBN;
        this.writer = writer;
        this.bookTitle = title;
    }

    public void showInfo() {
        System.out.println("상품 ID : " + super.getIdentifier());
        System.out.println("책 설명 : " + super.getIntroduce());
        System.out.println("책 생산자 : " + super.getMade());
        System.out.println("책 가격 : " + super.getPrice());
        System.out.println("책 ISBN : " + this.getISBN());
        System.out.println("책 저자 : " + this.getWriter());
        System.out.println("책 제목 : " + this.getBookTitle());
        System.out.println("=====================================");
    }

    public int getISBN() {
        return ISBN;
    }

    public String getWriter() {
        return writer;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
