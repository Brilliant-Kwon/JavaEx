package JavaStudy.Jan_29.Jan_29.product;

public class ConversationBook extends Book {
    private String language;

    public ConversationBook(int identifier, String introduce, String made, int price, int ISBN, String writer, String title, String language) {
        super(identifier, introduce, made, price, ISBN, writer, title);
        this.language = language;
    }

    public void showInfo() {
        System.out.println("상품 ID : " + super.getIdentifier());
        System.out.println("회화책 설명 : " + super.getIntroduce());
        System.out.println("회화책 생산자 : " + super.getMade());
        System.out.println("회화책 가격 : " + super.getPrice());
        System.out.println("회화책 ISBN : " + this.getISBN());
        System.out.println("회화책 저자 : " + this.getWriter());
        System.out.println("회화책 제목 : " + this.getBookTitle());
        System.out.println("회화책 제목 : " + this.getLanguage());
        System.out.println("=====================================");
    }

    public String getLanguage() {
        return language;
    }
}
